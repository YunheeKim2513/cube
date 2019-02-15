package com.cube.admin.companyinfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.ZipDto;
import com.cube.util.Encoder;

public class ZipcheckAction implements Action{
	private static ZipcheckAction zipcheckAction;
	static {
		zipcheckAction = new ZipcheckAction();
	}
	
	public static ZipcheckAction getZipcheckAction() {
		return zipcheckAction;
	}
	private ZipcheckAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dong=Encoder.isoToEuc(request.getParameter("dong"));
		//System.out.println("검색 동 : "+dong);
		List<ZipDto> list=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().zipSearch(dong);//dong을 service로 보내야함
		//System.out.println("검색 동 수 : "+list.size());
		request.setAttribute("ziplist", list);
		request.setAttribute("searchdong", dong);
		return "/pages/admin_companyinfo/zipsearch.jsp";
		//return "/emp?act=mvzip";
	}

}
