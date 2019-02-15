package com.cube.admin.companyinfo.action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.dao.AdminCompanyinfoEmployeeDaoImpl;
import com.cube.model.dto.EmployeesListDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EmployeeFireUpdateAction implements Action{
	private static EmployeeFireUpdateAction employeeFireUpdateAction;
	static{
		employeeFireUpdateAction=new EmployeeFireUpdateAction();
	}
	
	public static EmployeeFireUpdateAction getEmployeeFireUpdateAction() {
		return employeeFireUpdateAction;
	}
	private EmployeeFireUpdateAction(){
		maxPostSize=10*1024*1024;//10MB
		encoding="EUC-KR";
		//System.out.println("rootDirectory : "+rootDirectory);
	}
	private String rootDirectory;
	private String saveDirectory;
	private int maxPostSize;
	private String encoding;
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("EmployeeFireUpdateAction");
		if(rootDirectory==null)
			rootDirectory=request.getServletContext().getRealPath("/picture");//실제 파일디스크 경로
		DateFormat df=new SimpleDateFormat("yyyyMMdd");
		String today=df.format(new Date());// 20161011
		saveDirectory=rootDirectory+File.separator+today;
		//System.out.println("saveDirectory : "+saveDirectory);
		File file=new File(saveDirectory);
		if(!file.exists())//file이 존재하지 않으면
			file.mkdirs();//file을 만들어라
		MultipartRequest multi=new MultipartRequest(request, saveDirectory, maxPostSize,
				encoding, new DefaultFileRenamePolicy());
		
		EmployeesListDto employeesListDto=new EmployeesListDto();
		employeesListDto.setEmployee_id(multi.getParameter("employee_id"));
		employeesListDto.setDepartment_id(multi.getParameter("department"));
		employeesListDto.setGrade_id(multi.getParameter("grade"));
		employeesListDto.setName(multi.getParameter("employee_name"));
		employeesListDto.setPass(multi.getParameter("pwd"));
		employeesListDto.setGroup_standard(multi.getParameter("group"));
		employeesListDto.setEmail1(multi.getParameter("email1"));
		employeesListDto.setEmail2(multi.getParameter("email2"));
		employeesListDto.setGender(multi.getParameter("gender"));
		employeesListDto.setHn1(multi.getParameter("htel1"));
		employeesListDto.setHn2(multi.getParameter("htel2"));
		employeesListDto.setHn3(multi.getParameter("htel3"));
		employeesListDto.setHp1(multi.getParameter("tel1"));
		employeesListDto.setHp2(multi.getParameter("tel2"));
		employeesListDto.setHp3(multi.getParameter("tel3"));
		employeesListDto.setZip1(multi.getParameter("post1"));
		employeesListDto.setZip2(multi.getParameter("post2"));
		employeesListDto.setAddr1(multi.getParameter("address1"));
		employeesListDto.setAddr2(multi.getParameter("address2"));
		employeesListDto.setMarraige(multi.getParameter("marry"));
		employeesListDto.setSave_folder(today);
		employeesListDto.setOrigin_picture(multi.getOriginalFileName("imgInp"));
													//last "."   jpg, png, ..
		employeesListDto.setSave_picture(multi.getFilesystemName("imgInp"));		
		int result=AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().fireupdate(employeesListDto);
		String url="";
		if(result==2){
			url="/employee_fireupdate_ok.jsp";
		} else {
			url="/employee_fireupdate_no.jsp";
		}
		return "/pages/admin_companyinfo"+url;
	}

}
