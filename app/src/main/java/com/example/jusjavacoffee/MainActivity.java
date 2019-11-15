package com.example.jusjavacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
        //Find the users's name
        EditText nameField = (EditText) view.findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //Figure out is the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

    // Calculate the price
    int price = calculatePrice(hasWhippedCream, hasChocolate);

    // Display the order summary on the screen
    String message = createOrderSummary(price, hasWhippedCream, hasChocolate);
    Intent intent = new Intent(Intent.ACTION_SENDTO);
    intent.setData(Uri.parse("mailto:"));

    intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
    intent.putExtra(Intent.EXTRA_TEXT, + price);
    if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    }

    displayMessage(message);

}


    /**
     * calculates the price of the order
     *
     * @param addWhippedCream checks whether the user wants whipped cream topping
     * @param addChocolate checks whether the user wants chocolate topping
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;
        if (addWhippedCream){
            basePrice = basePrice + 1;
        }
        if(addChocolate){
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;

    }
//DISPLAY TO USER
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
//ORDER SUMMERY METHOD THAT TAKES PRICE AS A ARG
    private String createOrderSummary(int price,boolean addWhippedCream, boolean chocolate ) {
        String priceMessage = "Name "  ;
        priceMessage = priceMessage + "\nAdd whipped cream; " + addWhippedCream;
        priceMessage = priceMessage + "\n Added chocolate: " + chocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal :$" + price;

        priceMessage = priceMessage + "\n Thank you customer, we value you";
        displayMessage(priceMessage);

        return priceMessage;
    }
//INCREASES BY ONE
    public void increment(View view) {
        if (quantity == 100){
            Toast.makeText(this, "You cannot order more than 100 cups at once",Toast.LENGTH_SHORT).show();
            return ;
        }
        display(quantity = quantity + 1);
    }
//DECREASES BY ONE
public void decrement(View view) {
    if (quantity == 1) {
        // Show an error message as a toast
        Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
        // Exit this method early because there's nothing left to do
        return;
    }
    quantity = quantity - 1;
    display(quantity);
}
    //DISPLAY MESSAGE METHOD
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summery_text_view);
        priceTextView.setText(message);
    }




}

