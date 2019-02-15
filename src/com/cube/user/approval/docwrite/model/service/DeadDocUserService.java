package com.cube.user.approval.docwrite.model.service;

import com.cube.model.dto.DeaddocDto;

public interface DeadDocUserService {
	int writesuccess(DeaddocDto deaddocDto);
	int updatesuccess(DeaddocDto deaddocDto);
}
