package com.cube.user.approval.docwrite.model.service;

import com.cube.model.dto.Biztrip_reportDto;

public interface BiztripreportDocUserService {
	int writesuccess(Biztrip_reportDto biztrip_reportDto);
	int updatesuccess(Biztrip_reportDto biztrip_reportDto);
}
