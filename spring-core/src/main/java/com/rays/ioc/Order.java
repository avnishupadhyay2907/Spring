package com.rays.ioc;

public class Order {

	private Inventery inventery;
	private Payment payment;

	public void setInventery(Inventery inventery) {
		this.inventery = inventery;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void order(int item) {

		int perItem = 100;

		int totalAmount = item * perItem;

		int remainingAmt = payment.pay(totalAmount);

		int remainingBooks = inventery.sold(item);

		System.out.println("amount paid: " + totalAmount);
		System.out.println("book ordered: " + item);
		System.out.println("remaining amt: " + remainingAmt);
		System.out.println("remaining book: " + remainingBooks);

	}

}
