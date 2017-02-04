package com.example.tradeprocessor.service.impl;

import com.example.tradeprocessor.domain.Trade;
import com.example.tradeprocessor.domain.TradeCurrency;
import com.example.tradeprocessor.service.TradeLoader;
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
public class CSVTradeLoader implements TradeLoader {

    private File loadFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());

    }

    @Override
    public List<Trade> getAllTrades() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(loadFile("inputfiles/data.csv")), ',' , '"' , 1);

        List<Trade> trades = new ArrayList<>();
        String[] record = null;

        while ((record = reader.readNext()) != null) {
            Trade trade = new Trade();
            trade.setId(Long.parseLong(record[0]));
            trade.setTrader(record[1]);
            trade.setTradeDate(LocalDate.parse(record[2]));
            trade.setTradeCurrency(TradeCurrency.valueOf(record[3]));
            trade.setAmount(new BigDecimal(record[4]));
            trades.add(trade);
        }
        System.out.println(trades);
        reader.close();
        return trades;
    }
}
