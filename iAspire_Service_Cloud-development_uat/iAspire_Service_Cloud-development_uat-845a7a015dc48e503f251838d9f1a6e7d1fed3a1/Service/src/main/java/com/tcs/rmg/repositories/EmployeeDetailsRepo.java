/*package com.tcs.rmg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tcs.rmg.domain.EmployeeDetails;


*//**
 * @author 1077397
 *
 *//*
public interface EmployeeDetailsRepo extends CrudRepository<EmployeeDetails, Integer>, JpaRepository<EmployeeDetails, Integer> {

	
	@Query(value = "select business from EmployeeDetails where employeeNumber = :employeeNumber")
	String getEmployeeBusinessUnit(@Param("employeeNumber") Integer employeeNumber);
	
	@Query(value = "select portalGroup from EmployeeDetails where employeeNumber = :employeeNumber")
	String getRoleOfEmployee(@Param("employeeNumber") Integer employeeNumber);
	
	@Query(value = "select rmEmployeeNumber from EmployeeDetails where employeeNumber = :employeeNumber")
	Integer getRmgEmployeeId(@Param("employeeNumber") Integer employeeNumber);
	
	@Query(value = "select glEmpNo from EmployeeDetails where employeeNumber = :employeeNumber")
	Integer getGlEmployeeId(@Param("employeeNumber") Integer employeeNumber);
	
	@Query(value = "select employeeName from EmployeeDetails where employeeNumber = :employeeNumber")
	String getEmployeeName(@Param("employeeNumber") Integer employeeNumber);

	@Query(value = "select emailAddress from EmployeeDetails where employeeNumber = :employeeNumber")
	String getEmployeerEmail(@Param("employeeNumber")Integer rmgId);



}
*/