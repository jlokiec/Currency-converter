package pl.jlokiec.currencyconverter.converter;

public class CurrencyConverter {
    private double input;
    private CurrencyConverterConfiguration configuration;

    public CurrencyConverter(double input, CurrencyConverterConfiguration configuration) {
        this.input = input;
        this.configuration = configuration;
    }

    public double convert() {
        return input * configuration.getRate();
    }
}
