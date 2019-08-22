package com.madinatic.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.madinatic.classes.Supervisor;
import com.madinatic.dao.DaoFactory;
import com.madinatic.dao.SupervisorDAO;

/**
 * Servlet implementation class WilayaServlet
 */
@WebServlet("/UpdateTown")
public class UpdateTownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Supervisor supervisor;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		try {
			connection = daoFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SupervisorDAO supervisorDAO = new SupervisorDAO(connection);
	    supervisor = supervisorDAO.find(request.getParameter("id"));
		System.out.println("Supervisooor is"+supervisor);
		request.setAttribute("supervisor",supervisor);
		if(supervisor!=null)this.getServletContext().getRequestDispatcher("/WEB-INF/town.jsp").forward(request, response); 
		else// this.getServletContext().getRequestDispatcher("/Servlet").forward(request, response);
		{
			request.setAttribute("id_town", request.getParameter("id"));
			response.sendRedirect("/CreateTown");//this.getServletContext().getRequestDispatcher("/CreateTown").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(Integer.toString( supervisor.getEmployee().getId_card() ) ==request.getParameter("id_card")) {
			if((supervisor.getEmployee().getName()==request.getParameter("supervisor_name"))&&
					(supervisor.getEmployee().getFirst_name()==request.getParameter("first_name"))) {
				
			}
		}else {
			SupervisorDAO supervisorDAO = new SupervisorDAO(connection);
			supervisorDAO.update(supervisor);
		}
		System.out.println("post upadte town");
		System.out.println(supervisor.getEmployee().getName());
		//this.getServletContext().getRequestDispatcher("/Servlet").forward(request, response);
		
	}

}
