package com.booksinfoservice.service;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.booksinfoservice.model.BooksItem;
import com.booksinfoservice.model.BooksReq;

/**
 * 
 * @author Soujanya Pagala
 *
 *         This class is inter service communication between booksitemservice
 */
@FeignClient(name = "http://booksitemservice/BooksItemReq/")
public interface BooksItemFeignClientProxy {

	@GetMapping("/retriveBooksItem")
	public List<BooksReq> getAllBooksItems();

	@PostMapping("/placeBooksItem")
	public BooksItem saveBookItem(@RequestBody BooksItem bookItem);

	@GetMapping("/BooksItemById")
	public BooksItem getBooksItemById(@RequestParam("id") long id);

	@GetMapping("/BooksItemByIds")
	public Set<BooksItem> getBooksItemByIds(@RequestParam("ids") Set<Long> ids);
}