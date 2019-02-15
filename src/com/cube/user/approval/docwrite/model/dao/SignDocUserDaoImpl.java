package com.cube.user.approval.docwrite.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.SigndocDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class SignDocUserDaoImpl implements SignDocUserDao {

	private static SignDocUserDao signDocUserDao;

	static {
		signDocUserDao = new SignDocUserDaoImpl();
	}

	private SignDocUserDaoImpl() {
	}

	public static SignDocUserDao getSignDocUserDao() {
		return signDocUserDao;
	}

	@Override
	public List<Confirmlist_infoDto> confirmlist() {
		List<Confirmlist_infoDto> list = new ArrayList<Confirmlist_infoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "select confirm_code, confirm_name, confirmlist1, nvl(confirmlist2,' ') confirmlist2, nvl(confirmlist3,' ') confirmlist3 from confirmlist_info";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Confirmlist_infoDto confirmlist_infoDto = new Confirmlist_infoDto();
				confirmlist_infoDto.setConfirm_code(rs.getString("confirm_code"));
				confirmlist_infoDto.setConfirm_name(rs.getString("confirm_name"));
				confirmlist_infoDto.setConfirmlist1(rs.getString("confirmlist1"));
				confirmlist_infoDto.setConfirmlist2(rs.getString("confirmlist2"));
				confirmlist_infoDto.setConfirmlist3(rs.getString("confirmlist3"));
				list.add(confirmlist_infoDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("dao" + list.size());
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Confirmlist_infoDto confirmlist_infoDto(String confirmname) {
		Confirmlist_infoDto confirmlist_infoDto = new Confirmlist_infoDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "select confirmlist1, nvl(confirmlist2,' ') confirmlist2, nvl(confirmlist3,' ') confirmlist3 from confirmlist_info where confirm_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, confirmname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				confirmlist_infoDto.setConfirmlist1(rs.getString("confirmlist1"));
				confirmlist_infoDto.setConfirmlist2(rs.getString("confirmlist2"));
				confirmlist_infoDto.setConfirmlist3(rs.getString("confirmlist3"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return confirmlist_infoDto;
	}

	@Override
	public List<EmployeesDto> confirmlistview() {
		List<EmployeesDto> confirmlistview = new ArrayList<EmployeesDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "select e.employee_id, e.name, d.department_name, e.department_id, g.grade_name from employees e, departments d, grades g where e.department_id=d.department_id and e.grade_id=g.grade_id order by d.department_name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeesDto employeesDto = new EmployeesDto();
				employeesDto.setEmployee_id(rs.getString("employee_id"));
				employeesDto.setDepartment_name(rs.getString("department_name"));
				employeesDto.setName(rs.getString("name"));
				employeesDto.setDepartment_id(rs.getString("department_id"));
				employeesDto.setGarde_name(rs.getString("grade_name"));
				confirmlistview.add(employeesDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return confirmlistview;
	}

	@Override
	public int writesuccess(SigndocDto signdocDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			StringBuffer docdetail_insert = new StringBuffer();
			docdetail_insert.append("insert into doc_info_detail (doc_seq, doc_writetime, doc_code, doc_name, doc_state, doc_dep, doc_writer, doc_date, doc_receiver, ");
			docdetail_insert.append("doc_reference, doc_file, doc_subject, confirmname1, confirmname2, confirmname3, employee_id, name1, name2, name3) \n");
			docdetail_insert.append("values (to_char(sysdate,'yyyy-mm-dd')||'-S01-'||doc_seq.nextval,to_char(sysdate,'yyyy-mm-dd hh:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) \n");
			pstmt = conn.prepareStatement(docdetail_insert.toString());
			int idx = 0;
			pstmt.setString(++idx, signdocDto.getDoc_code());		//1
			pstmt.setString(++idx, signdocDto.getDoc_name());		//2
			pstmt.setString(++idx, signdocDto.getDoc_state());		//3
			pstmt.setString(++idx, signdocDto.getDoc_dep());		//4
			pstmt.setString(++idx, signdocDto.getDoc_writer());		//5
			pstmt.setString(++idx, signdocDto.getDoc_date());		//6
			pstmt.setString(++idx, signdocDto.getDoc_receiver());	//7
			pstmt.setString(++idx, signdocDto.getDoc_reference());	//8
			pstmt.setString(++idx, signdocDto.getDoc_file());		//9
			pstmt.setString(++idx, signdocDto.getDoc_subject());	//10
			pstmt.setString(++idx, signdocDto.getConfirmlist1());	//11
			pstmt.setString(++idx, signdocDto.getConfirmlist2());	//12
			pstmt.setString(++idx, signdocDto.getConfirmlist3());	//13
			pstmt.setString(++idx, signdocDto.getEmployee_id());	//14
			pstmt.setString(++idx, signdocDto.getConfirmlistname1());
			pstmt.setString(++idx, signdocDto.getConfirmlistname2());
			pstmt.setString(++idx, signdocDto.getConfirmlistname3());
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer signdoc_insert = new StringBuffer();
			signdoc_insert.append("insert into signdoc (doc_seq, signdoc_content) \n");
			signdoc_insert.append("values (to_char(sysdate,'yyyy-mm-dd')||'-S01-'||doc_seq.currval,?) \n");
			pstmt = conn.prepareStatement(signdoc_insert.toString());
			pstmt.setString(1, signdocDto.getSigndoc_content());
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
	public String confirmname(String confirmname1) {
		String confirmname="";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select e.name, d.department_name, g.grade_name  \n");
			sql.append("from employees e, departments d, grades g  \n");
			sql.append("where e.department_id=d.department_id and e.grade_id=g.grade_id and \n");
			sql.append("      e.employee_id=? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, confirmname1);
			rs = pstmt.executeQuery();
			if(rs.next()){
				confirmname = rs.getString("department_name");
				confirmname += " ("+rs.getString("grade_name")+")";
				confirmname += rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return confirmname;
	}

	@Override
	public int updatesuccess(SigndocDto signdocDto) {
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
			pstmt.setString(++idx, signdocDto.getDoc_code());		//1
			pstmt.setString(++idx, signdocDto.getDoc_name());		//2
			pstmt.setString(++idx, signdocDto.getDoc_state());		//3
			pstmt.setString(++idx, signdocDto.getDoc_dep());		//4
			pstmt.setString(++idx, signdocDto.getDoc_writer());		//5
			pstmt.setString(++idx, signdocDto.getDoc_date());		//6
			pstmt.setString(++idx, signdocDto.getDoc_receiver());	//7
			pstmt.setString(++idx, signdocDto.getDoc_reference());	//8
			pstmt.setString(++idx, signdocDto.getDoc_file());		//9
			pstmt.setString(++idx, signdocDto.getDoc_subject());	//10
			pstmt.setString(++idx, signdocDto.getConfirmlist1());	//11
			pstmt.setString(++idx, signdocDto.getConfirmlist2());	//12
			pstmt.setString(++idx, signdocDto.getConfirmlist3());	//13
			pstmt.setString(++idx, signdocDto.getEmployee_id());	//14
			pstmt.setString(++idx, signdocDto.getConfirmlistname1());
			pstmt.setString(++idx, signdocDto.getConfirmlistname2());
			pstmt.setString(++idx, signdocDto.getConfirmlistname3());
			pstmt.setString(++idx, signdocDto.getDoc_seq());	//14
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer vacdoc_update = new StringBuffer();
			vacdoc_update.append("update signdoc set signdoc_content=? \n");
			vacdoc_update.append("where doc_seq=? \n");
			pstmt = conn.prepareStatement(vacdoc_update.toString());
			idx=0;
			pstmt.setString(++idx, signdocDto.getSigndoc_content());
			pstmt.setString(++idx, signdocDto.getDoc_seq());	//14
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
