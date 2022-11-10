package com.tcs.rmg.repositories;

import com.tcs.rmg.entities.AspireUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AspireUserDetailsRepo
    extends CrudRepository<AspireUserDetails, Integer>, JpaRepository<AspireUserDetails, Integer> {}
