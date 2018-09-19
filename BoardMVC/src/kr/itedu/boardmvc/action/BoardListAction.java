package kr.itedu.boardmvc.action;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.*;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardListAction implements Action {
      
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NamingException
	{
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		BoardListService service = new BoardListService();
       
		int btype = Utils.getParamInt(request.getParameter("btype"));
		ArrayList<BoardVO> result = service.getBoardList(btype);
	    
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", result);
		
		//request.setAttribute("boardList", result);
		try {
			Connection conn = DBManager.getConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return forward;
	}
	
}
