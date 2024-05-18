package com.maan.eway;

import java.util.concurrent.Executor;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableBatchProcessing
@EnableTransactionManagement
public class EwayMotorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwayMotorApiApplication.class, args);
	}

	
	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor =new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(50);
		executor.setQueueCapacity(1000);
		executor.setThreadNamePrefix("EXCEL_UPLOAD");
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.initialize();
		return executor;
	}
}
