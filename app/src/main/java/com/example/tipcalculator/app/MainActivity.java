package com.example.tipcalculator.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

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
        EditText billAmount = (EditText) findViewById(R.id.editText);
        TextView tipAmount = (TextView) findViewById(R.id.tTipAmount);
        float tipFactor = 0f;
        switch (view.getId()){
            case R.id.btn10pc:
                tipFactor = 0.1f;
                break;
            case R.id.btn15pc:
                tipFactor = 0.15f;
                break;
            case R.id.btn20pc:
                tipFactor = 0.2f;
                break;
        }
        tipAmount.setText(String.valueOf(Integer.parseInt(billAmount.getText().toString()) * tipFactor));
    }
}
