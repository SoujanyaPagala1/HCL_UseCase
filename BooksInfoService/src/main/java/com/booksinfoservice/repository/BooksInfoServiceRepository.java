package com.booksinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booksinfoservice.entity.BooksOrderData;

/**
 * @author Soujanya Pagala
 *
 */
public interface BooksInfoServiceRepository extends JpaRepository<BooksOrderData, Long> {

}