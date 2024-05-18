package com.example.demo.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.demo.common.AccessDeniedException;
import com.example.demo.entity.LoginDetailsEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;

@Component
public class JwtUtil {

private final static String secret = "login";
	


	public String generateToken(LoginDetailsEntity data) {
		Claims claims = Jwts.claims()
				           .setIssuer(data.getUserName())
				           .setIssuedAt(new Date()
				        		   );		               		
		return Jwts.builder()
			   .setClaims(claims)
			   .signWith(SignatureAlgorithm.HS512, secret)
			   .compact();
	}


	public void verifyToken(String authorization) throws Exception{
		try {
		Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization);
		}
		catch(Exception e) {
			throw new AccessDeniedException("Access Denied");
		}
		System.out.println("Token Verified");
	}


	public String generateToken2() {
		// TODO Auto-generated method stub
		Claims claims = Jwts.claims()
		           .setIssuer("Kumar")
		           .setIssuedAt(new Date()
		        		   );		               		
		return Jwts.builder()
	   .setClaims(claims)
	   .signWith(SignatureAlgorithm.HS512, secret)
	   .compact();
	}
	
}
