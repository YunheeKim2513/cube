package com.cube.user.approval.docwrite.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cube.model.dto.VacdocDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class VacDocUserDaoImpl implements VacDocUserDao {
	
	private static VacDocUserDao vacDocUserDao;
	
	static {
		vacDocUserDao = new VacDocUserDaoImpl();
	}

	private VacDocUserDaoImpl(){}
	
	public static VacDocUserDao getVacDocUserDao() {
		return vacDocUserDao;
	}

	@Override
	public int writesuccess(VacdocDto vacdocDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			StringBuffer docdetail_insert = new StringBuffer();
			docdetail_insert.append("insert into doc_info_detail (doc_seq, doc_writetime, doc_code, doc_name, doc_state, doc_dep, doc_writer, doc_date, doc_receiver, ");
			docdetail_insert.append("doc_reference, doc_file, doc_subject, confirmname1, confirmname2, confirmname3, employee_id, name1, name2, name3) \n");
			docdetail_insert.append("values (to_char(sysdate,'yyyy-mm-dd')||'-V03-'||doc_seq.nextval,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) \n");
			System.out.println(docdetail_insert.toString());
			pstmt = conn.prepareStatement(docdetail_insert.toString());
			int idx = 0;
			pstmt.setString(++idx, vacdocDto.getDoc_code());		//1
			pstmt.setString(++idx, vacdocDto.getDoc_name());		//2
			pstmt.setString(++idx, vacdocDto.getDoc_state());		//3
			pstmt.setString(++idx, vacdocDto.getDoc_dep());		//4
			pstmt.setString(++idx, vacdocDto.getDoc_writer());		//5
			pstmt.setString(++idx, vacdocDto.getDoc_date());		//6
			pstmt.setString(++idx, vacdocDto.getDoc_receiver());	//7
			pstmt.setString(++idx, vacdocDto.getDoc_reference());	//8
			pstmt.setString(++idx, vacdocDto.getDoc_file());		//9
			pstmt.setString(++idx, vacdocDto.getDoc_subject());	//10
			pstmt.setString(++idx, vacdocDto.getConfirmlist1());	//11
			pstmt.setString(++idx, vacdocDto.getConfirmlist2());	//12
			pstmt.setString(++idx, vacdocDto.getConfirmlist3());	//13
			pstmt.setString(++idx, vacdocDto.getEmployee_id());	//14
			pstmt.setString(++idx, vacdocDto.getConfirmlistname1());
			pstmt.setString(++idx, vacdocDto.getConfirmlistname2());
			pstmt.setString(++idx, vacdocDto.getConfirmlistname3());
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer vacdoc_insert = new StringBuffer();
			vacdoc_insert.append("insert into vacdoc (doc_seq, vacdoc_start, vacdoc_end, vacdoc_kind, vacdoc_content, route) \n");
			vacdoc_insert.append("values (to_char(sysdate,'yyyy-mm-dd')||'-V03-'||doc_seq.currval,?,?,?,?,?) \n");
			pstmt = conn.prepareStatement(vacdoc_insert.toString());
			idx=0;
			pstmt.setString(++idx, vacdocDto.getVacdoc_start());
			pstmt.setString(++idx, vacdocDto.getVacdoc_end());
			pstmt.setString(++idx, vacdocDto.getVacdoc_kind());
			pstmt.setString(++idx, vacdocDto.getVacdoc_content());
			pstmt.setString(++idx, vacdocDto.getVacdoc_route());
			pstmt.executeUpdate();
			conn.commit();
			cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int updatesuccess(VacdocDto vacdocDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			StringBuffer docdetail_update = new StringBuffer();
			docdetail_update.append("update doc_info_detail set doc_writetime=to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'), doc_code=?, doc_name=?, doc_state=?, doc_dep=?,  \n");
			docdetail_update.append("       doc_writer=?, doc_date=?, doc_receiver=?, doc_reference=?, doc_file=?, doc_subject=?,  \n");
			docdetail_update.append("       confirmname1=?, confirmname2=?, confirmname3=?, employee_id=?, name1=?, name2=?, name3=? \n");
			docdetail_update.append("where doc_seq=? \n");
			pstmt = conn.prepareStatement(docdetail_update.toString());
			int idx = 0;
			pstmt.setString(++idx, vacdocDto.getDoc_code());		//1
			pstmt.setString(++idx, vacdocDto.getDoc_name());		//2
			pstmt.setString(++idx, vacdocDto.getDoc_state());		//3
			pstmt.setString(++idx, vacdocDto.getDoc_dep());		//4
			pstmt.setString(++idx, vacdocDto.getDoc_writer());		//5
			pstmt.setString(++idx, vacdocDto.getDoc_date());		//6
			pstmt.setString(++idx, vacdocDto.getDoc_receiver());	//7
			pstmt.setString(++idx, vacdocDto.getDoc_reference());	//8
			pstmt.setString(++idx, vacdocDto.getDoc_file());		//9
			pstmt.setString(++idx, vacdocDto.getDoc_subject());	//10
			pstmt.setString(++idx, vacdocDto.getConfirmlist1());	//11
			pstmt.setString(++idx, vacdocDto.getConfirmlist2());	//12
			pstmt.setString(++idx, vacdocDto.getConfirmlist3());	//13
			pstmt.setString(++idx, vacdocDto.getEmployee_id());	//14
			pstmt.setString(++idx, vacdocDto.getConfirmlistname1());
			pstmt.setString(++idx, vacdocDto.getConfirmlistname2());
			pstmt.setString(++idx, vacdocDto.getConfirmlistname3());
			pstmt.setString(++idx, vacdocDto.getDoc_seq());	//14
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer vacdoc_update = new StringBuffer();
			vacdoc_update.append("update vacdoc set vacdoc_start=?, vacdoc_end=?, vacdoc_kind=?, vacdoc_content=?, route=? \n");
			vacdoc_update.append("where doc_seq=? \n");
			pstmt = conn.prepareStatement(vacdoc_update.toString());
			idx=0;
			pstmt.setString(++idx, vacdocDto.getVacdoc_start());
			pstmt.setString(++idx, vacdocDto.getVacdoc_end());
			pstmt.setString(++idx, vacdocDto.getVacdoc_kind());
			pstmt.setString(++idx, vacdocDto.getVacdoc_content());
			pstmt.setString(++idx, vacdocDto.getVacdoc_route());
			pstmt.setString(++idx, vacdocDto.getDoc_seq());	//14
			pstmt.executeUpdate();
			conn.commit();
			cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


}
