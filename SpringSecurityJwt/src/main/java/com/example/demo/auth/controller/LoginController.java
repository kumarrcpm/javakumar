package com.example.demo.auth.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.dto.AuthRequest;
import com.example.demo.auth.dto.CommonRes;
import com.example.demo.auth.dto.RefreshTokenReq;
import com.example.demo.auth.dto.SignupReq;
import com.example.demo.auth.dto.SuccessRes;
import com.example.demo.auth.dto.TokenRes;
import com.example.demo.auth.entity.RefreshTokenEntity;
import com.example.demo.auth.entity.UserInfo;
import com.example.demo.auth.repository.RefreshTokenRepository;
import com.example.demo.auth.repository.UserInfoRepository;
import com.example.demo.auth.service.JwtService;
import com.example.demo.auth.service.LoginService;
import com.example.demo.auth.service.RefreshTokenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Login,Token and Spring Security Apis")
@SecurityRequirement(name = "bearerAuth")
public class LoginController {
	/*
	 * @Operation( description = "Login Apis",
	 * summary="This is a summary for Login Apis", responses= {
	 * 
	 * @ApiResponse( description="Success", responseCode="200" ),
	 * 
	 * @ApiResponse( description="Unauthorized", responseCode="403" ) } )
	 */
	@Autowired
	private JwtService jwtService;
	@Autowired
	private RefreshTokenService refreshTokenService;
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private LoginService loginService;
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/addUser")
	public ResponseEntity<CommonRes> addUser(@RequestBody SignupReq req) {

		CommonRes data = new CommonRes();

		List<Error> validation = loginService.addUserValidation(req);

		if (validation != null && validation.size() != 0) {

			data.setCommonResponse(null);
			data.setIsError(true);
			data.setErrorMessage(validation);
			data.setMessage("Failed");

			return new ResponseEntity<CommonRes>(data, HttpStatus.OK);
		} else {

			SuccessRes res = loginService.saveaddUser(req);
			data.setCommonResponse(res);
			data.setIsError(false);
			data.setErrorMessage(Collections.emptyList());
			data.setMessage("Success");
			if (res != null) {
				return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}

	}

	@PostMapping("/authenticate")
	public ResponseEntity<CommonRes> generateToken(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException {
		CommonRes data = new CommonRes();
		TokenRes res = new TokenRes();
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
			if (authentication.isAuthenticated()) {
				String token = jwtService.generateToken(authRequest.getUsername());
				String refershtoken = refreshTokenService.refreshTokenService(authRequest.getUsername());
				res.setToken(token);
				res.setRefreshToken(refershtoken);
				data.setCommonResponse(res);
				data.setErrorMessage(Collections.emptyList());
				data.setIsError(false);
				data.setMessage("Success");						
			
				return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
			} else  {
				
				throw new UsernameNotFoundException("invalid user request !");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<CommonRes>(data, HttpStatus.OK);
//			throw new UsernameNotFoundException("invalid user request !");
		}

	}

	@PostMapping("/refreshToken")
	public TokenRes refreshToken(@RequestBody RefreshTokenReq req) {
		TokenRes res = new TokenRes();
		try {

			RefreshTokenEntity data = refreshTokenRepository.findByrefreshValue(req.getRefreshValue());
			refreshTokenService.expiryCheck(data.getRefreshValue());
			String token = jwtService.generateToken(data.getUserName());
			String refreshtoken = data.getRefreshValue();
			res.setToken(token);
			res.setRefreshToken(refreshtoken);

			RefreshTokenEntity newData = new RefreshTokenEntity();
			newData.setExpiryDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60));
			newData.setRefreshValue(refreshtoken);
			newData.setUserName(data.getUserName());
			newData.setId(data.getId());
			refreshTokenRepository.save(newData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;

	}

	@GetMapping("/welcomeAdmin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<CommonRes> welcomeAdmin() {
		CommonRes data = new CommonRes();
		data.setCommonResponse("Welcome this Api for Admin");
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");
		return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
	}

	@GetMapping("/welcomeManager")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public ResponseEntity<CommonRes> welcomeUser() {
		CommonRes data = new CommonRes();
		data.setCommonResponse("Welcome this Api for Manager");
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");
		return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);

	}

	@GetMapping("/welcomeInvestigator")
	@PreAuthorize("hasAuthority('ROLE_INVESTIGATOR')")
	public ResponseEntity<CommonRes> welcomeInvestigator() {
		CommonRes data = new CommonRes();
		data.setCommonResponse("Welcome this Api for Investigator");
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");
		return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);

	}

	@GetMapping("/welcomeAdminManager")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
	public ResponseEntity<CommonRes> welcomeAdminManager() {
		CommonRes data = new CommonRes();
		data.setCommonResponse("Welcome this Api for Admin and Manager");
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");
		return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);

	}

	@GetMapping("/welcomeAll")
	public ResponseEntity<CommonRes> welcomeAll() {

		CommonRes data = new CommonRes();
		data.setCommonResponse("Welcome this Api for Admin and Manager");
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");
		return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);

	}

}
