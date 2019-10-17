package com.example.jusjavacoffee;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
  //VARIABLES
    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//SUBMIT AFTER USER CLICKS SUBMIT BUTTON
public void submitOrder(View view) {
    // Figure out if the user wants whipped cream topping
    CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
    boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
    // Calculate the price
    int price = calculatePrice();

    // Display the order summary on the screen
    String message = createOrderSummary(price, hasWhippedCream);
    displayMessage(message);
}
//CALCULATES PRICE TO THE USER
    private int calculatePrice() {
        return quantity * 5;

    }
//DISPLAY TO USER
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
//ORDER SUMMERY METHOD THAT TAKES PRICE AS A ARG
    private String createOrderSummary(int price,boolean addWhippedCream ) {
        String priceMessage = "Name: Newton Kamau";
        priceMessage = priceMessage + "\nAdd whipped cream" + addWhippedCream;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal :$" + price;

        priceMessage = priceMessage + "\n Thank you customer, we value you";
        displayMessage(priceMessage);

        return priceMessage;
    }
//INCREASES BY ONE
    public void increment(View view) {
        display(quantity = quantity + 1);
    }
//DECREASES BY ONE
    public void decrement(View view) {
        display(quantity = quantity - 1);

    }
    //DISPLAY MESSAGE METHOD
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summery_text_view);
        priceTextView.setText(message);
    }




}

