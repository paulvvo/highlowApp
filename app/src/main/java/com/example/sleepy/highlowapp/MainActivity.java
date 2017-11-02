package com.example.sleepy.highlowapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static Random rand = new Random();
    static int randomNum = rand.nextInt(20 - 1 + 1) -1;

    public void numberCheck (View view){
        EditText numGuessEditText = (EditText)findViewById(R.id.numGuessEditText);
        try{
            if (Integer.parseInt(numGuessEditText.getText().toString()) > 20 || Integer.parseInt(numGuessEditText.getText().toString()) < 1 ){
                Toast.makeText(MainActivity.this, "The number should be in between 1 and 20", Toast.LENGTH_SHORT).show();
            }else if(Integer.parseInt(numGuessEditText.getText().toString()) > randomNum){
                Toast.makeText(MainActivity.this, "Lower!", Toast.LENGTH_SHORT).show();
            }else if(Integer.parseInt(numGuessEditText.getText().toString()) < randomNum) {
                Toast.makeText(MainActivity.this, "HIGHER!", Toast.LENGTH_SHORT).show();
            }else if(Integer.parseInt(numGuessEditText.getText().toString()) == randomNum){
                Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                randomNum = rand.nextInt(20 - 1 + 1) -1;
            }
        }catch(Exception e){
            Toast.makeText(MainActivity.this, "Please Only Enter In Numbers", Toast.LENGTH_SHORT).show();
            Log.i("Info", "Type Error");
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
