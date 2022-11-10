/*package com.tcs.rmg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.rmg.domain.RmgDetails;

public interface RmgDetailsHelperRepo extends JpaRepository<RmgDetails,Integer>{
	
	@Query(value = "select rmgId from  RmgDetails s where rmgId=:employeeNumber")
	Integer getRmgId(@Param("employeeNumber") Integer employeeNumber);

}
*/