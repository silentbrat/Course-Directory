package com.educationsite.CourseDirectory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educationsite.CourseDirectory.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
