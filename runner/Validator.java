package runner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Validates the various Scanner Inputs for the Application 
public class Validator {


	public static boolean dayValidator(int day) {
		if (day < 1 || day > 31) {
			System.out.print("\n**********************************\n");
			System.out.print("***You have entered invalid Day***\n");
			System.out.print("**********************************\n");
			return false;
		}
		return true;
	}
	
	public static boolean monthValidator(int month) { 
	
		
		if (month < 1 || month > 12) {
			System.out.print("************************************\n");
			System.out.print("***You have entered invalid Month***\n");
			System.out.print("************************************\n");
			return false;
		}
		
		return true; 

	}
		
	public static boolean yearValidator(int year) {
		
		if (year < 1900 || year > 2018) {
			System.out.print("***********************************\n");
			System.out.print("***You have entered invalid Year***\n");
			System.out.print("***********************************\n");
			return false;
		} 
			
		return true;
	}
	
	public static boolean zipValidator(String zip) {
		
		//Did not add a check to make sure it is an int because some international zip codes include letters and length varies
		if (zip.length() < 3 || zip.length() > 10) {
			System.out.print("\n***************************************\n");
			System.out.print("***You have entered invalid Zipcode.***\n");
			System.out.print("********** Invalid length. ************\n");
			System.out.print("***************************************\n");
			return false; 
		}
		return true;
	}
	
	
	public static boolean nameValidator(String name) {
		
		//Limits input
		if (name.length() < 1 || name.length() > 40) {
			System.out.print("\n****************************************\n");
			System.out.print("***You have entered an invalid input.***\n");
			System.out.print("*********** Invalid length. ************\n");
			System.out.print("****************************************\n");
			return false; 
		}
	
		//Makes sure that only letters (in all languages as well as hyphenated names) are input
		String regex = "^[\\p{L}-]+$";
		
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
 
        if (!matcher.matches()) {
        	System.out.print("\n*********************************************\n");
			System.out.print("*****You have entered an invalid input.******\n");
			System.out.print("*Numbers and special characters are invalid.*\n");
			System.out.print("*********************************************\n");	
	        return false; 
        } 
        
        return true;
        	
		}
	
	public static boolean addressValidator(String address) {
		
		//Limits input
		if (address.length() < 1 || address.length() > 30) {
			System.out.print("\n****************************************\n");
			System.out.print("***You have entered an invalid input.***\n");
			System.out.print("*********** Invalid length. ************\n");
			System.out.print("****************************************\n");
			return false; 
		}
	
		//Makes sure that only numbers and letters (as hyphenated places) are input
		String regex = "^[A-Za-zÀ-ÖØ-öø-ÿ0-9\\s-]+$";
		
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
 
        if (!matcher.matches()) {
        	System.out.print("\n****************************************\n");
			System.out.print("***You have entered an invalid input.***\n");
			System.out.print("*****Special characters are invalid.****\n");
			System.out.print("****************************************\n");	
	        return false; 
        } 
        
        return true;
        	
		}
	
	public static boolean unitValidator(String unit) {
		
		try {
		
		if (unit.length() < 1 || unit.length() > 7) {
			System.out.print("\n*******************************************\n");
			System.out.print("*You have entered an invalid Apartment NO.*\n");
			System.out.print("*********** Invalid length. ***************\n");
			System.out.print("*******************************************\n");
			return false;
		}
		
		//Checks to see if it's a numeric input 
		@SuppressWarnings("unused")
		double d = Double.parseDouble(unit); 
		
		//If it is not a numeric input it makes the user retype it
		} catch(NumberFormatException nfe) {
			System.out.print("\n***********************************************\n");
			System.out.print("***You have entered invalid Apartment number***\n");
			System.out.print("********Only numeric values are accepted*******\n");
			System.out.print("***********************************************\n");
			return false; 
		}

		return true; 
	}
	
	
	
	public static boolean ssnValidator(String ssn) {
		
		try {
		
		if (ssn.length() != 9) {
			System.out.print("\n*******************************************\n");
			System.out.print("**You have entered an invalid SSN number.**\n");
			System.out.print("*********** Invalid length. ***************\n");
			System.out.print("*******************************************\n");
			return false;
		}
		
		//Checks to see if it's a numeric input 
		@SuppressWarnings("unused")
		double d = Double.parseDouble(ssn); 
		
		//If it is not a numeric input it makes the user retype it
		} catch(NumberFormatException nfe) {
			System.out.print("\n*********************************************\n");
			System.out.print("*****You have entered invalid SSN number*****\n");
			System.out.print("*********************************************\n");
			return false; 
		}

		return true; 
	}
	
