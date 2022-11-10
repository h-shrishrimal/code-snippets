package com.tcs.rmg.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tcs.rmg.common.AppConstant;
import com.tcs.rmg.common.MailSender;
//import com.tcs.rmg.common.RSA;
import com.tcs.rmg.data.AdvanceFilter;
import com.tcs.rmg.data.AppliedRequirementData;
import com.tcs.rmg.data.ApplyButtonFields;
import com.tcs.rmg.data.ConfirmRelease;
import com.tcs.rmg.data.EmployeeDetails;
import com.tcs.rmg.data.ExcitingOpportunitiesCount;
import com.tcs.rmg.data.ExcitingOpportunitiesDataResponse;
import com.tcs.rmg.data.GLRequirementData;
import com.tcs.rmg.data.Message;
import com.tcs.rmg.data.RMGWorklistFYA;
import com.tcs.rmg.data.RequestorRecommendationCount;
import com.tcs.rmg.data.RequirementCount;
import com.tcs.rmg.data.RequirementData;
import com.tcs.rmg.data.Role;
import com.tcs.rmg.data.TotalExcitingOpportunitiesDetails;
import com.tcs.rmg.data.TotalRequirementDataResponse;
import com.tcs.rmg.data.TotalRequirementDetails;
import com.tcs.rmg.domain.UserAuditDetails;
import com.tcs.rmg.exception.RmgAppException;
import com.tcs.rmg.repositories.AppliedRequirementsDetailsRepo;
import com.tcs.rmg.repositories.AutoApplyRequirementRepository;
//import com.tcs.rmg.repositories.EmployeeDetailsRepo;
import com.tcs.rmg.repositories.RequirementDetailsRepo;
import com.tcs.rmg.repositories.UserAuditDetailsHelperRepo;
import com.tcs.rmg.service.impl.UserServiceImpl;
import com.tcs.rmg.services.UserService;


@RestController
@RequestMapping("rest/rmg")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	HttpSession session;
	@Autowired
	UserService userService;
	
	@Autowired
	RequirementDetailsRepo requirementDetailRepo;
	
	@Autowired 
	HttpServletRequest request;

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	UserAuditDetailsHelperRepo userAuditDetailsHelperRepo;
	
	@Autowired
	AutoApplyRequirementRepository autoApplyRequirementRepository;
	
	@Autowired
	AppliedRequirementsDetailsRepo appliedRequirementsDetailsRepo;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
/*		  SimpleClientHttpRequestFactory requestFactory = new  SimpleClientHttpRequestFactory(); Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("proxy.tcs.com", 8080)); requestFactory.setProxy(proxy);
		  return new RestTemplate(requestFactory);
*/	}

	@RequestMapping(value="/testService", method=RequestMethod.GET)
	public String testService()throws RmgAppException{
		try {

			try {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				String iAspireURL ="http://localhost:9104/iaspire/empdetails/1309480";
				logger.info("-----iAspireURL URL-----"+iAspireURL);
			    // customerData.toString().replace("PA And MI", "PA & MI");
			    ResponseEntity<String>  customerData = restTemplate().exchange(iAspireURL, HttpMethod.GET, null,String.class);
			    return customerData.getBody().toString();
			}catch (Exception e) {
				logger.info("-----getCustomerDetailVOs Exception--message---"+e.getMessage());
				logger.error("--getCustomerDetailVOs Exception-- e---"+e);
				 return null;
			}
		
			
		}catch(Exception e) {
			logger.error("testService"+e);
			throw new RmgAppException("testService", AppConstant.ERROR_CODE_501);
		}
	}
	

	
	@RequestMapping(value="/checkTFactorEligibility", method=RequestMethod.GET)
	public ResponseEntity checkTFactorEligibility(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP)throws RmgAppException{
		try {
		    logger.info("Inside checkTFactorEligibility start loggedInuser---" +employeeId);
			logger.info("checkTFactorEligibility remoteIP---" +remoteIP);
			
			String eligibility = userService.checkTFactorEligibility(employeeId);
			Message msg=new Message();
			msg.setMessage(eligibility);
			
			logger.info("Inside checkTFactorEligibility End---"+eligibility);
			return new ResponseEntity<>(msg, HttpStatus.OK);
		}catch(Exception e) {
			logger.error("checkTFactorEligibility"+e);
			throw new RmgAppException("checkTFactorEligibility", AppConstant.ERROR_CODE_501);
		}
	}
	
	//todo -1 Done -checked
	/*
	 * @RequestMapping(value="/getTotalRequirementDetails",
	 * method=RequestMethod.GET) public ResponseEntity
	 * getTotalRequirementDetails(@RequestHeader("employeeId") String
	 * employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu")
	 * String isu)throws RmgAppException{ try {
	 * logger.info("getTotalRequirementDetails loggedInuser---" +employeeId);
	 * logger.info("getTotalRequirementDetails remoteIP---" +remoteIP);
	 * List<RequirementData> reqDetails =
	 * userService.getTotalRequirementDetails(Integer.parseInt(employeeId),isu);
	 * if(reqDetails.isEmpty()) { return new
	 * ResponseEntity(reqDetails,HttpStatus.NO_CONTENT); }
	 * logger.info("empl "+employeeId); return new
	 * ResponseEntity<>(reqDetails,HttpStatus.OK); }catch(Exception e) {
	 * logger.error("getTotalRequirementDetails"+e); throw new
	 * RmgAppException("getTotalRequirementDetails", AppConstant.ERROR_CODE_501); }
	 * }
	 */	//todo -2 Done review
	@RequestMapping(value="/getTotalDigitalRequirementDetails", method=RequestMethod.POST)
	public ResponseEntity<TotalRequirementDataResponse> getTotalDigitalRequirementDetails(@RequestBody TotalRequirementDetails totalRequirement)throws RmgAppException{
		try {
				logger.info("Inside getTotalDigitalRequirementDetails--");
				//todo
				return ResponseEntity.ok(userService.getTotalDigitalRequirementDetails(totalRequirement,totalRequirement.getIsu()));
				
		}catch(Exception e) {
			logger.error("getTotalRequirementDetails"+e);
			throw new RmgAppException("getTotalRequirementDetails", AppConstant.ERROR_CODE_501);
		}
	}
	
	//todo -3 done checked
