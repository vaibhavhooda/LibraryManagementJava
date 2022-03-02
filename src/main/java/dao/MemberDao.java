package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Member;

public class MemberDao {

	/*
	 * Creating a registerStudent method that takes student object as parameter
	 * STUDENT TBL. ID - INT FIRSTNAME - STRING LASTNAME - STRING GRADE - STRING
	 */

	public static int register(Member mem) throws ClassNotFoundException {
		
		// create sql statement 
		String INSERT_USER_SQL = "INSERT INTO Member" +
				"(m_id, m_name, m_address, m_type, m_start, m_expiry) VALUES " +
				"(?,?,?,?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assgnment3", "root", "rootpassword");
		PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL)){
			
						
			ps.setInt(1, mem.getMem_id());
			ps.setString(2, mem.getMem_name());
			ps.setString(3, mem.getMem_address());
			ps.setString(4, mem.getMem_type());
			ps.setString(5, mem.getMem_date());
			ps.setString(6, mem.getExpiry_date());
			
			System.out.println(ps);
				
			result = ps.executeUpdate();
		}
				
		catch (SQLException e) {
			System.out.print(e.getMessage());
			printSQLException(e);  // calling printSQLException function...
				}
		return result;
	}		
	
public static int update(Member mem) throws ClassNotFoundException {
		
		// create sql statement 
		String UPDATE_USER_SQL = "update Member " +
				"set m_name=?, m_address=?, m_type=?, m_start=?, m_expiry=? " +
				"where m_id=?;";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assgnment3", "root", "rootpassword");
		PreparedStatement ps = connection.prepareStatement(UPDATE_USER_SQL)){
			
			ps.setInt(6, mem.getMem_id());
			ps.setString(1, mem.getMem_name());
			ps.setString(2, mem.getMem_address());
			ps.setString(3, mem.getMem_type());
			ps.setString(4, mem.getMem_date());
			ps.setString(5, mem.getExpiry_date());
			
			System.out.println(ps);
				
			result = ps.executeUpdate();
		}
				
		catch (SQLException e) {
			System.out.println(e.getMessage());
			printSQLException(e);  // calling printSQLException function...
				}
		return result;
	}

public static ResultSet getMembers() throws ClassNotFoundException {
	
	// create sql statement 
	String GET_USER_SQL = "select * from Member";
	
	ResultSet rs = null;
	
	Class.forName("com.mysql.jdbc.Driver");
	
	try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assgnment3", "root", "rootpassword");
	PreparedStatement ps = connection.prepareStatement(GET_USER_SQL)){
		
					
		rs = ps.executeQuery(GET_USER_SQL);
		
	}
			
	catch (SQLException e) {
		System.out.print(e.getMessage());
		printSQLException(e);  // calling printSQLException function...
			}
	return rs;
}	
	
		/*
		 *  Exception -function for printing SQL State, Error Code and Message .. 
		 */

	private static void printSQLException(SQLException ex) {

		for (Throwable e : ex) {
			if (e instanceof SQLException) {

				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + ((SQLException) e).getMessage());

				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause" + t);
					t = t.getCause();
				}
			}

		}

	}
	
}
