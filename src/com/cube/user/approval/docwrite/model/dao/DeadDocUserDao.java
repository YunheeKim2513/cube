package com.cube.user.approval.docwrite.model.dao;

import com.cube.model.dto.DeaddocDto;

public interface DeadDocUserDao {
	int writesuccess(DeaddocDto deaddocDto);
	int updatesuccess(DeaddocDto deaddocDto);
}
