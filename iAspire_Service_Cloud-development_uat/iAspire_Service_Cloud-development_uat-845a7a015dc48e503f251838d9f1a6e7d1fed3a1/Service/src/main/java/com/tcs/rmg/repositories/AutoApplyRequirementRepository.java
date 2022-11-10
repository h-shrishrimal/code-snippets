package com.tcs.rmg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.rmg.domain.AutoApplyRequirement;

public interface AutoApplyRequirementRepository extends CrudRepository<AutoApplyRequirement, Integer>, JpaRepository<AutoApplyRequirement, Integer> {

	
	@Query(value = "select a from AutoApplyRequirement a where a.isapplied = 'N'")
	List<AutoApplyRequirement> getRemainingAppliedPositionsForUser();

	

	@Transactional
	@Modifying
	@Query(value = "update AutoApplyRequirement set isapplied = 'Y' where requirementId = :requirementId and applicantEmployeeId=:employeeId and autoapplyRequirementId=:autoapplyRequirementId") 
	void updateAutoAppliedRequirement(@Param("requirementId") Integer requirementId,@Param("employeeId")Integer employeeId,@Param("autoapplyRequirementId")Integer autoapplyRequirementId);



	@Transactional
	@Modifying
	@Query(value = "update AutoApplyRequirement set isapplied = 'Y',reasonForFailure=:reasonForFailure where requirementId = :requirementId and applicantEmployeeId=:employeeId and autoapplyRequirementId=:autoapplyRequirementId") 
	void updateAutoAppliedRequirementwithFailureReason(@Param("reasonForFailure") String reasonForFailure,@Param("requirementId") Integer requirementId,@Param("employeeId")Integer employeeId,@Param("autoapplyRequirementId")Integer autoapplyRequirementId);

}