package com.booksinfoservice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Soujanya Pagala
 *
 */
@Entity
@Table(name = "BOOKS_ORDER_DATA")
public class BooksOrderData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookorderId;

	private String customerName;

	private Date bookDate;

	private String shippingAddress;

	private double totalPrice;
	
	@ElementCollection(targetClass = Long.class)
	public Set<Long> totalItemIds;

	public long getBookorderId() {
		return bookorderId;
	}

	public void setBookorderId(long bookorderId) {
		this.bookorderId = bookorderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
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