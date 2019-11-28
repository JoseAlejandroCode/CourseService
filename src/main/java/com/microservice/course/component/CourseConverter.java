package com.microservice.course.component;

import com.microservice.course.model.document.Course;
import com.microservice.course.model.dto.CourseDto;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {

  public CourseDto convertToDto(Course course){
    CourseDto courseDto = new CourseDto();
    courseDto.setId(course.getId());
    courseDto.setName(course.getName());
    courseDto.setStatus(course.getStatus());
    courseDto.setMinimumQuota(course.getMinimumQuota());
    courseDto.setMaximumQuota(course.getMaximumQuota());
    courseDto.setStartCourse(course.getStartCourse());
    courseDto.setEndCourse(course.getEndCourse());
    return courseDto;
  }

  public Course convertToDocument(CourseDto courseDto){
    Course course = new Course();
    course.setId(courseDto.getId());
    course.setName(courseDto.getName());
    course.setStatus(courseDto.getStatus());
    course.setMinimumQuota(courseDto.getMinimumQuota());
    course.setMaximumQuota(courseDto.getMaximumQuota());
    course.setStartCourse(courseDto.getStartCourse());
    course.setEndCourse(courseDto.getEndCourse());
    course.setIdTeacher(courseDto.getTeacher().getId());
    course.setIdInstitute(courseDto.getInstitute().getId());
    courseDto.getFamilyList().forEach(f -> course.addFamily(f.getId()));
    courseDto.getStudentList().forEach(s -> course.addStudent(s.getId()));
    return course;
  }

}
