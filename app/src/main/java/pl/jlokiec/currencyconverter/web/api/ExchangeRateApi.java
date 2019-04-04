package pl.jlokiec.currencyconverter.web.api;

import io.reactivex.Single;
import pl.jlokiec.currencyconverter.web.model.ExchangeRate;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ExchangeRateApi {
    String BASE = "base";
    String SYMBOLS = "symbols";

    @GET("latest")
    Single<Response<ExchangeRate>> getExchangeRatesForBase(@Query(BASE) String baseCurrencyCode, @Query(SYMBOLS) String desiredExchangeRates);
}
