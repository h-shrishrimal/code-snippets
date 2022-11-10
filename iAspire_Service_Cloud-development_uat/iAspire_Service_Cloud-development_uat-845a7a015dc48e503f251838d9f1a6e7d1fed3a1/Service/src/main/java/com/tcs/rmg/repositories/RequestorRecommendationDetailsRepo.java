package com.tcs.rmg.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.rmg.domain.AppliedRequirementsDetails;
import com.tcs.rmg.domain.RequestorRecommendationDetails;


/**
 * @author 1077397
 *
 */


public interface RequestorRecommendationDetailsRepo extends CrudRepository<RequestorRecommendationDetails, String>, JpaRepository<RequestorRecommendationDetails, String> {

	//changed
	@Query(value = "select a.employeeId,b.requirementId,a.ievolveMatch, b.role,b.totalExperience, b.requirementBranch,	b.requirementCity, b.requirementCountry, b.business, b.competencyProficiencyDetails, b.requestCreatedOn "
			+ "from RequestorRecommendationDetails a, RequirementDetails b where a.employeeId = :employeeNumber and a.requirementId = b.requirementId and b.isu in(:isu) ")
	List<Object> getRequestorRecommandations(@Param("employeeNumber") Integer employeeNumber, @Param("isu") String isu);
	
	@Query(value = "select count(*) from rmg_app.recommendations_requirement where employee_number = :employeeNumber",nativeQuery = true)
	Integer getRequestorRecommandationsCount(@Param("employeeNumber") Integer employeeNumber);
	
}
