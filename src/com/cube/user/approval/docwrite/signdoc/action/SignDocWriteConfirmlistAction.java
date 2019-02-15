package com.cube.user.approval.docwrite.signdoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;
import com.cube.util.Encoder;
import com.cube.util.UrlFormat;

public class SignDocWriteConfirmlistAction implements Action {
	
	private static SignDocWriteConfirmlistAction signDocWriteConfirmlistAction;
	
	static {
		signDocWriteConfirmlistAction = new SignDocWriteConfirmlistAction();
	}
	
	private SignDocWriteConfirmlistAction(){}
	
	
	public static SignDocWriteConfirmlistAction getSignDocWriteConfirmlist() {
		return signDocWriteConfirmlistAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String confirmname = Encoder.isoToUtf(request.getParameter("confirmname"));
			Confirmlist_infoDto confirmlist_infoDto = new Confirmlist_infoDto();
			confirmlist_infoDto = SignDocUserServiceImpl.getSignDocUserService().confirmlist_infoDto(confirmname);
			request.setAttribute("confirmline", confirmlist_infoDto);
			String confirmlistname1 = SignDocUserServiceImpl.getSignDocUserService().confirmname(confirmlist_infoDto.getConfirmlist1());
			String confirmlistname2 = SignDocUserServiceImpl.getSignDocUserService().confirmname(confirmlist_infoDto.getConfirmlist2());
			String confirmlistname3 = SignDocUserServiceImpl.getSignDocUserService().confirmname(confirmlist_infoDto.getConfirmlist3());
			String confirmlistname = confirmlistname1+"|"+confirmlistname2+"|"+confirmlistname3;
			String confirmline = confirmlist_infoDto.getConfirmlist1()+","+confirmlist_infoDto.getConfirmlist2()+","+confirmlist_infoDto.getConfirmlist3();
			return "/pages/user_approval/confirmlinecheck.jsp?confirmline="+UrlFormat.utfencode(confirmline)+"&confirmname="+UrlFormat.utfencode(confirmlistname);
	}

}
