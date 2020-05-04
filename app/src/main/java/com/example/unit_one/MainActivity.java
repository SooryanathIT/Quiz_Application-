package com.example.unit_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,passkey;
    Button signin,signup;
    TextView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.text1);

        signin=findViewById(R.id.button);

        header=findViewById(R.id.header);
        GradientDrawable gradientDrawable=new GradientDrawable();//for shape settings
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(Color.TRANSPARENT);
        gradientDrawable.setStroke(5,Color.WHITE);
        user.setBackground(gradientDrawable);

        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(user.hasFocus())
                   user.setHint("");
                else
                    user.setHint("Hogwards_Id");
            }
        });

        /*signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().length()!=0 && passkey.getText().length()!=0)
                {
                    String a=user.getText().toString();
                    int num1=Integer.parseInt(a);
                    String b=passkey.getText().toString();
                    int num2=Integer.parseInt(b);
                    int res=num1+num2;
                    Toast.makeText(getApplicationContext(),res+" is the result",Toast.LENGTH_LONG).show();
                }
              if(user.getText().length()==0)
                {
                    user.setError("enter the number ");
                }
                 if(passkey.getText().length()==0)
                {
                    passkey.setError("enter the number ");
                }
            }
        });*/
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Home.class);
                if(user.getText().length()!=0 )
                {
                    i.putExtra("Name",user.getText().toString());
                    startActivity(i);
                }
                if(user.getText().length()==0)
                {
                    user.setError("enter the name ");
                }


            }
        });


    }
}
