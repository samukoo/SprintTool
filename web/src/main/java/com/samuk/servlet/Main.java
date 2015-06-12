package com.samuk.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuk.utils.PropertyLoader;

@WebServlet("/main")
public class Main extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PropertyLoader pl = new PropertyLoader();
	private final String FILE = "teamtool_fi.properties";
	
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r = request.getRequestDispatcher("/pages/main.jsp");
		
		request.setAttribute("prop", pl.getProperties(FILE));
		r.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
