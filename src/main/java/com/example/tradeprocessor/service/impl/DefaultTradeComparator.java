package com.example.tradeprocessor.service.impl;

import com.example.tradeprocessor.domain.Trade;
import com.example.tradeprocessor.service.TradeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTradeComparator implements TradeComparator {
    @Autowired
    CSVTradeLoader csvTradeLoader;
    @Autowired
    DBTradeLoader dbTradeLoader;

    public void compareTrades() {
        List<Trade> dbTrades = dbTradeLoader.getAllTrades();
        List<Trade> csvTrades = csvTradeLoader.getAllTrades();
        //compare

    }
}
