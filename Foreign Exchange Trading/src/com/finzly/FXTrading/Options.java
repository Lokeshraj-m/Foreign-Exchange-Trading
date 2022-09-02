package com.finzly.FXTrading;

import java.util.Scanner;

public class Options {
	static void options() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Select the Valid Option");
		System.out.println("Book Trade - 1");
		System.out.println("Print Trade - 2");
		System.out.println("Exit - 3");
		String code = input.next();
		switch (code) {
			case ("1"):
				//Method to Book the Trade...
				BookTrade.bookTrade();       
			break;
			case ("2"):
				//Method to Print the List of Trade...
				PrintTrade.printTrade();     
			break;
			case ("3"):
				//Method to Exit the console...
				Exit.exit();                 
			break;
			default:
				System.out.println("Invalid option...\nSelect valid option"); 
				// Method to Print the List of Options like Book Trade, Print Trade and EXIT.
				Options.options();
		}
	}
}
