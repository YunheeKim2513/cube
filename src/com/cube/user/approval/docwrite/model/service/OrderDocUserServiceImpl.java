package com.cube.user.approval.docwrite.model.service;

import com.cube.model.dto.OrderdocDto;
import com.cube.user.approval.docwrite.model.dao.OrderDocUserDaoImpl;

public class OrderDocUserServiceImpl implements OrderDocUserService {
	
	private static OrderDocUserService orderDocUserService;
	
	static {
		orderDocUserService = new OrderDocUserServiceImpl();
	}
	
	private OrderDocUserServiceImpl(){}
	
	public static OrderDocUserService getOrderDocUserService() {
		return orderDocUserService;
	}

	@Override
	public int writesuccess(OrderdocDto orderdocDto) {
		return OrderDocUserDaoImpl.getOrderDocUserDao().writesuccess(orderdocDto);
	}

	@Override
	public int updatesuccess(OrderdocDto orderdocDto) {
		return OrderDocUserDaoImpl.getOrderDocUserDao().updatesuccess(orderdocDto);
	}

}
