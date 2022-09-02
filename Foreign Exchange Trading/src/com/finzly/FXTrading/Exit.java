package com.finzly.FXTrading;

import java.util.Scanner;

class Exit {
	// Method to exit the console...
	static void exit() {
		System.out.println("Do you really want to exit(y/n)?");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String exit = input.next();
		// condition for exit confirmation...
		try {
			if (exit.equalsIgnoreCase("y")) {
				System.out.println("Bye - Have a Nice Day...");
			} else if (exit.equalsIgnoreCase("n")) {
				Options.options();
			} else {
				System.out.println("Invalid Option...\nEnter the valid option...");
				Exit.exit();
			}
		} catch (Exception e) {

			System.out.println("Invalid Option...\nEnter the valid option...");
			Exit.exit();
		}
	}

}
