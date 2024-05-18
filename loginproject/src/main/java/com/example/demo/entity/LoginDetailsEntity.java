package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
@Data
@Entity
@Table(name="login_details")

public class LoginDetailsEntity implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name="ID", nullable=false)
		private Integer id;

		@Column(name="USER_NAME",length=100)
		private String userName;

		@Column(name="USER_TYPE",length=45)
		private String userType;

		@Column(name="PASS_WORD",length=45)
		private String passWord;

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name="ENTRY_DATE")
		private Date entryDate;

}
