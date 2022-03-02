package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Books;

public class BookDao {

	/*
	 * Creating a registerStudent method that takes student object as parameter
	 * STUDENT TBL. ID - INT FIRSTNAME - STRING LASTNAME - STRING GRADE - STRING
	 */

	public int issueBook(Books bk) throws ClassNotFoundException {
		
		// create sql statement 
		String INSERT_BORROW_SQL ="INSERT INTO Borrow_By" +
		"(Book_Id, Member_Id, Issue_Date, Due_Date, Return_Date) VALUES " +
		"(?,?,?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "rootpassword");
				PreparedStatement ps = connection.prepareStatement(INSERT_BORROW_SQL))
				{
				
				ps.setInt(1, 101);
				//ps.setString(2, bk.getFirstname());
				
			System.out.println(ps);
				
			result=  ps.executeUpdate();	
		
	}
				
		catch (SQLException e) {
			printSQLException(e);  // calling printSQLException function...
				}
		return result;
	}		
		/*
		 *  Exception -function for printing SQL State, Error Code and Message .. 
		 */

	private void printSQLException(SQLException ex) {

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
