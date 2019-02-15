package com.cube.factory;

import com.cube.action.Action;
import com.cube.admin.businesssupport.action.ApprovalInsertAction;
import com.cube.admin.businesssupport.action.ApprovalUpdateAction;
import com.cube.admin.businesssupport.action.ConfirmDocListManageAction;
import com.cube.admin.businesssupport.action.ConfirmDocSelectAction;
import com.cube.admin.businesssupport.action.DiligenceAllDeleteAction;
import com.cube.admin.businesssupport.action.DiligenceDeleteAction;
import com.cube.admin.businesssupport.action.DiligenceGroupInsertAction;
import com.cube.admin.businesssupport.action.DiligenceGroupInsertSmallAction;
import com.cube.admin.businesssupport.action.DiligenceHappyDaySearchAction;
import com.cube.admin.businesssupport.action.DiligenceHappyDaySetAction;
import com.cube.admin.businesssupport.action.DiligenceSearchAction;
import com.cube.admin.businesssupport.action.DiligenceTimeSetAction;
import com.cube.admin.companyinfo.action.DepartmentDeleteAction;
import com.cube.admin.companyinfo.action.DepartmentListAction;
import com.cube.admin.companyinfo.action.DepartmentWriteAction;
import com.cube.admin.companyinfo.action.EmployeeDeleteAction;
import com.cube.admin.companyinfo.action.EmployeeFireDeleteAction;
import com.cube.admin.companyinfo.action.EmployeeFireListAction;
import com.cube.admin.companyinfo.action.EmployeeFireUpdateAction;
import com.cube.admin.companyinfo.action.EmployeeListAction;
import com.cube.admin.companyinfo.action.EmployeeMoveFireUpdateAction;
import com.cube.admin.companyinfo.action.EmployeeMoveUpdateAction;
import com.cube.admin.companyinfo.action.EmployeeMoveWriteAction;
import com.cube.admin.companyinfo.action.EmployeeUpdateAction;
import com.cube.admin.companyinfo.action.EmployeeViewAction;
import com.cube.admin.companyinfo.action.EmployeeWriteAction;
import com.cube.admin.companyinfo.action.GradeDeleteAction;
import com.cube.admin.companyinfo.action.GradeListAction;
import com.cube.admin.companyinfo.action.GradeWriteAction;
import com.cube.admin.companyinfo.action.IdcheckAction;
import com.cube.admin.companyinfo.action.MoveIdcheckAction;
import com.cube.admin.companyinfo.action.MoveZipcheckAction;
import com.cube.admin.companyinfo.action.ZipcheckAction;
import com.cube.admin.home.action.HelpDeskReplyDeleteAction;
import com.cube.admin.home.action.HelpDeskReplyListAction;
import com.cube.admin.home.action.HelpDeskReplyModifyAction;
import com.cube.admin.home.action.HelpDeskReplyWriteAction;
import com.cube.admin.home.action.HomeChartAction;
import com.cube.admin.home.action.HomeNoticeListAction;
import com.cube.admin.home.action.HomeNoticeViewAction;
import com.cube.admin.home.action.HomeNoticeWriteAction;
import com.cube.login.action.LoginAdminAction;
import com.cube.login.action.LogoutAdminAction;
import com.cube.user.approval.docwrite.biztripdoc.action.BiztripDocWriteAction;
import com.cube.user.approval.docwrite.biztripdoc.action.BiztripDocWritePaperViewAction;
import com.cube.user.approval.docwrite.biztripreportdoc.action.BiztripreportDocWriteAction;
import com.cube.user.approval.docwrite.deaddoc.action.DeadDocWriteAction;
import com.cube.user.approval.docwrite.deaddoc.action.DeadDocWritePaperViewAction;
import com.cube.user.approval.docwrite.orderdoc.action.OrderDocWriteAction;
import com.cube.user.approval.docwrite.signdoc.action.SignDocWriteAction;
import com.cube.user.approval.docwrite.signdoc.action.SignDocWriteConfirmlistAction;
import com.cube.user.approval.docwrite.signdoc.action.SignDocWritePaperViewAction;
import com.cube.user.approval.docwrite.vacdoc.action.VacDocWriteAction;
import com.cube.user.approval.docwrite.vacdoc.action.VacDocWritePaperViewAction;
import com.cube.user.approval.main.action.ApprovalBusinessAction;
import com.cube.user.approval.main.action.ApprovalDepartmentAction;
import com.cube.user.approval.main.action.ApprovalMainAction;
import com.cube.user.approval.receivedoc.nodoc.action.NoDocCancelAction;
import com.cube.user.approval.receivedoc.nodoc.action.NoDocListAction;
import com.cube.user.approval.receivedoc.nodoc.action.NoDocSelectAction;
import com.cube.user.approval.receivedoc.okdoc.action.OkDocListAction;
import com.cube.user.approval.senddoc.reportdoc.action.ReportDocListAction;
import com.cube.user.approval.senddoc.reportdoc.action.ReportDocSelectAction;
import com.cube.user.approval.senddoc.returndoc.action.ReturnDocListAction;
import com.cube.user.approval.senddoc.savedoc.action.SaveDocDeleteAction;
import com.cube.user.approval.senddoc.savedoc.action.SaveDocListAction;
import com.cube.user.approval.senddoc.savedoc.action.SaveDocUpdateAction;
import com.cube.user.approval.senddoc.withdrawdoc.action.WithDrawDocListAction;
import com.cube.user.businessreport.action.MyWorkreportCheckListAction;
import com.cube.user.businessreport.action.MyWorkreportWriteAction;
import com.cube.user.businessreport.action.MyWorkreportWritePaperAction;
import com.cube.user.businessreport.action.WorkreportReplyDeleteAction;
import com.cube.user.businessreport.action.WorkreportReplyListAction;
import com.cube.user.businessreport.action.WorkreportReplyModifyAction;
import com.cube.user.businessreport.action.WorkreportReplyWriteAction;
import com.cube.user.diligence.action.UserDiligenceOutTimeAction;
import com.cube.user.diligence.action.UserDiligenceTimeAction;
import com.cube.user.diligence.action.UserDiligenceXmlAction;
import com.cube.user.mypage.action.PageMoveAction;
import com.cube.user.mypage.action.PageUpdateAction;
import com.cube.user.schedule.all.action.AllDeleteAction;
import com.cube.user.schedule.all.action.AllListAction;
import com.cube.user.schedule.all.action.AllModifyAction;
import com.cube.user.schedule.all.action.AllViewAction;
import com.cube.user.schedule.all.action.AllWriteAction;
import com.cube.user.schedule.all.action.AllXmlAction;
import com.cube.user.schedule.allsearch.action.AllSearchAction;
import com.cube.user.schedule.allsearch.action.AllSearchDeleteAction;
import com.cube.user.schedule.allsearch.action.AllSearchListAction;
import com.cube.user.schedule.allsearch.action.AllSearchUpdateAction;
import com.cube.user.schedule.allsearch.action.AllSearchViewAction;
import com.cube.user.schedule.company.action.CompanyDeleteAction;
import com.cube.user.schedule.company.action.CompanyListAction;
import com.cube.user.schedule.company.action.CompanyModifyAction;
import com.cube.user.schedule.company.action.CompanyViewAction;
import com.cube.user.schedule.company.action.CompanyWriteAction;
import com.cube.user.schedule.company.action.CompanyXmlAction;
import com.cube.user.schedule.department.action.DepartmentXmlAction;
import com.cube.user.schedule.department.action.ScheduleDepartmentDeleteAction;
import com.cube.user.schedule.department.action.ScheduleDepartmentListAction;
import com.cube.user.schedule.department.action.ScheduleDepartmentModifyAction;
import com.cube.user.schedule.department.action.ScheduleDepartmentViewAction;
import com.cube.user.schedule.department.action.ScheduleDepartmentWriteAction;
import com.cube.user.schedule.scheduleprivate.action.PrivateDeleteAction;
import com.cube.user.schedule.scheduleprivate.action.PrivateListAction;
import com.cube.user.schedule.scheduleprivate.action.PrivateModifyAction;
import com.cube.user.schedule.scheduleprivate.action.PrivateViewAction;
import com.cube.user.schedule.scheduleprivate.action.PrivateWriteAction;
import com.cube.user.schedule.scheduleprivate.action.PrivateXmlAction;
import com.cube.user.schedule.vacation.action.VacationListAction;
import com.cube.user.schedule.vacation.action.VacationXmlAction;

