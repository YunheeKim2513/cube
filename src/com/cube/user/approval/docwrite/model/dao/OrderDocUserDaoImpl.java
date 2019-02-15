package com.cube.user.approval.docwrite.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cube.model.dto.OrderdocDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class OrderDocUserDaoImpl implements OrderDocUserDao {

	private static OrderDocUserDao orderDocUserDao;
	
	static{
		orderDocUserDao = new OrderDocUserDaoImpl();
	}
	
	private OrderDocUserDaoImpl(){}
	
	public static OrderDocUserDao getOrderDocUserDao() {
		return orderDocUserDao;
	}

	@Override
	public int writesuccess(OrderdocDto orderdocDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			StringBuffer docdetail_insert = new StringBuffer();
			docdetail_insert.append("insert into doc_info_detail (doc_seq, doc_writetime, doc_code, doc_name, doc_state, doc_dep, doc_writer, doc_date, doc_receiver, ");
			docdetail_insert.append("doc_reference, doc_file, doc_subject, confirmname1, confirmname2, confirmname3, employee_id, name1, name2, name3) \n");
			docdetail_insert.append("values (to_char(sysdate,'yyyy-mm-dd')||'-O02-'||doc_seq.nextval,to_char(sysdate,'yyyy-mm-dd hh:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) \n");
			pstmt = conn.prepareStatement(docdetail_insert.toString());
			int idx = 0;
			pstmt.setString(++idx, orderdocDto.getDoc_code());		//1
			pstmt.setString(++idx, orderdocDto.getDoc_name());		//2
			pstmt.setString(++idx, orderdocDto.getDoc_state());		//3
			pstmt.setString(++idx, orderdocDto.getDoc_dep());		//4
			pstmt.setString(++idx, orderdocDto.getDoc_writer());		//5
			pstmt.setString(++idx, orderdocDto.getDoc_date());		//6
			pstmt.setString(++idx, orderdocDto.getDoc_receiver());	//7
			pstmt.setString(++idx, orderdocDto.getDoc_reference());	//8
			pstmt.setString(++idx, orderdocDto.getDoc_file());		//9
			pstmt.setString(++idx, orderdocDto.getDoc_subject());	//10
			pstmt.setString(++idx, orderdocDto.getConfirmlist1());	//11
			pstmt.setString(++idx, orderdocDto.getConfirmlist2());	//12
			pstmt.setString(++idx, orderdocDto.getConfirmlist3());	//13
			pstmt.setString(++idx, orderdocDto.getEmployee_id());	//14
			pstmt.setString(++idx, orderdocDto.getConfirmlistname1());
			pstmt.setString(++idx, orderdocDto.getConfirmlistname2());
			pstmt.setString(++idx, orderdocDto.getConfirmlistname3());
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer orderdoc_insert = new StringBuffer();
			orderdoc_insert.append("insert into orderdoc (doc_seq, orderdoc_content) \n");
			orderdoc_insert.append("values (to_char(sysdate,'yyyy-mm-dd')||'-O02-'||doc_seq.currval,?) \n");
			pstmt = conn.prepareStatement(orderdoc_insert.toString());
			pstmt.setString(1, orderdocDto.getOrderdoc_content());
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
	public int updatesuccess(OrderdocDto orderdocDto) {
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
			pstmt.setString(++idx, orderdocDto.getDoc_code());		//1
			pstmt.setString(++idx, orderdocDto.getDoc_name());		//2
			pstmt.setString(++idx, orderdocDto.getDoc_state());		//3
			pstmt.setString(++idx, orderdocDto.getDoc_dep());		//4
			pstmt.setString(++idx, orderdocDto.getDoc_writer());		//5
			pstmt.setString(++idx, orderdocDto.getDoc_date());		//6
			pstmt.setString(++idx, orderdocDto.getDoc_receiver());	//7
			pstmt.setString(++idx, orderdocDto.getDoc_reference());	//8
			pstmt.setString(++idx, orderdocDto.getDoc_file());		//9
			pstmt.setString(++idx, orderdocDto.getDoc_subject());	//10
			pstmt.setString(++idx, orderdocDto.getConfirmlist1());	//11
			pstmt.setString(++idx, orderdocDto.getConfirmlist2());	//12
			pstmt.setString(++idx, orderdocDto.getConfirmlist3());	//13
			pstmt.setString(++idx, orderdocDto.getEmployee_id());	//14
			pstmt.setString(++idx, orderdocDto.getConfirmlistname1());
			pstmt.setString(++idx, orderdocDto.getConfirmlistname2());
			pstmt.setString(++idx, orderdocDto.getConfirmlistname3());
			pstmt.setString(++idx, orderdocDto.getDoc_seq());	//14
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer vacdoc_update = new StringBuffer();
			vacdoc_update.append("update orderdoc set orderdoc_content=? \n");
			vacdoc_update.append("where doc_seq=? \n");
			pstmt = conn.prepareStatement(vacdoc_update.toString());
			idx=0;
			pstmt.setString(++idx, orderdocDto.getOrderdoc_content());
			pstmt.setString(++idx, orderdocDto.getDoc_seq());	//14
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
