package com.microservice.course.service;

import com.microservice.course.model.dto.CourseDto;
import com.microservice.course.model.dto.StudentDto;
import reactor.core.publisher.Mono;

public interface StudentService {
  Mono<StudentDto> findStudent(String idStudent);
  Mono<StudentDto> updateCourseList(CourseDto course, String idStudent);
}
