package myProject1;

import java.util.Scanner;

public class PhoneNumberValidator {
	public static void main(String[] args) {
		/*
		 * Valid number is 10 digits long and does not contain 911 in any parts
		 * make sure correctly formatted with parenthesis and dashes
		 * 
		 * VALID:
		 * 0123456789
		 * (012)  345-6789
		 * 012-345-6789
		 * 
		 * INVALID:
		 * 000911000
		 * (111) 911-2084
		 */
		String number="0911";
		Scanner sc=new Scanner(System.in);
		boolean cont = true;
		while(cont) {
			try {
				sc.reset();
				System.out.println("Enter a phone number: ");
				number = sc.nextLine();
				if(!validNumber(number)) { System.out.println("Invalid Number: " + number + " is not a valid number"); }
				else{ System.out.println(number + " is a valid number"); }
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			cont = continueGame(sc);
			if(!cont) {sc.close();}
		}
		System.out.println("\n------------------------------\nHave a nice day!");
		
	}
	
	
	
	private static boolean continueGame(Scanner sc) {
		System.out.println("Continue (Y\\N)?: ");
		try {
			String cc = sc.nextLine();
			if(cc.toLowerCase().equals("no") || cc.equals('0') || cc.toLowerCase().equals("n")) {
				return false;
			}	
			else if(cc.toLowerCase().equals("yes") || cc.equals('1') || cc.toLowerCase().equals("y")) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Inproper Input. Exiting");
		return false;
	}



	private static boolean validNumber(String num) {
		int size = num.length();
		String numbers="";
		for(int i=0; i<size; i++) {
			if(num.charAt(i) >= '0' && num.charAt(i) <= '9') {
				numbers += num.charAt(i);
			}
		}
		if(numbers.contains("911") || numbers.length() != 10) { return false; }
		return true;
	}
}
