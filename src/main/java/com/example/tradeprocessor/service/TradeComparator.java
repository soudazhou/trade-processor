package com.example.tradeprocessor.service;

import com.example.tradeprocessor.domain.Trade;

import java.util.List;

public interface TradeComparator {
   public String compareTrades();

   List<Trade> getAllCSVTrades();

   List<Trade> getAllDatabaseTrades();
}
