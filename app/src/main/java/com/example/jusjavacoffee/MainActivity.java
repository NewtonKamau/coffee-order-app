package com.example.jusjavacoffee;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
   int quantity = 0;
   String priceMessage = "free";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view) {
       int price = quantity * 5;
        String priceMessage = "Total $" + price;
        priceMessage = priceMessage + "\n Thank you";
        displayMessage(priceMessage);

//        display(quantity);
//        displayPrice(quantity* 5);
    }
    private void display(int number) {
        TextView quantityTextView =  findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }
    public void increment(View view){
      display(quantity = quantity + 1);
    }
    public void decrement(View view){
        display(quantity = quantity - 1);

    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
