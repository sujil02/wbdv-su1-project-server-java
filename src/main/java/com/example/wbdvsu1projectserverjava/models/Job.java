package com.example.wbdvsu1projectserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Job {
  @Id
  private String id;
  private String type;
  private String url;
  private String createdAt;
  @ManyToOne
  @JsonIgnore
  private Recruiter recruiter;
  private String company;
  private String companyUrl;
  private String location;
  private String title;
  private String description;
  private String how_to_apply;
  private String company_logo;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getCompanyUrl() {
    return companyUrl;
  }

  public void setCompanyUrl(String companyUrl) {
    this.companyUrl = companyUrl;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHow_to_apply() {
    return how_to_apply;
  }

  public void setHow_to_apply(String how_to_apply) {
    this.how_to_apply = how_to_apply;
  }

  public String getCompany_logo() {
    return company_logo;
  }

  public void setCompany_logo(String company_logo) {
    this.company_logo = company_logo;
  }

  public Recruiter getRecruiter() {
    return recruiter;
  }

  public void setRecruiter(Recruiter recruiter) {
    this.recruiter = recruiter;
  }
}