/**
 * @author Sin
 *
 */
/**
 * @author Sin
 *
 */
public class CubeActionFactory {
   //approval Action
   private static Action approvalMainAction;
   private static Action approvalBusinessAction;
   private static Action approvalDepartmentAction;
   
   //approval_docwrite Action>singdoc
   private static Action signDocWritePaperViewAction;
   private static Action signDocWriteAction;
   private static Action signDocWriteConfirmlistAction;
   
   //approval_docwrite Action>orderdoc
   private static Action orderDocWriteAction;
   
   //approval_docwrite Action>vacdoc
   private static Action vacDocWritePaperViewAction;
   private static Action vacDocWriteAction;
   
   //approval_docwrite Action>Biztripdoc
   private static Action biztripDocWritePaperViewAction;
   private static Action biztripDocWriteAction;
   
   //approval_docwrite Action>Biztripreport
   private static Action biztripreportDocWriteAction;
   
   //approval_docwrite Action>deaddoc
   private static Action deadDocWritePaperViewAction;
   private static Action deadDocWriteAction;
   
   //approval_senddoc
   private static Action saveDocListAction;
   private static Action reportDocListAction;
   private static Action reportDocSelectAction;
   private static Action withDrawDocListAction;
   private static Action returnDocListAction;
   private static Action saveDocDeleteAction;
   private static Action saveDocUpdateAction;
   
