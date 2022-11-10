package com.tcs.rmg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.rmg.domain.UserRequirementMapping;

public interface UserRequirementMappingHelperRepo extends JpaRepository<UserRequirementMapping, Integer>{

	@Query("select s from UserRequirementMapping s where s.userId=:employeeId")
	List<UserRequirementMapping> getByUser(@Param("employeeId")Integer employeeId);
	

}
