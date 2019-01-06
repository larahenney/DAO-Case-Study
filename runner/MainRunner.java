package runner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainRunner {

//	private static final com.runner.TransactionRunner New = null;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int menu;
		int numCust; 
		String selection = "\nPlease select the number from the following menu. \n \n" + "Transaction Detail: \n"
				+ "1. Display the transactions made by customers living in a given zipcode for a given Month and year. \n"
				+ "2. Display the number and total values of transactions for a given type. \n"
				+ "3. Display the number and total values of transactions for branches in a given state. \n\n"
				+ "Customer Detail: \n" 
				+ "4. Check the existing account details of a customer. \n"
				+ "5. Modify the existing account details of a customer. \n"
				+ "6. Generate monthly bill for a credit card number for a given month and year. \n"
				+ "7. Display the transactions made by a customer between two dates. \n" 
				+ "8. Exit \n" + "";
		
		try {
		
		
		
		System.out.print(selection);
		System.out.print("\n" +"Your Selection: ");
		menu = input.nextInt();
		
		//Validator class makes sure that the input for the menu is correct
		while (Validator.menuValidator(menu, 1, 8) != true) {
			System.out.print(selection);
			System.out.print("\n" +"Your Selection: ");
			menu = input.nextInt();
		}

		switch (menu) {
		case 1:
			TransactionRunner Transaction1 = new TransactionRunner();
			Transaction1.method1();
			break;
		case 2:
			TransactionRunner Transaction2 = new TransactionRunner();
			Transaction2.method2();
			break;
		case 3:
			TransactionRunner Transaction3 = new TransactionRunner();
			Transaction3.method3();
			break;
			
		case 4:
			//Added option to check multiple records if need be. Regardless of what they put it will run at least once.
			System.out.println("How many customer records would you like to check?");
			numCust = input.nextInt();
			CustomerRunner Customer1 = new CustomerRunner();
			do {
				Customer1.method1();
				numCust--; 
			} while (numCust > 0);
			break;
		case 5:
			//Added multiple records option here as well
			System.out.println("How many customer records would you like to modify?");
			numCust = input.nextInt(); 
			CustomerRunner Customer2 = new CustomerRunner();
			do {
				Customer2.method2();
				numCust--; 
			} while (numCust > 0); 

			break;
		case 6:
			CustomerRunner Customer3 = new CustomerRunner();
			Customer3.method3();
			break;
			
		case 7:
			CustomerRunner Customer4 = new CustomerRunner();
			Customer4.method4();
			break;
		case 8:
			
			System.out.println ("Thank you and goodbye!!.");
			break;
			
		default:
			System.out.println("It is not a correct #");
		}
	
		} catch (InputMismatchException i) {
			//Catches Input Mismatch. 
			//Inputs are generally checked over in validator class but this is here just in case.
			System.out.println("\n" + "Error: Invalid Input." + "\n" + "Application Terminated.");	
		
		}catch (Exception exc) {
			//Catches any general errors.
			System.out.println("\n" + "Error." + "\n" + "Application Terminated.");
		
		} finally {
			//Always closes input at the end of the application.
			input.close(); 
			}	
			
			
		
		
	}

}