/* obsolte method comment
	@RequestMapping(value="/getTotalRequirementDetailsForGL", method=RequestMethod.GET)
	public List<GLRequirementData> getTotalRequirementDetailsForGL(@RequestHeader("isu") String isu) throws RmgAppException{
		List<GLRequirementData> reqDetails = null;
		logger.info("Inside getTotalRequirementDetailsForGL--");
		//todo
		try {
			reqDetails = userService.getTotalRequirementDetailsForGL(isu);
		}catch(Exception e) {
			logger.error("getTotalRequirementDetailsForGL"+e);
			throw new RmgAppException("DATA source not avilable" , AppConstant.ERROR_CODE_501);
		}
		return reqDetails;
	}
	*/
	//todo -4 done checked 

	@RequestMapping(value="/getRequirementsCountForUser", method=RequestMethod.GET)
	public RequirementCount getRequirementsCountForUser(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("Inside getRequirementsCountForUser--");
		Integer totalOpenPositions, openPositionsInBusinessUnit, appliedPositions, pendingApprovals, recentOpenRequirements, totalOpenDigitalPosition;
		//todo
		totalOpenPositions = this.getTotalRequirementCount(isu);
		//tpdo
		totalOpenDigitalPosition =this.getRequirementCountInEmpBusinessUnit(employeeId,remoteIP,isu);
		openPositionsInBusinessUnit = 0;
		appliedPositions = this.getAppliedPositionsCountForUser(employeeId,remoteIP);
		pendingApprovals = this.getPendingPositionsCountForUser(employeeId,remoteIP);
		recentOpenRequirements = this.getRecentOpenRequirementCount(isu);
		RequirementCount requirementCount = new RequirementCount(totalOpenPositions,openPositionsInBusinessUnit,appliedPositions, pendingApprovals, recentOpenRequirements, totalOpenDigitalPosition);
		return requirementCount;
	}
	
	//todo-5 done checked

	@RequestMapping(value="/getTotalRequirementCount", method=RequestMethod.GET)
	public Integer getTotalRequirementCount(@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("Inside getTotalRequirementCount--");
		Integer totalOpenPositions;
		try {
			//todo
			totalOpenPositions= userService.getTotalRequirementCount(isu);
			if(totalOpenPositions==null) {
				throw new RmgAppException("NO_CONTENT", AppConstant.ERROR_CODE_501);
			}
		}catch(Exception e) {
			logger.error("getTotalRequirementCount"+e);
			throw new RmgAppException("DATA source not avilable or Wrong sql query", AppConstant.ERROR_CODE_501);
		}		
		return totalOpenPositions;
	}
	
	@RequestMapping(value="/getEmployeeBusinessUnit", method=RequestMethod.GET)
	public String getEmployeeBusinessUnit(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP) throws RmgAppException{
		
		logger.info("getEmployeeBusinessUnit loggedInuser---" +employeeId);
		logger.info("getEmployeeBusinessUnit remoteIP---" +remoteIP);
		String employeeBusinessUnit = userService.getEmployeeBusinessUnit(Integer.parseInt(employeeId));
		return employeeBusinessUnit;
	}
	
	//todo-6 done checked
	@RequestMapping(value="/getRequirementCountInEmpBusinessUnit", method=RequestMethod.GET)
	public Integer getRequirementCountInEmpBusinessUnit(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("getRequirementCountInEmpBusinessUnit loggedInuser---" +employeeId);
		logger.info("getRequirementCountInEmpBusinessUnit remoteIP---" +remoteIP);
	  return userService.getRequirementCountInEmpBusinessUnit(Integer.parseInt(employeeId),isu);
	}
	
	//todo-7 done checked
	@RequestMapping(value="/getRequirementListInEmpBusinessUnit", method=RequestMethod.GET)
	public List<RequirementData> getRequirementListInEmpBusinessUnit(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("getRequirementListInEmpBusinessUnit loggedInuser---" +employeeId);
		logger.info("getRequirementListInEmpBusinessUnit remoteIP---" +remoteIP);
	  return userService.getRequirementListInEmpBusinessUnit(Integer.parseInt(employeeId),isu);
		
	}
	
	@RequestMapping(value="/getEmployeeRole", method=RequestMethod.GET)
	public Role getEmployeeRole(@RequestHeader("employeeId") String employeeId, @RequestHeader("remoteIP") String remoteIP) throws RmgAppException{
		logger.info("Inside getEmployeeRole loggedInuser---start --" +employeeId);
		logger.info("Inside getEmployeeRole remoteIP---" +remoteIP);
		Role r=new Role();
		r.setRole(userService.getRoleOfEmployee(Integer.parseInt(employeeId)));
		logger.info("Inside getEmployeeRole loggedInuser End ---");
	  return r;
	}
	
	//todo-8 done checked
	@RequestMapping(value="/getRecentOpenRequirementList", method=RequestMethod.GET)
	public List<RequirementData> getRecentOpenRequirementList(@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("Inside getRecentOpenRequirementList--");
	  return userService.getRecentOpenRequirementList(isu);
		
	}
	
	//todo-9 done checked
	@RequestMapping(value="/getRecentOpenRequirementCount", method=RequestMethod.GET)
	public Integer getRecentOpenRequirementCount(@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("Inside getRecentOpenRequirementCount--");
	  return userService.getRecentOpenRequirementCount(isu);
		
	}

	@RequestMapping(value="/getAppliedPositionsCountForUser", method=RequestMethod.GET)
	public Integer getAppliedPositionsCountForUser(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP) throws RmgAppException{
		logger.info("getAppliedPositionsCountForUser loggedInuser---" +employeeId);
		logger.info("getAppliedPositionsCountForUser remoteIP---" +remoteIP);
	  return userService.getAppliedPositionsCountForUser(Integer.parseInt(employeeId));	
	}
	@RequestMapping(value="/getAppliedPositionsListForUser", method=RequestMethod.GET)
	public List<AppliedRequirementData> getAppliedPositionsListForUser(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP) throws RmgAppException{
		logger.info("getAppliedPositionsListForUser loggedInuser---" +employeeId);
		logger.info("getAppliedPositionsListForUser remoteIP---" +remoteIP);
	  return userService.getAppliedPositionsListForUser(Integer.parseInt(employeeId));
	}
	
	@RequestMapping(value="/getAppliedPositionsListForUserApplied", method=RequestMethod.GET)
	public List<AppliedRequirementData> getAppliedPositionsListForUserApplied(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP) throws RmgAppException{
		logger.info("getAppliedPositionsListForUserApplied loggedInuser---" +employeeId);
		logger.info("getAppliedPositionsListForUserApplied remoteIP---" +remoteIP);
		//saveAuditEvent(Integer.parseInt(employeeId), "Applicant_FYI");
		return userService.getAppliedPositionsListForUserApplied(Integer.parseInt(employeeId));
	}
	
