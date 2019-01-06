package runner;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


import dao.TransactionDaoImpl;


public class TransactionRunner {

	Scanner input = new Scanner(System.in);
	
	public void method1() {
		int month, year;
		String zip;
		

		try {
			String selection1 = "\nPlease enter a valid Zipcode. \n" + "";
			System.out.print(selection1);
			zip = input.next();
			
			while (Validator.zipValidator(zip) != true) {
				System.out.print(selection1);
				zip = input.next();
			}

			String selection2 = "\nPlease enter a valid Month as MM \n" + "";
			System.out.print(selection2);
			month = input.nextInt();

			while (Validator.monthValidator(month) != true) {
				System.out.print(selection2);
				month = input.nextInt();
			}; 

			String selection3 = "\nPlease enter a valid year between "
					+ "1950 to 2018 as YYYY  \n" + "";
			System.out.print(selection3);
			year = input.nextInt();
			
			while (Validator.yearValidator(year) != true) {
				System.out.print(selection3);
				System.out.println();
				year = input.nextInt();
			}

			TransactionDaoImpl TXDaoimpl1 = new TransactionDaoImpl();
			
			TXDaoimpl1.getbyZipcode(zip, month, year);
		
		} catch (InputMismatchException i) {
			System.out.println("\n" + "Error: Invalid Input." + "\n" + "Application Terminated.");

		} catch (SQLException e) {
			System.out.println("\n" + "SQL Error." + "\n" + "Application Terminated.");
			
		}catch (Exception exc) {
			System.out.println("\n" + "Error." + "\n" + "Application Terminated.");
			
		}
	} 

	public void method2() {
		 		
		String type; 

		try {
			
			String selection1 = "\nPlease select and enter the type from the list below. \n" + "" 
	                   + "\n'Education', 'Entertainment', 'Grocery', 'Gas', 'Bills', 'Test', 'Healthcare'\n ";
			System.out.print(selection1);
			System.out.print("\n" +"Your Selection: ");

			//Takes input, converts it to Upper Case 
			type = (input.nextLine()).toUpperCase();
	       
			
			while (Validator.typeValidator(type) != true) {
			     System.out.print(selection1);
			 	 System.out.print("\n" +"Your Selection: ");
			     type = (input.next()).toUpperCase();
			}; 
	
			
	        //If it matches, it creates a new object to implement the DAO. 
			TransactionDaoImpl TXDaoimpl2 = new TransactionDaoImpl();
			
			TXDaoimpl2.getbyType(type);
		
		} catch (InputMismatchException i) {
			System.out.println("\n" + "Error: Invalid Input." + "\n" + "Application Terminated.");
		} catch (SQLException e) {
			System.out.println("\n" + "SQL Error." + "\n" + "Application Terminated.");
		} catch (Exception exc) {
			System.out.println("\n" + "Error." + "\n" + "Application Terminated.");

		}
		
	}

	
	public void method3() {
		  
		String state; 

		try {
			
			String selection1 = "\nPlease enter a valid two character State code \n";                  
			System.out.print(selection1);
			state = (input.nextLine()).toUpperCase();
			
			while (Validator.stateValidator(state) != true) {
				System.out.print(selection1);
				state = (input.next()).toUpperCase();
			}; 
			
	        
	        
			TransactionDaoImpl TXDaoimpl3 = new TransactionDaoImpl();
			TXDaoimpl3.getbyState(state);
			
		} catch (InputMismatchException i) {
			System.out.println("\n" + "Error: Invalid Input." + "\n" + "Application Terminated.");
		} catch (SQLException e) {
			System.out.println("\n" + "SQL Error." + "\n" + "Application Terminated.");
		} catch (Exception exc) {
			System.out.println("\n" + "Error." + "\n" + "Application Terminated.");

		}

	}
	
}