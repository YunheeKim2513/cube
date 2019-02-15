package com.cube.admin.businesssuport.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class BusiniesssuportApprivalAdminDaoImpl implements BusiniesssuportApprivalAdminDao {
	
	private static BusiniesssuportApprivalAdminDao businiesssuportApprivalAdminDao;
	
	static{
		businiesssuportApprivalAdminDao = new BusiniesssuportApprivalAdminDaoImpl();
	}
	
	private BusiniesssuportApprivalAdminDaoImpl(){}
	
	public static BusiniesssuportApprivalAdminDao getBusiniesssuportApprivalAdminDao() {
		return businiesssuportApprivalAdminDao;
	}

	@Override
	public void confirmlistinsert(String confirmname, String confirmlist1, String confirmlist2, String confirmlist3) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "insert into confirmlist_info (confirm_code, confirm_name, confirmlist1, confirmlist2, confirmlist3) \n";
			sql += "values (to_char(sysdate,'yyyy-mm-dd')||'-'||confirmlist_info_seq.nextval, ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, confirmname);
			pstmt.setString(2, confirmlist1);
			pstmt.setString(3, confirmlist2);
			pstmt.setString(4, confirmlist3);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void confirmlistupdate(String confirmname, String confirmlist1, String confirmlist2, String confirmlist3) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update confirmlist_info set confirmlist1=?, confirmlist2=?, confirmlist3=? where confirm_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, confirmlist1);
			pstmt.setString(2, confirmlist2);
			pstmt.setString(3, confirmlist3);
			pstmt.setString(4, confirmname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void confirmlistdelete(String confirmcode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "delete from confirmlist_info where confirm_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, confirmcode);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public List<Doc_info_detailDto> doclist() {
		List<Doc_info_detailDto> doclist = new ArrayList<Doc_info_detailDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select doc_seq, doc_name, doc_date, doc_writer, doc_dep, doc_state, nvl(doc_complite_date,' ') doc_complite_date,   \n");
			sql.append("       decode (confirmname1_ok, 0 ,name1, 1, decode(confirmname2_ok, 0, name2, 1, name3)) confirmname, doc_subject, \n");
			sql.append("(confirmname1_ok+confirmname2_ok+confirmname3_ok)||'/'||(nvl2(confirmname1,1,0)+nvl2(confirmname2,1,0)+nvl2(confirmname3,1,0)) confirm_state \n");
			sql.append("from doc_info_detail where not doc_name='업무보고'");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Doc_info_detailDto doc_info_detailDto = new Doc_info_detailDto();
				doc_info_detailDto.setDoc_seq(rs.getString("doc_seq"));
				doc_info_detailDto.setDoc_name(rs.getString("doc_name"));
				doc_info_detailDto.setDoc_date(rs.getString("doc_date"));
				doc_info_detailDto.setDoc_writer(rs.getString("doc_writer"));
				doc_info_detailDto.setDoc_dep(rs.getString("doc_dep"));
				doc_info_detailDto.setConfirmname(rs.getString("confirmname"));
				doc_info_detailDto.setDoc_state(rs.getString("doc_state"));
				doc_info_detailDto.setDoc_subject(rs.getString("doc_subject"));
				doc_info_detailDto.setConfirm_state(rs.getString("confirm_state"));
				doc_info_detailDto.setConfirmokdate(rs.getString("doc_complite_date"));
				doclist.add(doc_info_detailDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(conn, pstmt, rs);
		}
		return doclist;
	}

}
