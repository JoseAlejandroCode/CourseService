package com.microservice.course.controller;

import com.microservice.course.model.dto.CourseDto;
import com.microservice.course.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;

@Api(value="courses", description="Operations pertaining to courses")
@RestController
@RequestMapping("/api/courses")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @ApiOperation(value = "View a list of available courses", response = CourseDto.class)
  @GetMapping
  public Mono<ResponseEntity<Flux<CourseDto>>> findAll(){
    return Mono.just(ResponseEntity
            .ok().contentType(MediaType.APPLICATION_JSON).body(courseService.findAll()));
  }

  @ApiOperation(value = "View a course by ID", response = CourseDto.class)
  @GetMapping("/{id}")
  public Mono<ResponseEntity<CourseDto>> finById(@PathVariable String id){
    return courseService.findById(id)
            .map(course -> ResponseEntity
            .ok().contentType(MediaType.APPLICATION_JSON).body(course));
  }

  @ApiOperation(value = "Save a course", response = CourseDto.class)
  @PostMapping
  public  Mono<ResponseEntity<CourseDto>> save(@Valid @RequestBody CourseDto course) {
    return courseService.create(course)
            .map(s -> ResponseEntity
            .created(URI.create("/api/courses")).contentType(MediaType.APPLICATION_JSON).body(s));
  }

  @ApiOperation(value = "Update a course", response = CourseDto.class)
  @PutMapping("/{id}")
  public Mono<ResponseEntity<CourseDto>> update(@RequestBody CourseDto course, @PathVariable String id){
    return courseService.update(course, id)
            .map(s -> ResponseEntity
                .created(URI.create("/api/courses")).contentType(MediaType.APPLICATION_JSON).body(s));
  }

  @ApiOperation(value = "Delete of available course", response = Mono.class)
  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
    return courseService.delete(id)
            .flatMap(p -> Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
  }

}
