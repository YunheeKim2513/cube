package com.cube.admin.businesssupport.controller;

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
import com.cube.factory.CubeActionFactory;
import com.cube.model.dto.Admin_timeSelectDto;
import com.cube.model.dto.DiligencegroupDto;
import com.cube.model.dto.HappyDayDto;
import com.cube.util.MovePage;


@WebServlet("/admindiligence")
public class AdminDiligenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "";
		if("departsearch".equals(act)){//���� �˻�
			
			path=CubeActionFactory.getDiligenceSearchAction().action(request, response);
			MovePage.forward(path, request, response);
			
		}else if("datesearch".equals(act)){//���� �˻�
			//���� ���� �˻�
			path=CubeActionFactory.getDiligenceTimeSetAction().action(request, response);
			MovePage.forward(path, request, response);
	
		}else if("weeksearch".equals(act)){//���� �˻�
			
		}else if("monthsearch".equals(act)){//���� �˻�
			
		}else if("threemonthsearch".equals(act)){//���� �˻�
			
		}else if("allsearch".equals(act)){//���� �˻�
			
			//��¥�� ����� ��ȣ�� ������ �˻��� �ϴ� ��
			path=CubeActionFactory.getDiligenceSearchAction().action(request, response);
			MovePage.forward(path, request, response);
					
		}else if("diligencesaveact".equals(act)){
			
			System.out.println("���½ð� �� �������?");
			path=CubeActionFactory.getDiligenceGroupInsertAction().action(request, response);
			System.out.println("�̵��Ǵ�?");
			MovePage.forward(path, request, response);
			
		}else if("diligenceGroupDelete".equals(act)){
			System.out.println("���±׷� ���� �Ѵ�~ ��Ʈ�ѷ�");
			path=CubeActionFactory.getDiligenceDeleteAction().action(request, response);
//			MovePage.redirect(root+path, response);
			MovePage.forward(path, request, response);

		}else if("diligencegroupselect".equals(act)){
			
			System.out.println("���½ð� ���� �������� ���Դ�");
			System.out.println("����Ǿ� �ִ� ���±׷찪 �Ѹ���~!");
			
			 //���±׷�
			List<DiligencegroupDto> list = BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().diligencekind();
			
			JSONObject json = new JSONObject();
			JSONArray jarray = new JSONArray();
			for(DiligencegroupDto diligencegroupDto : list){
				
				JSONObject jobj = new JSONObject();
				
				jobj.put("group_standard", diligencegroupDto.getGroup_standard());

				jarray.add(jobj);
			}
			json.put("diligencelist", jarray);
			
			System.out.println(" json : "+json);
			
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println(json.toJSONString());
			

		}else if("diligenceinsert".equals(act)){
			path=CubeActionFactory.getDiligenceGroupInsertSmallAction().action(request, response); 
			MovePage.forward(path, request, response);
			
		}else if("diligenceselectact".equals(act)){
			//��ü �Ѹ���
			System.out.println("���� ����Ʈ �Ѹ���");
			
			
			
			 //���±׷�
			List<Admin_timeSelectDto> list2 = BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().diligenceselect();
			
			JSONObject json2 = new JSONObject();
			JSONArray jarray2 = new JSONArray();
			
			for(Admin_timeSelectDto admin_timeSelectDto : list2){
				
				JSONObject jobj2 = new JSONObject();
				//System.out.println(admin_timeSelectDto.getAdmintime_seq());
				jobj2.put("admintime_seq", admin_timeSelectDto.getAdmintime_seq());
				jobj2.put("endcon", admin_timeSelectDto.getEndset());
				jobj2.put("startcon", admin_timeSelectDto.getStartset());
				jobj2.put("group_standard", admin_timeSelectDto.getGroupStandard());

				
				 
				jarray2.add(jobj2);
			}
			json2.put("diligencegrouplist", jarray2);
			
			System.out.println(" json2 : "+json2);
			
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println(json2.toJSONString());
			
		}else if("deletebtn".equals(act)){
			
			System.out.println("����Ʈ ���� �����Ѵ�~");
			path=CubeActionFactory.getDiligenceAllDeleteAction().action(request, response);
			MovePage.forward(path, request, response);
			
		}else if("happyday".equals(act)){
			
			System.out.println("happy ���� controller");		
			
			path=CubeActionFactory.getDiligenceHappyDaySetAction().action(request, response);
			MovePage.forward(path, request, response);

		}else if("happydaylist".equals(act)){
			System.out.println("happylist �Ѹ��� controller");		
			
			/*path=CubeActionFactory.getDiligenceHappyDaySearchAction().action(request, response);
			MovePage.forward(path, request, response);
*/
			List<HappyDayDto> happyDayDtolist = BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().happyDayDto();
			
			JSONObject json4 = new JSONObject();
			JSONArray jarray4 = new JSONArray();
			
			for(HappyDayDto happyDayDto : happyDayDtolist){
				
				JSONObject jobj4 = new JSONObject();
				//System.out.println(admin_timeSelectDto.getAdmintime_seq());
				jobj4.put("happy_code", happyDayDto.getHappy_code());
				jobj4.put("happy_name", happyDayDto.getHappy_name());
				jobj4.put("happy_start", happyDayDto.getHappy_stat());
				jobj4.put("happy_end", happyDayDto.getHappy_end());

				
				 
				jarray4.add(jobj4);
			}
			json4.put("happyDayDtolist", jarray4);
			
			System.out.println(" json4 : "+json4);
			
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println(json4.toJSONString());
			
			
			
		}else if("happypage".equals(act)){
			path="/pages/admin_diligence/admin_diligence_happyday.jsp";
			MovePage.redirect(root+path, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
