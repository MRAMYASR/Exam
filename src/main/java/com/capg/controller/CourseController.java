package com.capg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.model.Course;
import com.capg.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService service;

	@PostMapping("/createCourse")
	public ResponseEntity<Course> createCourse(@Validated @RequestBody Course course) {
		Course a = service.addCourse(course);
		System.out.println(a);
		return new ResponseEntity<Course>(a, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<Course>> fetchCourse() {
		List<Course> course = service.findAllCourse();
		return ResponseEntity.ok().body(course);
	}

}
