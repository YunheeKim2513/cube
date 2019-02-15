package com.cube.admin.home.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.cube.admin.businesssuport.model.service.BusiniesssuportDiligenceAdminServiceImpl;
import com.cube.admin.home.action.HomeNoticeCompliteAction;
import com.cube.admin.home.action.HomeNoticeWriteAction;
import com.cube.admin.home.action.HomeNoticemvUpdateAction;
import com.cube.admin.home.model.dao.HomeAdminDaoImpl;
import com.cube.factory.CubeActionFactory;
import com.cube.model.dto.Doc_info_detailDto;
import com.cube.model.dto.EmployeeDilDto;
import com.cube.model.dto.NoticeDto;
import com.cube.user.approval.main.model.dao.MainUserDaoImpl;
import com.cube.util.GroupwareConstance;
import com.cube.util.MovePage;


@WebServlet("/adminhome")
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "";
		if("admin_home".equals(act)){
			path = "/pages/home/admin_home.jsp";
			MovePage.redirect(root+path, response);
		} else if("helpdesk_list".equals(act)||"userhelpdesk_list".equals(act)){
			path = CubeActionFactory.getHomeNoticeListAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("mvhlepwrite".equals(act)){
			path ="/pages/helpdesk/helpdesk_write.jsp";
			MovePage.redirect(root+path, response);
		} else if("usermvhlepwrite".equals(act)){
			path ="/pages/helpdesk_home/helpdesk_write.jsp";
			MovePage.redirect(root+path, response);
		} else if("helpregistor".equals(act)||"userhelpregistor".equals(act)){
			path = CubeActionFactory.getHomeNoticeWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("noticeview".equals(act)||"usernoticeview".equals(act)){
			path = CubeActionFactory.getHomeNoticeViewAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("chart".equals(act)){
	         List<EmployeeDilDto> employeelist = BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().employeeDilDtolist();
	         int len = employeelist.size();
	         int timenomalsum = 0;
	         int timelatesum = 0;
	         for(int i=0; i<len; i++){
	            timenomalsum += Integer.parseInt(employeelist.get(i).getNomal_limit());
	            timelatesum += Integer.parseInt(employeelist.get(i).getEndtime());
	         }
	         JSONObject json = new JSONObject();
	         JSONArray jarray = new JSONArray();
	      //for(EmployeeDilDto employeeDilDto : employeelist){
	            JSONObject jobj = new JSONObject();
	            //System.out.println(admin_timeSelectDto.getAdmintime_seq());
	            jobj.put("thetime", timenomalsum);
	            jobj.put("timelate", timelatesum);
	            jarray.add(jobj);
	      //   }
	         json.put("employeelist", jarray);
	         System.out.println(" json : "+json);
	         response.setContentType("text/html; charset=euc-kr");
	         PrintWriter out = response.getWriter();
	         out.println(json.toJSONString());
	      }else if("homelist".equals(act)){
	         path = CubeActionFactory.getHomeChartAction().action(request, response);
	         MovePage.redirect(root+path, response);
	      }else if("admin_homelist".equals(act)){
	         List<Doc_info_detailDto> bapprovallist = MainUserDaoImpl.getMainUserDao().bapprovallist();
	         JSONObject json = new JSONObject();
	         JSONArray jarray = new JSONArray();
	         for(Doc_info_detailDto doc_info_detailDto : bapprovallist){
	            JSONObject jobj = new JSONObject();
	            jobj.put("doc_seq", doc_info_detailDto.getDoc_seq());
	            jobj.put("doc_name", doc_info_detailDto.getDoc_name());
	            jobj.put("doc_date", doc_info_detailDto.getDoc_date());
	            jobj.put("doc_writer", doc_info_detailDto.getDoc_writer());
	            jobj.put("doc_subject", doc_info_detailDto.getDoc_subject());
	            jarray.add(jobj);
	         }
	         json.put("bapprovallist", jarray);
	         System.out.println(" json : "+json);
	         response.setContentType("text/html; charset=euc-kr");
	         PrintWriter out = response.getWriter();
	         out.println(json.toJSONString());
	      }else if("nolist".equals(act)){
	    	  
	    	  List<NoticeDto> nolist = HomeAdminDaoImpl.getHomeAdminDao().noList(); 
	    	   
		         JSONObject json = new JSONObject();
		         JSONArray jarray = new JSONArray();
		         for(NoticeDto noticeDto : nolist){
		            JSONObject jobj = new JSONObject();
		            jobj.put("notice_seq", noticeDto.getNotice_seq());
		            jobj.put("notice_subject", noticeDto.getNotice_subject());
		            jobj.put("notice_writer", noticeDto.getNotic_writer());
		            jobj.put("notice_date", noticeDto.getNotice_date());
		            
		            jarray.add(jobj);
		         }
		         json.put("nolist", jarray);
		         System.out.println(" json : "+json);
		         response.setContentType("text/html; charset=euc-kr");
		         PrintWriter out = response.getWriter();
		         out.println(json.toJSONString());
	      } else if("mvupdate".equals(act)){
	    	  path=HomeNoticemvUpdateAction.getHomeNoticemvUpdateAction().action(request, response);
	    	  MovePage.forward(path, request, response);
	      } else if("helpupdate".equals(act)){
	    	  path=HomeNoticeWriteAction.getHomeNoticeWriteAction().action(request, response);
	    	  MovePage.forward(path, request, response);
	      } else if("complite".equals(act)){
	    	  path=HomeNoticeCompliteAction.getHomeNoticeCompliteAction().action(request, response);
	    	  MovePage.forward(path, request, response);
	      }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}

}
