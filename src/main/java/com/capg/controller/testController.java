package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.capg.model.test;
import com.capg.service.TestService;

@RestController
public class testController {

	@Autowired
	TestService service;

	@PostMapping("/test")
	public ResponseEntity<test> createTest(@Validated @RequestBody test test) {
		System.out.println("Rest");
		System.out.println(test);
		test mv = service.addTest(test);
		return new ResponseEntity<test>(mv, HttpStatus.OK);
	}
}

