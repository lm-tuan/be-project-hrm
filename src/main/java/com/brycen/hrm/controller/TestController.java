package com.brycen.hrm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TestController {
	@GetMapping("/test")
	public ResponseEntity<String> getAll() {
	    return new ResponseEntity<>("Hello world", HttpStatus.OK);
	  }
}
