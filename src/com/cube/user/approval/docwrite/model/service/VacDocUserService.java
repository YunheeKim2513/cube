package com.cube.user.approval.docwrite.model.service;

import com.cube.model.dto.VacdocDto;

public interface VacDocUserService {
	int writesuccess(VacdocDto vacdocDto);
	int updatesuccess(VacdocDto vacdocDto);
}
