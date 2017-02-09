package com.example.tradeprocessor.service.impl;

import com.example.tradeprocessor.domain.Trade;
import com.example.tradeprocessor.domain.TradeCurrency;
import com.example.tradeprocessor.service.TradeManager;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVTradeManager implements TradeManager {

    private File loadFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());

    }

    @Override
    public List<Trade> getAllTrades() {

        List<Trade> trades = new ArrayList<>();
        String[] record = null;
        try(CSVReader reader = new CSVReader(new FileReader(loadFile("input/data.csv")), ',', '"', 1)) {
            while ((record = reader.readNext()) != null) {
                Trade trade = new Trade();
                trade.setId(Long.parseLong(record[0]));
                trade.setTrader(record[1].trim());
                trade.setTradeDate(LocalDate.parse(record[2].trim()));
                trade.setTradeCurrency(TradeCurrency.valueOf(record[3].trim()));
                trade.setAmount(new BigDecimal(record[4].trim()));
                trades.add(trade);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(trades);
        return trades;
    }

    @Override
    public void insertTradeintoDb(Trade trade) {

    }
}
