package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}