   //approval_nookreport
   private static Action noDocListAction;
   private static Action noDocSelectAction;
   private static Action okDocListAction;
   private static Action noDocCancelAction;
   
   //loginAdminAction
   private static Action loginAdminAction;
   //logoutAction
   private static Action logoutAdminAction;
   
   
   //user > diligence Action
   private static Action userDiligenceTimeAction;
   private static Action userDiligenceOutTimeAction;
   private static Action userDiligenceXmlAction;
   
   //admin > diligence Action
   private static Action diligenceSearchAction;
   private static Action diligenceTimeSetAction;
   private static Action diligenceGroupAction;
   private static Action diligenceGroupInsertAction;
   private static Action diligenceDeleteAction;
   private static Action diligenceGroupSelectAction;
   private static Action diligenceGroupInsertSmallAction;
   private static Action diligenceAllDeleteAction;
   private static Action diligenceHappyDaySetAction;
   private static Action diligenceHappyDaySearchAction;
   

   //admin -> companyinfo aciton
   private static Action employeeWriteAction;
   private static Action employeeMoveWriteAction;
   private static Action employeeViewAction;
   private static Action employeeUpdateAction;
   private static Action employeeMoveUpdateAction;
   private static Action employeeDeleteAction;
   private static Action employeeListAction;
   private static Action employeeFireListAction;
   private static Action employeeFireUpdateAction;
   private static Action employeeMoveFireUpdateAction;
   private static Action employeeFireDeleteAction;
   private static Action gradeWriteAction;
   private static Action gradeListAction;
   private static Action gradeDeleteAction;
   private static Action departmentWriteAction;
   private static Action departmentListAction;
   private static Action departmentDeleteAction;
   private static Action idcheckAction;
   private static Action moveIdcheckAction;
   private static Action zipcheckAction;
   private static Action moveZipcheckAction;
   
   
   //user -> schedule action
   private static Action allWriteAction;
   private static Action allViewAction;
   private static Action allModifyAction;
   private static Action allListAction;
   private static Action allDeleteAction;
   private static Action allXmlAction;
   
   private static Action allSearchAction;
   private static Action allSearchListAction;
   private static Action allSearchViewAction;
   private static Action allSearchDeleteAction;
   private static Action allSearchUpdateAction;

   private static Action privateWriteAction;
   private static Action privateViewAction;
   private static Action privateModifyAction;
   private static Action privateListAction;
   private static Action privateDeleteAction;
   private static Action privateXmlAction;
   
   private static Action scheduleDepartmentWriteAction;
   private static Action scheduleDepartmentViewAction;
   private static Action scheduleDepartmentModifyAction;
   private static Action scheduleDepartmentListAction;
   private static Action scheduleDepartmentDeleteAction;
   private static Action departmentXmlAction;
   
   private static Action companyWriteAction;
   private static Action companyViewAction;
   private static Action companyModifyAction;
   private static Action companyListAction;
   private static Action companyDeleteAction;
   private static Action companyXmlAction;
   
