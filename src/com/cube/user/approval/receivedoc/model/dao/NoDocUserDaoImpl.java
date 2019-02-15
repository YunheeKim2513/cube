package com.cube.user.approval.receivedoc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class NoDocUserDaoImpl implements NoDocUserDao {
	
	private static NoDocUserDao noDocUserDao;
	
	static{
		noDocUserDao = new NoDocUserDaoImpl();
	}
	
	private NoDocUserDaoImpl(){}

	public static NoDocUserDao getNoDocUserDao() {
		return noDocUserDao;
	}

	@Override
	public List<Doc_info_detailDto> nolistapprovallist(String id) {
		List<Doc_info_detailDto> nolistapprovallist = new ArrayList<Doc_info_detailDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select doc_seq, doc_name, doc_date, doc_writer, doc_dep, (confirmname1_ok+confirmname2_ok+confirmname3_ok) confirmlist_ok, doc_subject \n");
			sql.append("from doc_info_detail \n");
			sql.append("where decode (confirmname1_ok, 0 ,confirmname1, 1, decode(confirmname2_ok, 0, confirmname2, 1, confirmname3))=? and confirmname3_ok=0");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Doc_info_detailDto doc_info_detailDto = new Doc_info_detailDto();
				doc_info_detailDto.setDoc_seq(rs.getString("doc_seq"));
				doc_info_detailDto.setDoc_name(rs.getString("doc_name"));
				doc_info_detailDto.setDoc_dep(rs.getString("doc_dep"));
				doc_info_detailDto.setDoc_writer(rs.getString("doc_writer"));
				doc_info_detailDto.setDoc_date(rs.getString("doc_date"));
				doc_info_detailDto.setConfirmlist_ok(rs.getInt("confirmlist_ok"));
				doc_info_detailDto.setDoc_subject(rs.getString("doc_subject"));
				nolistapprovallist.add(doc_info_detailDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(conn, pstmt, rs);
		}
		return nolistapprovallist;
	}

	@Override
	public int confirmcheck1(int confirmlist, String seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update doc_info_detail set confirmname1_ok = 1 where doc_seq=? and (confirmname1_ok+confirmname2_ok+confirmname3_ok)=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.setInt(2, confirmlist);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}
	
	@Override
	public int confirmcheck2(int confirmlist, String seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update doc_info_detail set confirmname2_ok = 1 where doc_seq=? and (confirmname1_ok+confirmname2_ok+confirmname3_ok)=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.setInt(2, confirmlist);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}
	
	@Override
	public int confirmcheck3(int confirmlist, String seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update doc_info_detail set confirmname3_ok = 1 where doc_seq=? and (confirmname1_ok+confirmname2_ok+confirmname3_ok)=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.setInt(2, confirmlist);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public String name(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String name=null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "select name from employees where employee_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			name = rs.getString("name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return name;
	}
	
	
}
