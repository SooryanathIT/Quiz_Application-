package com.example.unit_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity {
    TextView name;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name=findViewById(R.id.welcome);
        Intent receive=getIntent();
        String s=receive.getStringExtra("Name").toUpperCase();
        name.setText("HELLO "  + s +" ARE YOU READY TO TAKE THE QUIZ?");
        fab=findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Buffer_one.class);
                startActivity(i);
            }
        });

    }
}