   private static Action vacationListAction;
   private static Action vacationXmlAction;
   
   
   
   private static Action approvalInsertAction;
   private static Action approvalUpdateAction;
   
   private static Action myWorkreportWritePaperAction;
   private static Action myWorkreportWriteAction;
   private static Action myWorkreportCheckListAction;
   private static Action workreportReplyWriteAction;
   private static Action workreportReplyListAction;
   private static Action workreportReplyDeleteAction;
   private static Action workreportReplyModifyAction;
   
   private static Action confirmDocListManageAction;
   private static Action confirmDocSelectAction;
   
   private static Action homeChartAction;
   private static Action homeNoticeWriteAction;
   private static Action homeNoticeListAction;
   private static Action homeNoticeViewAction;
   private static Action helpDeskReplyListAction;
   private static Action helpDeskReplyDeleteAction;
   private static Action helpDeskReplyModifyAction;
   private static Action helpDeskReplyWriteAction;
   
   private static Action pageMoveAction;
   private static Action pageUpdateAction;
   
   static {
      approvalMainAction = ApprovalMainAction.getApprovalMainAction();
      approvalBusinessAction = ApprovalBusinessAction.getApprovalBusinessAction();
      approvalDepartmentAction = ApprovalDepartmentAction.getApprovalDepartmentAction();
      signDocWritePaperViewAction = SignDocWritePaperViewAction.getSignDocWritePaperViewAction();
      signDocWriteAction = SignDocWriteAction.getSignDocWriteAction();
      signDocWriteConfirmlistAction = SignDocWriteConfirmlistAction.getSignDocWriteConfirmlist();
      loginAdminAction = LoginAdminAction.getLoginAdminAction();
      saveDocListAction = SaveDocListAction.getSaveDocListAction();
      reportDocListAction = ReportDocListAction.getReportDocListAction();
      orderDocWriteAction = OrderDocWriteAction.getOrderDocWriteAction();
      vacDocWriteAction = VacDocWriteAction.getVacDocWriteAction();
      vacDocWritePaperViewAction = VacDocWritePaperViewAction.getVacDocWritePaperViewAction();
      biztripDocWritePaperViewAction = BiztripDocWritePaperViewAction.getBiztripDocWritePaperViewAction();
      biztripDocWriteAction = BiztripDocWriteAction.getBiztripDocWriteAction();
      deadDocWritePaperViewAction = DeadDocWritePaperViewAction.getDeadDocWritePaperViewAction();
      deadDocWriteAction = DeadDocWriteAction.getDeadDocWriteAction();
      reportDocSelectAction = ReportDocSelectAction.getReportDocSelectAction();
      biztripreportDocWriteAction = BiztripreportDocWriteAction.getBiztripreportDocWriteAction();
      noDocListAction = NoDocListAction.getNoDocListAction();
      noDocSelectAction = NoDocSelectAction.getNoDocSelectAction();
      withDrawDocListAction = WithDrawDocListAction.getWithDrawDocListAction();
      okDocListAction = OkDocListAction.getOkDocListAction();
      noDocCancelAction = NoDocCancelAction.getNoDocCancelAction();
      returnDocListAction = ReturnDocListAction.getReturnDocListAction();
      saveDocDeleteAction = SaveDocDeleteAction.getSaveDocDeleteAction();
      saveDocUpdateAction = SaveDocUpdateAction.getSaveDocUpdateAction();
   
      userDiligenceTimeAction = UserDiligenceTimeAction.getUserDiligenceTimeAction();
      userDiligenceOutTimeAction = UserDiligenceOutTimeAction.getUserDiligenceOutTimeAction();
      userDiligenceXmlAction=UserDiligenceXmlAction.getUserDiligenceXmlAction();
      
      diligenceSearchAction = DiligenceSearchAction.getDiligenceSearchAction();
      diligenceTimeSetAction = DiligenceTimeSetAction.getDiligenceTimeSetAction();
      diligenceGroupInsertAction = DiligenceGroupInsertAction.getDiligenceGroupInsertAction();
      diligenceDeleteAction = DiligenceDeleteAction.getDiligenceDeleteAction();
      diligenceAllDeleteAction = DiligenceAllDeleteAction.getDiligenceAllDeleteAction();
      diligenceHappyDaySetAction = DiligenceHappyDaySetAction.getDiligenceHappyDaySetAction();
      diligenceHappyDaySearchAction=DiligenceHappyDaySearchAction.getDiligenceHappyDaySearchAction();
      
            
            
      logoutAdminAction = LogoutAdminAction.getLogoutAdminAction();
      
      
      
      employeeWriteAction = EmployeeWriteAction.getEmployeeWriteAction();
      employeeMoveWriteAction = EmployeeMoveWriteAction.getEmployeeMoveWriteAction();
      employeeViewAction = EmployeeViewAction.getEmployeeViewAction();
      employeeUpdateAction = EmployeeUpdateAction.getEmployeeUpdateAction();
      employeeMoveUpdateAction = EmployeeMoveUpdateAction.getEmployeeMoveUpdateAction();
      employeeDeleteAction = EmployeeDeleteAction.getEmployeeDeleteAction();
      employeeListAction = EmployeeListAction.getEmployeeListAction();
      employeeFireListAction = EmployeeFireListAction.getEmployeeFireListAction();
      employeeFireUpdateAction = EmployeeFireUpdateAction.getEmployeeFireUpdateAction();
      employeeMoveFireUpdateAction = EmployeeMoveFireUpdateAction.getEmployeeMoveFireUpdateAction();
      employeeFireDeleteAction = EmployeeFireDeleteAction.getEmployeeFireDeleteAction();
      gradeWriteAction = GradeWriteAction.getGradeWriteAction();
      gradeDeleteAction = GradeDeleteAction.getGradesDeleteAction();
      gradeListAction = GradeListAction.getGradesListAction();
      departmentWriteAction = DepartmentWriteAction.getDepartmentWriteAction();
      departmentDeleteAction = DepartmentDeleteAction.getGradesDeleleAction();
      departmentListAction = DepartmentListAction.getDepartmentListAction();
      idcheckAction=IdcheckAction.getIdcheckAction();
      moveIdcheckAction=MoveIdcheckAction.getMoveIdcheckAction();
      zipcheckAction=ZipcheckAction.getZipcheckAction();
      moveZipcheckAction=MoveZipcheckAction.getMoveZipcheckAction();
      
      
      allWriteAction=AllWriteAction.getAllWriteAction();
      allViewAction=AllViewAction.getAllViewAction();
      allModifyAction=AllModifyAction.getAllModifyAction();
      allListAction=AllListAction.getAllListAction();
      allDeleteAction=AllDeleteAction.getAllDeleteAction();
      allXmlAction=AllXmlAction.getAllXmlAction();
      
      allSearchAction=AllSearchAction.getAllSearchAction();
      allSearchListAction=AllSearchListAction.getAllSearchListAction();
      allSearchViewAction=AllSearchViewAction.getAllSearchViewAction();
      allSearchDeleteAction=AllSearchDeleteAction.getAllSearchDeleteAction();
      allSearchUpdateAction=AllSearchUpdateAction.getAllSearchUpdateAction();
      
      privateWriteAction=PrivateWriteAction.getPrivateWriteAction();
      privateViewAction=PrivateViewAction.getPrivateViewAction();
      privateModifyAction=PrivateModifyAction.getPrivateModifyAction();
      privateDeleteAction=PrivateDeleteAction.getPrivateDeleteAction();
      privateListAction=PrivateListAction.getPrivateListAction();
      privateXmlAction=PrivateXmlAction.getPrivateXmlAction();
      
      scheduleDepartmentWriteAction=ScheduleDepartmentWriteAction.getScheduleDepartmentWriteAction();
      scheduleDepartmentViewAction=ScheduleDepartmentViewAction.getScheduleDepartmentViewAction();
      scheduleDepartmentModifyAction=ScheduleDepartmentModifyAction.getScheduleDepartmentModifyAction();
      scheduleDepartmentDeleteAction=ScheduleDepartmentDeleteAction.getScheduleDepartmentDeleteAction();
      scheduleDepartmentListAction=ScheduleDepartmentListAction.getScheduleDepartmentListAction();
      departmentXmlAction=DepartmentXmlAction.getDepartmentXmlAction();
      
      companyWriteAction=CompanyWriteAction.getCompanyWriteAction();
      companyViewAction=CompanyViewAction.getCompanyViewAction();
      companyModifyAction=CompanyModifyAction.getCompanyModifyAction();
      companyDeleteAction=CompanyDeleteAction.getCompanyDeleteAction();
      companyListAction=CompanyListAction.getCompanyListAction();
      companyXmlAction=CompanyXmlAction.getCompanyXmlAction();
      
      vacationListAction=VacationListAction.getVacationListAction();
      vacationXmlAction=VacationXmlAction.getVacationXmlAction();
      
      approvalInsertAction=ApprovalInsertAction.getApprovalInsertAction();
      approvalUpdateAction=ApprovalUpdateAction.getApprovalUpdateAction();
      
      diligenceGroupInsertSmallAction=DiligenceGroupInsertSmallAction.getDiligenceGroupInsertSmallAction();
      
      myWorkreportWritePaperAction = MyWorkreportWritePaperAction.getMyWorkreportWritePaperAction();
      myWorkreportWriteAction = MyWorkreportWriteAction.getMyWorkreportWriteAction();
      myWorkreportCheckListAction = MyWorkreportCheckListAction.getMyWorkreportCheckListAction();
      workreportReplyWriteAction = WorkreportReplyWriteAction.getWorkreportReplyWriteAction();
      workreportReplyListAction = WorkreportReplyListAction.getWorkreportReplyListAction();      
      workreportReplyDeleteAction = WorkreportReplyDeleteAction.getWorkreportReplyDeleteAction();
      workreportReplyModifyAction = WorkreportReplyModifyAction.getWorkreportReplyModifyAction();
      confirmDocListManageAction = ConfirmDocListManageAction.getConfirmDocListManageAction();
      confirmDocSelectAction = ConfirmDocSelectAction.getConfirmDocSelectAction();
      
      homeChartAction = HomeChartAction.getHomeChartAction();
      homeNoticeWriteAction = HomeNoticeWriteAction.getHomeNoticeWriteAction();
      homeNoticeListAction = HomeNoticeListAction.getHomeNoticeListAction();
      homeNoticeViewAction = HomeNoticeViewAction.getHomeNoticeViewAction();
      helpDeskReplyListAction = HelpDeskReplyListAction.getHelpDeskReplyListAction();
      helpDeskReplyDeleteAction = HelpDeskReplyDeleteAction.getHelpDeskReplyDeleteAction();
      helpDeskReplyModifyAction = HelpDeskReplyModifyAction.getHelpDeskReplyModifyAction();
      helpDeskReplyWriteAction = HelpDeskReplyWriteAction.getHelpDeskReplyWriteAction();
      
      pageMoveAction = PageMoveAction.getPageMoveAction();
      pageUpdateAction = PageUpdateAction.getPageUpdateAction();
   }

   


