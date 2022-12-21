package emailapp;

import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Email em1;
		
		System.out.println("Please, enter with your data: ");
		System.out.print("First name: ");
		String firstName = sc.nextLine();
		System.out.print("Last name: ");
		String lastName = sc.nextLine();
	
		System.out.println();
		em1 = new Email(firstName, lastName);
		System.out.println(em1.showInfo()); 
		
		sc.close();
	}

}
