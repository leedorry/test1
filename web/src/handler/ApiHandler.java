package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import dao.StoreRequest;

public class ApiHandler implements CommandHandler {
	private static final String FORM_VIEW = "WEB-INF/view/board/blank.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return processForm(req, res);
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		StoreRequest storeReq = new StoreRequest();
		storeReq.setStoreName(req.getParameter("storename"));
		storeReq.setStorePic(req.getParameter("storepic"));
		storeReq.setAddress(req.getParameter("address"));
		storeReq.setHours(req.getParameter("hours"));
		storeReq.setClosedays(req.getParameter("closedays"));
		storeReq.setCallNumber(Integer.parseInt(req.getParameter("callnumber")));
		
		
		return FORM_VIEW;
	}



}
