package dev.example.repo;

import dev.example.entities.User;
import dev.example.entities.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInformation, Long> {}
