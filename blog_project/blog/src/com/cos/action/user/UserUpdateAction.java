package com.cos.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.action.Action;
import com.cos.dao.UserDao;
import com.cos.model.User;
import com.cos.util.SHA256;
import com.cos.util.Script;

public class UserUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form태그의 name값들을 받아서 DB에 insert하고 페이지 이동
		
				// 나중에 null값 처리하기, 유효성검사(나중에)
				int id = Integer.parseInt(request.getParameter("id")); //update.jsp에서 세션의 user아이디(PK)를 가지고옴
				String username = request.getParameter("username");
				String rawPassword  = request.getParameter("password");
				String email  = request.getParameter("email");
				String address = request.getParameter("address");
				String password = SHA256.getEncrypt(rawPassword, "cos");
				
				
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);	//Encryption(암호화) 해야댐다.
				user.setEmail(email);
				user.setAddress(address);
				
				//Dao접근해서 insert
				UserDao dao = new UserDao();
				int result = dao.update(user);
				
				if(result==1) {
					
					HttpSession session = request.getSession();
					session.setAttribute("user",user);
					
					response.sendRedirect("/blog/index.jsp");
					
				}else {
					
					Script.back(response);
				}
	}
}
