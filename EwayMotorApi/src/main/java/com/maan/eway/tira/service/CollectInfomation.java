package com.maan.eway.tira.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maan.eway.bean.CompanyProductMaster;
import com.maan.eway.bean.HomePositionMaster;
import com.maan.eway.bean.InsuranceCompanyMaster;
import com.maan.eway.bean.ListItemValue;
import com.maan.eway.bean.LoginUserInfo;
import com.maan.eway.bean.MotorVehicleInfo;
import com.maan.eway.bean.PersonalInfo;
import com.maan.eway.bean.PolicyCoverData;
import com.maan.eway.bean.ProductSectionMaster;
import com.maan.eway.config.thread.MyTaskList;
import com.maan.eway.req.push.TiraMsgVehiclePush;
import com.maan.eway.tira.bean.MaansarovarToTira;
@Service
public class CollectInfomation {

	@Autowired
	private QuoteInfoUtil quote;
	
	List<Callable<Object>> queue = new ArrayList<Callable<Object>>();
	
	@Autowired
	private ConvertTiraRequest covernt;
	
	
	public TiraMsgVehiclePush collectInfo(String quoteNo) {
		
		HomePositionMaster hp=quote.getFromHomePositionMaster(quoteNo);
		
		List<Callable<Object>> queue = new ArrayList<Callable<Object>>();
		
		
		Callable<Object> q1 = new Callable<Object>(){
			@Override
			public Object call() throws Exception {
			
				return quote.getFromCompanyProductMaster(hp.getCompanyId(),hp.getProductId().toString());
			}
		};
		queue.add(q1);
		
		Callable<Object> q2 = new Callable<Object>(){
			@Override
			public Object call() throws Exception {
			
				return quote.getFromInsuranceCompanyMaster(hp.getCompanyId());
			}
		};
		queue.add(q2);
		
		Callable<Object> q3 = new Callable<Object>(){
			@Override
			public Object call() throws Exception {
			
				return quote.getLogInUserDetails(hp.getLoginId(), hp.getCompanyId());
			}
		};
		queue.add(q3);
		if(hp.getApplicationId()!=null && !(hp.getApplicationId().equals("1")||  hp.getApplicationId().equals("01") ) ) {
			Callable<Object> q4 = new Callable<Object>(){
				@Override
				public Object call() throws Exception {

					return quote.getLogInUserDetails(hp.getApplicationId(), hp.getCompanyId());
				}
			};
			queue.add(q4);
		}
		Callable<Object> q5 = new Callable<Object>(){
			@Override
			public Object call() throws Exception {
			
				return quote.getFromPolicyCoverData(quoteNo);
			}
		};
		queue.add(q5);
		
		Callable<Object> q6 = new Callable<Object>(){
			@Override
			public Object call() throws Exception {
			
				return quote.getFromListItemValue("PAYMENT_MODE", hp.getPaymentMode());
			}
		};
		queue.add(q6);
		
		Callable<Object> q7 = new Callable<Object>(){
			@Override
			public Object call() throws Exception {
			
				return quote.getFromPresonalInfo(hp.getCompanyId(),hp.getCustomerId());
			}
		};
		queue.add(q7);

		Callable<Object> q8 = new Callable<Object>(){
			@Override
			public Object call() throws Exception {
			
				return quote.getFromMotorVehicleInfo(hp.getQuoteNo(),"1");
			}
		};
		queue.add(q8);
		
		Callable<Object> q9 = new Callable<Object>(){
			@Override
			public Object call() throws Exception {
			
				return quote.getFromSectionMaster(hp.getCompanyId(),hp.getProductId(),hp.getSectionId());
			}
		};
		queue.add(q9);
		//getFromListItemValue
		
		
		InsuranceCompanyMaster companyId=null;
		CompanyProductMaster product=null;
		LoginUserInfo broker=null;
		LoginUserInfo uw=null;
		List<PolicyCoverData> covers=null;
		PersonalInfo customerInfo=null;
		MotorVehicleInfo vehicleInfo=null;
		ListItemValue l=null;
		ProductSectionMaster p=null;
		if(!queue.isEmpty()) {
			 MyTaskList taskList = new MyTaskList(queue);		
			 ForkJoinPool forkjoin = new ForkJoinPool((queue.size()>1 ? (queue.size()>10)?10:(int )(queue.size()/2) : 1)); 
	         ConcurrentLinkedQueue<Future<Object>> invoke  = (ConcurrentLinkedQueue<Future<Object>>) forkjoin.invoke(taskList) ;
	         int success=0;
	         for (Future<Object> callable : invoke) {
					System.out.println(callable.getClass() + "," + callable.isDone());
					if (callable.isDone()) {
						try {
							
							Object object = callable.get();
							if(object instanceof InsuranceCompanyMaster  ) {
								companyId= (InsuranceCompanyMaster) object;
							}else if(object instanceof CompanyProductMaster  ) {
								product= (CompanyProductMaster) object;
							}else if(object instanceof LoginUserInfo  ) {
								LoginUserInfo o = (LoginUserInfo) object;
								if(o !=null && o.getLoginId().equals(hp.getLoginId())) {
									broker=o;
								}else if(o !=null && o.getLoginId().equals(hp.getApplicationId())) {
									uw=o;
								} 
							}else if(object instanceof ListItemValue){
								l=(ListItemValue) object;
							}else if (object instanceof PersonalInfo){
								customerInfo=(PersonalInfo) object;
							}else if( object instanceof MotorVehicleInfo) {
								vehicleInfo = (MotorVehicleInfo) object;
							}else if(object instanceof ProductSectionMaster){
								p=(ProductSectionMaster) object;
							}else {
								covers=(List<PolicyCoverData>) object;
							}
								
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	         }
	         
		}
		
		MaansarovarToTira tira=MaansarovarToTira.builder()
								.company(companyId)
								.product(product)
								.covers(covers)
								.broker(broker)
								.uw(uw)
								.vehicleInfo(vehicleInfo)
								.customerInfo(customerInfo)	
								.ltPayment(l)
								.policy(hp)
								.section(p)
								.build();
		TiraMsgVehiclePush convert = covernt.convert(tira);
		 
		return convert;
	}
	
}