//todo 10-done checked
	@RequestMapping(value="/getPendingPositionsListForUser", method=RequestMethod.GET)
	public List<AppliedRequirementData> getPendingPositionsListForUser(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("getPendingPositionsListForUser loggedInuser---" +employeeId);
		logger.info("getPendingPositionsListForUser remoteIP---" +remoteIP);
	  return userService.getPendingPositionsListForUser(Integer.parseInt(employeeId),isu);
	}
//todo 11 //appliedReqDetails
	@RequestMapping(value="/getPendingPositionsCountForUser", method=RequestMethod.GET)
	public Integer getPendingPositionsCountForUser(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP) throws RmgAppException{
		logger.info("getPendingPositionsCountForUser loggedInuser---" +employeeId);
		logger.info("getPendingPositionsCountForUser remoteIP---" +remoteIP);
	  return userService.getPendingPositionsCountForUser(Integer.parseInt(employeeId));
	}
	
	//todo 12 done checked 
	@RequestMapping(value="/getCompetencyList", method=RequestMethod.GET)
	public List<String> getCompetencyList(@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("Inside getCompetencyList--");
	  return userService.getCompetencyList(isu);
	}
	
	@RequestMapping(value="/getRoleList", method=RequestMethod.GET)
	public List<String> getRoleList() throws RmgAppException{
		logger.info("Inside getRoleList--");
	  return userService.getRoleList();
	}
	
	@RequestMapping(value="/getRequestIdList", method=RequestMethod.GET)
	public List<Integer> getRequestIdList(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP) throws RmgAppException{
		logger.info("getRequestIdList loggedInuser---" +employeeId);
		logger.info("getRequestIdList remoteIP---" +remoteIP);
	  return userService.getRequestIdList(Integer.parseInt(employeeId));
	}
	//todo -13 done checked
	@RequestMapping(value="/getGeographyList", method=RequestMethod.GET)
	public List<String> getGeographyList(@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("Inside getGeographyList--");
		return userService.getGeographyList(isu);
	}
	//todo -14 done checked
	@RequestMapping(value="/getCountryList", method=RequestMethod.GET)
	public List<String> getCountryList(@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("Inside getCountryList--");
		return userService.getCountryList(isu);
	}
	//todo -15 done checked 
	@RequestMapping(value="/getBranchList", method=RequestMethod.GET)
	public List<String> getBranchList(@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("Inside getBranchList--");
		return userService.getBranchList(isu);
	}
	/* obsolte method comment

	@RequestMapping(value="/getRequirementParentIOUList", method=RequestMethod.GET)
	public List<String> getRequirementParentIOUList() throws RmgAppException{
		logger.info("Inside getRequirementParentIOUList--");
		return userService.getRequirementParentIOUList();
	}
	
	@RequestMapping(value="/getRequirementChildIOUList", method=RequestMethod.GET)
	public List<String> getRequirementChildIOUList() throws RmgAppException{
		logger.info("Inside getRequirementChildIOUList--");
		return userService.getRequirementChildIOUList();
	}
	
	@RequestMapping(value="/getHorizontalParentIOUList", method=RequestMethod.GET)
	public Set<String> getHorizontalParentIOUList(){
		logger.info("Inside getHorizontalParentIOUList--");
		Set<String> parentIOUList = new HashSet<>(userService.getHorizontalParentIOUList());
		return parentIOUList;
	}
	
	@RequestMapping(value="/getHorizontalChildIOUList", method=RequestMethod.GET)
	public Set<String> getHorizontalChildIOUList(){
		logger.info("Inside getHorizontalChildIOUList--");
		Set<String> childIOUList = new HashSet<>(userService.getHorizontalChildIOUList());
		return childIOUList;
	}
	*/
	@RequestMapping(value="/getIOUList", method=RequestMethod.GET)
	public Set<String> getIOUList() throws RmgAppException{
		logger.info("Inside getIOUList--");
		List<String> list = userService.getRequirementParentIOUList();
		
		list.addAll(userService.getRequirementChildIOUList());
		list.addAll(userService.getHorizontalParentIOUList());
		list.addAll(userService.getHorizontalChildIOUList());
		
		Set<String> iouList = new HashSet<>(list);
		return iouList;
	}
	
	//todo -16 doubt ---if condition Review 
	@RequestMapping(value="/getRequirementsSearchList", method=RequestMethod.GET)
	public List<RequirementData> getRequirementsSearchList(@RequestParam(value = "competency", required = false) String competency,
			@RequestParam(value = "role", required = false) String role,
			@RequestParam(value = "geography", required = false) String geography,
	        @RequestParam(value = "isu") String isu){
		logger.info("Inside getRequirementsSearchList--");
		return userService.getRequirementSearchList(competency, role, geography,isu);
	}
	
