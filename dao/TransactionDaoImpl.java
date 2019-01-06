package dao;

import java.sql.*;

import connection.DBConnectionManager;

public class TransactionDaoImpl implements TransactionDao {

	private Connection con = null; 
	private PreparedStatement myStmt = null;
	private ResultSet myRs = null;
	
	public void getbyZipcode(String zip, int month, int year) throws SQLException {


		try {
			
			// 1. Get a connection to database
			con = DBConnectionManager.getConnection(); 
		
			// 2. Create a statement
			myStmt = con.prepareStatement(SqlFile.query1);

			// 2a. set the parameter;
			myStmt.setString(1, zip);
			myStmt.setInt(2, month);
			myStmt.setInt(3, year); 

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println("Date: " + myRs.getString("MONTH") + 
						"/" + myRs.getString("DAY") + 
						"/" + myRs.getString("YEAR") + " | " +
						"Credit Card Number: " + myRs.getString("CREDIT_CARD_NO") + " | " +
						"Customer SSN: " + myRs.getString("CUST_SSN")+ " | " +
						"Branch Code: " + myRs.getString("BRANCH_CODE") + " | " +
						"Transaction Type: " + myRs.getString("TRANSACTION_TYPE") + " | " +
						"Transaction Value: " + myRs.getString("TRANSACTION_VALUE"));
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println("Date: " + myRs.getString("MONTH") + 
						"/" + myRs.getString("DAY") + 
						"/" + myRs.getString("YEAR") + " | " +
						"Credit Card Number: " + myRs.getString("CREDIT_CARD_NO") + " | " +
						"Customer SSN: " + myRs.getString("CUST_SSN")+ " | " +
						"Branch Code: " + myRs.getString("BRANCH_CODE") + " | " +
						"Transaction Type: " + myRs.getString("TRANSACTION_TYPE") + " | " +
						"Transaction Value: " + myRs.getString("TRANSACTION_VALUE"));
			}
		 
		
		} catch (Exception exc) {
		System.out.println("Error in DAO Implmentation.");
		}
		
		finally {
			//Closes Database Connection
			DBConnectionManager.closeConnection(); 
		
		}

	}

	@Override
	public void getbyType(String type) throws SQLException {

		try {
			// 1. Get a connection to database
			con = DBConnectionManager.getConnection(); 


			// 2. Create a statement
			myStmt = con.prepareStatement(SqlFile.query2);

			// 2a. set the parameter;
			myStmt.setString(1, type);

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println("# of Transactions: " + myRs.getString("# of Transactions") + " || " 
			+ "Total Transaction Amount: " + "$" + myRs.getString("Total Transaction Amount"));
						
			}

		} catch (Exception exc) {
			System.out.println("Error in DAO Implmentation.");
		} finally {
			//Closes Database Connection
			DBConnectionManager.closeConnection(); 
			
		}

	}

	@Override
	public void getbyState(String state) throws SQLException {
		
		try {
			// 1. Get a connection to database
			con = DBConnectionManager.getConnection();  

			// 2. Create a statement
			myStmt = con.prepareStatement(SqlFile.query3);

			// 2a. set the parameter;
			myStmt.setString(1, state);

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println("# of Transactions: " + myRs.getString("# of Transaction") + " || " 
						+ "Total Transaction Amount: " + "$" + myRs.getString("Transaction Amount"));
			}
				
		} catch (Exception exc) {
			System.out.println("Error in DAO Implmentation.");
		} finally {
			//Closes Database Connection
			DBConnectionManager.closeConnection(); 
			
		}

	}
}