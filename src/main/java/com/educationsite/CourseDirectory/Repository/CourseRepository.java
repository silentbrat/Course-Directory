package com.educationsite.CourseDirectory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.educationsite.CourseDirectory.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	@Query("SELECT a FROM Course a "
			+ " WHERE a.id in :ids")
	public List<Course> getByIds(@Param("ids") List<Long> ids);

}