//todo -17 doubt --doubt iou and isu Review
	@RequestMapping(value="/getRequirementsSearchListForGL", method=RequestMethod.GET)
	public List<GLRequirementData> getRequirementsSearchList(@RequestBody AdvanceFilter advanceFilter){
		logger.info("Inside getRequirementsSearchListForGL--");
		return userService.getRequirementSearchListForGL(advanceFilter.getCompetency(), advanceFilter.getRole(), advanceFilter.getGeography(), advanceFilter.getCountry(), advanceFilter.getBranch(), advanceFilter.getExperience(), advanceFilter.getIou(), advanceFilter.getRequirementStartDate(),advanceFilter.getIsu());
	}
	
	/* obsolte method comment
	@RequestMapping(value="/getAppliedPositionsCountForRmg", method=RequestMethod.GET)
	public Integer getAppliedPositionsCountForRmg(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP){
		logger.info("getAppliedPositionsCountForRmg loggedInuser---" +employeeId);
		logger.info("getAppliedPositionsListForRmg remoteIP---" +remoteIP);
	  return userService.getAppliedPositionsCountForRmg(Integer.parseInt(employeeId));
	}
*/	

	//todo -18 done checked
	@RequestMapping(value="/getAppliedPositionsListForRmg", method=RequestMethod.GET)
	public List<AppliedRequirementData> getAppliedPositionsListForRmg(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP, @RequestHeader("isu") String isu){
		logger.info("getAppliedPositionsListForRmg loggedInuser---" +employeeId);
		logger.info("getAppliedPositionsListForRmg remoteIP---" +remoteIP);
	  return userService.getAppliedPositionsListForRmg(Integer.parseInt(employeeId),isu);
	}
	
	@RequestMapping(value="/getRmgWorklistFYA", method=RequestMethod.GET)
	public List<RMGWorklistFYA> getRmgWorklistFYA(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu){
		logger.info("Inside getRmgWorklistFYA Start loggedInuser---" +employeeId);
		logger.info("getRmgWorklistFYA remoteIP---" +remoteIP);
		saveAuditEvent(Integer.parseInt(employeeId), "RMG_FYA");
		logger.info("Inside getRmgWorklistFYA End---");
		return userService.getRmgWorklistFYA(Integer.parseInt(employeeId),isu);
	}
	//tpdo -19 done  chekced
	/* obsolte method comment

	@RequestMapping(value="/getAppliedPositionsCountForGL", method=RequestMethod.GET)
	public Integer getAppliedPositionsCountForGL(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP){
		logger.info("getAppliedPositionsCountForGL loggedInuser---" +employeeId);
		logger.info("getAppliedPositionsCountForGL remoteIP---" +remoteIP);
	  return userService.getAppliedPositionsCountForGL(Integer.parseInt(employeeId));
	}
	
	@RequestMapping(value="/getPendingPositionsCountForGL", method=RequestMethod.GET)
	public Integer getPendingPositionsCountForGL(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP){
		logger.info("getPendingPositionsCountForGL loggedInuser---" +employeeId);
		logger.info("getPendingPositionsCountForGL remoteIP---" +remoteIP);
	  return userService.getPendingPositionsCountForGL(Integer.parseInt(employeeId));
	}
	*/

