package com.cube.admin.businesssupport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;


public class DiligenceHappyDayDeleteAction implements Action{

	private static DiligenceHappyDayDeleteAction diligenceHappyDayDeleteAction;
	
	static{
		diligenceHappyDayDeleteAction = new DiligenceHappyDayDeleteAction();
	}
	
	private DiligenceHappyDayDeleteAction(){};
	
	public static DiligenceHappyDayDeleteAction getDiligenceHappyDayDeleteAction() {
		return diligenceHappyDayDeleteAction;
	}

	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		return null;
	}

}
