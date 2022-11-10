package com.tcs.rmg.repositories;

import com.tcs.rmg.entities.EmployeeHeadCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeHeadCountRepo extends CrudRepository<EmployeeHeadCount, Integer>, JpaRepository<EmployeeHeadCount, Integer> {
}
