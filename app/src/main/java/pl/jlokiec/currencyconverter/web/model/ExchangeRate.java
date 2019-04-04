package pl.jlokiec.currencyconverter.web.model;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {
    private String base;
    private Map<String, Double> rates;
    private String date;

    public ExchangeRate() {
        rates = new HashMap<>();
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "base='" + base + '\'' +
                ", rates=" + rates +
                ", date='" + date + '\'' +
                '}';
    }
}
