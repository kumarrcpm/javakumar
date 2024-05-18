package com.example.demo.req;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class EmployeeSaveReq {

	@NotBlank(message="Not Empty")
	@Schema(example=" ",description="EmployeeId")
	@JsonProperty("EmployeeId")
	private String employeeId;
	
	@JsonProperty("EmployeeName")
	private String employeeName;

	@JsonProperty("JoiningDate")
	private Date joiningDate;
}
