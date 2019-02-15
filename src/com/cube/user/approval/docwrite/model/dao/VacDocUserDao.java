package com.cube.user.approval.docwrite.model.dao;

import com.cube.model.dto.VacdocDto;

public interface VacDocUserDao {
	int writesuccess(VacdocDto vacdocDto);
	int updatesuccess(VacdocDto vacdocDto);
}
