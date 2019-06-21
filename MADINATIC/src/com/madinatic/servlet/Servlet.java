package com.madinatic.servlet;

import java.io.IOException;
import com.madinatic.classes.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import Dao.DaoFactory;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Admin admin = new Admin();
    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin.jsp").forward(request, response);
		DaoFactory daoFactory = DaoFactory.getInstance();
		try {
		PreparedStatement preparedStat = daoFactory.getConnection()
				.prepareStatement("insert into Town values(1,'Miliana',true,44)");
		preparedStat.executeUpdate();
		}catch(Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Service ser = new Service();
		ser.setId_card(Integer.parseInt(request.getParameter("AgentService")));
		System.out.println("id card" + ser.getId_card());
		ser.setName((String)request.getParameter("ServiceName"));
		System.out.println("phone" + ser.getName());
		ser.setId_town(1);
		ser.setType_service(TypeService.INTERN);
		admin.addService(ser);
		
	}

}