   public static Action getPageUpdateAction() {
	return pageUpdateAction;
}

public static Action getPageMoveAction() {
	return pageMoveAction;
}

public static Action getHelpDeskReplyDeleteAction() {
	return helpDeskReplyDeleteAction;
}

public static Action getHelpDeskReplyModifyAction() {
	return helpDeskReplyModifyAction;
}

public static Action getHelpDeskReplyWriteAction() {
	return helpDeskReplyWriteAction;
}

public static Action getHelpDeskReplyListAction() {
	return helpDeskReplyListAction;
}

public static Action getHomeNoticeViewAction() {
   return homeNoticeViewAction;
}

public static Action getHomeNoticeListAction() {
   return homeNoticeListAction;
}

public static Action getHomeNoticeWriteAction() {
   return homeNoticeWriteAction;
}

public static Action getHomeChartAction() {
   return homeChartAction;
}

public static Action getApprovalUpdateAction() {
      return approvalUpdateAction;
   }

   public static Action getApprovalInsertAction() {
      return approvalInsertAction;
   }

   public static Action getUserDiligenceOutTimeAction() {
      return userDiligenceOutTimeAction;
   }

   public static Action getDiligenceGroupSelectAction() {
      return diligenceGroupSelectAction;
   }

   public static Action getDiligenceGroupInsertSmallAction() {
      return diligenceGroupInsertSmallAction;
   }

