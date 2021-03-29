package com.c19;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Goodhealth extends AppCompatActivity {
    TextView output;
    float result = MainActivity.getScore();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodhealth);
        output = (TextView) findViewById(R.id.textView);
        Log.i("result good: ", String.valueOf(result));
        output.setText("You're in good Health, Your result is " + (int) result + "%");
        Button btn_exit = findViewById(R.id.button);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("button clicked", "ok"); // debugging msg
                AlertDialog.Builder builder = new AlertDialog.Builder(Goodhealth.this);
                builder.setTitle("Do you want to exit?")
                        .setMessage("Click yes to exit or No to start again")
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("No clicked", "ok"); // debugging msg
                                openActivity();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finishAffinity();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }
    private void openActivity() {
        Intent intent = new Intent(this, Note.class);
        startActivity(intent);
    }

}
