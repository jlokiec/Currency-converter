package pl.jlokiec.currencyconverter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.Map;

import io.reactivex.functions.Consumer;
import pl.jlokiec.currencyconverter.converter.CurrencyCodes;
import pl.jlokiec.currencyconverter.converter.CurrencyConverter;
import pl.jlokiec.currencyconverter.converter.CurrencyConverterConfiguration;
import pl.jlokiec.currencyconverter.repository.ExchangeRateRepository;
import pl.jlokiec.currencyconverter.web.model.ExchangeRate;

public class MainViewModel extends ViewModel {
    private ExchangeRateRepository repository;
    private MutableLiveData<Double> conversionResult;

    public MainViewModel() {
        repository = new ExchangeRateRepository();
    }

    public void convertValue(CurrencyCodes baseCurrency, CurrencyCodes targetCurrency, double value) {
        repository.getExchangeRate(baseCurrency, targetCurrency)
                .subscribe(new Consumer<ExchangeRate>() {
                    @Override
                    public void accept(ExchangeRate exchangeRate) throws Exception {
                        String targetCurrencyString = targetCurrency.toString();
                        Map<String, Double> rates = exchangeRate.getRates();

                        if (rates.containsKey(targetCurrencyString)) {
                            double rate = rates.get(targetCurrencyString);
                            CurrencyConverterConfiguration configuration = new CurrencyConverterConfiguration(baseCurrency, targetCurrency, rate);
                            CurrencyConverter converter = new CurrencyConverter(value, configuration);

                            conversionResult.setValue(converter.convert());
                        }
                    }
                });
    }

    public MutableLiveData<Double> getConversionResult() {
        if (conversionResult == null) {
            conversionResult = new MutableLiveData<>();
        }
        return conversionResult;
    }
}
