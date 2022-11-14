package com.tcs.rmg.repositories;

import com.tcs.rmg.entities.EmpCertification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpCertificationRepo extends CrudRepository<EmpCertification, Long>, JpaRepository<EmpCertification, Long> {
}
