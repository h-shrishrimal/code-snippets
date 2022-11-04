package dev.example;

import dev.example.entities.User;
import dev.example.entities.UserDetail;
import dev.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired private UserRepository userRepo;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    userRepo.save(new User("a1@b.com",new UserDetail("1234","Mumbai")));
    userRepo.save(new User("a2@b.com",new UserDetail("1234","Mumbai")));
    userRepo.save(new User("a3@b.com",new UserDetail("1234","Mumbai")));
    userRepo.save(new User("a4@b.com",new UserDetail("1234","Mumbai")));
  }
}
