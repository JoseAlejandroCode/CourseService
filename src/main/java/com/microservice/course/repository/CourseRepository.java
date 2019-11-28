package com.microservice.course.repository;

import com.microservice.course.model.document.Course;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CourseRepository extends ReactiveMongoRepository<Course, String> {
  Flux<Course> findByIdInstitute(String idInstitute);
}
