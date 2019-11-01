package com.cos.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public static void back(HttpServletResponse response) {
		
		try {
			PrintWriter out	= response.getWriter();

			out.println("<script>");
			out.println("alert('Login Fail');");
			out.println("history.back()");
			out.println("</script>");
			out.flush(); //버퍼를 비워줌
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
