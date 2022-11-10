package com.tcs.rmg.common;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//import org.apache.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RSA {
	
	private static final Logger logger = LoggerFactory.getLogger(RSA.class);
	
  public synchronized String decrypt(String refId) throws Exception {
	  String empId = null;
	  String cipherText = "";
	  BigInteger dKey = null;
	  BigInteger nKey = null;
	  Connection con=null;
	  ResultSet rs = null;
	  PreparedStatement pstmt = null;
	  String Query = "select cipherText, d, n from new_ultimate.rsa where d=? and flag='Y'";
	  	try{
			  con = getConnection();
			  
			  	pstmt = con.prepareStatement(Query);
				pstmt.setString(1, refId);
				logger.info("Query : "+pstmt.toString());
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					cipherText = rs.getString("cipherText");
					dKey = new BigInteger(rs.getString("d"));
					nKey = new BigInteger(rs.getString("n"));
				}
				if(!cipherText.equalsIgnoreCase(""))
				{
					empId = new String((new BigInteger(cipherText)).modPow(dKey, nKey).toByteArray());
				}
	  	}
	  catch(Exception ex)
	  {
		  logger.info("Exception in decrypt:"+ex);
		  throw ex;
	  }
	  finally{
	  	if(null != pstmt) {
			pstmt.close();
			closeConnection(con);
		}
	  }
	  return empId;
  }
  
  /** Disable ref id after being used..
 * @throws Exception */
  public void disableId(String id) throws Exception
  {
	  Connection con=null; 
	  PreparedStatement pstmt = null;
	  String Query = "update new_ultimate.rsa set flag='N' where d=? ";
	  try{
		  con = getConnection();
		  
		  	pstmt = con.prepareStatement(Query);
			pstmt.setString(1, id);
			logger.info("Query : "+pstmt.toString());
			pstmt.execute();
			logger.info("Deleted...");
	  }
	  catch(Exception exp)
	  {
		  logger.info("Exception in disableId:"+exp);
		  throw exp;
	  }
	  finally{
		  if(null != pstmt) {
			  pstmt.close();
			  closeConnection(con);
		  }
	  }
  }
  
  public Connection getConnection()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con =DriverManager.getConnection("jdbc:mysql://3.209.122.246/rmg_app", "rmg_app","digi_rmg_app");
		} catch (Exception e) {
			try {
				if(con!=null) {
				con.close();
				}
			} catch (SQLException e1) {
				logger.info("Exception in RSA --"+e1);
				e1.printStackTrace();
			}
			logger.info("Exception in RSA: "+e);
			e.printStackTrace();
		}
		return con;
	}

	public void closeConnection(Connection con) throws Exception
	{
		if(con!=null)
		{
			try 
			{
				con.close();
			} 
			catch(SQLException e) 
			{
				logger.error("Exception in closeConnection:"+e);
				throw e;
			}
		}
	}
 
}