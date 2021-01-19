package com.booksitemservice.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booksitemservice.entity.BooksItem;

/**
 * @author Soujanya Pagala
 *
 */

public interface BooksItemRepository extends JpaRepository<BooksItem, Long> {

	List<BooksItem> findAllByBookCodeIn(Set<Long> productCode);

}
