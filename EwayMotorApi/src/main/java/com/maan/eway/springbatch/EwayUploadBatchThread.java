package com.maan.eway.springbatch;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.maan.eway.batch.entity.EwayUploadTypeMaster;
import com.maan.eway.batch.entity.EwayXlconfigMaster;

public class EwayUploadBatchThread implements Runnable{
	
	Logger log =LogManager.getLogger(EwayUploadBatchThread.class);
	
	private SpringBatchServiceImpl batchServiceImpl;
	
	private EwayUploadRes uploadRes;
	
	private List<EwayXlconfigMaster> xlConfigData;
	
	private EwayUploadTypeMaster uploadTypeMaster;

	public EwayUploadBatchThread(SpringBatchServiceImpl batchServiceImpl, EwayUploadRes uploadRes,
			List<EwayXlconfigMaster> xlConfigData, EwayUploadTypeMaster uploadTypeMaster) {
		
		this.batchServiceImpl=batchServiceImpl;
		
		this.uploadRes=uploadRes;
		
		this.uploadTypeMaster=uploadTypeMaster;
		
		this.xlConfigData =xlConfigData;
		
	}

	@Override
	public void run() {
		try {
			log.info("EwayUploadBatchThread || doRawdataInsert|| Start doing raw table insertion...");
			batchServiceImpl.doRawdataInsert(uploadRes,uploadTypeMaster,xlConfigData);
			log.info("EwayUploadBatchThread || doRawdataInsert|| raw table insertion completed");
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
	}

}
