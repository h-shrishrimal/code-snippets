package com.tcs.rmg.common;

public class AppConstant {
	
	public static final String ERROR_CODE_501 = "501";
	
	public static final String ERROR_CODE_1001 = "1001";
	public static final String ERROR_MSG_1001 = "User is not able to apply for this requirement.";
	public static final String ERROR_CODE_1002 = "1002";
	public static final String ERROR_MSG_1002 = "RMG Role is not authorized to apply any requirement.";
	public static final String ERROR_CODE_1003 = "1003";
	public static final String ERROR_MSG_1003 = "You have already applied for this requirement.";
	
	private AppConstant() {
		throw new IllegalAccessError("Constant class");
	}
}
