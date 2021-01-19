package com.booksitemservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booksitemservice.entity.BooksItem;
import com.booksitemservice.model.BooksItemReq;
import com.booksitemservice.service.BooksItemService;

/**
 * @author Soujanya Pagala
 *
 */
@RestController
@RequestMapping("/BooksItemReq")
public class BooksItemController {

	private static final Logger LOGGER = LogManager.getLogger(BooksItemController.class);

	@Autowired
	BooksItemService booksItemService;

	/**
	 * This method will return all the book Item details .
	 * 
	 * @return
	 */
	@GetMapping("/retriveBooksItem")
	public ResponseEntity<List<BooksItem>> getAllBooksItems() {
		LOGGER.info("BooksItemController :: Received Request ....");
		List<BooksItem> booksItemList = new ArrayList<BooksItem>();
		booksItemList = booksItemService.getAllbooksItems();
		return new ResponseEntity<>(booksItemList, HttpStatus.OK);
	}

	/**
	 * This method will save the item details into Database
	 * 
	 * @param booksItemReq
	 */
	@PostMapping("/placeBooksItem")
	public ResponseEntity<BooksItem> saveBookItem(@Valid @RequestBody BooksItemReq booksItemReq) {
		LOGGER.info("BooksItemController :: Received Request ....");
		BooksItem booksItem = booksItemService.addBooksItem(booksItemReq);
		return new ResponseEntity<>(booksItem, HttpStatus.OK);
	}

	/**
	 * Fetching booksItemsBy id equals
	 * @param id
	 * @return
	 */
	@GetMapping("/BooksItemById")
	public ResponseEntity<BooksItem> getBookItemById(@RequestParam("id") long id) {
		LOGGER.info("BooksItemController :: Received Request :: getBooksItemById: " + id);
		BooksItem booksItemReq = booksItemService.getBookItemById(id);
		return new ResponseEntity<>(booksItemReq, HttpStatus.OK);
	}

	/**
	 * Fetching the booksItemsBy bookCode
	 * @param ids
	 * @return
	 */
	@GetMapping("/BooksItemByIds")
	public ResponseEntity<Set<BooksItem>> getBookItemByIds(@RequestParam("ids") Set<Long> ids) {
		LOGGER.info("BooksItemController :: Received Request ::  getBookItemByIds: " + ids.toString());
		Set<BooksItem> booksItems = booksItemService.getBookItemByBookCode(ids);
		return new ResponseEntity<>(booksItems, HttpStatus.OK);

	}
}
