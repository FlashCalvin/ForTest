package com.calvin.guess;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.nfc.Tag;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int secret = new Random().nextInt(10) + 1;
    int counter;
    private EditText edNumber;
    private int num;
    private TextView ds;
    private TextView edCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("mainActive","secret number : " + secret);
        edNumber = findViewById(R.id.number);
        edCounter = findViewById(R.id.counter);
        edCounter.setText(counter+"");
        ds = findViewById(R.id.desription);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reset();
            }
        });
    }

    public void reset(){
        edCounter.setText("");
        edNumber.setText("");
    }

    public void guess(final View view){
        num = Integer.parseInt(edNumber.getText().toString());
        counter++;

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        };

        if (num < secret){
            ds.setText("太小了啦，沒有感覺");
            Toast.makeText(MainActivity.this, "太小了啦，沒有感覺",Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("認真猜好不好")
                    .setMessage("大一點啦，丁能兒 ")
                    .setPositiveButton("凶屁喔",null)
                    .show();
        }else if (num > secret){
            ds.setText("太大會頂到");
            Toast.makeText(MainActivity.this, "太大會頂到",Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("給我認真猜")
                    .setMessage("小一點，真的很鬼翊耶")
                    .setPositiveButton("好啦",null)
                    .show();

        }else{
            ds.setText("我們天生交合");
            Toast.makeText(MainActivity.this, "我們天生交合",Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("吼吼齁")
                    .setMessage("JOLIHI")
                    .setPositiveButton("Bingo",  listener)
                    .show();
                    };



        }



    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
