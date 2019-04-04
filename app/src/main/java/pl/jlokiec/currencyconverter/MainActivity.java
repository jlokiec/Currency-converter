package pl.jlokiec.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import pl.jlokiec.currencyconverter.converter.CurrencyCodes;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private TextView txtConvertedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeSpinners();
        setupViewModel();

        txtConvertedValue = findViewById(R.id.lbl_converted_value);
        findViewById(R.id.btn_convert).setOnClickListener(this::convert);
    }

    private void initializeSpinners() {
        Spinner spinnerCurrencyFrom = findViewById(R.id.spinner_currency_from_code);
        Spinner spinnerCurrencyTo = findViewById(R.id.spinner_currency_to_code);

        ArrayAdapter<CharSequence> currencyCodesAdapter = ArrayAdapter.createFromResource(this, R.array.currency_codes, android.R.layout.simple_spinner_item);
        currencyCodesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCurrencyFrom.setAdapter(currencyCodesAdapter);
        spinnerCurrencyTo.setAdapter(currencyCodesAdapter);
    }

    private void setupViewModel() {
        viewModel = new MainViewModel();
        viewModel.getConversionResult().observe(this, conversionResult -> {
            String convertedValueFormatted = String.format("%.2f", conversionResult);
            txtConvertedValue.setText(convertedValueFormatted);
        });
    }

    private void convert(View view) {
        Spinner spinnerCurrencyFrom = findViewById(R.id.spinner_currency_from_code);
        Spinner spinnerCurrencyTo = findViewById(R.id.spinner_currency_to_code);

        String currencyFrom = spinnerCurrencyFrom.getSelectedItem().toString();
        String currencyTo = spinnerCurrencyTo.getSelectedItem().toString();

        CurrencyCodes baseCurrency = CurrencyCodes.valueOf(currencyFrom);
        CurrencyCodes targetCurrency = CurrencyCodes.valueOf(currencyTo);

        String userInput = ((EditText) findViewById(R.id.txt_currency_from_value)).getText().toString();
        double valueToConvert = Double.valueOf(userInput);
        viewModel.convertValue(baseCurrency, targetCurrency, valueToConvert);
    }
}
