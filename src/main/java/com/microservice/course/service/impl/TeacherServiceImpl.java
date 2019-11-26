package com.microservice.course.service.impl;

import com.microservice.course.model.dto.CourseDto;
import com.microservice.course.model.dto.TeacherDto;
import com.microservice.course.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class TeacherServiceImpl implements TeacherService {

  @Autowired
  private WebClient webClient;

  @Override
  public Mono<TeacherDto> findTeacher(String idTeacher) {
    return webClient
            .get()
            .uri("/api/teachers/{id}", Collections.singletonMap("id", idTeacher))
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(TeacherDto.class);
  }

  @Override
  public Mono<TeacherDto> updateCourseList(CourseDto course, String idTeacher) {
    return findTeacher(idTeacher)
            .flatMap(
                    student -> {
                      student.addCourse(course);
                      return Mono.just(student);
                    }).flatMap(
                    student -> webClient
                            .put()
                            .uri("/api/teachers/{id}", Collections.singletonMap("id", idTeacher))
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(student))
                            .retrieve()
                            .bodyToMono(TeacherDto.class)
            );
  }
}