//todo- 20 done checked 
	@RequestMapping(value="/getRequestorWorklistFYA", method=RequestMethod.GET)
	public List<RMGWorklistFYA> getRequestorWorklistFYA(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu){
		logger.info("Inside getRequestorWorklistFYA loggedInuser start---" +employeeId);
		logger.info("getRequestorWorklistFYA remoteIP---" +remoteIP);
		saveAuditEvent(Integer.parseInt(employeeId), "REQ_FYA");
		logger.info("Inside getRequestorWorklistFYA loggedInuser End---");
		return userService.getRequestorWorklistFYA(Integer.parseInt(employeeId),isu);
	}
//todo -21 done checked
	@RequestMapping(value="/getApprovedRequestorWorklistFYA", method=RequestMethod.GET)
	public List<RMGWorklistFYA> getApprovedRequestorWorklistFYA(@RequestHeader("employeeId") String employeeId, Integer requirementId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu){
		logger.info("getApprovedRequestorWorklistFYA loggedInuser---" +employeeId);
		logger.info("getApprovedRequestorWorklistFYA remoteIP---" +remoteIP);
	  return userService.getApprovedRequestorWorklistFYA(Integer.parseInt(employeeId),requirementId,isu);
	}
//todo -22	done checked 
	/* obsolte method comment

	@RequestMapping(value="/getGLWorklist", method=RequestMethod.GET)
	public List<GLWorkList> getGLWorklist(Integer rgsId,String isu){
		logger.info("Inside getGLWorklist--");
	  return userService.getGLWorklist(rgsId,isu);
	}
	*/
