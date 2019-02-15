package com.cube.user.approval.senddoc.model.dao;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface SaveDocUserDao {
	List<Doc_info_detailDto> savedoclist(String employee_id);
	void savedoc(String seq);
	void savedocdelete(String seq, String dockind);
	void savedocupdate(String seq);
}
