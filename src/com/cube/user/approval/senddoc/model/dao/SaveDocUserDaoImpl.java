package com.cube.user.approval.senddoc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class SaveDocUserDaoImpl implements SaveDocUserDao {

	private static SaveDocUserDao saveDocUserDao;
	
	static {
		saveDocUserDao = new SaveDocUserDaoImpl();
	}
	
	private SaveDocUserDaoImpl(){}
	
	public static SaveDocUserDao getSaveDocUserDao() {
		return saveDocUserDao;
	}

	@Override
	public List<Doc_info_detailDto> savedoclist(String employee_id) {
		List<Doc_info_detailDto> savedoclist = new ArrayList<Doc_info_detailDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select doc_seq, doc_name, doc_date, doc_writetime, doc_subject \n");
			sql.append("from doc_info_detail where employee_id=? and doc_state='회수'");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, employee_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Doc_info_detailDto doc_info_detailDto = new Doc_info_detailDto();
				doc_info_detailDto.setDoc_seq(rs.getString("doc_seq"));
				doc_info_detailDto.setDoc_name(rs.getString("doc_name"));
				doc_info_detailDto.setDoc_date(rs.getString("doc_date"));
				doc_info_detailDto.setDoc_writetime(rs.getString("doc_writetime"));
				doc_info_detailDto.setDoc_subject(rs.getString("doc_subject"));
				savedoclist.add(doc_info_detailDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(conn, pstmt, rs);
		}
		return savedoclist;
	}

	@Override
	public void savedoc(String seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update doc_info_detail set doc_state='회수' where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void savedocdelete(String seq, String dockind) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			String sql = "delete from "+dockind+" where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.executeUpdate();
			pstmt.close();
			sql = "delete from doc_info_detail where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void savedocupdate(String seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update doc_info_detail set doc_state='결재 진행중' where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}
}
