package com.example.tradeprocessor.service;

import com.example.tradeprocessor.domain.Trade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface TradeLoader {

    public List<Trade> getAllTrades() throws IOException;
}
