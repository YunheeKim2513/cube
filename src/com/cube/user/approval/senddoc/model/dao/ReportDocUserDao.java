package com.cube.user.approval.senddoc.model.dao;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface ReportDocUserDao {
	List<Doc_info_detailDto> reportlist(String employee_id);
}
