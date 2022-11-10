package com.tcs.rmg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.tcs.rmg.domain.UserAuthorizationDetails;

public interface UserAuthorizationRepository extends CrudRepository<UserAuthorizationDetails, Long> {
	
	@Query(value ="select empNumber from UserAuthorizationDetails where appId =2 and roleName ='RM' and empNumber =:employeeNumber")
	String getRmgId(@Param("employeeNumber") String employeeNumber);
	
	@Query(value ="select empNumber from UserAuthorizationDetails where appId =2 and roleName ='RM'")
	List<String> getRmgList();
	

	@Query(value ="select empNumber from UserAuthorizationDetails where appId =2 and roleName ='EXOPP_REQUESTOR'")
	List<String> getRequesterIdList();

	@Query(value ="select empNumber from UserAuthorizationDetails where appId =2 and roleName ='EXOPP_REQUESTOR' and empNumber =:employeeNumber")
	String checkExOppRequestor(@Param("employeeNumber") String employeeNumber);

	
	//String getRmgId(@Param("employeeNumber") Integer employeeNumber);
	
	//"select empNumber from UserAuthorizationDetails where appId =2 and roleName ='RM' and emp_no =:employeeNumber"
	
	//"select emp_no from global_login.user_authorization_details where app_id =2 and role_name ='RM' and emp_no ='325915'";


}