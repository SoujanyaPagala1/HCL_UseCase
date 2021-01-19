package com.booksinfoservice.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.booksinfoservice.entity.BooksOrderData;
import com.booksinfoservice.exception.BooksOrderNotFoundException;
import com.booksinfoservice.model.BooksItem;
import com.booksinfoservice.model.BooksReq;
import com.booksinfoservice.repository.BooksInfoServiceRepository;

@Service
public class BooksInfoService {

	private static final Logger LOGGER = LogManager.getLogger(BooksInfoService.class);

	@Autowired
	BooksInfoServiceRepository booksInfoServiceRepository;

	@Autowired
	BooksItemFeignClientProxy booksItemFeignClientProxy;

	/*
	 * Save order details into Database
	 * 
	 * @param BooksReq
	 * @return BooksOrderData
	 * 
	 * */
	@Transactional
	public BooksOrderData createOrderedBooks(@RequestBody BooksReq booksReq) {
		LOGGER.info("--- Enter into BooksInfoService :: createdOrderedBooks {} ");
		Set<Long> totalItemIds = new HashSet<>();
		BooksOrderData booksOrderedData = new BooksOrderData();
		
		if(!booksReq.getTotalItemIds().isEmpty())
		{
			totalItemIds = booksReq.getTotalItemIds();
			// Calling the another booksItemService to check weather the given bookorderItem is present or not
			Set<BooksItem> totalItems = booksItemFeignClientProxy.getBooksItemByIds(totalItemIds);
			if (totalItems.size() != totalItemIds.size()) {
				throw new BooksOrderNotFoundException();
			}
		}
		BeanUtils.copyProperties(booksReq, booksOrderedData);
		booksOrderedData.setTotalItemIds(totalItemIds);
		booksOrderedData.setBookDate(new Date());
		LOGGER.info("Exited from BooksInfoService :: createOrderedBooks {} ");
		return booksInfoServiceRepository.save(booksOrderedData);
	}

	/**
	 * Get ordered book details with matching ID .
	 * 
	 * @param long ID
	 * @return booksOrderData
	 */
	public BooksOrderData getOrderedBookById(long id) {
		LOGGER.info("Fetching the books order data for given id");
		return booksInfoServiceRepository.findById(id).orElseThrow(() -> new BooksOrderNotFoundException());
	}

	/**
	 * Get the all ordered book details .
	 * 
	 * @return List<BooksOrderData>
	 * 
	 */
	public List<BooksOrderData> getAllOrderedBooks() {
		LOGGER.info("Fetching all the books order Details from Database ");
		return booksInfoServiceRepository.findAll();
	}

}
