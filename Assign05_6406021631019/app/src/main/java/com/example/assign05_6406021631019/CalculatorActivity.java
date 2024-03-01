package com.example.assign05_6406021631019;

import androidx.appcompat.app.AppCompatActivity;
// เรียกใช้ฟังชั่นต่างๆที่จำเป็น
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    public TextView resultTextView; //ประกาศตัวแปล
    public StringBuilder numberBuilder; //ประกาศตัวแปล
    public double firstValue, secondValue; //ประกาศตัวแปล
    public char operator;

    public ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout); //ดึงค่าตัวแปล

        resultTextView = findViewById(R.id.textView3); //ดึงค่าตัวแปล
        numberBuilder = new StringBuilder();

        // set OnClickListener ให้กับปุ่ม ตัวเลข
        findViewById(R.id.numButtom0).setOnClickListener(this);
        findViewById(R.id.numButtom1).setOnClickListener(this);
        findViewById(R.id.numButtom2).setOnClickListener(this);
        findViewById(R.id.numButtom3).setOnClickListener(this);
        findViewById(R.id.numButtom4).setOnClickListener(this);
        findViewById(R.id.numButtom5).setOnClickListener(this);
        findViewById(R.id.numButtom6).setOnClickListener(this);
        findViewById(R.id.numButtom7).setOnClickListener(this);
        findViewById(R.id.numButtom8).setOnClickListener(this);
        findViewById(R.id.numButtom9).setOnClickListener(this);
        findViewById(R.id.numButtomDot).setOnClickListener(this);

        // Set OnClickListener ให้กับปุ่ม คำณวน
        findViewById(R.id.plusBtn).setOnClickListener(this);
        findViewById(R.id.minusBtn).setOnClickListener(this);
        findViewById(R.id.multiplyBtn).setOnClickListener(this);
        findViewById(R.id.divideBtn).setOnClickListener(this);

        // Set OnClickListener ให้กับปุ่ม เท่ากับ(=) เครียค่า(ac)
        findViewById(R.id.equalToBtn).setOnClickListener(this);
        findViewById(R.id.acBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String buttonText = ((Button) v).getText().toString();

        //เช็คการทำงานว่ากดปุ่มไหนจะได้เรียกฟังชั่นถูก
        if (buttonText.matches("[0-9.]")) {
            handleNumberClick(buttonText);//เก็บค่าตัวเลข
        } else if (buttonText.matches("[+\\-x%]")) {
            handleOperatorClick(buttonText.charAt(0));
        } else if (v.getId() == R.id.equalToBtn) {
            calculateResult(); //ฟังชั่นในการคำณวน
        } else if (v.getId() == R.id.acBtn) {
            clear(); //ฟังชั่นเครียค่า
        }
    }

    private void handleNumberClick(String num) {  //เก็บค่าตัวเลข
        numberBuilder.append(num);
        resultTextView.setText(numberBuilder.toString());
    }

    private void handleOperatorClick(char op) { //เก็บค่า Operator
        if (numberBuilder.length() > 0) {
            firstValue = Double.parseDouble(numberBuilder.toString());
            numberBuilder.setLength(0);
            operator = op;
        }
    }

    private void calculateResult() { //ฟังชั่นในการคำณวน
        if (numberBuilder.length() > 0) {
            secondValue = Double.parseDouble(numberBuilder.toString());
            double result = 0;
            if (operator == '+') {
                result = firstValue + secondValue;
            } else if (operator == '-') {
                result = firstValue - secondValue;
            } else if (operator == 'x') {
                result = firstValue * secondValue;
            } else if (operator == '%') {
                if (secondValue != 0) {
                    result = firstValue / secondValue;
                } else {
                    resultTextView.setText("Error");
                    return;
                }
            }
            resultTextView.setText(String.valueOf(result));
            numberBuilder.setLength(0);
        }
    }

    private void clear() { //ฟังชั่นเครียค่า
        numberBuilder.setLength(0);
        resultTextView.setText("0");
        firstValue = 0;
        secondValue = 0;
        operator = '\u0000';
    }



    //สร้าง OptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // เรียกใช้ OptionsMenu
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if(item.getItemId() == R.id.Calculator){ //ถ้าคริกปุ่มนี้ .Calculator จะไป CalculatorActivity
            Toast.makeText( this, "AutoComplete", Toast.LENGTH_SHORT).show();
            Intent launchAdapterViewFipper = new Intent(this,CalculatorActivity.class);
            startActivity(launchAdapterViewFipper);
            return true;
        }
        else if(item.getItemId() == R.id.MatchingGame){ //ถ้าคริกปุ่มนี้ MatchingGame จะไป MatchingGameActivity
            Toast.makeText( this, "MatchingGameActivity", Toast.LENGTH_SHORT).show();
            Intent launchAdapterViewFipper = new Intent(this,MatchingGameActivity.class);
            startActivity(launchAdapterViewFipper);
            return true;
        }
        else if(item.getItemId() == R.id.exit){ //ถ้าคริกปุ่มนี้ exit จะไปกลับไปหน้า main menu
            Toast.makeText( this, "Exit", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        else
        {return super.onOptionsItemSelected(item);}

    }
}