package com.tcs.rmg.repositories;

import com.tcs.rmg.entities.EmpMltHcrData;
import com.tcs.rmg.entities.EmployeeHeadCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpMltHcrDataRepo extends CrudRepository<EmpMltHcrData, Long>, JpaRepository<EmpMltHcrData, Long> {
}
