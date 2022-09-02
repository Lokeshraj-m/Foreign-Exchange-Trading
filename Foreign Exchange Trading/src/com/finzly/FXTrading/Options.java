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
		int code = input.nextInt();
		switch (code) {
			case (1):
				BookTrade.bookTrade();
			break;
			case (2):
				PrintTrade.printTrade();
			break;
			case (3):
				Exit.exit();
			break;
			default:
				System.out.println("Invalid option...\nSelect valid option");
				Options.options();
		}
	}
}
