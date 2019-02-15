package com.cube.user.approval.receivedoc.model.dao;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface OkDocUserDao {
	List<Doc_info_detailDto> oklistapprovallist(String id);
}
