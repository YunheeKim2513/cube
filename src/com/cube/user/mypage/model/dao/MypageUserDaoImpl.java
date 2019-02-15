package com.cube.user.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cube.model.dto.EmployeesListDto;
import com.cube.user.mypage.action.PageMoveAction;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class MypageUserDaoImpl implements MypageUserDao {
	
	private static MypageUserDaoImpl mypageUserDaoImpl;
	static{
		mypageUserDaoImpl=new MypageUserDaoImpl();
	}
	
	public static MypageUserDaoImpl getMypageUserDaoImpl() {
		return mypageUserDaoImpl;
	}
	private MypageUserDaoImpl(){
	
	}

	
	

	@Override
	public EmployeesListDto searchid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int empupdate(EmployeesListDto employeesListDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			conn=DBConnection.makeConnection();
			int idx=0;
			String sql="";
			sql="update employees \n";
			sql+="set pass=?, \n";
			sql+="    gender=?, hp1=?, hp2=?, hp3=?, email1=?, email2=? \n";
			sql+="where employee_id=? \n";
			pstmt=conn.prepareStatement(sql);
			System.out.println("Employee_id() : "+employeesListDto.getEmployee_id());
			pstmt.setString(++idx, employeesListDto.getPass());
			pstmt.setString(++idx, employeesListDto.getGender());
			pstmt.setString(++idx, employeesListDto.getHp1());
			pstmt.setString(++idx, employeesListDto.getHp2());
			pstmt.setString(++idx, employeesListDto.getHp3());
			pstmt.setString(++idx, employeesListDto.getEmail1());
			pstmt.setString(++idx, employeesListDto.getEmail2());
			pstmt.setString(++idx, employeesListDto.getEmployee_id());
			result=pstmt.executeUpdate();
			
			pstmt.close();
			
			idx=0;//save_folder, origin_picture, save_picture
			sql="update employees_detail \n";
			sql+="set hn1=?, hn2=?, hn3=?, marriage=?, \n";
			sql+="    zip1=?, zip2=?, addr1=?, addr2=?, \n";
			sql+="    save_folder=?, origin_picture=?, save_picture=? \n";
			sql+="where employee_id=? \n";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(++idx, employeesListDto.getHn1());
			pstmt.setString(++idx, employeesListDto.getHn2());
			pstmt.setString(++idx, employeesListDto.getHn3());
			pstmt.setString(++idx, employeesListDto.getMarraige());
			pstmt.setString(++idx, employeesListDto.getZip1());
			pstmt.setString(++idx, employeesListDto.getZip2());
			pstmt.setString(++idx, employeesListDto.getAddr1());
			pstmt.setString(++idx, employeesListDto.getAddr2());
			pstmt.setString(++idx, employeesListDto.getSave_folder());
			pstmt.setString(++idx, employeesListDto.getOrigin_picture());
			pstmt.setString(++idx, employeesListDto.getSave_picture());
			pstmt.setString(++idx, employeesListDto.getEmployee_id());
			result+=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return result;
	}





}
