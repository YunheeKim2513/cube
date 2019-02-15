package com.cube.user.approval.main.model.dao;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface MainUserDao {
	List<Doc_info_detailDto> bapprovallist();
	List<Doc_info_detailDto> depapprovallist(String dep);
}
