package com.cube.user.approval.docwrite.model.service;

import com.cube.model.dto.BiztripdocDto;

public interface BiztripDocUserService {
	int writesuccess(BiztripdocDto biztripdocDto);
	int updatesuccess(BiztripdocDto biztripdocDto);
}
