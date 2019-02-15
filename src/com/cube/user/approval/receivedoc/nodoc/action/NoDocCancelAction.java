package com.cube.user.approval.receivedoc.nodoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.user.approval.receivedoc.model.service.NoDocUserServiceImpl;

public class NoDocCancelAction implements Action {

	private static NoDocCancelAction noDocCancelAction;
	
	static{
		noDocCancelAction = new NoDocCancelAction();
	}
	
	NoDocCancelAction(){}
	
	public static NoDocCancelAction getNoDocCancelAction() {
		return noDocCancelAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seq = request.getParameter("seq");
		String id = request.getParameter("id");
		int confirmlist = Integer.parseInt(request.getParameter("confirmlist"));
		if(confirmlist==0){
			NoDocUserServiceImpl.getNoDocUserService().confirmcheck1(confirmlist, seq);
		} else if(confirmlist==1){
			NoDocUserServiceImpl.getNoDocUserService().confirmcheck2(confirmlist, seq);
		} else if(confirmlist==2){
			NoDocUserServiceImpl.getNoDocUserService().confirmcheck3(confirmlist, seq);
		}
		String confirmcheck = toString().valueOf(CommonServiceImpl.getCommonServiceImpl().confirmcheck(seq));
		String confirmnames = toString().valueOf(CommonServiceImpl.getCommonServiceImpl().confirmnames(seq));
		String name = NoDocUserServiceImpl.getNoDocUserService().name(id);
		CommonServiceImpl.getCommonServiceImpl().docstatecancel(seq);
		return confirmcheck+"@"+name+"@"+confirmnames+"@";
	}

}
