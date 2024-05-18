package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.LoginDetailsEntity;
import com.example.demo.repository.LoginDetailsRepository;
import com.example.demo.req.LoginDetailsSaveReq;
import com.example.demo.res.SuccessRes;
import com.example.demo.util.JwtUtil;

@Service
@Transactional
public class LoginDetailsServiceImpl {

	@Autowired
	private LoginDetailsRepository repo;

	@Autowired
	private JwtUtil jwtutil;
	
	public String signup(LoginDetailsSaveReq req) {
		// TODO Auto-generated method stub
		LoginDetailsEntity savedata = new LoginDetailsEntity();
		savedata.setId(1);
		savedata.setUserName(req.getUserName());
		repo.save(savedata);
		return "Successfully Added";
	}


	public String getuser(LoginDetailsSaveReq req) {
		LoginDetailsEntity data = repo.findByUserName(req.getUserName());
		String token ="";
		if(data!=null) {
		System.out.println(data.getUserName());
     	token=jwtutil.generateToken(data);
		}
		return token;
	}


	public SuccessRes privateapi(String auth) throws Exception {
		// TODO Auto-generated method stub
		SuccessRes res = new SuccessRes();
		jwtutil.verifyToken(auth);
		res.setCodeDesc("Success");
		return res;
	}


	public String generateToken() {
		// TODO Auto-generated method stub
		String token ="";
		token=jwtutil.generateToken2();
		return token;
	}
}
