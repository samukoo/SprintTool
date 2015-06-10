package com.samuk.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuk.orm.Member;
import com.samuk.orm.Role;
import com.samuk.orm.Team;
import com.samuk.services.MemberOperations;
import com.samuk.services.TeamOperations;

/**
 * Servlet implementation class Members
 */
@WebServlet("/members")
public class MembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberOperations memOps = new MemberOperations();
    private TeamOperations teamOps = new TeamOperations();   
	
	
    public MembersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r = request.getRequestDispatcher("/pages/members.jsp");
		
		request.setAttribute("members", memOps.listAll());
		request.setAttribute("teams", teamOps.listAll());
		request.setAttribute("roles", Role.values());
		
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r = request.getRequestDispatcher("/pages/members.jsp");
		Member m = new Member();
		
		System.out.println(request.getParameter("firstname"));
		System.out.println(request.getParameter("lastname"));
		System.out.println(request.getParameter("role"));
		System.out.println("TIIMI: " + request.getParameter("team"));
		
		Long id = Long.valueOf(request.getParameter("team"));
		System.out.println("Long:" +id);
		
		Team team = teamOps.find(id);
		
		System.out.println(team.getTeam_description());
		
		m.setName(request.getParameter("firstname") + " " + request.getParameter("lastname"));
		m.setRole(Role.valueOf(request.getParameter("role")));
		m.setTeam(team);
		
		memOps.create(m);
		
		request.setAttribute("members", memOps.listAll());
		
		
		r.forward(request, response);
	}

}
