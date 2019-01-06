package runner;

 import java.util.InputMismatchException;
import java.util.Scanner;

import dao.CustomerDaoImpl;

import java.sql.*;

public class CustomerRunner {
	
	public Scanner input = new Scanner(System.in); 
	
	//
	public void method1() {
		String ssn;

		try {
	

			CustomerDaoImpl CustDaoimpl1 = new CustomerDaoImpl();
			
			String selection1 = "\nPlease enter a valid Social Security Number \n" + "";
			System.out.print(selection1);
			ssn = input.next();
			
			//Validates if the SSN input is the correct length/right input
			while (Validator.ssnValidator(ssn) != true) {
				System.out.print(selection1);
				ssn = input.next();
			}

			CustDaoimpl1.CheckCustomer(ssn);
		
		} catch (InputMismatchException i) {
			System.out.println("\n" + "Error: Invalid Input." + "\n" + "Application Terminated.");
		} catch (SQLException e) {
			System.out.println("\n" + "SQL Error." + "\n" + "Application Terminated.");
		} catch (Exception exc) {
			System.out.println("\n" + "Error." + "\n" + "Application Terminated.");

		}
	}

	public void method2() {

		String CUST_ZIP, CUST_PHONE; 
		String FIRST_NAME, MIDDLE_NAME, LAST_NAME, APT_NO, STREET_NAME, CUST_CITY, CUST_STATE; 
		String CUST_COUNTRY, CUST_EMAIL, SSN;
		int menu;


		String selection1 = "\nPlease enter a valid Social Security Number to modify the record \n" + "";
		System.out.print(selection1);
		
		try {
		SSN = input.next();

		while (Validator.ssnValidator(SSN) != true) {
			System.out.print(selection1);
			SSN = input.next();
		}
		
		String selection = "\nSelect the number from the following menu you would like to modify. \n \n" 
				+ "1. Name Fields \n"
				+ "2. Address \n"
				+ "3. Phone \n"
				+ "4. Email \n"; 
				
		System.out.print(selection);
		System.out.print("\n" +"Your Selection: ");
		menu = input.nextInt();
		
		//Validates the input for the menu
		while (Validator.menuValidator(menu, 1, 4) != true) {
			System.out.print(selection);
			System.out.print("\n" +"Your Selection: ");
			menu = input.nextInt();
		}

		switch (menu) {
		case 1:
			System.out.print("Enter First Name: ");
			FIRST_NAME = input.next();
			
			//Validates if the name input is only letters etc.
			while (Validator.nameValidator(FIRST_NAME) != true) {
				System.out.print("Enter First Name: ");
				FIRST_NAME = input.next();
			}
			
			System.out.print("Enter Middle Name: ");
			MIDDLE_NAME = input.next();
			
			while (Validator.nameValidator(MIDDLE_NAME) != true) {
				System.out.print("Enter Middle Name: ");
				MIDDLE_NAME = input.next();
			}
			
			System.out.print("Enter Last Name: ");
			LAST_NAME = input.next();
			
			while (Validator.nameValidator(LAST_NAME) != true) {
				System.out.print("Enter Last Name: ");
				LAST_NAME = input.next();
			}
			
			CustomerDaoImpl CustDaoimpl2a = new CustomerDaoImpl();
			CustDaoimpl2a.ModifyCustomerName(SSN, FIRST_NAME, MIDDLE_NAME, LAST_NAME);
			
		 	break; 
		case 2:
			System.out.print("Enter Apartment NO: ");
			APT_NO = input.next();
			
			while (Validator.unitValidator(APT_NO) != true) {
				System.out.println("Enter Apartment NO: ");
				APT_NO = input.next(); 
			}
			
			System.out.print("Enter Street Name: ");
			STREET_NAME = input.next();
			
			while (Validator.addressValidator(STREET_NAME) != true) {
				System.out.print("Enter Street Name: ");
				STREET_NAME = input.next(); 
			}
			
			input.nextLine(); 
			System.out.print("Enter City: ");
			CUST_CITY = input.next();
		
			while (Validator.nameValidator(CUST_CITY) != true) {
				System.out.print("Enter City: ");
				CUST_CITY = input.next();
			}
			
			System.out.print("Enter State: ");
			CUST_STATE = input.next();
			
			while (Validator.stateValidator(CUST_STATE) != true) {
				System.out.print("Enter State: ");
				CUST_STATE = input.next();
			}; 
			
			
       		System.out.print("Enter Country: ");
			CUST_COUNTRY = input.next();
			while (Validator.nameValidator(CUST_COUNTRY) != true) {
				System.out.print("Enter Country: ");
				CUST_COUNTRY = input.next();
			}
			
			
			input.nextLine(); 
			System.out.print("Enter Zip: ");
			CUST_ZIP = input.next();
			while (Validator.zipValidator(CUST_ZIP) != true) {
				System.out.print("Enter Zip: ");
				CUST_ZIP = input.next();
			}
			
		 	CustomerDaoImpl CustDaoimpl2b = new CustomerDaoImpl();
		 	CustDaoimpl2b.ModifyCustomerAdd(SSN, APT_NO,STREET_NAME, CUST_CITY, CUST_STATE, CUST_COUNTRY, CUST_ZIP);
		 	break;
		 	
		case 3:
			System.out.print("Enter 7 digit Phone number: ");
			CUST_PHONE = input.next();
			
			while (Validator.phoneValidator(CUST_PHONE) != true) {
				System.out.print("Enter 7 digit Phone number: ");
				CUST_ZIP = input.next();
			}
	
		 	CustomerDaoImpl CustDaoimpl2c = new CustomerDaoImpl();
		 	CustDaoimpl2c.ModifyCustomerPhone(SSN, CUST_PHONE);
		 	break;
		case 4:
			System.out.print("Enter Email: ");
			CUST_EMAIL = input.next();
			
			while (Validator.emailValidator(CUST_EMAIL) != true) {
				System.out.print("Enter Email: ");
				CUST_EMAIL = input.next();
			}
			
			
			CustomerDaoImpl CustDaoimpl2d = new CustomerDaoImpl();
		 	CustDaoimpl2d.ModifyCustomerEmail(SSN, CUST_EMAIL);
		 	break;
		default:
			System.out.println("It is not a correct #");
		}	
		
		} catch (InputMismatchException i) {
			System.out.println("\n" + "Error: Invalid Input." + "\n" + "Application Terminated.");
		} catch (SQLException e) {
			System.out.println("\n" + "SQL Error." + "\n" + "Application Terminated.");
		} catch (Exception exc) {
			System.out.println("\n" + "Error." + "\n" + "Application Terminated.");
		}
	}
	
