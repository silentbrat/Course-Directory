package com.educationsite.CourseDirectory.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.educationsite.CourseDirectory.Model.Course;
import com.educationsite.CourseDirectory.POJO.CourseDTO;
import com.educationsite.CourseDirectory.Repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository repository;
	
	public ResponseEntity<Object> getAll(){
		List<Course> list= repository.findAll();
		if(list.isEmpty()) return new ResponseEntity<>("No Course found.",HttpStatus.OK);
		List<CourseDTO> dtoList=list.stream()
				                    .map(ele-> new CourseDTO(ele.getId(),ele.getCourseName(),ele.getIsActive(),ele.getDescription()))
				                    .collect(Collectors.toList());
		return new ResponseEntity<>(dtoList,HttpStatus.OK);
	} 
	
	public ResponseEntity<Object> getById(Long id){
		Optional<Course> obj= repository.findById(id);
		if(obj.isPresent()) {
			CourseDTO dto=new CourseDTO();
			BeanUtils.copyProperties(obj.get(), dto);
			return new ResponseEntity<>(dto,HttpStatus.OK);
		} 
		return new ResponseEntity<>("Such Course does not exist.",HttpStatus.OK);
	}
	
	public ResponseEntity<Object> create(CourseDTO dto){
		Course entity=new Course();
		BeanUtils.copyProperties(dto, entity);
		repository.save(entity);
		return new ResponseEntity<>("New course added.",HttpStatus.OK);
	} 
	
	public ResponseEntity<Object> update(Long id,CourseDTO dto){
		Optional<Course> obj= repository.findById(id);
		if(obj.isPresent()) {
			BeanUtils.copyProperties(dto, obj.get());
			repository.save(obj.get());
			return new ResponseEntity<>("New course updated.",HttpStatus.OK);
		} 
		return create(dto);
	}
	
	public ResponseEntity<Object> delete(Long id){
		repository.deleteById(id);
		return new ResponseEntity<>("Course delete triggered.",HttpStatus.OK);
	}
	
	

}
