package com.cube.admin.businesssuport.model.dao;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;

public interface BusiniesssuportApprivalAdminDao {
	void confirmlistinsert(String confirmname, String confirmlist1, String confirmlist2, String confirmlist3);
	void confirmlistupdate(String confirmname, String confirmlist1, String confirmlist2, String confirmlist3);
	void confirmlistdelete(String confirmcode);
	List<Doc_info_detailDto> doclist();
}
