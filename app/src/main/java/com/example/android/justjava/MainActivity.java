package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText nameEditText = (EditText) findViewById(R.id.plain_edit_text);
        Editable name = nameEditText.getText();
        boolean hasChocolate = chocolateCheckBox.isChecked();
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
         price = calculatePrice(hasWhippedCream,hasChocolate);
        displaymessage(createOrderSummary(price,hasWhippedCream,hasChocolate,name));
    }

    private int calculatePrice(boolean addWhippedCream,boolean addChocolate){
        if(addWhippedCream && addChocolate){
            return price = (1+2+5)*quantity;
        }else if(addWhippedCream){
            return price = (1+5)*quantity;
        }else{
            return price = (2+5)*quantity;
        }
    }

    private String createOrderSummary(int price,boolean addWhippedCream,boolean addChocolate,Editable name){
        String priceMessage="Name: "+ name + "\n" + "Add Whipped Cream : "+ addWhippedCream +"\n" + "Add Chocolate : " + addChocolate +"\n"+"Quantity: "+quantity+"\n"+ "Total: $" + price;
        priceMessage = priceMessage + "\n Thank you!";
        return priceMessage;
    }


    public void increment(View view) {
        if(quantity == 100){
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity+1;
        displayQuantity(quantity);
    }
    public void decrement(View view) {
        if(quantity == 1){
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity-1;
        displayQuantity(quantity);
    }

    private void displayQuantity(int numberOfCoffees){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displaymessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText( message);
    }


}