   public static Action getSaveDocUpdateAction() {
      return saveDocUpdateAction;
   }

   public static Action getSaveDocDeleteAction() {
      return saveDocDeleteAction;
   }

   public static Action getReturnDocListAction() {
      return returnDocListAction;
   }
   
   public static Action getNoDocCancelAction() {
      return noDocCancelAction;
   }


   public static Action getOkDocListAction() {
      return okDocListAction;
   }


   public static Action getWithDrawDocListAction() {
      return withDrawDocListAction;
   }


   public static Action getEmployeeWriteAction() {
      return employeeWriteAction;
   }



   public static Action getEmployeeMoveWriteAction() {
      return employeeMoveWriteAction;
   }



   public static Action getEmployeeViewAction() {
      return employeeViewAction;
   }



   public static Action getEmployeeUpdateAction() {
      return employeeUpdateAction;
   }



   public static Action getEmployeeMoveUpdateAction() {
      return employeeMoveUpdateAction;
   }



   public static Action getEmployeeDeleteAction() {
      return employeeDeleteAction;
   }



   public static Action getEmployeeListAction() {
      return employeeListAction;
   }



   public static Action getEmployeeFireListAction() {
      return employeeFireListAction;
   }



   public static Action getEmployeeFireUpdateAction() {
      return employeeFireUpdateAction;
   }



