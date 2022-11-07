package com.tcs.iaspire.controller;

import com.tcs.iaspire.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(path = "/iaspire/empDetails/{empId}")
  public Map<String, ? extends Serializable> details(@PathVariable Long empId) {
    return userService.empDetails(empId);
  }
}
