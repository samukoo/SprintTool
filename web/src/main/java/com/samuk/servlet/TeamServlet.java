package com.samuk.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuk.orm.Member;
import com.samuk.orm.Team;
import com.samuk.services.MemberOperations;
import com.samuk.services.TeamOperations;

/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/team/*")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamOperations teamOps = new TeamOperations(); 
	private MemberOperations memOps = new MemberOperations();
	
    public TeamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r = request.getRequestDispatcher("/pages/team.jsp");
		
		String[] dest = request.getRequestURI().split("/"); 
		Team t = teamOps.find(Long.parseLong(dest[dest.length-1]));
		
		List<Member> memberList = memOps.listAllTeamMembers(t);
		
		
		
		request.setAttribute("team", t);
		request.setAttribute("id", dest[dest.length-1]);
		request.setAttribute("members", memberList);
		
		r.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
