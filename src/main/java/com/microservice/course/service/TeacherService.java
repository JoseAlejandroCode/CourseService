package com.microservice.course.service;

import com.microservice.course.model.dto.CourseDto;
import com.microservice.course.model.dto.TeacherDto;
import reactor.core.publisher.Mono;

public interface TeacherService {
  Mono<TeacherDto> findTeacher(String idTeacher);
  Mono<TeacherDto> updateCourseList(CourseDto course, String idTeacher);
}
