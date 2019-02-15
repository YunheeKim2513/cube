package com.cube.user.approval.senddoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface WithDrawDocUserService {
	List<Doc_info_detailDto> withdrawdoclist(String employee_id);
}
