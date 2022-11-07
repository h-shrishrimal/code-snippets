package dev.example.service;

import dev.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Map;

@Service
public class UserService {
  private final UserRepository userRepo;

  @Autowired
  public UserService(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  public Map<String, ? extends Serializable> empDetails(Long empId) {
    if (userRepo.findById(empId).isPresent())
      return Map.of("employeeId", empId, "isMLTEligible", true);
    return Map.of("employeeId", empId, "isMLTEligible", false);
  }
}
