package com.microservice.course.service.impl;

import com.microservice.course.component.CourseConverter;
import com.microservice.course.model.dto.CourseDto;
import com.microservice.course.repository.CourseRepository;
import com.microservice.course.service.CourseService;
import com.microservice.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private CourseConverter courseConverter;

  @Autowired
  private StudentService studentService;

  @Override
  public Flux<CourseDto> findAll() {
    return courseRepository.findAll()
            .flatMap(course -> Mono.just(courseConverter.convertToDto(course)));
  }

  @Override
  public Mono<CourseDto> findById(String id) {
    return courseRepository.findById(id)
            .flatMap(course -> Mono.just(courseConverter.convertToDto(course)));
  }

  @Override
  public Mono<CourseDto> create(CourseDto course) {
    return courseRepository.save(courseConverter.convertToDocument(course))
            .flatMap(c -> Mono.just(courseConverter.convertToDto(c)));
  }

  @Override
  public Mono<CourseDto> update(CourseDto course, String id) {
    return findById(id).flatMap(c -> {
      c.setName(course.getName());
      c.setStatus(course.getStatus());
      c.setMinimumQuota(course.getMinimumQuota());
      c.setMaximumQuota(course.getMaximumQuota());
      c.setStartCourse(course.getStartCourse());
      c.setEndCourse(course.getEndCourse());
      c.setTeacher(course.getTeacher());
      course.getStudentList().forEach(student -> c.addStudent(student));
      return courseRepository.save(courseConverter.convertToDocument(c))
              .flatMap(cour -> Mono.just(courseConverter.convertToDto(cour)))
              .flatMap(cour -> {
                course.getStudentList().forEach(student -> {
                  student.addCourse(cour);
                  cour.addStudent(studentService.updateCourseList(cour, student.getId()).block());
                });
                return Mono.just(cour);
              });
    });
  }

  @Override
  public Mono<Void> delete(String  id) {
    return findById(id)
              .flatMap(c -> courseRepository.delete(courseConverter.convertToDocument(c)));
  }

}
