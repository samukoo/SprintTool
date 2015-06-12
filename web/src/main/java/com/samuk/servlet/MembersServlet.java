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
import com.samuk.utils.PropertyLoader;

/**
 * Servlet implementation class Members
 */
@WebServlet("/members")
public class MembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberOperations memOps = new MemberOperations();
    private TeamOperations teamOps = new TeamOperations();   
    private PropertyLoader pl = new PropertyLoader();
    private final String FILE = "teamtool_fi.properties";
	
    public MembersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r = request.getRequestDispatcher("/pages/members.jsp");
		
		request.setAttribute("prop", pl.getProperties(FILE));
		request.setAttribute("members", memOps.listAll());
		request.setAttribute("teams", teamOps.listAll());
		request.setAttribute("roles", Role.values());
		
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r = request.getRequestDispatcher("/pages/members.jsp");
		Member m = new Member();
		
		
		Long id = Long.valueOf(request.getParameter("team"));
		
		Team team = teamOps.find(id);
		
		m.setName(request.getParameter("firstname") + " " + request.getParameter("lastname"));
		m.setRole(Role.valueOf(request.getParameter("role")));
		m.setTeam(team);
		
		memOps.create(m);
		
		request.setAttribute("prop", pl.getProperties(FILE));
		request.setAttribute("members", memOps.listAll());
		request.setAttribute("teams", teamOps.listAll());
		request.setAttribute("roles", Role.values());
		
		r.forward(request, response);
	}

}
