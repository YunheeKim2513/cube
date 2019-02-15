package com.cube.util.db;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBConnection {
	
//	
//	static{// 처음에 로드 할 때 한번만 실행 된다. 
//		
// 		try {
// 			Class.forName("oracle.jdbc.driver.OracleDriver");
// 		} catch (ClassNotFoundException e) {
// 			e.printStackTrace();
// 		}
// 
//}
//
//	
//	
//	public synchronized static Connection makeConnection() throws SQLException {//내가 호출한 것 내가 가져가 쓰니깐 new를 안하려고 static한것
//			return DriverManager.getConnection("jdbc:oracle:thin:@183.101.196.135:1521:orcl", "cube", "cube");
//
//	}
	
	
	 private static DataSource dataSource;
	   
	   static {
	      try {
	         Context ctx = new InitialContext();
	         Context rootCtx = (Context) ctx.lookup("java:comp/env");
	         dataSource = (DataSource) rootCtx.lookup("jdbc/ncs_cubegroupware");
	      } catch (NamingException e) {
	         e.printStackTrace();
	      }
	   }

	   public static Connection makeConnection() throws SQLException {
	      return dataSource.getConnection();
	   }

}
