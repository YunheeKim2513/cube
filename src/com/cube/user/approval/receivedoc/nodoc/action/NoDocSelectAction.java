package com.cube.user.approval.receivedoc.nodoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.BiztripdocDto;
import com.cube.model.dto.VacdocDto;
import com.cube.user.approval.receivedoc.model.service.NoDocUserServiceImpl;
import com.cube.util.Encoder;

public class NoDocSelectAction implements Action {

	private static NoDocSelectAction noDocSelectAction;
	
	static{
		noDocSelectAction = new NoDocSelectAction();
	}
	
	private NoDocSelectAction(){}
	
	public static NoDocSelectAction getNoDocSelectAction() {
		return noDocSelectAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seq = request.getParameter("seq");
		int confirmlist = Integer.parseInt(request.getParameter("confirmlist"));
		String id = request.getParameter("id");
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
		String docname = Encoder.isoToUtf(request.getParameter("docname"));
		System.out.println(docname+"werwerwerwerwewerwer");
		System.out.println(confirmcheck);
		System.out.println(confirmnames);
		if(confirmcheck.equals(confirmnames)){
			if("사직서".equals(docname)){
				String docwriteid =  Encoder.isoToUtf(request.getParameter("docwriteid"));
				CommonServiceImpl.getCommonServiceImpl().getCommonServiceImpl().docdead(seq, docwriteid);
			} else if("휴가계".equals(docname)){
				VacdocDto vacdocDto = new VacdocDto();
				vacdocDto = CommonServiceImpl.getCommonServiceImpl().vacview(seq);
				System.out.println("휴가계성공");
				CommonServiceImpl.getCommonServiceImpl().docvac(vacdocDto);
			}  else if("출장신청서".equals(docname)){
				BiztripdocDto biztripdocDto = new BiztripdocDto();
				biztripdocDto = CommonServiceImpl.getCommonServiceImpl().bizview(seq);
				CommonServiceImpl.getCommonServiceImpl().docbiztrip(biztripdocDto);
			} else {
				CommonServiceImpl.getCommonServiceImpl().docstate(seq);
			}
		}
		return confirmcheck+"@"+name+"@"+confirmnames+"@";
	}

}	
