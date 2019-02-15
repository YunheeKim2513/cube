package com.cube.user.approval.receivedoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface OkDocUserService {
	List<Doc_info_detailDto> oklistapprovallist(String id);
}
