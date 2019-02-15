package com.cube.user.businessreport.model.dao;

import java.util.List;

import com.cube.model.dto.Work_reportDto;

public interface MyWorkreportUserDao {
	 void workinsert(Work_reportDto work_reportDto);
	 String worktime(String seq);
	 List<Work_reportDto> mywork_reportlist(String employee_id);
	 List<Work_reportDto> receivework_reportlist(String employee_id, String department_name);
	 Work_reportDto work_report_view(String seq);
	 void workupdate(Work_reportDto work_reportDto);
}
