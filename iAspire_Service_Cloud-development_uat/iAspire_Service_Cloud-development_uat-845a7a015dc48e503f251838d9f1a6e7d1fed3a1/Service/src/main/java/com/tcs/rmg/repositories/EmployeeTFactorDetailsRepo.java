package com.tcs.rmg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tcs.rmg.domain.EmployeeTFactorDetails;


/**
 * @author 1077397
 *
 */
public interface EmployeeTFactorDetailsRepo extends CrudRepository<EmployeeTFactorDetails, String>, JpaRepository<EmployeeTFactorDetails, String> {

	@Query(value = "select tFactor from EmployeeTFactorDetails where employeeNumber = :employeeNumber")
	Double getTFactorDetails(@Param("employeeNumber") Integer employeeNumber);

}
