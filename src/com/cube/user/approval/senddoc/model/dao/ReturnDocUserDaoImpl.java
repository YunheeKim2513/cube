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

public class ReturnDocUserDaoImpl implements ReturnDocUserDao {

	private static ReturnDocUserDao returnDocUserDao;
	
	static {
		returnDocUserDao = new ReturnDocUserDaoImpl();
	}
	
	private ReturnDocUserDaoImpl(){}
	
	public static ReturnDocUserDao getReturnDocUserDao() {
		return returnDocUserDao;
	}

	@Override
	public List<Doc_info_detailDto> returndoclist(String employee_id) {
		List<Doc_info_detailDto> returndoclist = new ArrayList<Doc_info_detailDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select doc_seq, doc_name, doc_date, (confirmname1_ok+confirmname2_ok+confirmname3_ok) confirmlist_ok, doc_state, doc_complite_date, \n");
			sql.append("       decode (confirmname1_ok, 1 ,name1, 0, decode(confirmname2_ok, 1, name2, 0, name3)) confirmname, doc_subject, \n");
			sql.append("(confirmname1_ok+confirmname2_ok+confirmname3_ok)||'/'||(nvl2(confirmname1,1,0)+nvl2(confirmname2,1,0)+nvl2(confirmname3,1,0)) confirm_state \n");
			sql.append("from doc_info_detail where employee_id=? and doc_state='¹Ý·Á'");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, employee_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Doc_info_detailDto doc_info_detailDto = new Doc_info_detailDto();
				doc_info_detailDto.setDoc_seq(rs.getString("doc_seq"));
				doc_info_detailDto.setDoc_name(rs.getString("doc_name"));
				doc_info_detailDto.setDoc_date(rs.getString("doc_date"));
				doc_info_detailDto.setConfirmokdate(rs.getString("doc_complite_date"));
				doc_info_detailDto.setConfirm_state(rs.getString("confirm_state"));
				doc_info_detailDto.setConfirmname(rs.getString("confirmname"));
				doc_info_detailDto.setDoc_state(rs.getString("doc_state"));
				doc_info_detailDto.setConfirmlistname3(rs.getString("confirmname"));
				doc_info_detailDto.setDoc_subject(rs.getString("doc_subject"));
				returndoclist.add(doc_info_detailDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(conn, pstmt, rs);
		}
		return returndoclist;
	}


}
