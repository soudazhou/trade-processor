package com.example.tradeprocessor.persistence;

import com.example.tradeprocessor.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepo extends JpaRepository<Trade, Integer> {

}
