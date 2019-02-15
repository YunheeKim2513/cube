package com.cube.user.approval.main.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface MainUserService {
	//String bapprovallist();
	List<Doc_info_detailDto> bapprovallist();
	List<Doc_info_detailDto> depapprovallist(String dep);
}
