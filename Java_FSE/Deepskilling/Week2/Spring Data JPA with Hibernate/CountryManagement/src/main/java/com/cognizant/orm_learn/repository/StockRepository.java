package com.cognizant.orm_learn.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);
}
