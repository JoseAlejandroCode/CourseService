package com.microservice.course.service.impl;

import com.microservice.course.model.dto.CourseDto;
import com.microservice.course.model.dto.StudentDto;
import com.microservice.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class StudentServiceImpl implements StudentService {

  @Value("${config.base.student.uri}")
  private String pathStudent;

  @Autowired
  private WebClient webClient;

  @Override
  public Mono<StudentDto> updateCourseList(CourseDto course) {
    return null;
  }
}
