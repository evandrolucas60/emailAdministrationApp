package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	private String companySuffix = "gamecompany.com";
	private int mailBoxCapacity = 500;
	private int defaultPasswordLength = 10;

	// constructor
	public Email() {};
	public Email(String firstname, String lastName) {
		this.firstName = firstname;
		this.lastName = lastName;

		
		System.out.println("New worker: " + this.firstName + " " + this.lastName);
		//check if the worker has an alternate email
		checkAlternateEmail();
		
		// call a method asking for the department - return the department
		this.department = setDepartment();
		System.out.println("Department: " + this.department);

		// call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);

		// combine elements to generate email
		email = firstname.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		System.out.println();

		

	}
	
	//Alternate email checkout
	private void checkAlternateEmail() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Do you have any email address (Y/N): ");
		char yesORNo = sc.next().charAt(0);
		String altEmail = null;
		
		if(yesORNo == 'y') {
			System.out.print("Please, Enter your email: ");
			altEmail = sc.next();
			setAlternateEmail(altEmail);			
		} else {
			setAlternateEmail(altEmail);
		}
	}
	
	// Ask for department
	private String setDepartment() {
		System.out.println();
		System.out.print(
				"DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "sales";
		} else if (depChoice == 2) {
			return "dev";
		} else if (depChoice == 3) {
			return "acct";
		} else {
			return "";
		}
	}

	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// Set mailBox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}

	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public String showInfo() {
				if (getAlternateEmail() != null) {
					return "DISPLAY NAME: " + firstName + " " + lastName +
					"\nCOMPANY EMAIL: " + email +
					"\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb" +
					"\nALTERNATE EMAIL: " + alternateEmail;
				} else {
					return "DISPLAY NAME: " + firstName + " " + lastName +
							"\nCOMPANY EMAIL: " + email +
							"\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
				}
	}

}
