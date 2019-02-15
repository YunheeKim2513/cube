package com.cube.user.approval.receivedoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface NoDocUserService {
	List<Doc_info_detailDto> nolistapprovallist(String id);
	int confirmcheck1(int confirmlist, String seq);
	int confirmcheck2(int confirmlist, String seq);
	int confirmcheck3(int confirmlist, String seq);
	String name(String id);
}
