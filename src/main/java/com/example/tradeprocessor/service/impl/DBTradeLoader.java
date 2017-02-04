package com.example.tradeprocessor.service.impl;

import com.example.tradeprocessor.domain.Trade;
import com.example.tradeprocessor.persistence.TradeRepo;
import com.example.tradeprocessor.service.TradeLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBTradeLoader implements TradeLoader {
    @Autowired
    TradeRepo tradeRepo;

    public List<Trade> getAllTrades() {
        return tradeRepo.findAll();
    }
}
