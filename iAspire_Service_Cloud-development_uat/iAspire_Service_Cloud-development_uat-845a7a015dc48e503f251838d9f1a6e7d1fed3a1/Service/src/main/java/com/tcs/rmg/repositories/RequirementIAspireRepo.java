package com.tcs.rmg.repositories;

import com.tcs.rmg.entities.RequirementIAspire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RequirementIAspireRepo extends CrudRepository<RequirementIAspire, Integer>, JpaRepository<RequirementIAspire, Integer>  {
}
