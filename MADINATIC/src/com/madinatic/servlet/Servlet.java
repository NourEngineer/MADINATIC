package com.madinatic.servlet;

import com.madinatic.dao.*;
import java.io.IOException;
import com.madinatic.classes.*;
import com.madinatic.exception.MadinaticException;
import com.madinatic.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Admin admin = new Admin();
	private Connection connection;
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
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		try {
		connection = daoFactory.getConnection();
		WilayaDAO dao = new WilayaDAO(connection);
		ArrayList<Wilaya> wilayas = dao.restore();
		request.setAttribute("wilayas", wilayas);
		
		/*PreparedStatement preparedStat = connection
				.prepareStatement("insert into Town values(1,'Miliana',44)");
		preparedStat.executeUpdate();*/
		}catch(Exception e) {
			System.out.println("wrooooong");
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*Service ser = new Service();
		ser.setId_card(Integer.parseInt(request.getParameter("AgentService")));
		System.out.println("id card" + ser.getId_card());
		ser.setName((String)request.getParameter("ServiceName"));
		System.out.println("Name " + ser.getName());
		ser.setId_town(1);
		ser.setType_service(TypeService.INTERN);
		String message ="";
		try{
			admin.addService(ser);
		}catch (ServiceException service) {
			message = service.getMessage();
			System.out.println(message);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Name " + request.getParameter("type"));
		
	}
	
	private void ajouterService(User user,Service service,Employee employee) throws SQLException, MadinaticException {
		UserDAO userDAO = new UserDAO(connection); 
		ServiceDAO serviceDAO = new ServiceDAO(connection);
		EmployeeDAO employeeDAO = new EmployeeDAO(connection);
		userDAO.create(user);
		serviceDAO.create(service);
		employeeDAO.create(employee);
	}

}
