package com.tcs.iaspire.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "tcs_mlt_user")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class UserInformation {

  @Id
  @Column(name = "employee_id")
  private Long id;

  public UserInformation() {
  }

  public UserInformation(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "UserInformation{" +
      "id=" + id +
      '}';
  }
}
