package com.cube.admin.businesssupport.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;


public class DiligenceTimeSetAction implements Action{

	

	private static DiligenceTimeSetAction diligenceTimeSetAction;
	
	static{
		diligenceTimeSetAction = new DiligenceTimeSetAction();
	}
	
	private DiligenceTimeSetAction(){};
	
	public static DiligenceTimeSetAction getDiligenceTimeSetAction() {
		return diligenceTimeSetAction;
	}

	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		//모달부분 복붙
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		List<Confirmlist_infoDto> list = new ArrayList<Confirmlist_infoDto>();
		List<EmployeesDto> confirmlist = new ArrayList<EmployeesDto>();

		if(employeesDto==null)
		System.out.println("널");
		
		
		//String startdate = request.getParameter("startdate");
		//String enddate = request.getParameter("enddate");
		
		//int startdate1 = Integer.parseInt(startdate.substring(9));
		//int enddate1 = Integer.parseInt(enddate.substring(9));
		
		list = SignDocUserServiceImpl.getSignDocUserService().confirmlist();
		confirmlist = SignDocUserServiceImpl.getSignDocUserService().confirmlistview();
		request.setAttribute("confirmlist", list);
		request.setAttribute("confirmlistview", confirmlist);
		
		
		//SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd", Locale.KOREA );
		//Date currentTime = new Date();

		//String dTime = formatter.format ( currentTime );
		
		//int dTime1 = Integer.parseInt(dTime.substring(9));
		
		//if(startdate != null && enddate != null){
		//	if(dTime1 >= startdate1 && dTime1 < enddate1){
				
			//}
		//}
		
		return "/pages/admin_diligence/admin_diligence_search.jsp";
	}

}
