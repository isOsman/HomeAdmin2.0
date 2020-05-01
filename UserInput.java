package com.osman.homeadmin;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for handling user input<br>  
 * Since System.in is implemets the Closeable interface
 * then when you close the scanner - System.in closes - the main thread
 * and we can no longer
 * therefore, one scanner for the entire program - the program for the spell and the program after exiting the program
*/
public class UserInput {
	
	//open scanner in start 
	//for read chars and lines
	private Scanner scanner;
	
	//constructor
	public UserInput() {
		this.scanner =  new Scanner(System.in);
	}
	
	//constructor with param - Scanner,if scanner already open
	public UserInput(Scanner scan) {
		this.scanner = scan;
	}
	
	
	//getter
	public Scanner getScanner() {
		return this.scanner;
	}
	
	//setter
	public void setScanner(Scanner scan) {
		this.scanner = scan;
	}
	
	
	//closes scanner,and also closes System.in
	 void closeScan() {
		//close scanner in the end 
		this.scanner.close();
	}
	  
	 
	//closes scanner when this object destroyed by gc 
	@Override
	protected void finalize() throws Throwable {
		this.scanner.close();
		super.finalize();
	}
	
	//return trimmed user line
	 String getUserLine(String title) {
		boolean exit=false;	
		String userStr="";
		while(!exit){//a loop is needed to get a non-empty string
			System.out.println("Enter "+title);
			userStr=scanner.nextLine().trim();//get line
			if(userStr.length() == 0) //if line is empty
				System.out.println("Repeat enter");
			else 
				exit = true;			
		}
		return userStr;	
	}
	
	 
	//return user char
	 char getUserChar() { return getUserLine("").charAt(0); }
	
	
	//return user num 
	 int getUserNum(String title) {
		int num = -1;
		boolean exit = false;
		while(!exit){
			try {
				num = Integer.parseInt(getUserLine(title));
				exit = true;
			}catch(NumberFormatException |InputMismatchException e) {
				System.out.println("Repeat enter");
			}
		}	
		return num;
	}
	
	

	
}
