package com.cube.common.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cube.model.dto.Biztrip_reportDto;
import com.cube.model.dto.BiztripdocDto;
import com.cube.model.dto.DeaddocDto;
import com.cube.model.dto.OrderdocDto;
import com.cube.model.dto.SigndocDto;
import com.cube.model.dto.VacdocDto;
import com.cube.model.dto.Work_reportDto;
import com.cube.model.dto.Work_report_replyDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class CommonDaoImpl implements CommonDao {

	private static CommonDaoImpl commonDaoImpl;

	static {
		commonDaoImpl = new CommonDaoImpl();

	}

	public static CommonDaoImpl getCommonDaoImpl() {
		return commonDaoImpl;
	}

	private CommonDaoImpl() {}

	@Override
	public String seq(String doccode, String eid) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String seq = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "select max(doc_seq) doc_seq from doc_info_detail where doc_code=? and employee_id=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, doccode);
			pstmt.setString(2, eid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				seq = rs.getString("doc_seq");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return seq;
	}

	@Override
	public SigndocDto signview(String seq) {
		SigndocDto signview = new SigndocDto();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			int confirmlistcheck=0;
			sql.append("select d.doc_seq, d.doc_code, d.doc_name, d.doc_state, d.doc_dep, d.doc_writer,  \n");
			sql.append("       d.doc_date, d.doc_receiver, d.doc_reference, d.doc_file, d.doc_subject,  \n");
			sql.append("       d.confirmname1, d.confirmname2, d.confirmname3, d.employee_id, s.signdoc_content,  \n");
			sql.append("       d.confirmname1_ok, d.confirmname2_ok, d.confirmname3_ok \n");
			sql.append("from doc_info_detail d, signdoc s where d.doc_seq=s.doc_seq and s.doc_seq=? \n");
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				signview.setDoc_seq(rs.getString("doc_seq"));
				signview.setDoc_code(rs.getString("doc_code"));
				signview.setDoc_name(rs.getString("doc_name"));
				signview.setDoc_state(rs.getString("doc_state"));
				signview.setDoc_dep(rs.getString("doc_dep"));
				signview.setDoc_writer(rs.getString("doc_writer"));
				signview.setDoc_date(rs.getString("doc_date"));
				signview.setDoc_receiver(rs.getString("doc_receiver"));
				signview.setDoc_reference(rs.getString("doc_reference"));
				signview.setDoc_file(rs.getString("doc_file"));
				signview.setDoc_subject(rs.getString("doc_subject"));
				signview.setConfirmlist1(rs.getString("confirmname1"));
				signview.setConfirmlist2(rs.getString("confirmname2"));
				signview.setConfirmlist3(rs.getString("confirmname3"));
				signview.setEmployee_id(rs.getString("employee_id"));
				signview.setSigndoc_content(rs.getString("signdoc_content"));
				confirmlistcheck = rs.getInt("confirmname1_ok");
				confirmlistcheck += rs.getInt("confirmname2_ok");
				confirmlistcheck += rs.getInt("confirmname3_ok");
				signview.setConfirmlist_ok(confirmlistcheck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return signview;
	}

	@Override
	public OrderdocDto orderview(String seq) {
		OrderdocDto orderdocDto = new OrderdocDto();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			int confirmlistcheck=0;
			sql.append("select d.doc_seq, d.doc_code, d.doc_name, d.doc_state, d.doc_dep, d.doc_writer,  \n");
			sql.append("       d.doc_date, d.doc_receiver, d.doc_reference, d.doc_file, d.doc_subject,  \n");
			sql.append("       d.confirmname1, d.confirmname2, d.confirmname3, d.employee_id, o.orderdoc_content,  \n");
			sql.append("       d.confirmname1_ok, d.confirmname2_ok, d.confirmname3_ok \n");
			sql.append("from doc_info_detail d, orderdoc o where d.doc_seq=o.doc_seq and o.doc_seq=? \n");
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				orderdocDto.setDoc_seq(rs.getString("doc_seq"));
				orderdocDto.setDoc_code(rs.getString("doc_code"));
				orderdocDto.setDoc_name(rs.getString("doc_name"));
				orderdocDto.setDoc_state(rs.getString("doc_state"));
				orderdocDto.setDoc_dep(rs.getString("doc_dep"));
				orderdocDto.setDoc_writer(rs.getString("doc_writer"));
				orderdocDto.setDoc_date(rs.getString("doc_date"));
				orderdocDto.setDoc_receiver(rs.getString("doc_receiver"));
				orderdocDto.setDoc_reference(rs.getString("doc_reference"));
				orderdocDto.setDoc_file(rs.getString("doc_file"));
				orderdocDto.setDoc_subject(rs.getString("doc_subject"));
				orderdocDto.setConfirmlist1(rs.getString("confirmname1"));
				orderdocDto.setConfirmlist2(rs.getString("confirmname2"));
				orderdocDto.setConfirmlist3(rs.getString("confirmname3"));
				orderdocDto.setEmployee_id(rs.getString("employee_id"));
				orderdocDto.setOrderdoc_content(rs.getString("orderdoc_content"));
				confirmlistcheck = rs.getInt("confirmname1_ok");
				confirmlistcheck += rs.getInt("confirmname2_ok");
				confirmlistcheck += rs.getInt("confirmname3_ok");
				orderdocDto.setConfirmlist_ok(confirmlistcheck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return orderdocDto;
	}

	@Override
	public VacdocDto vacview(String seq) {
		VacdocDto vacdocDto = new VacdocDto();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			int confirmlistcheck=0;
			sql.append("select d.doc_seq, d.doc_code, d.doc_name, d.doc_state, d.doc_dep, d.doc_writer,  \n");
			sql.append("       d.doc_date, d.doc_receiver, d.doc_reference, d.doc_file, d.doc_subject,  \n");
			sql.append("       d.confirmname1, d.confirmname2, d.confirmname3, d.employee_id, v.vacdoc_content,  \n");
			sql.append("       v.vacdoc_start, v.vacdoc_end, v.vacdoc_kind, v.route, \n");
			sql.append("       d.confirmname1_ok, d.confirmname2_ok, d.confirmname3_ok \n");
			sql.append("from doc_info_detail d, vacdoc v where d.doc_seq=v.doc_seq and v.doc_seq=? \n");
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vacdocDto.setDoc_seq(rs.getString("doc_seq"));
				vacdocDto.setDoc_code(rs.getString("doc_code"));
				vacdocDto.setDoc_name(rs.getString("doc_name"));
				vacdocDto.setDoc_state(rs.getString("doc_state"));
				vacdocDto.setDoc_dep(rs.getString("doc_dep"));
				vacdocDto.setDoc_writer(rs.getString("doc_writer"));
				vacdocDto.setDoc_date(rs.getString("doc_date"));
				vacdocDto.setDoc_receiver(rs.getString("doc_receiver"));
				vacdocDto.setDoc_reference(rs.getString("doc_reference"));
				vacdocDto.setDoc_file(rs.getString("doc_file"));
				vacdocDto.setDoc_subject(rs.getString("doc_subject"));
				vacdocDto.setConfirmlist1(rs.getString("confirmname1"));
				vacdocDto.setConfirmlist2(rs.getString("confirmname2"));
				vacdocDto.setConfirmlist3(rs.getString("confirmname3"));
				vacdocDto.setEmployee_id(rs.getString("employee_id"));
				vacdocDto.setVacdoc_content(rs.getString("vacdoc_content"));
				vacdocDto.setVacdoc_start(rs.getString("vacdoc_start"));
				vacdocDto.setVacdoc_end(rs.getString("vacdoc_end"));
				vacdocDto.setVacdoc_kind(rs.getString("vacdoc_kind"));
				vacdocDto.setVacdoc_route(rs.getString("route"));
				confirmlistcheck = rs.getInt("confirmname1_ok");
				confirmlistcheck += rs.getInt("confirmname2_ok");
				confirmlistcheck += rs.getInt("confirmname3_ok");
				vacdocDto.setConfirmlist_ok(confirmlistcheck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return vacdocDto;
	}

	@Override
	public BiztripdocDto bizview(String seq) {
		BiztripdocDto biztripdocDto = new BiztripdocDto();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			int confirmlistcheck=0;
			sql.append("select d.doc_seq, d.doc_code, d.doc_name, d.doc_state, d.doc_dep, d.doc_writer,  \n");
			sql.append("       d.doc_date, d.doc_receiver, d.doc_reference, d.doc_file, d.doc_subject,  \n");
			sql.append("       d.confirmname1, d.confirmname2, d.confirmname3, d.employee_id, b.biztripdoc_content,  \n");
			sql.append("       b.biztripdoc_start, b.biztripdoc_end, b.biztripdoc_place, \n");
			sql.append("       d.confirmname1_ok, d.confirmname2_ok, d.confirmname3_ok \n");
			sql.append("from doc_info_detail d, biztripdoc b where d.doc_seq=b.doc_seq and b.doc_seq=? \n");
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				biztripdocDto.setDoc_seq(rs.getString("doc_seq"));
				biztripdocDto.setDoc_code(rs.getString("doc_code"));
				biztripdocDto.setDoc_name(rs.getString("doc_name"));
				biztripdocDto.setDoc_state(rs.getString("doc_state"));
				biztripdocDto.setDoc_dep(rs.getString("doc_dep"));
				biztripdocDto.setDoc_writer(rs.getString("doc_writer"));
				biztripdocDto.setDoc_date(rs.getString("doc_date"));
				biztripdocDto.setDoc_receiver(rs.getString("doc_receiver"));
				biztripdocDto.setDoc_reference(rs.getString("doc_reference"));
				biztripdocDto.setDoc_file(rs.getString("doc_file"));
				biztripdocDto.setDoc_subject(rs.getString("doc_subject"));
				biztripdocDto.setConfirmlist1(rs.getString("confirmname1"));
				biztripdocDto.setConfirmlist2(rs.getString("confirmname2"));
				biztripdocDto.setConfirmlist3(rs.getString("confirmname3"));
				biztripdocDto.setEmployee_id(rs.getString("employee_id"));
				biztripdocDto.setBiztripdoc_content(rs.getString("biztripdoc_content"));
				biztripdocDto.setBiztripdoc_start(rs.getString("biztripdoc_start"));
				biztripdocDto.setBiztripdoc_end(rs.getString("biztripdoc_end"));
				biztripdocDto.setBiztripdoc_place(rs.getString("biztripdoc_place"));
				confirmlistcheck = rs.getInt("confirmname1_ok");
				confirmlistcheck += rs.getInt("confirmname2_ok");
				confirmlistcheck += rs.getInt("confirmname3_ok");
				biztripdocDto.setConfirmlist_ok(confirmlistcheck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return biztripdocDto;
	}

	@Override
	public Biztrip_reportDto breportview(String seq) {
		Biztrip_reportDto biztrip_reportDto = new Biztrip_reportDto();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			int confirmlistcheck=0;
			sql.append("select d.doc_seq, d.doc_code, d.doc_name, d.doc_state, d.doc_dep, d.doc_writer,  \n");
			sql.append("       d.doc_date, d.doc_receiver, d.doc_reference, d.doc_file, d.doc_subject,  \n");
			sql.append("       d.confirmname1, d.confirmname2, d.confirmname3, d.employee_id, t.tripreport_content,  \n");
			sql.append("       t.tripreport_start, t.tripreport_end, t.tripreport_place, \n");
			sql.append("       d.confirmname1_ok, d.confirmname2_ok, d.confirmname3_ok \n");
			sql.append("from doc_info_detail d, biztrip_report t where d.doc_seq=t.doc_seq and t.doc_seq=? \n");
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				biztrip_reportDto.setDoc_seq(rs.getString("doc_seq"));
				biztrip_reportDto.setDoc_code(rs.getString("doc_code"));
				biztrip_reportDto.setDoc_name(rs.getString("doc_name"));
				biztrip_reportDto.setDoc_state(rs.getString("doc_state"));
				biztrip_reportDto.setDoc_dep(rs.getString("doc_dep"));
				biztrip_reportDto.setDoc_writer(rs.getString("doc_writer"));
				biztrip_reportDto.setDoc_date(rs.getString("doc_date"));
				biztrip_reportDto.setDoc_receiver(rs.getString("doc_receiver"));
				biztrip_reportDto.setDoc_reference(rs.getString("doc_reference"));
				biztrip_reportDto.setDoc_file(rs.getString("doc_file"));
				biztrip_reportDto.setDoc_subject(rs.getString("doc_subject"));
				biztrip_reportDto.setConfirmlist1(rs.getString("confirmname1"));
				biztrip_reportDto.setConfirmlist2(rs.getString("confirmname2"));
				biztrip_reportDto.setConfirmlist3(rs.getString("confirmname3"));
				biztrip_reportDto.setEmployee_id(rs.getString("employee_id"));
				biztrip_reportDto.setBiztrip_report_content(rs.getString("tripreport_content"));
				biztrip_reportDto.setBiztrip_report_start(rs.getString("tripreport_start"));
				biztrip_reportDto.setBiztrip_report_end(rs.getString("tripreport_end"));
				biztrip_reportDto.setBiztrip_report_route(rs.getString("tripreport_place"));
				confirmlistcheck = rs.getInt("confirmname1_ok");
				confirmlistcheck += rs.getInt("confirmname2_ok");
				confirmlistcheck += rs.getInt("confirmname3_ok");
				biztrip_reportDto.setConfirmlist_ok(confirmlistcheck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return biztrip_reportDto;
	}

	@Override
	public DeaddocDto deadview(String seq) {
		DeaddocDto deaddto = new DeaddocDto();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			int confirmlistcheck=0;
			sql.append("select d.doc_seq, d.doc_code, d.doc_name, d.doc_state, d.doc_dep, d.doc_writer,  \n");
			sql.append("       d.doc_date, d.doc_receiver, d.doc_reference, d.doc_file, d.doc_subject,  \n");
			sql.append("       d.confirmname1, d.confirmname2, d.confirmname3, d.employee_id, a.deaddoc_content,  \n");
			sql.append("       a.startdate, a.enddate, a.currentwork, \n");
			sql.append("       d.confirmname1_ok, d.confirmname2_ok, d.confirmname3_ok, d.employee_id \n");
			sql.append("from doc_info_detail d, deaddoc a where d.doc_seq=a.doc_seq and a.doc_seq=? \n");
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				deaddto.setDoc_seq(rs.getString("doc_seq"));
				deaddto.setDoc_code(rs.getString("doc_code"));
				deaddto.setDoc_name(rs.getString("doc_name"));
				deaddto.setDoc_state(rs.getString("doc_state"));
				deaddto.setDoc_dep(rs.getString("doc_dep"));
				deaddto.setDoc_writer(rs.getString("doc_writer"));
				deaddto.setDoc_date(rs.getString("doc_date"));
				deaddto.setDoc_receiver(rs.getString("doc_receiver"));
				deaddto.setDoc_reference(rs.getString("doc_reference"));
				deaddto.setDoc_file(rs.getString("doc_file"));
				deaddto.setDoc_subject(rs.getString("doc_subject"));
				deaddto.setConfirmlist1(rs.getString("confirmname1"));
				deaddto.setConfirmlist2(rs.getString("confirmname2"));
				deaddto.setConfirmlist3(rs.getString("confirmname3"));
				deaddto.setEmployee_id(rs.getString("employee_id"));
				deaddto.setDeaddoc_content(rs.getString("Deaddoc_content"));
				deaddto.setDeaddoc_startdate(rs.getString("startdate"));
				deaddto.setDeaddoc_enddate(rs.getString("enddate"));
				deaddto.setDeaddoc_currentwork(rs.getString("currentwork"));
				deaddto.setEmployee_id(rs.getString("employee_id"));
				confirmlistcheck = rs.getInt("confirmname1_ok");
				confirmlistcheck += rs.getInt("confirmname2_ok");
				confirmlistcheck += rs.getInt("confirmname3_ok");
				deaddto.setConfirmlist_ok(confirmlistcheck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return deaddto;
	}

	@Override
	public Work_reportDto work_reportview(String seq) {
		Work_reportDto work_reportDto = new Work_reportDto();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		int confirmlistcheck=0;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select w.doc_seq, di.employee_id, di.doc_code, di.doc_name, di.doc_state, di.doc_dep,  \n");
			sql.append("       di.doc_writer, di.doc_date, di.doc_subject, di.doc_writetime, w.workdoc_open,  \n");
			sql.append("       w.workdoc_daycontent, w.confirmlist, w.workdoc_nextcontent, w.workdoc_kind, w.work_finaltime  \n");
			sql.append("from doc_info_detail di, work_report w  \n");
			sql.append("where di.doc_seq=w.doc_seq and w.doc_seq=? \n");
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				work_reportDto.setDoc_seq(rs.getString("doc_seq"));
				work_reportDto.setEmployee_id(rs.getString("employee_id"));
				work_reportDto.setDoc_code(rs.getString("doc_code"));
				work_reportDto.setDoc_name(rs.getString("doc_name"));
				work_reportDto.setDoc_state(rs.getString("doc_state"));
				work_reportDto.setDoc_dep(rs.getString("doc_dep"));
				work_reportDto.setDoc_writer(rs.getString("doc_writer"));
				work_reportDto.setDoc_date(rs.getString("doc_date"));
				work_reportDto.setDoc_subject(rs.getString("doc_subject"));
				work_reportDto.setDoc_writetime(rs.getString("doc_writetime"));
				work_reportDto.setWorkdoc_open(rs.getString("workdoc_open"));
				work_reportDto.setWorkdoc_daycontent(rs.getString("workdoc_daycontent"));
				work_reportDto.setConfirmlist(rs.getString("confirmlist"));
				work_reportDto.setWorkdoc_nextcontent(rs.getString("workdoc_nextcontent"));
				work_reportDto.setWorkdoc_kind(rs.getString("workdoc_kind"));
				work_reportDto.setWorkdoc_finaltime(rs.getString("work_finaltime"));
			}
			confirmlistcheck=1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return work_reportDto;
	}
	
	@Override
	public String confirmname(String seq) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String confirmname = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "select confirmname1||','||confirmname2||','||confirmname3 confirmnames from doc_info_detail where doc_seq=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				confirmname = rs.getString("confirmnames");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return confirmname;
	}

	@Override
	public int confirmcheck(String seq) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		int confirmcheck = 0;
		try {
			conn = DBConnection.makeConnection();
			String sql = "select (confirmname1_ok+confirmname2_ok+confirmname3_ok) confirmlist_ok from doc_info_detail where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			rs  = pstmt.executeQuery();
			rs.next();
			confirmcheck = rs.getInt("confirmlist_ok");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return confirmcheck;
	}

	@Override
	public int confirmnames(String seq) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		int confirmnames = 0;
		try {
			conn = DBConnection.makeConnection();
			String sql = "select (nvl2(name1,1,0)+nvl2(name2,1,0)+nvl2(name3,1,0)) confirmnames from doc_info_detail where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			rs  = pstmt.executeQuery();
			rs.next();
			confirmnames = rs.getInt("confirmnames");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return confirmnames;
	}

	@Override
	public void docstate(String seq) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		int docstate = 0;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update doc_info_detail set doc_state='결재완료', doc_complite_date=to_char(sysdate,'yyyy-mm-dd hh:mi:ss') where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			docstate = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}
	
	@Override
	public void docstatecancel(String seq) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		int docstate = 0;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update doc_info_detail set doc_state='반려', doc_complite_date=to_char(sysdate,'yyyy-mm-dd hh:mi:ss') where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			docstate = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void docdead(String seq, String docwriteid) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		int docdead = 0;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			String sql = "update doc_info_detail set doc_state='결재완료', doc_complite_date=to_char(sysdate,'yyyy-mm-dd hh:mi:ss') where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.executeUpdate();
			pstmt.close();
			sql="update employees_detail set out_date=to_char(sysdate,'yyyy-mm-dd hh:mi:ss') where employee_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, docwriteid);
			pstmt.executeUpdate();
			pstmt.close();
			sql="update employees set working='n' where employee_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, docwriteid);
			pstmt.executeUpdate();
			conn.commit();
			docdead = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}
	
	@Override
	public void docvac(VacdocDto vacdocDto) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		int docvac = 0;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			String sql = "update doc_info_detail set doc_state='결재완료', doc_complite_date=to_char(sysdate,'yyyy-mm-dd hh:mi:ss') where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vacdocDto.getDoc_seq());
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer schedule_insert = new StringBuffer();
			schedule_insert.append("insert into schedule(employee_id, schedule_seq, schedule_subject, schedule_content, \n");
			schedule_insert.append("			        schedule_startdate, schedule_enddate, schedule_kind) \n");
			schedule_insert.append("values (?, schedule_seq.nextval, ?, ?, ?,?,'휴가') \n");
			pstmt = conn.prepareStatement(schedule_insert.toString());
			int idx=0;
			pstmt.setString(++idx, vacdocDto.getEmployee_id());//1
			pstmt.setString(++idx, vacdocDto.getDoc_subject());//2
			pstmt.setString(++idx, vacdocDto.getVacdoc_content());//3
			pstmt.setString(++idx, vacdocDto.getVacdoc_start());//4
			pstmt.setString(++idx, vacdocDto.getVacdoc_end());//5
			pstmt.executeUpdate();
			conn.commit();
			docvac = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void memowrite(Work_report_replyDto work_report_replyDto) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "insert into work_report_reply (doc_seq, wmseq, wmlogtime, mcontent, mwriter, mid) \n";
			sql += "values (?, wmseq_seq.nextval, to_char(sysdate,'yyyy-mm-dd hh24:mm:ss'), ?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, work_report_replyDto.getDoc_seq());
			pstmt.setString(2, work_report_replyDto.getContent());
			pstmt.setString(3, work_report_replyDto.getMwriter());
			pstmt.setString(4, work_report_replyDto.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public List<Work_report_replyDto> memoList(String seq) {
		List<Work_report_replyDto> list = new ArrayList<Work_report_replyDto>();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		System.out.println(seq);
		try {
			conn = DBConnection.makeConnection();
			String sql = "select * from work_report_reply where doc_seq=? order by wmlogtime desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Work_report_replyDto work_report_replyDto = new Work_report_replyDto();
				work_report_replyDto.setContent(rs.getString("mcontent"));
				work_report_replyDto.setWmlogtime(rs.getString("wmlogtime"));
				work_report_replyDto.setMwriter(rs.getString("mwriter"));
				work_report_replyDto.setDoc_seq(rs.getString("doc_seq"));
				work_report_replyDto.setWmseq(rs.getInt("wmseq"));
				work_report_replyDto.setMid(rs.getString("mid"));
				list.add(work_report_replyDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public void memoDelete(int mseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "delete from work_report_reply where wmseq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mseq);
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public void memoModify(Work_report_replyDto work_report_replyDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update work_report_reply set mcontent=?, wmlogtime=to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') where wmseq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, work_report_replyDto.getContent());
			pstmt.setInt(2, work_report_replyDto.getWmseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void docbiztrip(BiztripdocDto biztripdocDto) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		int docbiz = 0;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			String sql = "update doc_info_detail set doc_state='결재완료', doc_complite_date=to_char(sysdate,'yyyy-mm-dd hh:mi:ss') where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, biztripdocDto.getDoc_seq());
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer schedule_insert = new StringBuffer();
			schedule_insert.append("insert into schedule(employee_id, schedule_seq, schedule_subject, schedule_content, \n");
			schedule_insert.append("			        schedule_startdate, schedule_enddate, schedule_kind) \n");
			schedule_insert.append("values (?, schedule_seq.nextval, ?, ?, ?,?,'부서') \n");
			pstmt = conn.prepareStatement(schedule_insert.toString());
			int idx=0;
			pstmt.setString(++idx, biztripdocDto.getEmployee_id());//1
			pstmt.setString(++idx, biztripdocDto.getDoc_subject());//2
			pstmt.setString(++idx, biztripdocDto.getBiztripdoc_content());//3
			pstmt.setString(++idx, biztripdocDto.getBiztripdoc_start());//4
			pstmt.setString(++idx, biztripdocDto.getBiztripdoc_end());//5
			pstmt.executeUpdate();
			conn.commit();
			docbiz = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}
}
