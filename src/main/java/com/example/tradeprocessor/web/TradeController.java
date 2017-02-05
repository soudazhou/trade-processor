package com.example.tradeprocessor.web;

import com.example.tradeprocessor.domain.Trade;
import com.example.tradeprocessor.service.TradeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TradeController {
    @Autowired
    TradeComparator tradeComparator;

    @RequestMapping(value = "/allTrades", method = RequestMethod.GET)
    public String compareTrades(Model model) {
        List<Trade> csvTrades = tradeComparator.getAllCSVTrades();
        List<Trade> dbTrades = tradeComparator.getAllDatabaseTrades();
        model.addAttribute("csvTrades", csvTrades);
        model.addAttribute("dbTrades", dbTrades);
        return "report";
    }
}
