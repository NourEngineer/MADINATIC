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
			e.printStackTrace();
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
		
		switch(request.getParameter("kind")) {
			case "Supervisor" :
				System. out.println("Sup");
			try {
				addSupervisor(request);
				System. out.println(" No Exception  occured");
			} catch (SQLException | MadinaticException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}
				break;
			case "Service" :
				System. out.println("Ser");
				try {
					addService(request);
				} catch (SQLException | MadinaticException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "Declartion" :
				System. out.println("Dec");
				break;
		}
	}
	private void addSupervisor(HttpServletRequest request) throws SQLException, MadinaticException {
		Supervisor supervisor = new Supervisor();
		Employee employee = new Employee();
		
		SupervisorDAO dao = new SupervisorDAO(connection);
		
		employee.setId_card(Integer.valueOf(request.getParameter("id_card")));
		employee.setType_employee(TypeEmployee.SUPERVISOR);
		employee.setFirst_name(request.getParameter("first_name"));
		employee.setName(request.getParameter("name"));
		employee.setPhone_number(request.getParameter("phone_number"));
		  
		supervisor.setUsername(supervisor.username());
		supervisor.setPassword(User.generatePassword());
		supervisor.setEmployee(employee);
		System.out.println( Integer.valueOf(request.getParameter("town")) );
		supervisor.getTown().setId_town(Integer.valueOf(request.getParameter("town")));
	
		dao.create(supervisor);
	}
	
	private void addService(HttpServletRequest request) throws SQLException, MadinaticException {
		Service service = new Service();
		Employee employee = new Employee();
		
		ServiceDAO dao = new ServiceDAO(connection);
		
		employee.setId_card(Integer.valueOf(request.getParameter("id_card")));
		employee.setType_employee(TypeEmployee.SERVICE_AGENT);
		employee.setFirst_name(request.getParameter("first_name"));
		System.out.println("FirstName/***************"+request.getParameter("first_name"));
		employee.setName(request.getParameter("name"));
		employee.setPhone_number(request.getParameter("phone_number"));
		  
		
		service.setPassword(User.generatePassword());
		service.setEmployee(employee);
		service.setType_service(TypeService.valueOf(request.getParameter("type")));
		service.setName(request.getParameter("service_name"));
		service.setEmail(request.getParameter("email"));
		service.setSite_web(request.getParameter("site_web"));
		System.out.println( Integer.valueOf(request.getParameter("town")) );
		service.getTown().setId_town(Integer.valueOf(request.getParameter("town")));
		service.setUsername(service.username());
		
		dao.create(service);
	}
	/*private void addService(HttpServletRequest request) throws SQLException, MadinaticException {
		User user = new User();
		Service service = new Service();
		Employee employee = new Employee();
		
		UserDAO userDAO = new UserDAO(connection); 
		ServiceDAO serviceDAO = new ServiceDAO(connection);
		EmployeeDAO employeeDAO = new EmployeeDAO(connection);
		
		System.out.println("//////YEEEES");
		
		service.setName(request.getParameter("service_name"));
		service.setEmail(request.getParameter("email"));
		service.setId_town(Integer.valueOf(request.getParameter("town")));
		service.setSite_web(request.getParameter("site_web"));
		service.setType_service(TypeService.valueOf(request.getParameter("type")));
		
		
		user.setUsername(service.username());
		user.setPassword(User.generatePassword());
		
		service.setUsername(user.getUsername());
		service.setPassword(user.getPassword());
		
		userDAO.create(service);
		serviceDAO.create(service);
		
		employee.setId_card(Integer.valueOf(request.getParameter("id_card")));
		employee.setType_employee(TypeEmployee.SERVICE_AGENT);
		employee.setFirst_name(request.getParameter("first_name"));
		employee.setName(request.getParameter("name"));
		employee.setPhone_number(request.getParameter("phone_number"));
		
		employeeDAO.create(employee);
		System.out.println("//////YEEEES");
	}*/

}
