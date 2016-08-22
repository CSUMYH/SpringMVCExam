package com.mao.hand.Beans;

import java.sql.Timestamp;
import java.util.Date;

public class Payment {
private int payment_id;
private int customer_id;
private int staff_id;
private double amount;
private Date payment_date;
private Timestamp last_update;
public int getPayment_id() {
	return payment_id;
}
public void setPayment_id(int payment_id) {
	this.payment_id = payment_id;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public int getStaff_id() {
	return staff_id;
}
public void setStaff_id(int staff_id) {
	this.staff_id = staff_id;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Date getPayment_date() {
	return payment_date;
}
public void setPayment_date(Date payment_date) {
	this.payment_date = payment_date;
}
public Timestamp getLast_update() {
	return last_update;
}
public void setLast_update(Timestamp last_update) {
	this.last_update = last_update;
}


}
