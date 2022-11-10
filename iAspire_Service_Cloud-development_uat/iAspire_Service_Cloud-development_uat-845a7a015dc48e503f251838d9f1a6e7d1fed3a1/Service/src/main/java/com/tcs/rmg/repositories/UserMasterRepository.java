package com.tcs.rmg.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tcs.rmg.domain.UserMasterEntity;

@Repository
public interface UserMasterRepository extends CrudRepository<UserMasterEntity, Long> {

/*	public UserMasterData findByEmpNumber(String empNo) throws Exception;
	//public User findByUserName(String name) throws Exception;
	 * 
	
	@Query(value =  " select a from UserMasterData a where a.empNumber = :empNo OR a.empName like %:empName%\r\n order by a.empName")
	List<UserMasterData>getEmployeeDetails(@Param("empNo") String empNumber, @Param("empName") String empName);*/
	
	public UserMasterEntity findByEmpNo(String empNo) throws Exception;
	
	@Query(value = "select segment from UserMasterEntity where empNo = :employeeNumber")
	String getEmployeeBusinessUnit(@Param("employeeNumber") String employeeNumber);
	
	@Query(value = "select role from UserMasterEntity where empNo = :employeeNumber")
	String getRoleOfEmployee(@Param("employeeNumber") String employeeNumber);
	
	/*@Query(value = "select rmEmployeeNumber from EmployeeDetails where employeeNumber = :employeeNumber")
	Integer getRmgEmployeeId(@Param("employeeNumber") Integer employeeNumber);*/
	
	/*@Query(value = "select glEmpNo from EmployeeDetails where employeeNumber = :employeeNumber")
	Integer getGlEmployeeId(@Param("employeeNumber") Integer employeeNumber);*/
	
	@Query(value = "select empName from UserMasterEntity where empNo = :employeeNumber")
	String getEmployeeName(@Param("employeeNumber") String employeeNumber);
	
	/*@Query(value = "select emailAddress from EmployeeDetails where employeeNumber = :employeeNumber")
	String getEmployeerEmail(@Param("employeeNumber")Integer rmgId);*/
	
	@Query(value = "select grade from UserMasterEntity where empNo = :employeeNumber")
	String getGradeOfEmployee(@Param("employeeNumber") String employeeNumber);
	
	@Query(value = "select employeeDeputeCountry from UserMasterEntity where empNo = :employeeNumber")
	String getEmployeeDeputeCountry(@Param("employeeNumber") String employeeNumber);

	@Query(value = "select tfactorFlag from UserMasterEntity where empNo = :employeeNumber")
	String getTFactorFlagDetails(@Param("employeeNumber") String employeeNumber);

	@Query(value = "select grade from UserMasterEntity where empNo = :employeeNumber")
	String getEmployeeGrade(@Param("employeeNumber") String employeeNumber);

}
