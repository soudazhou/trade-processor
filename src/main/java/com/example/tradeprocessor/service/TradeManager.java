package com.example.tradeprocessor.service;

import com.example.tradeprocessor.domain.Trade;

import java.io.IOException;
import java.util.List;

public interface TradeManager {

    public List<Trade> getAllTrades() throws IOException;

    void insertTradeintoDb(Trade trade);
}
