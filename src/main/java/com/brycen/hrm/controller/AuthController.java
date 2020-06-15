package com.brycen.hrm.controller;

import java.util.HashSet;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.payload.request.LoginRequest;
import com.brycen.hrm.model.payload.request.SignupRequest;

import com.brycen.hrm.service.AuthService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthService authService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> sigin(@Valid @RequestBody LoginRequest loginRequest) {
		return this.authService.sigin(loginRequest);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> sigup(@Valid @RequestBody SignupRequest signUpRequest) {
		return this.authService.sigup(signUpRequest);
	}
}
