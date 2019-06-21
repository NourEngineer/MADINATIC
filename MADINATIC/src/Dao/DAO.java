package Dao;
import java.sql.*;

import com.madinatic.exception.MadinaticException;

public abstract class DAO<T> {
	public Connection connection;
	   
	public DAO(Connection connection) {
		this.connection = connection;
	}
	  /**
	  * Méthode de création
	  * @param obj
	  * @return boolean 
	 * @throws SQLException 
	  */
	  public abstract boolean create(T obj) throws SQLException , MadinaticException;

	  /**
	  * Méthode pour effacer
	  * @param obj
	  * @return boolean 
	  */
	  public abstract boolean delete(T obj);

	  /**
	  * Méthode de mise à jour
	  * @param obj
	  * @return boolean
	  */
	  public abstract boolean update(T obj);

	  /**
	  * Méthode de recherche des informations
	  * @param id
	  * @return T
	  */
	  public abstract T find(int id);
	
}