	public static boolean stateValidator(String state) {
		String expression = "AK|AL|AR|AZ|CA|CO|CT|DC|DE|FL|GA|HI|IA|ID|IL|IN|KS|KY|LA|MA|MD|ME|MI|MN|MO|MS|MT|NC|ND|NE|NH|NJ|NM|NV|NY|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VA|VT|WA|WI|WV|WY"; 
		
		//Method makes sure that the input state is valid, regardless of case. 
	    state = state.toUpperCase();  
		CharSequence inputStr = state;
         Pattern pattern = Pattern.compile(expression);
         Matcher matcher = pattern.matcher(inputStr);
  
         if (!matcher.matches()) {
		          System.out.print("\n************************************\n");
		          System.out.print("***You have entered invalid State***\n");
		          System.out.print("************************************\n");
		          return false; 
	        }
		return true; 
	}
	
	
	public static boolean typeValidator(String type) {
		String text = "EDUCATION|ENTERTAINMENT|GROCERY|GAS|BILLS|TEST|HEALTHCARE";
		
		//Method makes sure that the input type is one of the ones listed in the menu.
		type = type.toUpperCase(); 
		CharSequence inputStr = type;
        Pattern pattern = Pattern.compile(text);
        Matcher matcher = pattern.matcher(inputStr);
 
        if (!matcher.matches()) {
	          System.out.print("\n***********************************\n");
	          System.out.print("***You have entered invalid Type***\n");
	          System.out.print("***********************************\n");
	          return false; 
        } 
		return true; 
	}
	
	public static boolean phoneValidator(String phone) {
		
		try {
		
			//Makes sure it's 7 places long
			if (phone.length() != 7) {
				System.out.print("\n*******************************************\n");
				System.out.print("*You have entered an invalid Phone Number.*\n");
				System.out.print("*********** Invalid length. ***************\n");
				System.out.print("*******************************************\n");
			return false; 
		} 
		
		//Checks to see if it's a numeric input 
		@SuppressWarnings("unused")
		double d = Double.parseDouble(phone); 
		
		
		} catch(NumberFormatException nfe) {
			System.out.print("\n********************************************\n");
			System.out.print("***You have entered invalid Phone number ***\n");
			System.out.print("********************************************\n");
			return false; 
		}
			return true; 
	}
	
	
	
	public static boolean creditCardValidator(String creditCard) {
		
		try {
		
		if (creditCard.length() != 16) {
			System.out.print("\n*********************************************\n");
			System.out.print("*You have entered an invalid Credit Card NO.*\n");
			System.out.print("************ Invalid length. ****************\n");
			System.out.print("*********************************************\n");
			return false; 
		}
		
		//Makes sure it is a number input
		@SuppressWarnings("unused")
		double d = Double.parseDouble(creditCard); 
		
		
		} catch(NumberFormatException nfe) {
			System.out.print("\n*********************************************\n");
			System.out.print("***You have entered invalid Credit Card NO***\n");
			System.out.print("*********************************************\n");
			return false; 
		}

		return true;
	}
	
	
	public static boolean menuValidator(int input, int firstEntry, int lastEntry) {
		
		//Makes sure that what is input is between the listed menu's first and last entry
		if (input < firstEntry || input > lastEntry) {
			System.out.print("\n******************************************\n");
			System.out.print("*** You have entered invalid selection ***\n");
			System.out.print("******************************************\n");	
			return false; 
		}
	
		return true; 
	}
	
	public static boolean emailValidator(String email) {
		
		//Limits input
		if (email.length() < 1 || email.length() > 40) {
			System.out.print("\n******************************************\n");
			System.out.print("****You have entered an invalid Email.****\n");
			System.out.print("*********** Invalid length. **************\n");
			System.out.print("******************************************\n");
			return false; 
		}
	
		//Expression checks if it's a valid email 
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(email);
 
        if (!matcher.matches()) {
        	System.out.print("\n************************************\n");
			System.out.print("*You have entered an invalid email.*\n");
			System.out.print("************************************\n");	
	        return false; 
        } 
        
        return true;
        	
		}

	
	
}
