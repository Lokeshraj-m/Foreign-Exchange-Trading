package com.finzly.FXTrading;

import java.util.ArrayList;
import java.util.Scanner;

class BookTrade {
	// To count the Number of Trades Done...
	static int count = 0;

	static void bookTrade() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Customer Name");
		String customerName = input.nextLine().trim();
		// To Prevent the user from providing Numeric Data...
		if (customerName.matches("^[A-Za-z//s]*$")) {
		} else {
			System.out.println("Invalid Customer Name...");
			BookTrade.bookTrade();
		}
		System.out.println("Enter Currency Pair");
		String currencyPair = input.next();
		// In future new currency pairs can add by using this ArrayList...
		ArrayList<String> currencyPairsList = new ArrayList<>();
		currencyPairsList.add("USDINR");
		for (String currencyPairs : currencyPairsList) {
			try {
				// To check the currency pair is exist in the ArrayList.If exists exchange
				// method will goes on.
				if (currencyPairs.equals(currencyPair)) {
					// For different currency pair single exchange method...
					exchange(count, currencyPair, customerName);
				}
			} catch (Exception e) {
				System.out.println("Invalid Currency Pair...\nCurrency Pair Not Found");
				BookTrade.bookTrade();
			}
		}
	}

	static void exchange(int tradeNo, String currencyPair, String customerName) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter amount to transfer");
		float amount = 0;
		try {
			amount = input.nextFloat();
		} catch (Exception e) {
			System.out.println("Invalid Amount...");
			BookTrade.bookTrade();
		}

		System.out.println("Do you want to get Rate(yes/no)?");
		String getRate = input.next();
		// For different currency pairs by use of switch case in future we can edit new
		// currency pair case.
		switch (currencyPair) {
			case ("USDINR"):
				// final is used for fixed rate...
				final double rate = 66.00;
				double inrConverted = amount * rate;
				// checking did user need exchange rate or not...
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
					// Once Trade is booked, the trade details will be added in the ArrayList which
					// exists in Print Trade Class...
					Options.options();
				} else if (tradeConfirmation.equalsIgnoreCase("Cancel")) {
					System.out.println("Trade is cancelled.......");
					Options.options();
				} else {
					System.out.println("Invalid option...\nTrade is Cancelled.");
					BookTrade.bookTrade();
				}
				break;
		}

	}
}
