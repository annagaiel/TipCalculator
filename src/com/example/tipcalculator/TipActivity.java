package com.example.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipActivity extends Activity {
	private EditText totalBill;
	private TextView totalTip;
	private Button tenPercent;
	private Button fifteenPercent;
	private Button twentyPercent;
	boolean validNumber= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
    }
    
    public void calculateTip(View v){
    	double numBill = 0;
    	double numTotalTip = 0;
        Button tipChoice = (Button)v;
      
    	totalBill = (EditText) findViewById(R.id.totalBill);
    	totalTip = (TextView) findViewById(R.id.totalTip);
    	tenPercent = (Button) findViewById(R.id.tenPercent);
    	fifteenPercent = (Button) findViewById(R.id.fifteenPercent);
    	twentyPercent = (Button) findViewById(R.id.twentyPercent);
    	
    	checkBillPrice();
    	
    	if(validNumber){
    	numBill = Double.parseDouble(totalBill.getText().toString());
    	
    	switch(tipChoice.getText().toString()){
    	
    	case "10%":
    		numTotalTip= numBill * (.10);
    		break;
    	case "15%":
    		numTotalTip= numBill * (.15);
    		break;
    	case "20%":
    		numTotalTip= numBill * (.20);
    		break;
    	default:
    		throw new IllegalArgumentException("Invalid tip percent");
    	}
    	
        totalTip.setText("Tip is: $ "+ Double.toString(numTotalTip));
    	}else{
    	totalTip.setText("ERROR: Please enter a valid number");
    	}//end of validNumber
    }

    private void checkBillPrice() {
    	try{
    		Integer.parseInt(totalBill.getText().toString());
    		validNumber=true;
    	}catch(Exception e){
    		validNumber=false;
    	}
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip, menu);
        return true;
    }


}
