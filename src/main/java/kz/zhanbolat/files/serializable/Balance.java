package kz.zhanbolat.files.serializable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Balance implements Serializable {
    private String currency;
    private BigDecimal amount;
    private BigDecimal exchangeRate;

    public Balance(String currency, BigDecimal amount, BigDecimal exchangeRate) {
        this.currency = currency;
        this.amount = amount;
        this.exchangeRate = exchangeRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return Objects.equals(currency, balance.currency) &&
                Objects.equals(amount, balance.amount) &&
                Objects.equals(exchangeRate, balance.exchangeRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount, exchangeRate);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
