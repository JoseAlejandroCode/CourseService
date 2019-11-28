package com.microservice.course.service;

import com.microservice.course.model.dto.CourseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface CourseService {
  Flux<CourseDto> findAll();
  Mono<CourseDto> findById(String id);
  Mono<CourseDto> create(CourseDto course);
  Mono<CourseDto> update(CourseDto course, String id);
  Mono<Void> delete(String id);
  Flux<CourseDto> findByIdInstitute(String idInstitute);
}
