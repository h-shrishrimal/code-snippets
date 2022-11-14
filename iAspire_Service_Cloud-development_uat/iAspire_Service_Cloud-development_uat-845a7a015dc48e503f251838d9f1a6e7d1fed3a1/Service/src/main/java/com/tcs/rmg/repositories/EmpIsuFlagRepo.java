package com.tcs.rmg.repositories;

import com.tcs.rmg.entities.EmpCertification;
import com.tcs.rmg.entities.EmpIsuFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpIsuFlagRepo extends CrudRepository<EmpIsuFlag, Integer>, JpaRepository<EmpIsuFlag, Integer> {
}
