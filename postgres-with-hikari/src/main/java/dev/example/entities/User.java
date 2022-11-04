package dev.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_detail")
public class User {
  public User() {}

  public User(String email) {
    this.email = email;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "email")
  private String email;

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", email='" + email + '\'' + '}';
  }
}
