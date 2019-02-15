package com.cube.user.approval.docwrite.model.dao;

import com.cube.model.dto.BiztripdocDto;

public interface BiztripDocUserDao {
	int writesuccess(BiztripdocDto biztripdocDto);
	int updatesuccess(BiztripdocDto biztripdocDto);
}
