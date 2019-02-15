package com.cube.user.approval.docwrite.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cube.model.dto.Biztrip_reportDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class BiztripreportDocUserDaoImpl implements BiztripreportDocUserDao {
	
	private static BiztripreportDocUserDao biztripreportDocUserDao;
	
	static {
		biztripreportDocUserDao = new BiztripreportDocUserDaoImpl();
	}
	
	private BiztripreportDocUserDaoImpl() {}
	
	public static BiztripreportDocUserDao getBiztripreportDocUserDao() {
		return biztripreportDocUserDao;
	}

	@Override
	public int writesuccess(Biztrip_reportDto biztrip_reportDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			StringBuffer docdetail_insert = new StringBuffer();
			docdetail_insert.append("insert into doc_info_detail (doc_seq, doc_writetime, doc_code, doc_name, doc_state, doc_dep, doc_writer, doc_date, doc_receiver, ");
			docdetail_insert.append("doc_reference, doc_file, doc_subject, confirmname1, confirmname2, confirmname3, employee_id, name1, name2, name3) \n");
			docdetail_insert.append("values (to_char(sysdate,'yyyy-mm-dd')||'-B05-'||doc_seq.nextval,to_char(sysdate,'yyyy-mm-dd hh:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) \n");
			System.out.println(docdetail_insert.toString());
			pstmt = conn.prepareStatement(docdetail_insert.toString());
			int idx = 0;
			pstmt.setString(++idx, biztrip_reportDto.getDoc_code());		//1
			pstmt.setString(++idx, biztrip_reportDto.getDoc_name());		//2
			pstmt.setString(++idx, biztrip_reportDto.getDoc_state());		//3
			pstmt.setString(++idx, biztrip_reportDto.getDoc_dep());		//4
			pstmt.setString(++idx, biztrip_reportDto.getDoc_writer());		//5
			pstmt.setString(++idx, biztrip_reportDto.getDoc_date());		//6
			pstmt.setString(++idx, biztrip_reportDto.getDoc_receiver());	//7
			pstmt.setString(++idx, biztrip_reportDto.getDoc_reference());	//8
			pstmt.setString(++idx, biztrip_reportDto.getDoc_file());		//9
			pstmt.setString(++idx, biztrip_reportDto.getDoc_subject());	//10
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlist1());	//11
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlist2());	//12
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlist3());	//13
			pstmt.setString(++idx, biztrip_reportDto.getEmployee_id());	//14
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlistname1());
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlistname2());
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlistname3());
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer signdoc_insert = new StringBuffer();
			signdoc_insert.append("insert into biztrip_report (doc_seq, tripreport_start, tripreport_end, tripreport_content, tripreport_place) \n");
			signdoc_insert.append("values (to_char(sysdate,'yyyy-mm-dd')||'-B05-'||doc_seq.currval,?,?,?,?) \n");
			pstmt = conn.prepareStatement(signdoc_insert.toString());
			idx=0;
			pstmt.setString(++idx, biztrip_reportDto.getBiztrip_report_start());
			pstmt.setString(++idx, biztrip_reportDto.getBiztrip_report_end());
			pstmt.setString(++idx, biztrip_reportDto.getBiztrip_report_content());
			pstmt.setString(++idx, biztrip_reportDto.getBiztrip_report_route());
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
	public int updatesuccess(Biztrip_reportDto biztrip_reportDto) {
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
			pstmt.setString(++idx, biztrip_reportDto.getDoc_code());		//1
			pstmt.setString(++idx, biztrip_reportDto.getDoc_name());		//2
			pstmt.setString(++idx, biztrip_reportDto.getDoc_state());		//3
			pstmt.setString(++idx, biztrip_reportDto.getDoc_dep());		//4
			pstmt.setString(++idx, biztrip_reportDto.getDoc_writer());		//5
			pstmt.setString(++idx, biztrip_reportDto.getDoc_date());		//6
			pstmt.setString(++idx, biztrip_reportDto.getDoc_receiver());	//7
			pstmt.setString(++idx, biztrip_reportDto.getDoc_reference());	//8
			pstmt.setString(++idx, biztrip_reportDto.getDoc_file());		//9
			pstmt.setString(++idx, biztrip_reportDto.getDoc_subject());	//10
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlist1());	//11
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlist2());	//12
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlist3());	//13
			pstmt.setString(++idx, biztrip_reportDto.getEmployee_id());	//14
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlistname1());
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlistname2());
			pstmt.setString(++idx, biztrip_reportDto.getConfirmlistname3());
			pstmt.setString(++idx, biztrip_reportDto.getDoc_seq());	//14
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer vacdoc_update = new StringBuffer();
			vacdoc_update.append("update biztrip_report set tripreport_start=?, tripreport_end=?, tripreport_place=?, tripreport_content=? \n");
			vacdoc_update.append("where doc_seq=? \n");
			pstmt = conn.prepareStatement(vacdoc_update.toString());
			idx=0;
			pstmt.setString(++idx, biztrip_reportDto.getBiztrip_report_start());
			pstmt.setString(++idx, biztrip_reportDto.getBiztrip_report_end());
			pstmt.setString(++idx, biztrip_reportDto.getBiztrip_report_route());
			pstmt.setString(++idx, biztrip_reportDto.getBiztrip_report_content());
			pstmt.setString(++idx, biztrip_reportDto.getDoc_seq());	//14
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
