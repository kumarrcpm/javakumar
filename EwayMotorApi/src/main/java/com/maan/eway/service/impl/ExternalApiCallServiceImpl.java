package com.maan.eway.service.impl;

import java.io.StringWriter;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.maan.eway.config.DigitalSignatureGenerator;
import com.maan.eway.req.MotorVerificationReq;
import com.maan.eway.req.TiraMsg;
import com.maan.eway.req.push.MotorCoverNoteRefReq;
import com.maan.eway.req.push.TiraMsgVehiclePush;
import com.maan.eway.res.MotorTiraMsgRes;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.ExternalApiCallService;
import com.maan.eway.service.RegulatoryInfoService;

@Service
public class ExternalApiCallServiceImpl implements ExternalApiCallService {
	 
	@Value("${MotorVerificationV1Link}")
	private String motorVerificationV1Link ;
	
	@Value("${HeadearAdd1Key}")
	private String headearAdd1Key ;
	
	@Value("${HeadearAdd1Value}")
	private String headearAdd1Value ;
	
	@Value("${AuthApiKey}")
	private String authApiKey ;
	
	@Value("${AuthApiValue}")
	private String authApiValue ;
	
	@Value("${AuthApiCode}")
	private String authApiCode ;
	
	
	@Value("${MotorPostingV1Link}")
	private String motorpostingV1Link ;
	
	@Autowired
	private RegulatoryInfoService motorInfoService ;
	
	@Autowired	
	private DigitalSignatureGenerator signature;

	private Logger log=LogManager.getLogger(ExternalApiCallServiceImpl.class);
	
	@Override
	public MotorTiraMsgRes getSampleData(TiraMsg req) {
		String xmlString = "";
		{
			try {
				StringWriter sw = new StringWriter();
				
				MotorVerificationReq motorVerificationReq = req.getMotorVerificationReq();
				
				JAXBContext newInstancev1 = JAXBContext.newInstance(MotorVerificationReq.class);
				Marshaller createMarshallerv1 = newInstancev1.createMarshaller();
				createMarshallerv1.setProperty("com.sun.xml.bind.xmlDeclaration", false);

				createMarshallerv1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				createMarshallerv1.marshal(motorVerificationReq, sw);
				String motorVerification = sw.toString();
				motorVerification=motorVerification.replaceAll(">[\\s\r\n]*<", "><");//("[\r\n]+", "");
				
				String collectMsgSignature = signature.collectMsgSignature(motorVerification);
				req.setMsgSignature(collectMsgSignature);
				
				sw.flush();
				sw = new StringWriter();
				JAXBContext newInstance = JAXBContext.newInstance(TiraMsg.class);
				Marshaller createMarshaller = newInstance.createMarshaller();
				createMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				createMarshaller.setProperty("com.sun.xml.bind.xmlDeclaration", false);
				createMarshaller.marshal(req, sw);
				 xmlString = sw.toString().replaceAll(">[\\s\r\n]*<", "><");//("[\r\n]+", "");

				System.out.println("Request: "+xmlString); 
				
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		MotorTiraMsgRes tiraRes = new MotorTiraMsgRes();
	 try {
			RestTemplate restTemplate = new RestTemplate();
			String url = motorVerificationV1Link ;
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
			//headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setContentType(MediaType.APPLICATION_XML);
			headers.set(headearAdd1Key, headearAdd1Value);
			//headers.add("x-api-key", authApiCode);		
			headers.add("ClientKey", "0*fZ^y5@G2b!pgGQAD9SnP");
		
			HttpEntity<Object> entityReq = new HttpEntity<>(xmlString, headers);
		 
			ResponseEntity<MotorTiraMsgRes> response = restTemplate.postForEntity(url, entityReq, MotorTiraMsgRes.class);
			tiraRes = response.getBody() ;

			
			// Save Motor Info
			SuccessRes res  = motorInfoService.saveMotorInfo(req , tiraRes ) ;

			System.out.println(res.getResponse());
			System.out.println(""+tiraRes);

	 } catch (Exception e) {
		 e.printStackTrace();
		 log.info("Exception is ---> " + e.getMessage());
		 return null ;
	 }
		return tiraRes;
	}

	@Override
	public void pushVehicleInfo(TiraMsgVehiclePush req) {

		String xmlString = "";
		{
			try {
				StringWriter sw = new StringWriter();
				
			    MotorCoverNoteRefReq coverNoteRefReqBean = req.getMotorCoverNoteRefReq();
				
				JAXBContext newInstancev1 = JAXBContext.newInstance(MotorCoverNoteRefReq.class);
				Marshaller createMarshallerv1 = newInstancev1.createMarshaller();
				createMarshallerv1.setProperty("com.sun.xml.bind.xmlDeclaration", false);

				createMarshallerv1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				createMarshallerv1.marshal(coverNoteRefReqBean, sw);
				String motorVerification = sw.toString();
				motorVerification=motorVerification.replaceAll(">[\\s\r\n]*<", "><");//("[\r\n]+", ""); //
				
				String collectMsgSignature = signature.collectMsgSignature(motorVerification);
				req.setMsgSignature(collectMsgSignature);
				
				sw.flush();
				sw = new StringWriter();
				JAXBContext newInstance = JAXBContext.newInstance(TiraMsgVehiclePush.class);
				Marshaller createMarshaller = newInstance.createMarshaller();
				createMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				createMarshaller.setProperty("com.sun.xml.bind.xmlDeclaration", false);
				createMarshaller.marshal(req, sw);
				 xmlString = sw.toString().replaceAll(">[\\s\r\n]*<", "><");//("[\r\n]+", "");

				System.out.println("Request: "+xmlString); 
				
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		MotorTiraMsgRes tiraRes = new MotorTiraMsgRes();
	 try {
			RestTemplate restTemplate = new RestTemplate();
			String url = motorpostingV1Link ;
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
			//headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setContentType(MediaType.APPLICATION_XML);
			headers.set(headearAdd1Key, headearAdd1Value);
			//headers.add("x-api-key", authApiCode);		
			headers.add("ClientKey", "0*fZ^y5@G2b!pgGQAD9SnP");
		
			HttpEntity<Object> entityReq = new HttpEntity<>(xmlString, headers);
		 
			ResponseEntity<MotorTiraMsgRes> response = restTemplate.postForEntity(url, entityReq, MotorTiraMsgRes.class);
			tiraRes = response.getBody() ;
			System.out.println("REsponse");
			System.out.println(""+tiraRes);
	 } catch (Exception e) {
		 e.printStackTrace();
		 log.info("Exception is ---> " + e.getMessage());
		// return null ;
	 }
		//return tiraRes;
	
		
	}

}
