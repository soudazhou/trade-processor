package com.example.tradeprocessor.service.impl;

import com.example.tradeprocessor.domain.Trade;
import com.example.tradeprocessor.service.TradeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTradeComparator implements TradeComparator {
    @Autowired
    CSVTradeManager csvTradeManager;
    @Autowired
    DBTradeManager dbTradeManager;

    @Override
    public String compareTrades() {
        List<Trade> dbTrades = dbTradeManager.getAllTrades();
        List<Trade> csvTrades = csvTradeManager.getAllTrades();
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
        return csvTradeManager.getAllTrades();
    }

    @Override
    public List<Trade> getAllDatabaseTrades() {
        return dbTradeManager.getAllTrades();
    }

    @Override
    public void insertTradeintoDb(Trade trade) {
        dbTradeManager.insertTradeintoDb(trade);
    }
}
