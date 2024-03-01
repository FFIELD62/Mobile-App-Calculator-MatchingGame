package com.example.assign05_6406021631019;
// เรียกใช้ฟังชั่นต่างๆที่จำเป็น
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout; //ประกาศตัวแปล

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout); //ดึงค่าตัวแปล
    }

    public void buttonClick1(View v) {  //เซ็ตให้เมื่อกดปุ่นจะไปหน้า CalculatorActivity
        //ประกาศข้อความว่าไปหน้าไหน
        Toast.makeText( this, "CalculatorActivity", Toast.LENGTH_SHORT).show();
        Intent launchAdapterViewFipper = new Intent(this,CalculatorActivity.class);
        startActivity(launchAdapterViewFipper);
    }
    public void buttonClick2(View v) { //เซ็ตให้เมื่อกดปุ่นจะไปหน้า MatchingGameActivity
        //ประกาศข้อความว่าไปหน้าไหน
        Toast.makeText( this, "MatchingGameActivity", Toast.LENGTH_SHORT).show();
        Intent launchAdapterViewFipper = new Intent(this,MatchingGameActivity.class);
        startActivity(launchAdapterViewFipper);
    }
    public void buttonClick3(View v) { //เซ็ตให้เมื่อกดปุ่นกลับหน้า
        //ประกาศข้อความว่าออก
        Toast.makeText( this, "Exit", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        if(item.getItemId() == R.id.Calculator){
            Toast.makeText( this, "AutoComplete", Toast.LENGTH_SHORT).show();
            Intent launchAdapterViewFipper = new Intent(this,CalculatorActivity.class);
            startActivity(launchAdapterViewFipper);
            return true;
        }
        else if(item.getItemId() == R.id.MatchingGame){
            Toast.makeText( this, "MatchingGameActivity", Toast.LENGTH_SHORT).show();
            Intent launchAdapterViewFipper = new Intent(this,MatchingGameActivity.class);
            startActivity(launchAdapterViewFipper);
            return true;
        }
        else if(item.getItemId() == R.id.exit){
            Toast.makeText( this, "Exit", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        else
        {return super.onOptionsItemSelected(item);}

    }
}