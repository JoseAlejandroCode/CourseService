package com.microservice.course.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "courses")
public class Course {
  @Id
  private String id;
  @NotEmpty
  private String nombre;
  @NotNull
  private Integer status;
  @NotNull
  private Integer minimumQuota;
  @NotNull
  private Integer maximumQuota;
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startCourse;
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endCourse;

  public Course() {
  }

  public Course(String nombre, Integer status, Integer minimumQuota, Integer maximumQuota, Date startCourse, Date endCourse) {
    this.nombre = nombre;
    this.status = status;
    this.minimumQuota = minimumQuota;
    this.maximumQuota = maximumQuota;
    this.startCourse = startCourse;
    this.endCourse = endCourse;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getMinimumQuota() {
    return minimumQuota;
  }

  public void setMinimumQuota(Integer minimumQuota) {
    this.minimumQuota = minimumQuota;
  }

  public Integer getMaximumQuota() {
    return maximumQuota;
  }

  public void setMaximumQuota(Integer maximumQuota) {
    this.maximumQuota = maximumQuota;
  }

  public Date getStartCourse() {
    return startCourse;
  }

  public void setStartCourse(Date startCourse) {
    this.startCourse = startCourse;
  }

  public Date getEndCourse() {
    return endCourse;
  }

  public void setEndCourse(Date endCourse) {
    this.endCourse = endCourse;
  }
}
