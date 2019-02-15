package com.cube.util.db;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBConnection {
	
//	
//	static{// ó���� �ε� �� �� �ѹ��� ���� �ȴ�. 
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
//	public synchronized static Connection makeConnection() throws SQLException {//���� ȣ���� �� ���� ������ ���ϱ� new�� ���Ϸ��� static�Ѱ�
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
