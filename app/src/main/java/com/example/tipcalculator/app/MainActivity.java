package com.example.tipcalculator.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    private NumberFormat tipAmountFormatter = NumberFormat.getCurrencyInstance();
    private float currentTipFactor;

    public void setCurrentTipFactor(float currentTipFactor) {
        this.currentTipFactor = currentTipFactor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void calculateTip(View view){
        setCurrentTipFactor(0f);
        EditText billAmount = (EditText) findViewById(R.id.editText);
        String totalAmount = billAmount.getText().toString();
        totalAmount = totalAmount != null && totalAmount.length() > 0 ? totalAmount : "0";
        TextView tipAmount = (TextView) findViewById(R.id.tTipAmount);
        setCurrentTipFactor(Float.parseFloat(view.getTag().toString()));
        String tip = tipAmountFormatter.format(Double.parseDouble(totalAmount) * currentTipFactor);
        tipAmount.setText(tip);

        //Attach EventHandler
        billAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                TextView tipAmount = (TextView) findViewById(R.id.tTipAmount);
                if(s.length() > 0) {
                    String tip = tipAmountFormatter.format(Double.parseDouble(s.toString()) * currentTipFactor);
                    tipAmount.setText(tip);
                }else{
                    tipAmount.setText(tipAmountFormatter.format(0));
                }
            }
        });
    }
}
