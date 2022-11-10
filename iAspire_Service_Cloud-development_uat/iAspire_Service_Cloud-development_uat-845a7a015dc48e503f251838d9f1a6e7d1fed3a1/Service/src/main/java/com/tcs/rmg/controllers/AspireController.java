package com.tcs.rmg.controllers;

import com.tcs.rmg.common.AppConstant;
import com.tcs.rmg.data.TotalRequirementDataResponse;
import com.tcs.rmg.data.TotalRequirementDetails;
import com.tcs.rmg.exception.RmgAppException;
import com.tcs.rmg.service.impl.AspireService;
import com.tcs.rmg.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Map;

@RestController
@RequestMapping("rest/iaspire")
public class AspireController {

  private final AspireService aspireService;

  private static final Logger logger = LoggerFactory.getLogger(AspireController.class);

  public AspireController(AspireService aspireService) {
    this.aspireService = aspireService;
  }

  @GetMapping(path = "/empdetails/{empId}")
  public Map<String, ? extends Serializable> details(@PathVariable Long empId) {
    return aspireService.empDetails(empId);
  }


  @RequestMapping(value="/getTotalDigitalRequirementDetails", method= RequestMethod.POST)
  public ResponseEntity<TotalRequirementDataResponse> getTotalDigitalRequirementDetails(@RequestBody TotalRequirementDetails totalRequirement)throws RmgAppException {
    try {
      logger.info("Inside getTotalDigitalRequirementDetails--");
      return ResponseEntity.ok(aspireService.getTotalDigitalRequirementDetails(totalRequirement,totalRequirement.getIsu()));
    }catch(Exception e) {
      logger.error("getTotalRequirementDetails"+e);
      throw new RmgAppException("getTotalRequirementDetails", AppConstant.ERROR_CODE_501);
    }
  }
}
