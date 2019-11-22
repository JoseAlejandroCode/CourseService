package com.microservice.course.component;

import com.microservice.course.model.document.Course;
import com.microservice.course.model.dto.CourseDto;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {

  public CourseDto convertToDto(Course course){
    CourseDto courseDto = new CourseDto();

    return courseDto;
  }

  public Course convertToDocument(CourseDto courseDto){
    Course course = new Course();

    return course;
  }

}
