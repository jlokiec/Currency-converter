package pl.jlokiec.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeSpinners();
    }

    private void initializeSpinners() {
        Spinner spinnerCurrencyFrom = findViewById(R.id.spinner_currency_from_code);
        Spinner spinnerCurrencyTo = findViewById(R.id.spinner_currency_to_code);

        ArrayAdapter<CharSequence> currencyCodesAdapter = ArrayAdapter.createFromResource(this, R.array.currency_codes, android.R.layout.simple_spinner_item);
        currencyCodesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCurrencyFrom.setAdapter(currencyCodesAdapter);
        spinnerCurrencyTo.setAdapter(currencyCodesAdapter);
    }
}
