package com.tcs.rmg.common;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.tcs.rmg.services.UserService;

@Component
public class AutoApplyscheduler {
	
	@Autowired
	UserService userService;

  //@Scheduled(cron = "0 0 2 * * *") //1 AM every day
// @Scheduled(cron = "0 0 15 * * *") //2 PM every day
	//@Scheduled(cron = "0 10 16 * * *") 
	//@Scheduled(cron = "0 0/30 * * * *") 
	@Scheduled(cron = "0 0 3 * * *") //3 AM every day
	public void cronJobSch() {
         System.out.println("saveAutoAppliedPositionData job start at" + Calendar.getInstance().getTime());
         String type=userService.saveAutoAppliedPositionData();
 		if(type.equals("FAILED")) {
 		}	  System.out.println("saveAutoAppliedPositionData job end at with some issue" + Calendar.getInstance().getTime());
        System.out.println("saveAutoAppliedPositionData job end at" + Calendar.getInstance().getTime());
	}
}
