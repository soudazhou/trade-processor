package com.example.trade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Trade {
    @Id
    @GeneratedValue
    Long id;
    String trader;
    LocalDate tradeDate;
    TradeCurrency tradeCurrency;
    BigDecimal amount;


    public Trade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public TradeCurrency getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(TradeCurrency tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
