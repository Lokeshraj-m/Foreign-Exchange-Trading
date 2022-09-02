package com.finzly.FXTrading;

import java.util.ArrayList;
import java.util.Scanner;

class BookTrade {
	static int count = 0;
	static void bookTrade() {
		System.out.println("Enter Customer Name");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String customerName = input.nextLine().trim();
		System.out.println("Enter Currency Pair");
		String currencyPair = input.next();
		ArrayList<String> currencyPairsList = new ArrayList<>();
		currencyPairsList.add("USDINR");
		for (String currencyPairs : currencyPairsList) {
			if (currencyPairs.equals(currencyPair)) {
				exchange(count, currencyPair, customerName);
			} else {
				System.out.println("Invalid Currency Pair...\nCurrency Pair Not Found");
				BookTrade.bookTrade();
			}
		}
	}
	static void exchange(int tradeNo, String currencyPair, String customerName) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter amount to transfer");
		float amount = input.nextFloat();
		System.out.println("Do you want to get Rate(yes/no)?");
		String getRate = input.next();
		switch (currencyPair) {
			case ("USDINR"):
				final double rate = 66.00;
				double inrConverted = amount * rate;
				if (getRate.equalsIgnoreCase("Yes")) {
					System.out.println("You are transferring INR " + inrConverted + " to " + customerName + "."
							+ "(Assuming that rate was " + rate + ")");
				} else if (getRate.equalsIgnoreCase("no")) {
					System.out.println("ok...");
				} else {
					System.out.println("Invalid option...\n Re-Enter the Details...");
					BookTrade.bookTrade();
				}
				System.out.println("Book/Cancel this trade?");
				String tradeConfirmation = input.next();
				if (tradeConfirmation.equalsIgnoreCase("Book")) {
					BookTrade.count++;
					System.out.println("Trade for USDINR has been booked with rate " + rate + "," + "The amount of RS "
							+ inrConverted + " will be transferred in 2 working days to " + customerName + ".");
					PrintTrade.addTrade(count, currencyPair, customerName, inrConverted, rate);
					Options.options();
				} else if (tradeConfirmation.equalsIgnoreCase("Cancel")) {
					System.out.println("Trade is cancelled.");
					Options.options();
				} else {
					System.out.println("Invalid option... Trade is Cancelled.");
					BookTrade.bookTrade();
				}
				break;
		}

	}
}
