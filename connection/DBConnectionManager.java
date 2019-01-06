package connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



/* 
 * 
 * This is the Database Connection Manager. The username, password, and url are stored in 
 * a properties file in the resource folder. 
 * 
 * Lara Henney
 * 01/03/19
 * 
 */

public class DBConnectionManager {
	
	private static Connection con = null; 
	private static PreparedStatement myStmt = null;
	private static ResultSet myRs = null;
	
	
	
	//Establishes a connection to the database
	public static Connection getConnection() {
		
		Properties prop = new Properties();
		InputStream input = null;
			
		try {
				//Loads Password and username from properties folder
				input = new FileInputStream("resource/config.properties"); 
				prop.load(input);
				
				con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pass")); 
				System.out.println("\nConnection was successful!\n");
			} catch (SQLException ex) {
				//Catches if it failed to connect
				System.out.println("Failed to Connect.\n");
				ex.printStackTrace();
			} catch (FileNotFoundException e) {
				//Catches if file is not found in specified path.
				System.out.println("Unable to find File.\n");
				e.printStackTrace();
			} catch (IOException e) {
				//Catches if it was unable to load in properties. 
				System.out.println("Unable to load properties.\n");
				e.printStackTrace();
			} catch (Exception e) {
				//Catches general errors. 
				System.out.println("Error with Connection Manager.\n");
				e.printStackTrace();	
			
			}
		
		return con; 
		
	}
	
	//Closes the connection to Database, etc. 
	public static void closeConnection() throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (con != null) {
			con.close();
		}
		
		System.out.println("\nDatabase connection closed.");
	}

}
