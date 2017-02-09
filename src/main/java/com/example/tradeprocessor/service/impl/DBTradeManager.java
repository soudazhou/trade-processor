package com.example.tradeprocessor.service.impl;

import com.example.tradeprocessor.domain.Trade;
import com.example.tradeprocessor.persistence.TradeRepo;
import com.example.tradeprocessor.service.TradeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBTradeManager implements TradeManager {
    @Autowired
    TradeRepo tradeRepo;

    public List<Trade> getAllTrades() {
        return tradeRepo.findAll();
    }

    @Override
    public void insertTradeintoDb(Trade trade) {
        tradeRepo.save(trade);
    }
}
