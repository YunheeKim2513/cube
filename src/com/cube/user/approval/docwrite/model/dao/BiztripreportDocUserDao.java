package com.cube.user.approval.docwrite.model.dao;

import com.cube.model.dto.Biztrip_reportDto;

public interface BiztripreportDocUserDao {
	int writesuccess(Biztrip_reportDto biztrip_reportDto);
	int updatesuccess(Biztrip_reportDto biztrip_reportDto);
}
