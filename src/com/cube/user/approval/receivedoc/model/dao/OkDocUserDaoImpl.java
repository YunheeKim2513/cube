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

public class OkDocUserDaoImpl implements OkDocUserDao {
	
	private static OkDocUserDao okDocUserDao;
	
	static {
		okDocUserDao = new OkDocUserDaoImpl();
	}
	
	private OkDocUserDaoImpl(){}

	public static OkDocUserDao getOkDocUserDao() {
		return okDocUserDao;
	}

	@Override
	public List<Doc_info_detailDto> oklistapprovallist(String id) {
		List<Doc_info_detailDto> oklistapprovallist = new ArrayList<Doc_info_detailDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select doc_seq, doc_name, doc_date, doc_writer, doc_dep, doc_subject, doc_state, doc_complite_date, \n");
			sql.append("(confirmname1_ok+confirmname2_ok+confirmname3_ok)||'/'||(nvl2(confirmname1,1,0)+nvl2(confirmname2,1,0)+nvl2(confirmname3,1,0)) confirm_state, \n");
			sql.append("       decode (confirmname1_ok, 1 ,name1, 0, decode(confirmname2_ok, 1, name2, 0, name3)) confirmname \n");
			sql.append("from doc_info_detail \n");
			sql.append("where (confirmname1=? and confirmname1_ok=1) or \n");
			sql.append("      (confirmname2=? and confirmname2_ok=1) or \n");
			sql.append("      (confirmname3=? and confirmname3_ok=1) ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setString(3, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Doc_info_detailDto doc_info_detailDto = new Doc_info_detailDto();
				doc_info_detailDto.setDoc_seq(rs.getString("doc_seq"));
				doc_info_detailDto.setDoc_name(rs.getString("doc_name"));
				doc_info_detailDto.setDoc_dep(rs.getString("doc_dep"));
				doc_info_detailDto.setDoc_writer(rs.getString("doc_writer"));
				doc_info_detailDto.setDoc_date(rs.getString("doc_date"));
				doc_info_detailDto.setDoc_subject(rs.getString("doc_subject"));
				doc_info_detailDto.setConfirm_state(rs.getString("confirm_state"));
				doc_info_detailDto.setConfirmname(rs.getString("confirmname"));
				doc_info_detailDto.setDoc_state(rs.getString("doc_state"));
				doc_info_detailDto.setConfirmokdate(rs.getString("doc_complite_date"));
				oklistapprovallist.add(doc_info_detailDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(conn, pstmt, rs);
		}
		return oklistapprovallist;
	}
	
	
}
