package com.cube.admin.businesssupport.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.businesssuport.model.service.BusiniesssuportApprivalAdminServiceImpl;
import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;
import com.cube.util.Encoder;


public class ApprovalUpdateAction implements Action{

	private static ApprovalUpdateAction approvalUpdateAction;
	
	static {
		approvalUpdateAction = new ApprovalUpdateAction();
	}
	
	private ApprovalUpdateAction(){}
	
	
	public static ApprovalUpdateAction getApprovalUpdateAction() {
		return approvalUpdateAction;
	}


	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String confirm0 = request.getParameter("con1");
		if(confirm0!=null){
			String confirmname = Encoder.isoToUtf(request.getParameter("confirmname"));
			String confirm1 = request.getParameter("con2");
			String confirm2 = request.getParameter("con3");
			String inup = request.getParameter("inup");
			System.out.println(inup);
			if("insert".equals(inup)){
				BusiniesssuportApprivalAdminServiceImpl.getBusiniesssuportApprivalAdminService().confirmlistinsert(confirmname, confirm0, confirm1, confirm2);
			} else if("update".equals(inup)){
				BusiniesssuportApprivalAdminServiceImpl.getBusiniesssuportApprivalAdminService().confirmlistupdate(confirmname, confirm0, confirm1, confirm2);
			} else if("delete".equals(inup)){
				String confirmcode = request.getParameter("confirmcode");
				BusiniesssuportApprivalAdminServiceImpl.getBusiniesssuportApprivalAdminService().confirmlistdelete(confirmcode);
			}
		}
		List<Confirmlist_infoDto> list = new ArrayList<Confirmlist_infoDto>();
		list = SignDocUserServiceImpl.getSignDocUserService().confirmlist();
		String result="";
		result="<select class=\"form-control22\" id=\"confirmlist\" name=\"confirmlist\" style=\"width:90%; height:32px\" onchange=\"javascript:confirmline(this.value)\">";
		result+="<option value=\"choice\">-- 결재선 선택 --</option>";
		int idx1=0;
    	for(Confirmlist_infoDto confirmlist_infoDto : list) {
			result+="<option id='choice"+ (idx1++) +"' value='"+confirmlist_infoDto.getConfirm_code()+"'>"+confirmlist_infoDto.getConfirm_name()+"</option>";
    	}	
    	idx1=0;
		result+="</select>";
		return result;
	}

}
