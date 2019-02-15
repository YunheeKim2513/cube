package com.cube.user.approval.docwrite.model.dao;

import java.util.List;

import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.SigndocDto;

public interface SignDocUserDao {
	List<Confirmlist_infoDto> confirmlist();
	Confirmlist_infoDto confirmlist_infoDto(String confirmname);
	List<EmployeesDto> confirmlistview();
	int writesuccess(SigndocDto signdocDto);
	String confirmname(String confirmname1);
	int updatesuccess(SigndocDto signdocDto);
}
