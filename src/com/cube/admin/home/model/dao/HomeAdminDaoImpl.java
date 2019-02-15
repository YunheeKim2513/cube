package com.cube.admin.home.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cube.model.dto.MemoDto;
import com.cube.model.dto.NoticeDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class HomeAdminDaoImpl implements HomeAdminDao {
	
	private static HomeAdminDao homeAdminDao;
	
	static {
		homeAdminDao = new HomeAdminDaoImpl();
	}
	
	private HomeAdminDaoImpl(){}
	
	public static HomeAdminDao getHomeAdminDao() {
		return homeAdminDao;
	}

	@Override
	public void noticwriter(NoticeDto noticeDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "insert into notice (notice_seq, employee_id, notice_writer, notice_subject, notice_content, notice_state, employee_dep, notice_date) \n";
			sql += "values (notice_seq.nextval, ?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeDto.getEmployee_id());
			pstmt.setString(2, noticeDto.getNotic_writer());
			pstmt.setString(3, noticeDto.getNotice_subject());
			pstmt.setString(4, noticeDto.getNotice_content());
			pstmt.setString(5, noticeDto.getNotice_state());
			pstmt.setString(6, noticeDto.getEmployee_dep());
			pstmt.setString(7, noticeDto.getNotice_date());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public int noticeseq(String employee_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int seq=0;
		try {
			conn = DBConnection.makeConnection();
			String sql ="select max(notice_seq) notice_seq from notice where employee_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee_id);
			rs = pstmt.executeQuery();
			rs.next();
			seq = rs.getInt("notice_seq");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return seq;
	}

	@Override
	public NoticeDto noticeview(int seq) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		NoticeDto noticeview = new NoticeDto();
		try {
			conn = DBConnection.makeConnection();
			String sql = "select notice_seq, employee_id, notice_subject, notice_content, notice_writer, notice_state, employee_dep, notice_date, nvl(notice_complite,' ') notice_complite from notice where notice_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				noticeview.setNotice_seq(Integer.parseInt(rs.getString("notice_seq")));
				noticeview.setEmployee_id(rs.getString("employee_id"));
				noticeview.setNotice_subject(rs.getString("notice_subject"));
				noticeview.setNotice_content(rs.getString("notice_content"));
				noticeview.setNotic_writer(rs.getString("notice_writer"));
				noticeview.setNotice_state(rs.getString("notice_state"));
				noticeview.setEmployee_dep(rs.getString("employee_dep"));
				noticeview.setNotice_date(rs.getString("notice_date"));
				noticeview.setNotice_complite(rs.getString("notice_complite"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		
		return noticeview;
	}

	@Override
	public List<NoticeDto> noList() {
		List<NoticeDto> nolist = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "select notice_seq, employee_id, notice_subject, notice_content, notice_writer, notice_state, employee_dep, notice_date from notice";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				NoticeDto noticeDto = new NoticeDto();
				noticeDto.setNotice_seq(rs.getInt("notice_seq"));
				noticeDto.setEmployee_id(rs.getString("employee_id"));
				noticeDto.setNotice_subject(rs.getString("notice_subject"));
				noticeDto.setNotice_content(rs.getString("notice_content"));
				noticeDto.setNotic_writer(rs.getString("notice_writer"));
				noticeDto.setNotice_state(rs.getString("notice_state"));
				noticeDto.setEmployee_dep(rs.getString("employee_dep"));
				noticeDto.setNotice_date(rs.getString("notice_date"));
				nolist.add(noticeDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return nolist;
	}

	@Override
	public List<MemoDto> memoList(int seq) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<MemoDto> memolist = new ArrayList<MemoDto>();
		try {
			conn = DBConnection.makeConnection();
			String sql = "select notice_seq, memo_seq, memo_content, memo_logtime, employee_id, memo_writer from memo where notice_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MemoDto memoDto = new MemoDto();
				memoDto.setNotice_seq(rs.getInt("notice_seq"));
				memoDto.setMemo_seq(rs.getInt("memo_seq"));
				memoDto.setMemo_content(rs.getString("memo_content"));
				memoDto.setMemo_logtime(rs.getString("memo_logtime"));
				memoDto.setEmployee_id(rs.getString("employee_id"));
				memoDto.setMemo_writer(rs.getString("memo_writer"));
				memolist.add(memoDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(conn, pstmt, rs);
		}
		return memolist;
	}

	@Override
	public void memoWrite(MemoDto memoDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "insert into memo (memo_seq, memo_content, memo_logtime, notice_seq, memo_writer, employee_id) \n";
			sql += "values (memo_seq.nextval,?,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memoDto.getMemo_content());
			pstmt.setInt(2, memoDto.getNotice_seq());
			pstmt.setString(3, memoDto.getMemo_writer());
			pstmt.setString(4, memoDto.getEmployee_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void memoDelete(int mseq) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "delete from memo where memo_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void memoModify(MemoDto memoDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update memo set memo_content=?, memo_logtime=to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') where memo_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memoDto.getMemo_content());
			pstmt.setInt(2, memoDto.getMemo_seq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void noticeUpdate(NoticeDto noticeDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update notice set notice_subject=?, notice_content=? where notice_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeDto.getNotice_subject());
			pstmt.setString(2, noticeDto.getNotice_content());
			pstmt.setInt(3, noticeDto.getNotice_seq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void noticeComplite(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "update notice set notice_state='처리완료', notice_complite=to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') where notice_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
	}
}
