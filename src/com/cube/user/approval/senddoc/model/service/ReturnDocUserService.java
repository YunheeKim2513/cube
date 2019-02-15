package com.cube.user.approval.senddoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface ReturnDocUserService {
	List<Doc_info_detailDto> returndoclist(String employee_id);
}
