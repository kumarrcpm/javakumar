package com.example.demo.auth.service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.auth.entity.RefreshTokenEntity;
import com.example.demo.auth.repository.RefreshTokenRepository;

@Service
public class RefreshTokenService {

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	public String refreshTokenService(String username) {
		
		String token = UUID.randomUUID().toString();
		Long count = refreshTokenRepository.count();
		Integer count1=(count.intValue());	       
		RefreshTokenEntity refreshToken = new RefreshTokenEntity();
		refreshToken.setUserName(username);
		refreshToken.setRefreshValue(token);
		refreshToken.setId(count1+1);
		refreshToken.setExpiryDate(new Date(System.currentTimeMillis()+1000*60*60));
		refreshTokenRepository.save(refreshToken);
		return token;
	}
	
	public void expiryCheck(String refreshValue) {
	RefreshTokenEntity data =refreshTokenRepository.findByrefreshValue(refreshValue);
	if(data!=null) {
	Long milli=data.getExpiryDate().getTime();
	if (milli.compareTo(System.currentTimeMillis()) < 0) {
	refreshTokenRepository.delete(data);
	throw new RuntimeException(data.getRefreshValue() + " Refresh token was expired. Please make a new signin request");
	}		  
	}
	}

}
