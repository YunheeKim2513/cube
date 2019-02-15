package com.cube.user.approval.docwrite.model.service;

import com.cube.model.dto.OrderdocDto;

public interface OrderDocUserService {
	int writesuccess(OrderdocDto orderdocDto);
	int updatesuccess(OrderdocDto orderdocDto);
}
