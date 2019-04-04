package pl.jlokiec.currencyconverter.repository;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pl.jlokiec.currencyconverter.converter.CurrencyCodes;
import pl.jlokiec.currencyconverter.web.RetrofitSetup;
import pl.jlokiec.currencyconverter.web.api.ExchangeRateApi;
import pl.jlokiec.currencyconverter.web.model.ExchangeRate;

public class ExchangeRateRepository {
    private static final String API_URL = "https://api.exchangeratesapi.io/";

    private ExchangeRateApi api;

    public ExchangeRateRepository() {
        api = new RetrofitSetup(API_URL).getExchangeRateApi();
    }

    public Single<ExchangeRate> getExchangeRate(CurrencyCodes baseCurrency, CurrencyCodes targetCurrency) {
        return api.getExchangeRatesForBase(baseCurrency.toString(), targetCurrency.toString())
                .map(response -> response.body())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
