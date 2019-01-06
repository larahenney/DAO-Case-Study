package dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DBConnectionManager;

public class CustomerDaoImpl implements CustomerDao {


	
	private Connection con = null; 
	private PreparedStatement myStmt = null;
	private ResultSet myRs = null;

	public void CheckCustomer(String ssn) throws SQLException {


		try {
			// 1. Get a connection to database
			con = DBConnectionManager.getConnection(); 

			// 2. Create a statement
			myStmt = con.prepareStatement(SqlFile.query4);

			// 3. Set the parameter;
			myStmt.setString(1, ssn);

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			// If there are no results from said query lets user know.
			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			
			// Prints results.  	
			} else {
				System.out.println("\nCustomer Found!\n");
				System.out.println("First Name: " + myRs.getString("FIRST_NAME") 
				+ "\nMiddle Name: "
				+ "" + myRs.getString("MIDDLE_NAME") 
				+ "\nLast Name: " + myRs.getString("LAST_NAME") 
				+ "\nSSN: " + myRs.getString("SSN") 
				+ "\nCredit Card Number: " + myRs.getString("CREDIT_CARD_NO")
				+ "\nAddress: " + myRs.getString("APT_NO") + " " + myRs.getString("STREET_NAME")
					+ "\n" + myRs.getString("CUST_CITY") + ", " + myRs.getString("CUST_STATE") 
					+ " " + myRs.getString("CUST_ZIP")
					+ "\n" + myRs.getString("CUST_COUNTRY")
				+ "\nPhone Number: " + myRs.getString("CUST_PHONE") 
				+ "\nEmail: " + myRs.getString("CUST_EMAIL")
						);
			}

			
		} catch (Exception exc) {
			System.out.println("Error in DAO Implmentation.");
		} finally {
			
			//Closes Database Connection
			DBConnectionManager.closeConnection();
			}
	}

	

	@Override 
	public void ModifyCustomerName(String SSN, String FIRST_NAME, String MIDDLE_NAME, String LAST_NAME) throws SQLException {
			                       

		try {
			// 1. Get a connection to database
			con = DBConnectionManager.getConnection(); 

			// 2. Create a statement
			myStmt = con.prepareStatement(SqlFile.query5a);
	
			// 2a. set the parameter;
			
			myStmt.setString(1, FIRST_NAME);
			myStmt.setString(2, MIDDLE_NAME);
			myStmt.setString(3, LAST_NAME);
			myStmt.setString(4, SSN);
			
									
			// 3. Execute SQL query
			int Rows = myStmt.executeUpdate();
	
		
			if (Rows == 0) {
				System.out.println("******************************************");
				System.out.println("There is no record for the SSN to update !");
				System.out.println("******************************************");
			} else {
				System.out.println(SSN + ": Name Updated");
			}
			
		
		} catch (Exception exc) {
			System.out.println("Error in DAO Implmentation.");
		
		}  finally {
			//Closes Database Connection
			DBConnectionManager.closeConnection();
		}

	}

	@Override
	public void ModifyCustomerAdd(String SSN, String APT_NO, String STREET_NAME, String CUST_CITY, String CUST_STATE,
			String CUST_COUNTRY, String CUST_ZIP) throws SQLException {

		try {
			// 1. Get a connection to database
			con = DBConnectionManager.getConnection();  

			// 2. Create a statement
			myStmt = con.prepareStatement(SqlFile.query5b);
	
			// 2a. set the parameter;
			
			
			myStmt.setString(1, APT_NO);
			myStmt.setString(2, STREET_NAME);
			myStmt.setString(3, CUST_CITY);
			myStmt.setString(4, CUST_STATE);
			myStmt.setString(5, CUST_COUNTRY);
			myStmt.setString(6, CUST_ZIP);
			myStmt.setString(7, SSN);
									
			// 3. Execute SQL query
			int Rows = myStmt.executeUpdate();
	
		
			if (Rows == 0) {
				System.out.println("******************************************");
				System.out.println("There is no record for the SSN to update !");
				System.out.println("******************************************");
			} else {
				System.out.println(SSN + ": Address Updated");
			}
			
		} catch (Exception exc) {
			System.out.println("Error in DAO Implmentation.");
			
		} finally {
			//Closes Database Connection
			DBConnectionManager.closeConnection();
		}
		

	}

	
	@Override
	public void ModifyCustomerPhone(String SSN, String Phone) throws SQLException {
	

		try {
			// 1. Get a connection to database
			con = DBConnectionManager.getConnection();  

			// 2. Create a statement
			myStmt = con.prepareStatement(SqlFile.query5c);
	
			// 2a. set the parameter;
			
			
			myStmt.setString(1, Phone);
			myStmt.setString(2, SSN);
									
			// 3. Execute SQL query
			int Rows = myStmt.executeUpdate();
	
		
			if (Rows == 0) {
				System.out.println("******************************************");
				System.out.println("There is no record for the SSN to update !");
				System.out.println("******************************************");
			} else {
				System.out.println(SSN + ": Phone Number Updated");
			}
			
		} catch (Exception exc) {
			System.out.println("Error in DAO Implmentation.");
		} finally {
			//Closes Database Connection
			DBConnectionManager.closeConnection();
		}

	}

	@Override
	public void ModifyCustomerEmail(String SSN, String Email) throws SQLException {
		
		try {
			// 1. Get a connection to database
			con = DBConnectionManager.getConnection();  

			// 2. Create a statement
			myStmt = con.prepareStatement(SqlFile.query5d);
	
			// 2a. set the parameter;
			myStmt.setString(1, Email);
			myStmt.setString(2, SSN);
									
			// 3. Execute SQL query
			int Rows = myStmt.executeUpdate();
	
		
			if (Rows == 0) {
				System.out.println("******************************************");
				System.out.println("There is no record for the SSN to update !");
				System.out.println("******************************************");
			} else {
				System.out.println(SSN + ": Email Updated");
			}
			
		} catch (Exception exc) {
			System.out.println("Error in DAO Implmentation.");
		} finally {
			//Closes Database Connection
			DBConnectionManager.closeConnection();
		}

	}

	@Override
	public void GenerateBill(String creditCard, int month, int year) throws SQLException {


		try {
			// 1. Get a connection to database
			con = DBConnectionManager.getConnection(); 

			// 2. Create a statement
			myStmt = con.prepareStatement(SqlFile.query6);

			// 2a. set the parameter;
			myStmt.setString(1, creditCard);
			myStmt.setInt(2, month);
			myStmt.setInt(3, year);

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else if (myRs.getString("BILL") == null){
				System.out.println("The is no bill for month " + month + " during year " + year + " for this Credit Card Number.");
			}
			
			else {
				System.out.println("The bill for month " + month + " during year " + year + " is " + "$" + myRs.getString("BILL"));
			}

			
		} catch (Exception exc) {
			System.out.println("Error in DAO Implmentation.");
		} finally {
			//Closes Database Connection
			DBConnectionManager.closeConnection(); 
		}

	}

	@Override
	public void DisplayTrans(String ssn, int frYear, int frMonth, int frDay, int toYear, int toMonth, int toDay)
			throws SQLException {

		try {
			// 1. Get a connection to database
			con = DBConnectionManager.getConnection();  

			// 2. Create a statement
			myStmt = con.prepareStatement(SqlFile.query7);

			// 2a. set the parameter;
			myStmt.setString(1, ssn);
			myStmt.setInt(2, frYear);
			myStmt.setInt(3, frMonth);
			myStmt.setInt(4, frDay);
			myStmt.setInt(5, toYear);
			myStmt.setInt(6, toMonth);
			myStmt.setInt(7, toDay);
			

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println("Transaction ID: " + myRs.getString("TRANSACTION_ID") + " | "
						+ "Date: " + myRs.getString("MONTH") + "/"
						+ myRs.getString("DAY") + "/"
						+ myRs.getString("YEAR") + " | "
						+ "Credit Card Number: "  + myRs.getString("CREDIT_CARD_NO") + " | "
						+ "Customer SSN: " + myRs.getString("CUST_SSN") + " | "
						+ "Branch Code: " + myRs.getString("BRANCH_CODE") + " | "
						+ "Transaction Type: " + myRs.getString("TRANSACTION_TYPE")+ " | "
				);
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println("Transaction ID: " + myRs.getString("TRANSACTION_ID") + " | "
						+ "Date: " + myRs.getString("MONTH") + "/"
						+ myRs.getString("DAY") + "/"
						+ myRs.getString("YEAR") + " | "
						+ "Credit Card Number: "  + myRs.getString("CREDIT_CARD_NO") + " | "
						+ "Customer SSN: " + myRs.getString("CUST_SSN") + " | "
						+ "Branch Code: " + myRs.getString("BRANCH_CODE") + " | "
						+ "Transaction Type: " + myRs.getString("TRANSACTION_TYPE")+ " | "
						+ "Transaction Value: " + myRs.getString("TRANSACTION_VALUE")+ " | "
				
				);

			}
		
		} catch (Exception exc) {
			System.out.println("Error in DAO Implmentation.");
		} finally {
			//Closes Database Connection
			DBConnectionManager.closeConnection();
		}
	}


}