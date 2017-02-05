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

    @Override
    public String compareTrades() {
        List<Trade> dbTrades = dbTradeLoader.getAllTrades();
        List<Trade> csvTrades = csvTradeLoader.getAllTrades();
        //compare
        StringBuilder sb = new StringBuilder();
        sb.append("Comparison Report: ");
        sb.append("\n");
        sb.append("List of Db trades: ");
        sb.append("\n");
        for (Trade trade : dbTrades) {
            sb.append(trade);
            sb.append(System.getProperty("line.separator"));
        }
        sb.append("List of csv trades: \n");
        sb.append(System.getProperty("line.separator"));
        for (Trade trade : csvTrades) {
            sb.append(trade);
            sb.append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }

    @Override
    public List<Trade> getAllCSVTrades() {
        return csvTradeLoader.getAllTrades();
    }

    @Override
    public List<Trade> getAllDatabaseTrades() {
        return dbTradeLoader.getAllTrades();
    }
}
