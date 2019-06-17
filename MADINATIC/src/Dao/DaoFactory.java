package Dao;
import java.sql.*;

public class DaoFactory {
	public Connection connection ;
	private String username;
	private String password;
	private String url;
	public DaoFactory() {
		Class.forName("com.jdbc.Driver.manager");
		connection = getConnection(url,username,password);
	}
}
