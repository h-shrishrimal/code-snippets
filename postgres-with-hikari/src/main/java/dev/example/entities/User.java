package dev.example.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class User {
  public User() {}

  public User(String email, UserDetail details) {
    this.email = email;
    this.details = details;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "email")
  private String email;

  @Type(type = "jsonb")
  @Column(columnDefinition = "jsonb", name = "details")
  private UserDetail details;

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public UserDetail getDetails() {
    return details;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", email='" + email + '\'' + '}';
  }
}
