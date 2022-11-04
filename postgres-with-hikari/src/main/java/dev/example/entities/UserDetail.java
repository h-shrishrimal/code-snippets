package dev.example.entities;

import java.io.Serializable;

public class UserDetail implements Serializable {

  private String phone;
  private String city;

  public UserDetail(String phone, String city) {
    this.phone = phone;
    this.city = city;
  }

  public UserDetail() {}

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPhone() {
    return phone;
  }

  public String getCity() {
    return city;
  }
}
