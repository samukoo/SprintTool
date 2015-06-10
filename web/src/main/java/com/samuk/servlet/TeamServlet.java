package com.samuk.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuk.orm.Team;
import com.samuk.services.TeamOperations;

/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/team/*")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamOperations teamOps = new TeamOperations(); 
	
    public TeamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r = request.getRequestDispatcher("/pages/team.jsp");
		
		Team t = teamOps.find(Long.parseLong(request.getParameter("id")));
		
		request.setAttribute("team", t);
		request.setAttribute("id", request.getParameter("id"));
		
		r.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
