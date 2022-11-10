package com.tcs.rmg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.rmg.domain.DropDownEntity;

public interface DropDownRepository extends JpaRepository<DropDownEntity, Integer> {
	
	@Query("Select distinct a.dropdownColumn from DropDownEntity a")
	public List<String> getUniqueDDColumn();
	
	@Query("Select distinct a.dropdownValue from DropDownEntity a where a.dropdownColumn=:dropdownColumn")
	public List<String> getDropDownValueBasedOnCol(@Param("dropdownColumn") String dropdownColumn);

}