   public static Action getEmployeeMoveFireUpdateAction() {
      return employeeMoveFireUpdateAction;
   }



   public static Action getEmployeeFireDeleteAction() {
      return employeeFireDeleteAction;
   }



   public static Action getGradeWriteAction() {
      return gradeWriteAction;
   }



   public static Action getGradeListAction() {
      return gradeListAction;
   }



   public static Action getGradeDeleteAction() {
      return gradeDeleteAction;
   }



   public static Action getDepartmentWriteAction() {
      return departmentWriteAction;
   }



   public static Action getDepartmentListAction() {
      return departmentListAction;
   }



   public static Action getDepartmentDeleteAction() {
      return departmentDeleteAction;
   }



   public static Action getIdcheckAction() {
      return idcheckAction;
   }



   public static Action getMoveIdcheckAction() {
      return moveIdcheckAction;
   }



   public static Action getZipcheckAction() {
      return zipcheckAction;
   }



   public static Action getMoveZipcheckAction() {
      return moveZipcheckAction;
   }



   private CubeActionFactory() {}



   public static Action getLogoutAdminAction() {
      return logoutAdminAction;
   }



   public static Action getDiligenceDeleteAction() {
      return diligenceDeleteAction;
   }


   
   public static Action getDiligenceGroupInsertAction() {
      return diligenceGroupInsertAction;
   }
   
   public static Action getDiligenceGroupAction() {
      return diligenceGroupAction;
   }

   

   public static Action getDiligenceTimeSetAction() {
      return diligenceTimeSetAction;
   }


   public static Action getUserDiligenceTimeAction() {
      return userDiligenceTimeAction;
   }


   public static Action getDiligenceSearchAction() {
      return diligenceSearchAction;
   }


   public static Action getDiligenceTimeAction() {
      return userDiligenceTimeAction;
   }

   public static Action getLoginAdminAction() {
      return loginAdminAction;
   }

   public static Action getApprovalMainAction() {
      return approvalMainAction;
   }

   public static Action getApprovalBusinessAction() {
      return approvalBusinessAction;
   }

   public static Action getApprovalDepartmentAction() {
      return approvalDepartmentAction;
   }

   public static Action getSignDocWriteAction() {
      return signDocWriteAction;
   }

   public static Action getSignDocWritePaperViewAction() {
      return signDocWritePaperViewAction;
   }

   public static Action getSignDocWriteConfirmlistAction() {
      return signDocWriteConfirmlistAction;
   }



   public static Action getOrderDocWriteAction() {
      return orderDocWriteAction;
   }



   public static Action getVacDocWritePaperViewAction() {
      return vacDocWritePaperViewAction;
   }



   public static Action getVacDocWriteAction() {
      return vacDocWriteAction;
   }



   public static Action getBiztripDocWritePaperViewAction() {
      return biztripDocWritePaperViewAction;
   }



   public static Action getBiztripDocWriteAction() {
      return biztripDocWriteAction;
   }



   public static Action getBiztripreportDocWriteAction() {
      return biztripreportDocWriteAction;
   }



   public static Action getDeadDocWritePaperViewAction() {
      return deadDocWritePaperViewAction;
   }



