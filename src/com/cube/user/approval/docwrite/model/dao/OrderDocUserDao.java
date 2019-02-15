package com.cube.user.approval.docwrite.model.dao;

import com.cube.model.dto.OrderdocDto;

public interface OrderDocUserDao {
	int writesuccess(OrderdocDto orderdocDto);
	int updatesuccess(OrderdocDto orderdocDto);
}
