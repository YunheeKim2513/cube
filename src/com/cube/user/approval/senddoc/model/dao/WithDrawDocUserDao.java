package com.cube.user.approval.senddoc.model.dao;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface WithDrawDocUserDao {
	List<Doc_info_detailDto> withdrawdoclist(String employee_id);
}