//todo -23  done checked 
	/* obsolte method comment

	@RequestMapping(value="/getGLPendingWorklist", method=RequestMethod.GET)
	public List<GLWorkList> getGLPendingWorklist(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu){
		logger.info("getGLPendingWorklist loggedInuser---" +employeeId);
		logger.info("getGLPendingWorklist remoteIP---" +remoteIP);
	  return userService.getGLPendingWorklist(Integer.parseInt(employeeId),isu);
	}
//todo	-24 done checked
	@RequestMapping(value="/getPendingPositionsListForRmg", method=RequestMethod.GET)
	public List<AppliedRequirementData> getPendingPositionsListForRmg(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu){
		logger.info("getPendingPositionsListForRmg loggedInuser---" +employeeId);
		logger.info("getPendingPositionsListForRmg remoteIP---" +remoteIP);
	  return userService.getPendingPositionsListForRmg(Integer.parseInt(employeeId),isu);
	}
//todo	-25 appliedReqDetails
	@RequestMapping(value="/getPendingPositionsCountForRmg", method=RequestMethod.GET)
	public Integer getPendingPositionsCountForRmg(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP){
		logger.info("getPendingPositionsCountForRmg loggedInuser---" +employeeId);
		logger.info("getPendingPositionsCountForRmg remoteIP---" +remoteIP);
	  return userService.getPendingPositionsCountForRmg(Integer.parseInt(employeeId));
	}
	*/
	/* obsolte method comment

//todo -26 done checked
	@RequestMapping(value="/getRequirementsCountForRmg", method=RequestMethod.GET)
	public RequirementCount getRequirementsCountForRmg(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("Inside getRequirementsCountForRmg--");
		Integer totalOpenPositions, openPositionsInBusinessUnit, appliedPositions, pendingApprovals, recentOpenRequirements, totalOpenDigitalPosition;
		totalOpenPositions = this.getTotalRequirementCount(isu);
		totalOpenDigitalPosition =this.getRequirementCountInEmpBusinessUnit(employeeId,remoteIP,isu);
		openPositionsInBusinessUnit = 0;
		//openPositionsInBusinessUnit = this.getRequirementCountInEmpBusinessUnit(employeeNumber);
		appliedPositions = this.getAppliedPositionsCountForRmg(employeeId,remoteIP);
		pendingApprovals = this.getPendingPositionsCountForRmg(employeeId,remoteIP);
		recentOpenRequirements = this.getRecentOpenRequirementCount(isu);
		RequirementCount requirementCount = new RequirementCount(totalOpenPositions,openPositionsInBusinessUnit,appliedPositions, pendingApprovals, recentOpenRequirements, totalOpenDigitalPosition);
		return requirementCount;
	}
*/
	/* obsolte method comment
	
	//todo -27 done checked
	@RequestMapping(value="/getRequirementsCountForGL", method=RequestMethod.GET)
	public RequirementCount getRequirementsCountForGL(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("Inside getRequirementsCountForGL--");
		Integer totalOpenPositions, openPositionsInBusinessUnit, appliedPositions, pendingApprovals, recentOpenRequirements, totalOpenDigitalPosition;
		totalOpenPositions = this.getTotalRequirementCount(isu);
		totalOpenDigitalPosition =this.getRequirementCountInEmpBusinessUnit(employeeId,remoteIP,isu);
		openPositionsInBusinessUnit =0; 
		appliedPositions = this.getAppliedPositionsCountForGL(employeeId,remoteIP);
		pendingApprovals = this.getPendingPositionsCountForGL(employeeId,remoteIP);
		recentOpenRequirements = this.getRecentOpenRequirementCount(isu);
		RequirementCount requirementCount = new RequirementCount(totalOpenPositions,openPositionsInBusinessUnit,appliedPositions, pendingApprovals, recentOpenRequirements, totalOpenDigitalPosition);
		return requirementCount;
	}
	
*/	
	@RequestMapping(value="/addAppliedPositionData", method=RequestMethod.POST)
	public ResponseEntity<?> addAppliedPositionData(@RequestBody ApplyButtonFields applyButtonFields, @RequestHeader("remoteIP") String remoteIP) throws ParseException, AddressException, MessagingException{
		
			logger.info("Inside addAppliedPositionData Start---");
			logger.info("addAppliedPositionData remoteIP---" +remoteIP);
		if(applyButtonFields==null||applyButtonFields.getEmployeeId()==null||applyButtonFields.getExperience()==null) {
			return new ResponseEntity<>("Insufficient Input Data", HttpStatus.BAD_REQUEST); 
		}
			String type=userService.addAppliedPositionData(applyButtonFields);
			if(type.equals("FAILED")) {
				return new ResponseEntity<>("DataSource couldn't be accessed", HttpStatus.SERVICE_UNAVAILABLE);
			}
			String excOppFlag =requirementDetailRepo.getExcitingOpportunityFLAG(applyButtonFields.getRequirementId());
			logger.info("Inside addAppliedPositionData Email excOppFlag---"+excOppFlag);

			userService.sendEmailOnUserApplication(applyButtonFields.getEmployeeId(), applyButtonFields.getRequirementId(),false);
			Message msg=new Message();
			msg.setMessage(type);
			saveAuditEvent(applyButtonFields.getEmployeeId(), "APPLY");
			logger.info("::::::::::::::::::::::Inside addAppliedPositionData applied Success End:::::::::::");
			return new ResponseEntity<Message>(msg, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/confirmRelease", method = RequestMethod.POST)
	public ResponseEntity<?> confirmRelease(@RequestBody ConfirmRelease confirmRelease,
			@RequestHeader("remoteIP") String remoteIP) throws RmgAppException {

		logger.info("Inside confirmRelease by RMG Start---");
		logger.info("confirmRelease remoteIP---" + remoteIP);
		try {
			if (confirmRelease == null) {
				throw new RmgAppException("Input Data Missing", AppConstant.ERROR_CODE_501);
			}
			if (confirmRelease.getRequirementId() == null) {
				throw new RmgAppException("Request ID Missing", AppConstant.ERROR_CODE_501);
			}
			String type = userService.confirmRelease(confirmRelease);

			userService.sendEmailOnRmgAction(confirmRelease.getEmployeeId(), confirmRelease.getRequirementId(),
					confirmRelease.getRelease());
			Message msg = new Message();
			msg.setMessage(type);
			logger.info("Inside confirmRelease by RMG End---" + msg);
			return new ResponseEntity<Message>(msg, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Exception in confirmRelease--" + e);
			throw new RmgAppException("Exception in confirmRelease", AppConstant.ERROR_CODE_501);
		}
	}

	@RequestMapping(value="/confirmRequestorRelease", method=RequestMethod.POST)
	public ResponseEntity<?> confirmRequestorRelease(@RequestBody ConfirmRelease confirmRelease,@RequestHeader("remoteIP") String remoteIP) throws RmgAppException {
		
		logger.info("Inside confirmRequestorRelease by RQ Start---");
		logger.info("confirmRequestorRelease remoteIP---" +remoteIP);
		try {
				if(confirmRelease==null) {
					throw new RmgAppException("Input Data Missing",AppConstant.ERROR_CODE_501);
				}
				if(confirmRelease.getRequirementId()==null) {
					throw new RmgAppException("Request ID Missing",AppConstant.ERROR_CODE_501);
				}
				String type =  userService.confirmRequestorRelease(confirmRelease);
				logger.info("confirmRequestorRelease type---" +type);

				userService.sendEmailOnRequestorAction(confirmRelease.getEmployeeId(), confirmRelease.getRequirementId(),confirmRelease.getRelease(),confirmRelease.getRequestorEmployeeId());
				Message msg=new Message();
				msg.setMessage(type);
				logger.info(":::::::::::::::::Inside confirmRequestorRelease by RQ End:::::::-"+msg);
				return new ResponseEntity<Message>(msg, HttpStatus.OK);
		}catch(Exception e) {
				logger.info("Exception in confirmRequestorRelease--"+e);
				throw new RmgAppException("Exception in confirmRequestorRelease", AppConstant.ERROR_CODE_501); 
		}
	}
	/* obsolte method comment
	
	//todo -28 done checked 
	@RequestMapping(value="/exportToExcel", method=RequestMethod.GET)
	public HttpEntity<byte[]> exportToExcel(@RequestHeader("isu") String isu) throws IOException,RmgAppException{
		logger.info("Inside exportToExcel--");
		HSSFWorkbook wb=userService.excelExport(getTotalRequirementDetailsForGL(isu));
		byte[] excelContent = wb.getBytes();
	    HttpHeaders header = new HttpHeaders();
	    header.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
	    header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Requirement_Details.xls");
	    header.setContentLength(excelContent.length);
	    return new HttpEntity<>(excelContent, header);
	}
*/		
	@RequestMapping(value = "/sendmailForTestPurpose", method = RequestMethod.GET)
	public ResponseEntity<String> sendmailForTestPurpose(@RequestParam(name = "email") String email) throws RmgAppException {
		logger.info("entry into  sendmail --");
		try {
		    logger.info("entry into  sendmail --");
			mailSender.sendMail("Mail for testing purpose --", email);
		} catch (MessagingException e) {
			logger.error("Error  into  sendmail --"+e);
			e.printStackTrace();
		}
		return new ResponseEntity<>("Sent mail", HttpStatus.OK);
	}
	
	//todo -29 done checked 
	@RequestMapping(value="/getRequestorRecommandations", method=RequestMethod.GET)
	public List<Object> getRequestorRecommandations(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu) throws RmgAppException{
		logger.info("getRequestorRecommandations loggedInuser---" +employeeId);
		logger.info("getRequestorRecommandations remoteIP---" +remoteIP);
		logger.info("employeeNumber"+employeeId);
	  return userService.getRequestorRecommandations(Integer.parseInt(employeeId),isu);
	}
	
	//todo -30 done checked
	@RequestMapping(value="/getRequestorRecommandationsCount", method=RequestMethod.GET)
	public RequestorRecommendationCount getRecommandationsCount(@RequestHeader("employeeId") String employeeId,@RequestHeader("remoteIP") String remoteIP,@RequestHeader("isu") String isu) throws RmgAppException{
		RequestorRecommendationCount reqRec;
		logger.info("employeeNumber"+employeeId);
		logger.info("getRequestorRecommandationsCount loggedInuser---" +employeeId);
		logger.info("getRequestorRecommandationsCount remoteIP---" +remoteIP);
		reqRec = new RequestorRecommendationCount(userService.getRequestorRecommandations(Integer.parseInt(employeeId),isu).size());
		logger.info("reqRec"+reqRec);
	  return reqRec;
	}
	@RequestMapping(value="/close", method=RequestMethod.GET)
	public void close() throws RmgAppException {
		userService.updateUsers();
	} 
	
	private void saveAuditEvent(Integer userId, String action) {
		UserAuditDetails auditDtls=new UserAuditDetails();
		auditDtls.setUserId(userId);
		auditDtls.setAuditTimestamp(new Date());
		auditDtls.setUserAction(action);
		userAuditDetailsHelperRepo.save(auditDtls);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getDropdownValues")
	public Map<String, List<String>> getDropdownValues() {

		logger.info("Inside getDropdownValues--");
		
		try {
			logger.info("Fetching dropdown values");
			Map<String, List<String>> ddvalues = userService.getdropdownValues();
			logger.info("exit from fetching dropdown values");
			return ddvalues;
		} catch (Exception e) {
			logger.info("Exception In fetching dropdown data --" + e);
			return null;
		}
	}
	/* obsolte method comment

	@RequestMapping(value="/saveAutoAppliedPositionData", method=RequestMethod.GET)
	public ResponseEntity<?> saveAutoAppliedPositionData() {
		logger.info("entry into controller--saveAutoAppliedPositionData--1");
		String type=userService.saveAutoAppliedPositionData();
		if(type.equals("FAILED")) {
			return new ResponseEntity<>("DataSource couldn't be accessed", HttpStatus.SERVICE_UNAVAILABLE);
		}	
	
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
*/	
	
	/*//Fetch remote IP in all services
	public void fetchRemoteAddress(HttpServletRequest request) {
		logger.info("entering to fetchRemoteAddress");
			try{
				String ipAddress = request.getHeader("X-FORWARDED-FOR");
				if (ipAddress == null) {
					ipAddress = request.getRemoteAddr();
					String ipAddress1 =  ipAddress.contains(",") ? ipAddress.split(",")[0] : ipAddress;
					logger.info("ipadress after ---" +ipAddress1);
				}
				String remoteIPAddr =  ipAddress.contains(",") ? ipAddress.split(",")[0] : ipAddress;
				logger.info("Inside fetchRemoteAddress --"+remoteIPAddr);
			}
			catch(Exception e) {
				logger.debug("Exception In fetchRemoteAddress --" + e);
			}
		}*/
	
	@RequestMapping(method = RequestMethod.GET, value = "/getVisaEligibility")
	public ResponseEntity getVisaEligibility(@RequestParam("employeeId") String employeeId,Integer requirementId)throws RmgAppException{
		try {
			logger.info("Inside getVisaEligibility-- 1::");
			String visaEligibility = userService.getVisaEligibility(employeeId,requirementId);
			Message msg=new Message();
			msg.setMessage(visaEligibility);
			logger.info("Inside getVisaEligibility -->2::"+visaEligibility);
			return new ResponseEntity<>(msg, HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Inside getVisaEligibility -->3::"+e);
			throw new RmgAppException("Inside getVisaEligibility -->4::", AppConstant.ERROR_CODE_501);
		}
	}

	//todo -31 done checked
	@RequestMapping(value = "/getExcitingOpportunitiesCount", method = RequestMethod.GET)
	public ExcitingOpportunitiesCount getExcitingOpportunitiesCount(@RequestParam("isu") String isu) throws RmgAppException {
		logger.info("getExcitingOpportunitiesCount loggedInuser---");
		Integer totalExcitingOpportunities;
		ExcitingOpportunitiesCount excitingOpportunityCount= new ExcitingOpportunitiesCount();
		try {
			//todo
			totalExcitingOpportunities = userService.getExcitingOpportunitiesCount(isu);
			if (totalExcitingOpportunities == null) {
				throw new RmgAppException("NO_CONTENT", AppConstant.ERROR_CODE_501);
			}
		} catch (Exception e) {
			logger.error("getTotalExcitingOpportunitiesCount" + e);
			throw new RmgAppException("DATA source not avilable or Wrong sql query", AppConstant.ERROR_CODE_501);
		}
		excitingOpportunityCount.setCount(totalExcitingOpportunities);
		return excitingOpportunityCount;
	}
	
	//todo -32 done checked 
	@RequestMapping(value = "/getExcitingOpportunitiesList", method = RequestMethod.GET)
	public List<RequirementData> getExcitingOpportunitiesList(@RequestParam("isu") String isu) throws RmgAppException {
		logger.info("getExcitingOpportunitiesList loggedInuser---");
		return userService.getExcitingOpportunitiesList(isu);
	}
	
	//todo 33 done checked Review 
	@RequestMapping(value="/getExcitingOpportunitiesList", method=RequestMethod.POST)
	public ResponseEntity<ExcitingOpportunitiesDataResponse> getExcitingOpportunitiesList(@RequestBody TotalExcitingOpportunitiesDetails totalExcitingOpportunitiesDetails) throws RmgAppException {
		
		logger.info("getExcitingOpportunitiesList remoteIP---");
		try {	
			ExcitingOpportunitiesDataResponse response =  userService.getExcitingOpportunitiesList(totalExcitingOpportunitiesDetails,totalExcitingOpportunitiesDetails.getIsu());
			return new ResponseEntity<ExcitingOpportunitiesDataResponse>(response,HttpStatus.OK);  
					
			}catch(Exception e) {
				logger.info("Exception in getExcitingOpportunitiesList--"+e);
				throw new RmgAppException("Exception in getExcitingOpportunitiesList", AppConstant.ERROR_CODE_501); 
		}
	}

	
	@RequestMapping(value="/getEmployeeRoleAndGrade", method=RequestMethod.GET)
	public ResponseEntity<EmployeeDetails> getEmployeeRoleAndGrade(@RequestHeader("employeeId") String employeeId, @RequestHeader("remoteIP") String remoteIP) throws RmgAppException{
		logger.info("Inside getEmployeeRoleAndGrade loggedInuser--- --" +employeeId);
		try {	
			EmployeeDetails response =  userService.getEmployeeRoleAndGrade(employeeId);
			return new ResponseEntity<EmployeeDetails>(response,HttpStatus.OK);  
			}catch(Exception e) {
				logger.info("Exception in getExcitingOpportunitiesList--"+e);
				throw new RmgAppException("Exception in getExcitingOpportunitiesList", AppConstant.ERROR_CODE_501); 
		}
	}	

}