package com.educationsite.CourseDirectory.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educationsite.CourseDirectory.POJO.CourseDTO;
import com.educationsite.CourseDirectory.Service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllCourse(){
		return service.getAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> get(@PathVariable("id") Long id){
		return service.getById(id);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createCourse(@RequestBody CourseDTO dto ){
		return service.create(dto);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> createCourse(@RequestBody CourseDTO dto,@PathVariable("id") Long id){
		return service.update(id, dto);
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<Object> createCourse(@PathVariable("id") Long id){
		return service.delete(id);
	}
	

}
