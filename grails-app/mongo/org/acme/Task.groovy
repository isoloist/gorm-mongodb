package org.acme

import com.google.code.morphia.annotations.Id
import com.google.code.morphia.Key
import com.google.code.morphia.utils.IndexDirection

class Task {

  @Id
  String taskId // test manual id

  Key<Project> projectId
  String name

  Date startDate
  Date completionDate
  Integer estimatedHours
  Integer actualHours

  String description

  Date dateCreated
  Date lastUpdated

  int version

  transient String pass = "pass" // test ignore transients

  static indexes = {
    idx_date unique:true, dropDups:true, fields:[dateCreated:"asc", lastUpdated:"DESC"]
    idx_desc unique:false, dropDups:true, fields:[description:-1] // 1 = ASC, -1 = DESC
    idx_project fields:[projectId:IndexDirection.BOTH] // you can use morphias IndexDirection directly

  }

  static constraints = {
    projectId nullable: true
    description nullable: true
    name blank: false
    actualHours nullable: true
    estimatedHours nullable: true
    startDate nullable: true
    completionDate nullable: true
  }

  def beforeSave = {
//    println "Task before save: $taskId"
  }

  def afterSave = {
//    println "Task after save: $taskId"
  }

  def beforeDelete = {
//    println "Task before delete: $taskId"
  }

  def afterDelete = {
//    println "Task after delete: $taskId"
  }


  public String toString ( ) {
    return "Task{" +
        "taskId='" + taskId + '\'' +
        ", projectId='" + projectId + '\'' +
        ", name='" + name + '\'' +
        ", startDate=" + startDate +
        ", completionDate=" + completionDate +
        ", estimatedHours=" + estimatedHours +
        ", actualHours=" + actualHours +
        ", description='" + description + '\'' +
        ", dateCreated=" + dateCreated +
        ", lastUpdated=" + lastUpdated +
        ", pass='" + pass + '\'' +
        '}' ;
  }}
