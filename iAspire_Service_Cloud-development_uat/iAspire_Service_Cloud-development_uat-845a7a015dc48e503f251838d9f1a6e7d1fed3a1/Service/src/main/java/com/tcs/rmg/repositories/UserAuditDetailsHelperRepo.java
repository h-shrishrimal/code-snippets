package com.tcs.rmg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import com.tcs.rmg.domain.UserAuditDetails;

public interface UserAuditDetailsHelperRepo extends JpaRepository<UserAuditDetails,Integer>{

} 