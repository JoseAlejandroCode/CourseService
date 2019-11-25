package com.microservice.course.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "courses")
public class Course {
  @Id
  private String id;
  @NotEmpty
  private String name;
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
  @NotEmpty
  private String idTeacher;
  private List<String> studentsList;
  private List<String> familyList;

  public Course() {
    this.studentsList = new ArrayList<>();
    this.familyList = new ArrayList<>();
  }

  public Course(String id, String name, Integer status, Integer minimumQuota, Integer maximumQuota, Date startCourse, Date endCourse, String idTeacher) {
    this();
    this.id = id;
    this.name = name;
    this.status = status;
    this.minimumQuota = minimumQuota;
    this.maximumQuota = maximumQuota;
    this.startCourse = startCourse;
    this.endCourse = endCourse;
    this.idTeacher = idTeacher;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getIdTeacher() {
    return idTeacher;
  }

  public void setIdTeacher(String idTeacher) {
    this.idTeacher = idTeacher;
  }

  public List<String> getStudentsList() {
    return studentsList;
  }

  public void setStudentsList(List<String> studentsList) {
    this.studentsList = studentsList;
  }

  public void addStudent(String idStudent) {
    this.studentsList.add(idStudent);
  }

  public List<String> getFamilyList() {
    return familyList;
  }

  public void setFamilyList(List<String> familyList) {
    this.familyList = familyList;
  }

  public void addFamily(String idFamily) {
    this.familyList.add(idFamily);
  }
}
