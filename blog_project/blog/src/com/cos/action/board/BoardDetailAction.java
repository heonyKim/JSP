package com.cos.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.action.Action;
import com.cos.dao.BoardDao;
import com.cos.model.Board;
import com.cos.util.Script;
import com.cos.util.Utils;

public class BoardDetailAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null||request.getParameter("id").equals("")) return;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		BoardDao dao = new BoardDao();
		Board board = dao.findById(id);
		
		if(board!=null) {
			int result = dao.increaseReadCount(id);
			
			if(result==1) {
				
				//��Ʃ�� �ּ� �Ľ�
				Utils.setPreviewYoutube(board);
				
				
				request.setAttribute("board", board);
				RequestDispatcher dis = request.getRequestDispatcher("board/detail.jsp");
				dis.forward(request, response);
				System.out.println(board.getUserId());
			}else {
				Script.back(response);
			}
		}else {
			Script.back(response);
		}
		
	}
}
