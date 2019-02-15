package com.cube.admin.home.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cube.action.Action;
import com.cube.admin.businesssuport.model.service.BusiniesssuportDiligenceAdminServiceImpl;
import com.cube.admin.businesssupport.action.DiligenceAllDeleteAction;
import com.cube.model.dto.Admin_timeSelectDto;
import com.cube.model.dto.EmployeeDilDto;

public class HomeChartAction implements Action{

	private static HomeChartAction homeChartAction;

	static{
		homeChartAction = new HomeChartAction();
	}

	private HomeChartAction(){}

		public static HomeChartAction getHomeChartAction() {
		return homeChartAction;
	}

	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
/*		List<EmployeeDilDto> employeelist = BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().employeeDilDtolist();
		
		int len = employeelist.size();
		
		int timenomalsum = 0;
		int timelatesum = 0;
		
		for(int i=0; i<len; i++){
		
			timenomalsum += Integer.parseInt(employeelist.get(i).getNomal_limit());
			timelatesum += Integer.parseInt(employeelist.get(i).getEndtime());
			
			
		}
		
		
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray();
		
		for(EmployeeDilDto employeeDilDto : employeelist){
			
			JSONObject jobj = new JSONObject();
			//System.out.println(admin_timeSelectDto.getAdmintime_seq());
			jobj.put("thetime", timenomalsum);
			jobj.put("timelate", timelatesum);
		
			jarray.add(jobj);
		}
		json.put("employeelist", jarray);
		
		System.out.println(" json : "+json);
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println(json.toJSONString());
		*/
		
	
		//return "/pages/home/admin_home.jsp?";
		
		return null;
	}

}
