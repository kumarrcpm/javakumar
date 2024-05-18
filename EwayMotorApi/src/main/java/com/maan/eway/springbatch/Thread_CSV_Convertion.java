package com.maan.eway.springbatch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.maan.eway.batch.entity.EwayUploadTypeMaster;

public class Thread_CSV_Convertion implements Runnable {
	
	Logger log =LogManager.getFormatterLogger(Thread_CSV_Convertion.class);
	
	private EwayUploadRes uploadRes;
	
	private CSVFileConvertion csvFileConvertion;
	
	private EwayUploadTypeMaster uploadTypeMaster;

	public Thread_CSV_Convertion(EwayUploadRes uploadRes, CSVFileConvertion csvFileConvertion, EwayUploadTypeMaster uploadTypeMaster) {
		
		this.uploadRes=uploadRes;
		
		this.csvFileConvertion =csvFileConvertion;
		
		this.uploadTypeMaster=uploadTypeMaster;
	}

	@Override
	public void run() {
		try {
			log.info("Thread_CSV_Convertion || Run || Start doing CSVCovertion ..");
			csvFileConvertion.doCSVCovertion(uploadRes,uploadTypeMaster);
			log.info("Thread_CSV_Convertion || Run || CSVCovertion completed");
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
	}

}
