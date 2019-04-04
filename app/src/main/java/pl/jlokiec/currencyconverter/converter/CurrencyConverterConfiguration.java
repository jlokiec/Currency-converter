package pl.jlokiec.currencyconverter.converter;

public class CurrencyConverterConfiguration {
    private CurrencyCodes baseCurrency;
    private CurrencyCodes targetCurrency;
    private double rate;

    public CurrencyConverterConfiguration(CurrencyCodes baseCurrency, CurrencyCodes targetCurrency, double rate) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.rate = rate;
    }

    public CurrencyCodes getBaseCurrency() {
        return baseCurrency;
    }

    public CurrencyCodes getTargetCurrency() {
        return targetCurrency;
    }

    public double getRate() {
        return rate;
    }
}
