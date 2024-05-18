package com.maan.eway.springbatch;

import java.io.IOException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maan.eway.batch.repository.TransactionControlDetailsRepository;

@Configuration
@Component
public class EwayBatchConfig {
	
	private static final String OVERRIDDEN_BY_EXPRESSION = null;
	
	 @Autowired
	 public JobBuilderFactory jobBuilderFactory;
	 @Autowired
	 public StepBuilderFactory stepBuilderFactory;
	 @Autowired
	 private JdbcTemplate jdbcTemplate;  
	 
	 private EwayBatchWriter batchWriter =new EwayBatchWriter();
	 @Autowired
	 private TransactionControlDetailsRepository transactionDetailRepo;
	 
	 private ThreadPoolTaskExecutor asyncTaskExecutor;
	

	@StepScope
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	 public FlatFileItemReader<Record> reader(@Value("#{jobParameters[EwayBatchReq]}") String fileName,@Value("#{jobParameters[RequestReferenceNo]}") String TranId,@Value("#{jobParameters[ExcelHeaderNames]}") String ExcelHeaderNames) {
		 FlatFileItemReader<Record> reader = new FlatFileItemReader();
		 EwayUploadRes response = new EwayUploadRes();
		 try {
			 String csvFilePath = "";
			 EwayBatchReq request= new EwayBatchReq();
		     ObjectMapper mapper = new ObjectMapper();
		     try {
		    	 request = mapper.readValue(fileName, EwayBatchReq.class);
		    	 batchWriter.setEwayRequest(fileName);
		    	 response=request.getEwayUploadRes();
		    	 csvFilePath =response.getCsvfilepath();
			   } catch (JsonParseException e) {e.printStackTrace();}catch (JsonMappingException e) {e.printStackTrace();} 
		      	 catch (IOException e) {e.printStackTrace();}
		     	reader.setResource(new FileSystemResource(csvFilePath));
		     	reader.setLinesToSkip(1);
		     	reader.setLineMapper(new DefaultLineMapper() {{
			       setLineTokenizer(new DelimitedLineTokenizer("~") {{
			    	  // System.out.println("BatchExcelHeaderNames : " + ExcelHeaderNames);
			           setNames(ExcelHeaderNames.split(","));
			                }});
				      setFieldSetMapper(new CustomFieldSetMapper());
			       
			     }});
	     }catch(Exception e) {e.printStackTrace();
	     }
	     return reader;
	 }
	
	 @Bean
	 public Job importUserJob(JobExecutionListener listener) {
	     return jobBuilderFactory.get("Eway_Job")
	             .incrementer(new RunIdIncrementer())
	             .listener(listener)
	             .flow(step1())
	             .end()
	             .build();
	 }
	 @Bean
	 public TaskExecutor taskExecutor(){
		  asyncTaskExecutor=new ThreadPoolTaskExecutor();
		 	asyncTaskExecutor.setCorePoolSize(10);
		 	asyncTaskExecutor.setMaxPoolSize(10);
		 	asyncTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		 	asyncTaskExecutor.setAwaitTerminationSeconds(15);	
		 	asyncTaskExecutor.setQueueCapacity(1000);
		 	asyncTaskExecutor.setThreadNamePrefix("spring_batch");
		 	asyncTaskExecutor.initialize();
	     return asyncTaskExecutor;
	 }
	 
	 @Bean
	 public Step step1() {
	     return stepBuilderFactory.get("step1")
	             .<Record, Record>chunk(1000)
	             .reader(reader(OVERRIDDEN_BY_EXPRESSION,OVERRIDDEN_BY_EXPRESSION,OVERRIDDEN_BY_EXPRESSION))
	            // .processor(synchProcessor())
	             .writer(batchWriter.itemWriter(transactionDetailRepo,jdbcTemplate))///em,dataSource,,emf
	             .listener(listener())
	             .taskExecutor(taskExecutor())
	             .build();
	 }

	 @Bean
		public JobListener listener() {
			 return new JobListener();
		}

}
