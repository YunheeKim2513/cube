package com.cube.user.schedule.model.service;

import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.dao.ScheduleSearchUserDaoImpl;

public class ScheduleSearchUserServiceImpl implements ScheduleSearchUserService {
	private static ScheduleSearchUserService scheduleSearchUserService;
	static {
		scheduleSearchUserService=new ScheduleSearchUserServiceImpl();
	}
	public static ScheduleSearchUserService getScheduleSearchUserService() {
		return scheduleSearchUserService;
	}
	private ScheduleSearchUserServiceImpl(){}

	
	@Override
	public String list() {
		List<ScheduleDto> list=ScheduleSearchUserDaoImpl.getScheduleSearchUserDao().list();
		
		JSONObject json=new JSONObject();
		JSONArray jarray=new JSONArray();
		for(ScheduleDto scheduleDto : list){
			JSONObject jobj=new JSONObject();
			jobj.put("schedule_seq", scheduleDto.getSchedule_seq());
			jobj.put("employee_id", scheduleDto.getEmployee_id());
			jobj.put("employee_name", scheduleDto.getName());
			jobj.put("schedule_kind", scheduleDto.getSchedule_kind());
			jobj.put("department_name", scheduleDto.getDepartment_name());
			jobj.put("grade_name", scheduleDto.getGrade_name());
			jobj.put("schedule_startdate", scheduleDto.getSchedule_startdate());
			jobj.put("schedule_enddate", scheduleDto.getSchedule_enddate());
			jobj.put("schedule_subject", scheduleDto.getSchedule_subject());
			jobj.put("schedule_content", scheduleDto.getSchedule_content());
			jarray.add(jobj);
		}//{id:"abc", name:"abc", pass:"abcd", .., joindate:"2016-09-27"}
		json.put("schedulelist", jarray);
		//{mlist:{id:"abc", name:"abc", pass:"abcd", .., joindate:"2016-09-27"}}
		
		return json.toJSONString();
	}
	@Override
	public String search(String kind, String start, String end) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("kind", kind);
		map.put("start", start);
		map.put("end", end);

		List<ScheduleDto> list=ScheduleSearchUserDaoImpl.getScheduleSearchUserDao().search(map);
		
		JSONObject json=new JSONObject();
		JSONArray jarray=new JSONArray();
		for(ScheduleDto scheduleDto : list){
			JSONObject jobj=new JSONObject();
			jobj.put("schedule_seq", scheduleDto.getSchedule_seq());
			jobj.put("employee_name", scheduleDto.getName());
			jobj.put("schedule_kind", scheduleDto.getSchedule_kind());
			jobj.put("department_name", scheduleDto.getDepartment_name());
			jobj.put("grade_name", scheduleDto.getGrade_name());
			jobj.put("schedule_startdate", scheduleDto.getSchedule_startdate());
			jobj.put("schedule_enddate", scheduleDto.getSchedule_enddate());
			jobj.put("schedule_subject", scheduleDto.getSchedule_subject());
			jobj.put("schedule_content", scheduleDto.getSchedule_content());
			jarray.add(jobj);
		}//{id:"abc", name:"abc", pass:"abcd", .., joindate:"2016-09-27"}
		json.put("schedulelist", jarray);
		//{mlist:{id:"abc", name:"abc", pass:"abcd", .., joindate:"2016-09-27"}}
		
		return json.toJSONString();
	}
	@Override
	public void update(int seq, String subject,String content ,String kind, String start, String end) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("seq", seq+"");
		map.put("subject", subject);
		map.put("content", content);
		map.put("kind", kind);
		map.put("start", start);
		map.put("end", end);
		ScheduleSearchUserDaoImpl.getScheduleSearchUserDao().update(map);
	}
	@Override
	public void delete(int seq) {
		ScheduleSearchUserDaoImpl.getScheduleSearchUserDao().delete(seq);
	}
	@Override
	public String view(int seq) {
		ScheduleDto scheduleDto=ScheduleSearchUserDaoImpl.getScheduleSearchUserDao().view(seq);
		JSONObject json=new JSONObject();
		JSONArray jarray=new JSONArray();
		JSONObject jobj=new JSONObject();
		jobj.put("schedule_seq", scheduleDto.getSchedule_seq());
		jobj.put("schedule_kind", scheduleDto.getSchedule_kind());
		jobj.put("schedule_startdate", scheduleDto.getSchedule_startdate());
		jobj.put("schedule_enddate", scheduleDto.getSchedule_enddate());
		jobj.put("schedule_subject", scheduleDto.getSchedule_subject());
		jobj.put("schedule_content", scheduleDto.getSchedule_content());
		jarray.add(jobj);
		//{id:"abc", name:"abc", pass:"abcd", .., joindate:"2016-09-27"}
		json.put("schedulelist", jarray);
		//{mlist:{id:"abc", name:"abc", pass:"abcd", .., joindate:"2016-09-27"}}
		return json.toJSONString();
	}
	
}
