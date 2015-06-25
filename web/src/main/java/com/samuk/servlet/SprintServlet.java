package com.samuk.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuk.orm.Sprint;
import com.samuk.services.MemberOperations;
import com.samuk.services.SprintOperations;
import com.samuk.services.TeamOperations;

@WebServlet("/sprint")
public class SprintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SprintOperations sprintOps = new SprintOperations();
	private TeamOperations teamOps = new TeamOperations();
	
	public SprintServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null){
		
		RequestDispatcher r = request.getRequestDispatcher("pages/sprints.jsp");

		request.setAttribute("sprints", sprintOps.listAll());
		request.setAttribute("teams", teamOps.listAll());
		
		r.forward(request, response);
		}

		else{
			RequestDispatcher r = request.getRequestDispatcher("pages/sprint.jsp");
			
			Sprint s = sprintOps.find(Long.parseLong(request.getParameter("id")));
			
			MemberOperations memOps = new MemberOperations();
			request.setAttribute("members", memOps.listAll());
			request.setAttribute("Sprint", sprintOps.find(Long.parseLong(request.getParameter("id"))));
			
			System.out.println(s.getEid());
			
			r.forward(request, response);
		}
	
	
	
	
	
	
	}

	/**
	 * Add new sprint
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher r = request.getRequestDispatcher("pages/sprints.jsp");

		Sprint sprint = new Sprint();
		sprint.setWeek(Integer.parseInt(request.getParameter("week")));

		sprintOps.create(sprint);

		request.setAttribute("sprints", sprintOps.listAll());
		request.setAttribute("teams", teamOps.listAll());
		
		r.forward(request, response);

	}

}
