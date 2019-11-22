package com.microservice.course.repository;

import com.microservice.course.model.document.Course;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CourseRepository extends ReactiveMongoRepository<Course, String> {
}
