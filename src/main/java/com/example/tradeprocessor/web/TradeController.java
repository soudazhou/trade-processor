package com.example.tradeprocessor.web;

import com.example.tradeprocessor.service.TradeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TradeController {
    @Autowired
    TradeComparator tradeComparator;

    @RequestMapping(value = "/allTrades", method = RequestMethod.GET)
    public String compareTrades() {
        return "report";
    }
}
