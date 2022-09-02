package com.finzly.FXTrading;

import java.util.ArrayList;

public class PrintTrade {
	// ArrayList to store trade details once booked.
	static ArrayList<Variables> addList = new ArrayList<>();

	// Method to add the trade details into list.
	static void addTrade(int tradeNo, String currencyPair, String customerName, double amount, double rate) {
		addList.add(new Variables(tradeNo, currencyPair, customerName, amount, rate));
	}

	// Method to print the trade details.
	static void printTrade() {
		System.out.println("   TradeNo     " + "Currency Pairs     " + "Customer Name     " + "Amount    " + "Rate     ");
		if (addList.isEmpty()) {
			System.out.println("-----------No Trades Performmed--------------");
		} else {
			for (Variables printData : addList) {
				System.out.println(printData);
			}
		}
		Options.options();
	}
}
