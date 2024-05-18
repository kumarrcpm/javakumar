package com.example.demo.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.auth.controller.LoginController;
import com.example.demo.auth.dto.SignupReq;
import com.example.demo.auth.dto.SuccessRes;
import com.example.demo.auth.entity.UserInfo;
import com.example.demo.auth.repository.UserInfoRepository;

@Service
public class LoginService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;


	public List<Error> addUserValidation(SignupReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	public SuccessRes saveaddUser(SignupReq req) {
		// TODO Auto-generated method stub
		SuccessRes res = new SuccessRes();

	try {
		UserInfo data = new UserInfo();
		Long count=  userInfoRepository.count();
		Integer countvalue = count.intValue()+1;
		data.setName(req.getUserName());
		data.setEmail(req.getEmailId());
		data.setPassword(passwordEncoder.encode(req.getPassword()));
		data.setRoles(req.getRoles());
		data.setId(countvalue);
		userInfoRepository.save(data);
		
		res.setCode(req.getUserName());
		res.setCodeDesc("User Added Successfully");
	}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			
		}
		return res;
	}
	
}
