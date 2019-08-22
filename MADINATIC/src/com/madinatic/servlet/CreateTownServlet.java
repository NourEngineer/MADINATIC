package com.madinatic.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.madinatic.classes.Employee;
import com.madinatic.classes.Supervisor;
import com.madinatic.classes.TypeEmployee;
import com.madinatic.classes.User;
import com.madinatic.dao.DaoFactory;
import com.madinatic.dao.SupervisorDAO;
import com.madinatic.exception.MadinaticException;

/**
 * Servlet implementation class CreateTownServlet
 */
@WebServlet("/CreateTown")
public class CreateTownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTownServlet() {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/CreateTown.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			addSupervisor(request);
		} catch (SQLException | MadinaticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			
			this.getServletContext().getRequestDispatcher("/Servlet").forward(request, response);
			System. out.println(" No Exception  occured");
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
		employee.setPhone_number(request.getParameter("mobile"));
		  
		supervisor.getTown().setId_town(Integer.valueOf(request.getParameter("town")));
		supervisor.setUsername(supervisor.username());
		supervisor.setPassword(User.generatePassword());
		supervisor.setEmployee(employee);
		System.out.println( Integer.valueOf(request.getParameter("town")) );
		
	
		dao.create(supervisor);
	}
}