   public static Action getDeadDocWriteAction() {
      return deadDocWriteAction;
   }



   public static Action getSaveDocListAction() {
      return saveDocListAction;
   }



   public static Action getReportDocListAction() {
      return reportDocListAction;
   }



   public static Action getReportDocSelectAction() {
      return reportDocSelectAction;
   }



   public static Action getNoDocListAction() {
      return noDocListAction;
   }



   public static Action getNoDocSelectAction() {
      return noDocSelectAction;
   }


   public static Action getAllWriteAction() {
      return allWriteAction;
   }


   public static Action getAllViewAction() {
      return allViewAction;
   }


   public static Action getAllModifyAction() {
      return allModifyAction;
   }


   public static Action getAllListAction() {
      return allListAction;
   }


   public static Action getAllDeleteAction() {
      return allDeleteAction;
   }

   public static Action getAllSearchAction() {
      return allSearchAction;
   }

   public static Action getAllSearchListAction() {
      return allSearchListAction;
   }

   public static Action getAllSearchViewAction() {
      return allSearchViewAction;
   }

   public static Action getAllXmlAction() {
      return allXmlAction;
   }

   public static Action getPrivateWriteAction() {
      return privateWriteAction;
   }

   public static Action getPrivateViewAction() {
      return privateViewAction;
   }

   public static Action getPrivateModifyAction() {
      return privateModifyAction;
   }

   public static Action getPrivateListAction() {
      return privateListAction;
   }

   public static Action getPrivateDeleteAction() {
      return privateDeleteAction;
   }

   public static Action getPrivateXmlAction() {
      return privateXmlAction;
   }

   public static Action getScheduleDepartmentWriteAction() {
      return scheduleDepartmentWriteAction;
   }

   public static Action getScheduleDepartmentViewAction() {
      return scheduleDepartmentViewAction;
   }

   public static Action getScheduleDepartmentModifyAction() {
      return scheduleDepartmentModifyAction;
   }

   public static Action getScheduleDepartmentListAction() {
      return scheduleDepartmentListAction;
   }

   public static Action getScheduleDepartmentDeleteAction() {
      return scheduleDepartmentDeleteAction;
   }

   public static Action getDepartmentXmlAction() {
      return departmentXmlAction;
   }

   public static Action getCompanyWriteAction() {
      return companyWriteAction;
   }

   public static Action getCompanyViewAction() {
      return companyViewAction;
   }

   public static Action getCompanyModifyAction() {
      return companyModifyAction;
   }

   public static Action getCompanyListAction() {
      return companyListAction;
   }

   public static Action getCompanyDeleteAction() {
      return companyDeleteAction;
   }

   public static Action getCompanyXmlAction() {
      return companyXmlAction;
   }

   public static Action getAllSearchDeleteAction() {
      return allSearchDeleteAction;
   }

   public static Action getAllSearchUpdateAction() {
      return allSearchUpdateAction;
   }

   public static Action getVacationListAction() {
      return vacationListAction;
   }

public static Action getDiligenceAllDeleteAction() {
   return diligenceAllDeleteAction;
}

public static Action getDiligenceHappyDaySetAction() {
   return diligenceHappyDaySetAction;
}

public static Action getDiligenceHappyDaySearchAction() {
   return diligenceHappyDaySearchAction;
}

public static Action getMyWorkreportWritePaperAction() {
   return myWorkreportWritePaperAction;
}

public static Action getMyWorkreportWriteAction() {
   return myWorkreportWriteAction;
}

public static Action getMyWorkreportCheckListAction() {
   return myWorkreportCheckListAction;
}

public static Action getWorkreportReplyWriteAction() {
   return workreportReplyWriteAction;
}

public static Action getWorkreportReplyListAction() {
   return workreportReplyListAction;
}

public static Action getWorkreportReplyDeleteAction() {
   return workreportReplyDeleteAction;
}

public static Action getWorkreportReplyModifyAction() {
   return workreportReplyModifyAction;
}

public static Action getConfirmDocListManageAction() {
   return confirmDocListManageAction;
}

public static Action getConfirmDocSelectAction() {
   return confirmDocSelectAction;
}

public static Action getUserDiligenceXmlAction() {
   return userDiligenceXmlAction;
}

public static Action getVacationXmlAction() {
	return vacationXmlAction;
}


      
   
}