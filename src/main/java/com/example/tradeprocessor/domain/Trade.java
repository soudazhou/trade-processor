package com.example.tradeprocessor.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Trade {
    @Id
    @GeneratedValue
    @Column(name="ID", nullable=false, unique=true, length=11)
    private Long id;
    private String trader;
    //@Column(columnDefinition = "DATETIME")
    @CreatedDate
    private LocalDate tradeDate;
    @Enumerated(EnumType.STRING)
    private TradeCurrency tradeCurrency;
    private BigDecimal amount;


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

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", trader='" + trader + '\'' +
                ", tradeDate=" + tradeDate +
                ", tradeCurrency=" + tradeCurrency +
                ", amount=" + amount +
                '}';
    }
}
