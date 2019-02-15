package com.cube.user.diligence.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cube.model.dto.User_timeDto;
import com.cube.model.dto.User_timeworkDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class DiligenceDaoImpl implements DiligenceDao {
   private static DiligenceDaoImpl diligenceDaoImpl;
   
   static{
      diligenceDaoImpl = new DiligenceDaoImpl();
   }
   
   private DiligenceDaoImpl(){};
   
   public static DiligenceDaoImpl getDiligenceDaoImpl() {
      return diligenceDaoImpl;
   }

   @Override
   public void intime(User_timeDto user_timeDto) {
      

      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         conn=DBConnection.makeConnection();
         conn.setAutoCommit(false);
         
         StringBuffer sb = new StringBuffer();
         
         sb.append("insert into user_time(user_time_seq, employee_id, usercheckin_date, usercheckin_time, user_diligence)\n");
         sb.append("values(user_time_seq.nextval, ?, to_char(sysdate, 'YYYY-MM-DD'), ?, ?) \n");
      
         pstmt = conn.prepareStatement(sb.toString());
         
         int idx = 0;
         
         pstmt.setString(++idx, user_timeDto.getEmployee_id());
         pstmt.setString(++idx, user_timeDto.getUsercheckin_time());
         pstmt.setString(++idx, user_timeDto.getUser_diligence());
      
         
         pstmt.executeUpdate();
         
         conn.commit();
         
      } catch (SQLException e) {
         
         e.printStackTrace();
      }
      
      
   }

   @Override
   public void outtime(User_timeDto user_timeDto2) {

      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         conn=DBConnection.makeConnection();
         conn.setAutoCommit(false);
         
         StringBuffer sb = new StringBuffer();
    /*   
         Date today = new Date();
         SimpleDateFormat date = new SimpleDateFormat ( "yyyy-MM-dd");
         */
      
         sb.append("insert into user_time(user_time_seq, employee_id, usercheckout_date, usercheckout_time, user_diligence) \n");
         sb.append("values(user_time_seq.nextval, ?, to_char(sysdate, 'YYYY-MM-DD'), ?, ?)");
        
         pstmt = conn.prepareStatement(sb.toString());
         
        
         pstmt.setString(1, user_timeDto2.getEmployee_id());
         pstmt.setString(2, user_timeDto2.getUsercheckout_time());
         pstmt.setString(3, user_timeDto2.getUser_diligence());
   
         
         
         pstmt.executeUpdate();
         
         conn.commit();
         
      } catch (SQLException e) {
         
         e.printStackTrace();
      }
      
   }

   /*@Override
   public void intimework(User_timeworkDto user_timeworkDto) {
   
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         conn=DBConnection.makeConnection();
         conn.setAutoCommit(false);
         
         
         StringBuffer sb2 = new StringBuffer();
         
         sb2.append("insert into user_timework(usertimework_seq, starthour, starttime, startmin, group_standard, employee_id) \n");
         sb2.append("values (usertimework_seq.nextval, ?, ?, ?, ?, ?) \n");
      
         pstmt = conn.prepareStatement(sb2.toString());
   
   
         int idx2=0;
         

         pstmt.setString(++idx2, user_timeworkDto.getStarthour());
         pstmt.setString(++idx2, user_timeworkDto.getStarttime());
         pstmt.setString(++idx2, user_timeworkDto.getStartmin());
         pstmt.setString(++idx2, user_timeworkDto.getGroup_standard());
         pstmt.setString(++idx2, user_timeworkDto.getEmployee_id());
         
         
         pstmt.executeUpdate();
         
         conn.commit();
         
      } catch (SQLException e) {
         
         e.printStackTrace();
      }
      return ;
   }
*/
   @Override
   public void outtimework(User_timeworkDto user_timeworkDto) {

      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         conn=DBConnection.makeConnection();
         conn.setAutoCommit(false);
         
         
         StringBuffer sb2 = new StringBuffer();
         
         sb2.append("insert into user_timework(usertimework_seq, starthour, starttime, \n");
         sb2.append("			startmin, group_standard, employee_id, endtime, endhour, endmin) \n");
         sb2.append("values (usertimework_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?) \n");
      
      
         pstmt = conn.prepareStatement(sb2.toString());
   
   
         int idx2=0;
         
         pstmt.setString(++idx2, user_timeworkDto.getStarthour());
         pstmt.setString(++idx2, user_timeworkDto.getStarttime());
         pstmt.setString(++idx2, user_timeworkDto.getStartmin());
         pstmt.setString(++idx2, user_timeworkDto.getGroup_standard());
         pstmt.setString(++idx2, user_timeworkDto.getEmployee_id());
         pstmt.setString(++idx2, user_timeworkDto.getEndtime());
         pstmt.setString(++idx2, user_timeworkDto.getEndhour());
         pstmt.setString(++idx2, user_timeworkDto.getEndmin());

         
         
         
         pstmt.executeUpdate();
         
         conn.commit();
         
      } catch (SQLException e) {
         
         e.printStackTrace();
      }
   }



	@Override
	public List<User_timeDto> list(String id) {
		List<User_timeDto> list=new ArrayList<User_timeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select nvl(usercheckin_date,' ') usercheckin_date, nvl(usercheckout_date,' ') usercheckout_date, nvl(usercheckin_time,' ') usercheckin_time, nvl(usercheckout_time,' ') usercheckout_time \n");
			sql.append("from user_time \n");
			sql.append("where employee_id=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				User_timeDto user_timeDto=new User_timeDto();
				user_timeDto.setUsercheckin_date(rs.getString("usercheckin_date"));
				user_timeDto.setUsercheckout_date(rs.getString("usercheckout_date"));
				user_timeDto.setUsercheckin_time(rs.getString("usercheckin_time"));
				user_timeDto.setUsercheckout_time(rs.getString("usercheckout_time"));
				list.add(user_timeDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	
}
