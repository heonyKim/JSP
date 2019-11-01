package com.cos.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/test")
public class AjaxTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxTest() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//��û������ ó��
		BufferedReader in = request.getReader();	//BR
		String msg = in.readLine();
		System.out.println("��û ������ : " + msg);
		
		
		Gson gson = new Gson();
		
		
		
		//���� ������ ó��
		String jsonData = "{\"name\":\"�����\", \"sal\":100}";
		
		response.setContentType("text/plain; charset=UTF-8");	//MIME Ÿ��
		PrintWriter out =response.getWriter();		//PW
		out.println(jsonData);
		out.flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}