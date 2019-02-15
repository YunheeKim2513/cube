package com.cube.user.approval.senddoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface SaveDocUserService {
	List<Doc_info_detailDto> savedoclist(String employee_id);
	void savedoc(String seq);
	void savedocdelete(String seq, String dockind);
	void savedocupdate(String seq);
}
