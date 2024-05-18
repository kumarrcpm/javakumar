package com.example.demo.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.Req.AuthReq;

@RestController
@RequestMapping("/api")
public class DemoController {

	@GetMapping("/welcome")
	@PreAuthorize("hasAuthority('ADMIN','USER')")
	public void welcome() {
		System.out.println("Welcome");
	}

	@GetMapping("/welcomeAdmin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public void welcomeAdmin() {
		System.out.println("Welcome for Admins");
	}

}
