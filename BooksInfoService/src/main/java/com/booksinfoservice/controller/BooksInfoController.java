package com.booksinfoservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booksinfoservice.entity.BooksOrderData;
import com.booksinfoservice.model.BooksReq;
import com.booksinfoservice.service.BooksInfoService;
import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @author Soujanya Pagala
 *
 */
/**
 * In this class have the all the methods related to BooksService
 */
@RestController
@RequestMapping("/books")
public class BooksInfoController {

	private static final Logger LOGGER = LogManager.getLogger(BooksInfoController.class);

	@Autowired
	BooksInfoService booksInfoService;

	/**
	 * It will return the all books Data
	 * 
	 * @return BooksOrderData
	 */
	@HystrixCommand(fallbackMethod = "getFallBackBooksOrderDataAll")
	@GetMapping("")
	public ResponseEntity<List<BooksOrderData>> getAllBooks() {
		LOGGER.info("Enter into  OrderInfoController : getAllBooks method {} ");
		List<BooksOrderData> booksDataList = new ArrayList<BooksOrderData>();
		booksDataList = booksInfoService.getAllOrderedBooks();
		return new ResponseEntity<>(booksDataList, HttpStatus.OK);
	}
	
	 public List<BooksOrderData> getFallBackBooksOrderDataAll() {
		 return Lists.newArrayList();
	 }

	/**
	 * Save the BooksData into Database with given books request
	 * 
	 * @param booksReqInfo
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<BooksOrderData> saveOrder(@RequestBody BooksReq booksReq) {
		LOGGER.info("Enter into  BooksInfoController : saveOrder method {} ");

		BooksOrderData placeBook = booksInfoService.createOrderedBooks(booksReq);
		return new ResponseEntity<>(placeBook, HttpStatus.OK);
	}
	 
	/**
	 * getting the book details by orderId
	 * 
	 * @param id
	 * @return BooksData
	 */
	@HystrixCommand(fallbackMethod = "getFallBackBooksOrderData")
	@GetMapping("/{bookorderId}")
	public ResponseEntity<BooksOrderData> getBookItemById(@PathVariable("id") long id) {
		LOGGER.info("Enter into  BooksInfoController : getBookItemById method {} ");
		BooksOrderData bookData = booksInfoService.getOrderedBookById(id);
		return new ResponseEntity<>(bookData, HttpStatus.OK);
	}
	
	  public BooksOrderData getFallBackBooksOrderData(long bookorderId) {
		  BooksOrderData data = new BooksOrderData();
		  data.setBookorderId(-1);
		  data.setCustomerName("FallBack Method gets called");
		  data.setShippingAddress("N/A");
		  return data;
	  }
}