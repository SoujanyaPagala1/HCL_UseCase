package com.booksinfoservice.model;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Soujanya Pagala
 *
 */
public class BooksReq {

	@NotNull
	@Size(min = 3, message = "Name should be atlease 3 characters ")
	private String customerName;

	@NotNull
	private Date bookDate;
	
	@NotNull
	private String shippingAddress;
	
	@NotNull
	private double totalPrice;

	@NotNull
	public Set<Long> totalItemIds;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<Long> getTotalItemIds() {
		return totalItemIds;
	}

	public void setTotalItemIds(Set<Long> totalItemIds) {
		this.totalItemIds = totalItemIds;
	}
	
}