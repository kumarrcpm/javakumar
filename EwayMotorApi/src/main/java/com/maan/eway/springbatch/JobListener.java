package com.maan.eway.springbatch;

import javax.batch.api.chunk.listener.ChunkListener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JobListener extends JobExecutionListenerSupport implements ChunkListener {

	private static final String OVERRIDDEN_BY_EXPRESSION = null;
	@Autowired
	private SpringBatchServiceImpl service;
	@Override
	public void afterJob(JobExecution jobExecution) {
		try {
			EwayUploadRes uploadResponse = new EwayUploadRes();
			EwayBatchReq request= new EwayBatchReq();
			String ewayBatchReq = jobExecution.getJobParameters().getString("EwayBatchReq");
			
			ObjectMapper mapper = new ObjectMapper();
			request = mapper.readValue(ewayBatchReq, EwayBatchReq.class);
			uploadResponse=request.getEwayUploadRes();
			if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
				service.validateRawTableRecords(uploadResponse)	;			
			}else {
				service.fileUploadProgress(uploadResponse,"E","Failed","Raw table Insert Batch Failed","50");
			}
		}catch(Exception e) {e.printStackTrace();}
	}
	
	
	
	
	
	
	
	@Override
	public void beforeChunk() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onError(Exception ex) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterChunk() throws Exception {
		// TODO Auto-generated method stub
		
	}
	


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	