	public void method3() {
		String creditCard;
		int month, year;

		String selection1 = "\nPlease enter a valid Credit Card Number \n" + "";
		System.out.print(selection1);

		try {
			creditCard = input.next();

			while (Validator.creditCardValidator(creditCard) != true) {
				System.out.println(selection1);
				creditCard = input.next();
			}

			String selection2 = "\nPlease enter a valid Month as MM \n" + "";
			System.out.print(selection2);
			month = input.nextInt();
			
			while (Validator.monthValidator(month) != true) {
				System.out.println(selection2);
				month = input.nextInt();
			}


			String selection3 = "\nPlease enter a valid year between " + "1950 to 2018 as YYYY  \n" + "";
			System.out.print(selection3);
			year = input.nextInt();
			
			while (Validator.yearValidator(year) != true) {
				System.out.println(selection3);
				year = input.nextInt();
			}
			
			CustomerDaoImpl CustDaoimpl3 = new CustomerDaoImpl();
			
			CustDaoimpl3.GenerateBill(creditCard, month, year);
			
		} catch (InputMismatchException i) {
			System.out.println("\n" + "Error: Invalid Input." + "\n" + "Application Terminated.");
		} catch (SQLException e) {
			System.out.println("\n" + "SQL Error." + "\n" + "Application Terminated.");
		} catch (Exception exc) {
			System.out.println("\n" + "Error." + "\n" + "Application Terminated.");

		}
	}

	public void method4() {
		String ssn;
		int fromYear, toYear, fromMonth, toMonth, fromDay, toDay;
		Scanner input = new Scanner(System.in);

		String selection1 = "\nPlease enter a valid Social Security Number \n" + "";
		System.out.print(selection1);

		try {
			
			ssn = input.next();

			while (Validator.ssnValidator(ssn) != true) {
				System.out.println(selection1);
				ssn = input.next();
			}

			String selection2 = "\nPlease enter a valid starting year between " + "1950 to 2018 as YYYY:\n" + "";
			System.out.print(selection2);
			fromYear = input.nextInt();
			
			while (Validator.yearValidator(fromYear) != true) {
				System.out.println(selection2);
				fromYear = input.nextInt();
			}
			
			String selection3 = "\nPlease enter a valid starting Month as MM:\n" + "";
			System.out.print(selection3);
			fromMonth = input.nextInt();
			
			while (Validator.monthValidator(fromMonth) != true) {
				System.out.println(selection3);
				fromMonth = input.nextInt();
			}
			
			String selection4 = "\nPlease enter a valid starting Day as DD:\n" + "";
			System.out.print(selection4);
			fromDay = input.nextInt();
			
			while (Validator.dayValidator(fromDay) != true) {
				System.out.println(selection4);
				fromDay = input.nextInt();
			}
			

			String selection5 = "\nPlease enter a valid ending year between " + "1950 to 2018 as YYYY:\n" + "";
			System.out.print(selection5);
			toYear = input.nextInt();
			
			while (Validator.yearValidator(toYear) != true) {
				System.out.println(selection5);
				toYear = input.nextInt();
			}

			
			String selection6 = "\nPlease enter a valid ending Month as MM:\n" + "";
			System.out.print(selection6);
			toMonth = input.nextInt();
			while (Validator.monthValidator(toMonth) != true) {
				System.out.println(selection6);
				toMonth = input.nextInt();
			}
			
			
			String selection7 = "\nPlease enter a valid ending Day as DD:\n" + "";
			System.out.print(selection7);
			toDay = input.nextInt();
			
			while (Validator.dayValidator(toDay) != true) {
				System.out.println(selection7);
				toDay = input.nextInt();
			}
			
			CustomerDaoImpl CustDaoimpl4 = new CustomerDaoImpl();
			CustDaoimpl4.DisplayTrans(ssn, fromYear, fromMonth, fromDay, toYear, toMonth, toDay);
		
		} catch (InputMismatchException i) {
			System.out.println("\n" + "Error: Invalid Input." + "\n" + "Application Terminated.");
		} catch (SQLException e) {
			System.out.println("\n" + "SQL Error." + "\n" + "Application Terminated.");
		} catch (Exception exc) {
			System.out.println("\n" + "Error." + "\n" + "Application Terminated.");

		}

		input.close();
	}
}
