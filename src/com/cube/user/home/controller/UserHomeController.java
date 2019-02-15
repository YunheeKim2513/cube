package com.cube.user.home.controller;

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

import com.cube.factory.CubeActionFactory;
import com.cube.model.dto.DiligencegroupDto;
import com.cube.model.dto.Doc_info_detailDto;
import com.cube.user.approval.main.model.dao.MainUserDaoImpl;
import com.cube.util.GroupwareConstance;
import com.cube.util.MovePage;


@WebServlet("/userhome")
public class UserHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "";
		if("user_home".equals(act)){
			path = "/pages/home/user_home.jsp";
			MovePage.redirect(root+path, response);
		}else if( "user_homelist".equals(act)){
			
			/*path = CubeActionFactory.getHomeNoticeViewAction().action(request, response);
			MovePage.forward(path, request, response);*/
			

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
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}
}