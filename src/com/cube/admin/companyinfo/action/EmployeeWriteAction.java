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
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.Employees_detailDto;
import com.cube.util.ParameterCheck;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EmployeeWriteAction implements Action {
	private static EmployeeWriteAction employeeWriteAction;
	static{
		employeeWriteAction=new EmployeeWriteAction();
	}
	
	public static EmployeeWriteAction getEmployeeWriteAction() {
		return employeeWriteAction;
	}
	private EmployeeWriteAction(){
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
		//System.out.println("EmployeeWriteAction");
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
		
		String root=request.getContextPath();
		String url="";
		Employees_detailDto employees_detailDto = new Employees_detailDto();
		employees_detailDto.setEmployee_id(multi.getParameter("employee_id"));
		employees_detailDto.setName(multi.getParameter("employee_name"));
		employees_detailDto.setPass(multi.getParameter("pwd"));
		employees_detailDto.setDepartment_id(multi.getParameter("department"));
		employees_detailDto.setGrade_id(multi.getParameter("grade"));
		employees_detailDto.setGroup_standard(multi.getParameter("group"));
		employees_detailDto.setGender(multi.getParameter("gender"));
		employees_detailDto.setHp1(multi.getParameter("tel1"));
		employees_detailDto.setHp2(multi.getParameter("tel2"));
		employees_detailDto.setHp3(multi.getParameter("tel3"));
		employees_detailDto.setEmail1(multi.getParameter("email1"));
		employees_detailDto.setEmail2(multi.getParameter("email2"));
		employees_detailDto.setHn1(ParameterCheck.nullToBlank(multi.getParameter("htel1")));
		employees_detailDto.setHn2(ParameterCheck.nullToBlank(multi.getParameter("htel2")));
		employees_detailDto.setHn3(ParameterCheck.nullToBlank(multi.getParameter("htel3")));
		employees_detailDto.setZip1(multi.getParameter("post1"));
		employees_detailDto.setZip2(multi.getParameter("post2"));
		employees_detailDto.setAddr1(multi.getParameter("address1"));
		employees_detailDto.setAddr2(multi.getParameter("address2"));
		employees_detailDto.setMarrige(multi.getParameter("marry"));
		employees_detailDto.setSave_folder(today);
		employees_detailDto.setOrigin_picture(multi.getOriginalFileName("imgInp"));
													//last "."   jpg, png, ..
		employees_detailDto.setSave_picture(multi.getFilesystemName("imgInp"));

		int result=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().sign_up(employees_detailDto);
		if(result==0){
			url="/employee_signup_no.jsp";
		} else {
			url="/employee_signup_ok.jsp";
		}
		return "/pages/admin_companyinfo"+url;
	}

}
