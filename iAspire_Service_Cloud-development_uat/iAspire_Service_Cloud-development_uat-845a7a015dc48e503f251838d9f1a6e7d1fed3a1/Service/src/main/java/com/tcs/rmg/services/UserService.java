package com.tcs.rmg.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.tcs.rmg.data.AppliedRequirementData;
import com.tcs.rmg.data.ApplyButtonFields;
import com.tcs.rmg.data.ConfirmRelease;
import com.tcs.rmg.data.EmployeeDetails;
import com.tcs.rmg.data.ExcitingOpportunitiesDataResponse;
import com.tcs.rmg.data.GLRequirementData;
import com.tcs.rmg.data.GLWorkList;
import com.tcs.rmg.data.RMGWorklistFYA;
import com.tcs.rmg.data.RequirementData;
import com.tcs.rmg.data.TotalExcitingOpportunitiesDetails;
import com.tcs.rmg.data.TotalRequirementDetails;
import com.tcs.rmg.data.TotalRequirementDataResponse;
import com.tcs.rmg.exception.RmgAppException;


public interface UserService {

	List<RequirementData> getTotalRequirementDetails(Integer employeeId, String isu);
	
	public TotalRequirementDataResponse getTotalDigitalRequirementDetails(TotalRequirementDetails totalRequirement,String isu);
	
	List<GLRequirementData> getTotalRequirementDetailsForGL(String isu);
	
	Integer getTotalRequirementCount(String isu) throws RmgAppException;
	
	String getEmployeeBusinessUnit(Integer employeeNumber) throws RmgAppException;
	
	Integer getRequirementCountInEmpBusinessUnit(Integer employeeNumber,String isu) throws RmgAppException;
	
	Integer getAppliedPositionsCountForUser(Integer employeeNumber) throws RmgAppException;
	
	Integer getPendingPositionsCountForUser(Integer employeeNumber) throws RmgAppException;
	
	List<String> getCompetencyList(String isu) throws RmgAppException;

	List<String> getRoleList() throws RmgAppException;
	
	List<String> getGeographyList(String isu) throws RmgAppException;
	List<String> getCountryList(String isu) throws RmgAppException;
	
	List<String> getBranchList(String isu) throws RmgAppException;
	
	List<String> getRequirementParentIOUList() throws RmgAppException;
	
	List<String> getRequirementChildIOUList() throws RmgAppException;
	List<String> getHorizontalParentIOUList();
	List<String> getHorizontalChildIOUList();
	
	List<RequirementData> getRequirementSearchList(String competency, String role, String geography, String isu);
	
	List<GLRequirementData> getRequirementSearchListForGL(String competency, String role, String geography, String country, String branch, String experience, String iou, String requirementStartDate,String isu);
	
	List<RequirementData> getRequirementListInEmpBusinessUnit(Integer employeeNumber,String isu) throws RmgAppException;
	
	List<AppliedRequirementData> getAppliedPositionsListForUser(Integer employeeNumber) throws RmgAppException;
	
	//90 days constraint
	List<AppliedRequirementData> getAppliedPositionsListForUserApplied(Integer employeeNumber) throws RmgAppException;
	
	List<AppliedRequirementData> getPendingPositionsListForUser(Integer employeeNumber,String isu) throws RmgAppException;
	
	List<RequirementData> getRecentOpenRequirementList(String isu) throws RmgAppException;
	
	List<GLWorkList> getGLWorklist(Integer employeeNumber,String isu);
	
	List<GLWorkList> getGLPendingWorklist(Integer employeeNumber,String isu);
	
	Integer getAppliedPositionsCountForGL(Integer employeeNumber);
	
	List<Integer> getRequestIdList(Integer requestorEmployeeId) throws RmgAppException;
	
	Integer getRecentOpenRequirementCount(String isu) throws RmgAppException;
	
	String getRoleOfEmployee(Integer employeeNumber) throws RmgAppException;
	
    Integer getAppliedPositionsCountForRmg(Integer employeeNumber);
	
	List<AppliedRequirementData> getAppliedPositionsListForRmg(Integer employeeNumber,String isu);
	
	List<AppliedRequirementData> getPendingPositionsListForRmg(Integer employeeNumber,String isu);
	
	Integer getPendingPositionsCountForRmg(Integer employeeNumber);
	
	Integer getPendingPositionsCountForGL(Integer employeeNumber);
	
	String addAppliedPositionData(ApplyButtonFields applyButtonFields) throws RmgAppException;
	
	List<RMGWorklistFYA> getRmgWorklistFYA(Integer employeeNumber, String isu);
	
	String confirmRelease(ConfirmRelease confirmRelease);
	
	public HSSFWorkbook excelExport(List<GLRequirementData> list) throws FileNotFoundException, IOException;

	String checkTFactorEligibility(String employeeId);

	List<RMGWorklistFYA> getRequestorWorklistFYA(Integer employeeNumber,String isu);
	
	List<RMGWorklistFYA> getApprovedRequestorWorklistFYA(Integer employeeNumber, Integer requirementId,String isu);

	String confirmRequestorRelease(ConfirmRelease confirmRelease);
	
	boolean sendEmailOnUserApplication(Integer employeeId, Integer requirementId,boolean isAutoApprove) throws AddressException, MessagingException;

	boolean sendEmailOnRequestorAction(Integer employeeId, Integer requirementId, Boolean release, Integer requestorEmployeeId) throws AddressException, MessagingException;
	
	public boolean sendEmailOnRmgAction(Integer employeeId, Integer requirementId, Boolean release) throws AddressException, MessagingException;
	
	List<Object> getRequestorRecommandations(Integer employeeNumber,String isu);
	
	Integer getRequestorRecommandationsCount(Integer employeeNumber) throws RmgAppException;
	
	void updateUsers() throws RmgAppException;
	
	Map<String, List<String>> getdropdownValues() throws RmgAppException;
	public String saveAutoAppliedPositionData();
	
	public String getVisaEligibility(String employeeId,Integer requirementId) throws RmgAppException;
	
	
	Integer getExcitingOpportunitiesCount(String isu) throws RmgAppException;

	List<RequirementData> getExcitingOpportunitiesList(String isu) throws RmgAppException;

	public ExcitingOpportunitiesDataResponse getExcitingOpportunitiesList(TotalExcitingOpportunitiesDetails totalExcitingOpportunitiesDetails,String isu);
	
	public EmployeeDetails getEmployeeRoleAndGrade(String empNumber) throws RmgAppException;

	

}