package com.microservice.course.service.impl;

import com.microservice.course.model.dto.CourseDto;
import com.microservice.course.model.dto.StudentDto;
import com.microservice.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

public class StudentServiceImpl implements StudentService {

  @Value("${config.base.service.uri}")
  private String pathStudent;

  @Autowired
  private WebClient webClient;

  @Override
  public Mono<StudentDto> findStudent(String idStudent) {
    return webClient
            .get()
            .uri("/api/students/{id}", Collections.singletonMap("id", idStudent))
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(StudentDto.class);
  }

  @Override
  public Mono<StudentDto> updateCourseList(CourseDto course, String idStudent) {
    return findStudent(idStudent)
            .flatMap(
              student -> {
                student.addCourse(course);
                return Mono.just(student);
            }).flatMap(
                    student -> webClient
                      .put()
                      .uri("/api/students/{id}", Collections.singletonMap("id", idStudent))
                      .accept(MediaType.APPLICATION_JSON)
                      .contentType(MediaType.APPLICATION_JSON)
                      .body(BodyInserters.fromValue(student))
                      .retrieve()
                      .bodyToMono(StudentDto.class)
            );
  }

}
