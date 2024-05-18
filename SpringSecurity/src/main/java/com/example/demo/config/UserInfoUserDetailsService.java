package com.example.demo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.auth.entity.UserInfo;
import com.example.demo.auth.repository.UserInfoRepository;


@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
	Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
		return userInfo.map(UserInfoUserDetails :: new)
				.orElseThrow(()-> new UsernameNotFoundException("user not found"+username));
	}

}
