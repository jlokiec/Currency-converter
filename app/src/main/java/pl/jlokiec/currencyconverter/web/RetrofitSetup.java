package pl.jlokiec.currencyconverter.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pl.jlokiec.currencyconverter.web.api.ExchangeRateApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSetup {
    private Retrofit retrofit;

    public RetrofitSetup(String baseUrl) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public ExchangeRateApi getExchangeRateApi() {
        return retrofit.create(ExchangeRateApi.class);
    }
}
