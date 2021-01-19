package com.booksitemservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksitemservice.entity.BooksItem;
import com.booksitemservice.exception.BooksItemNotFoundException;
import com.booksitemservice.model.BooksItemReq;
import com.booksitemservice.repository.BooksItemRepository;


/**
 * 
 * @author Soujanya Pagala
 *
 */
@Service
public class BooksItemService {

	private static final Logger LOGGER = LogManager.getLogger(BooksItemService.class);

	@Autowired
	private BooksItemRepository booksItemRepository;

	/**
	 * Get all the Book item details
	 * 
	 * @return
	 */
	public List<BooksItem> getAllbooksItems() {
		LOGGER.info("Inside BooksItemService :: getAllbooksItems Method {} ");
		List<BooksItem> bookItemReq = new ArrayList<>();
		bookItemReq = booksItemRepository.findAll();
		return bookItemReq;
	}

	/**
	 * Save the BookItemdata into Database.
	 * 
	 * @param booksItemReq
	 */
	public BooksItem addBooksItem(BooksItemReq booksItemReq) {
		LOGGER.info("Inside BooksItemService :: addBooksItem Method {} ");
		BooksItem bookItem = new BooksItem();
		BeanUtils.copyProperties(booksItemReq, bookItem);
		BooksItem placedOrderItem = booksItemRepository.save(bookItem);
		return placedOrderItem;
	}

	/**
	 * get the book item details by Id
	 * 
	 * @param id
	 * @return BooksItem
	 * 
	 */
	public BooksItem getBookItemById(long id) {
		LOGGER.info("Inside BooksItemService :: getBookItemById Method {} ");
		return booksItemRepository.findById(id).orElseThrow(() -> new BooksItemNotFoundException());
	}

	/**
	 * Get the bookItems based on ids
	 * 
	 * @param ids
	 * @return Set<BooksItem>
	 * 
	 */
	public Set<BooksItem> getBookItemByBookCode(Set<Long> ids) {
		LOGGER.info("Inside BooksItemService :: getBookItemByIds Method {} ");
		List<BooksItem> items = booksItemRepository.findAllByBookCodeIn(ids);
		return items.stream().collect(Collectors.toSet());
	}
	
}