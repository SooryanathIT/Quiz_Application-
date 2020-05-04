package com.example.unit_one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;
import java.util.List;

import static android.graphics.Color.*;
import static maes.tech.intentanim.CustomIntent.customType;

public class questionh extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    //TextView Question;
    //TextView timer;
    RadioGroup Options;
    //RadioButton a,b,c,d;
    Button one,two,three,four;
    TextView question,timer;
    FloatingActionButton btn;


    int right=0;
    int wrong=0;
    int total=1;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionh);


        btn=findViewById(R.id.next);
        final GradientDrawable gradientDrawable=new GradientDrawable();
        gradientDrawable.setStroke(5, WHITE);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setCornerRadius((float) 15);
        int colorsa[]={Color.parseColor("#79FF79"),Color.parseColor("#00DB00")};
        gradientDrawable.setColors(colorsa);

        final GradientDrawable gradientDrawablew=new GradientDrawable();
        gradientDrawablew.setStroke(5, WHITE);
        gradientDrawablew.setShape(GradientDrawable.RECTANGLE);
        gradientDrawablew.setCornerRadius((float) 15);
        int colorsw[]={Color.parseColor("#FA8072"),Color.parseColor("#FF2800")};
        gradientDrawablew.setColors(colorsw);


        question=(TextView)findViewById(R.id.questions);
        one=findViewById(R.id.one);
        two= findViewById(R.id.two);
        three= findViewById(R.id.three);
        four=findViewById(R.id.four);
        final int[] next = {0};
        final int[] set = {0};
        final model[] m = new model[1];


        reference=FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(8));
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                m[0] = dataSnapshot.getValue(model.class);
                one.setText(m[0].getOption1());
                two.setText(m[0].getOption2());
                three.setText(m[0].getOption3());
                four.setText(m[0].getOption4());
                question.setText(m[0].getQuestion());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set[0]==0) {
                    set[0]=1;next[0]=1;
                    if (one.getText().toString().equals(m[0].getAnswer())) {
                        one.setBackground(gradientDrawable);right++;
                        Toast.makeText(getApplicationContext(), "Right!!", Toast.LENGTH_LONG).show();


                    } else {
                        one.setBackground(gradientDrawablew);
                        Toast.makeText(getApplicationContext(), "OOPS!!", Toast.LENGTH_LONG).show();
                        if (two.getText().toString().equals(m[0].getAnswer())) {
                            two.setBackground(gradientDrawable);
                        } else if (three.getText().toString().equals(m[0].getAnswer())) {
                            three.setBackground(gradientDrawable);
                        } else {
                            four.setBackground(gradientDrawable);
                        }

                    }
                }

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set[0]==0) {
                    set[0]=1;next[0]=1;
                    if (two.getText().toString().equals(m[0].getAnswer())) {
                        two.setBackground(gradientDrawable);right++;
                        Toast.makeText(getApplicationContext(), "Right!!", Toast.LENGTH_LONG).show();


                    } else {
                        two.setBackground(gradientDrawablew);
                        Toast.makeText(getApplicationContext(), "OOPS!!", Toast.LENGTH_LONG).show();
                        if (one.getText().toString().equals(m[0].getAnswer())) {
                            one.setBackground(gradientDrawable);
                        } else if (three.getText().toString().equals(m[0].getAnswer())) {
                            three.setBackground(gradientDrawable);
                        } else {
                            four.setBackground(gradientDrawable);
                        }

                    }
                }

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set[0]==0) {
                    set[0]=1;next[0]=1;
                    if (three.getText().toString().equals(m[0].getAnswer())) {
                        three.setBackground(gradientDrawable);right++;
                        Toast.makeText(getApplicationContext(), "Right!!", Toast.LENGTH_LONG).show();


                    } else {
                        three.setBackground(gradientDrawablew);
                        Toast.makeText(getApplicationContext(), "OOPS!!", Toast.LENGTH_LONG).show();
                        if (one.getText().toString().equals(m[0].getAnswer())) {
                            one.setBackground(gradientDrawable);
                        } else if (two.getText().toString().equals(m[0].getAnswer())) {
                            two.setBackground(gradientDrawable);
                        } else {
                            four.setBackground(gradientDrawable);
                        }

                    }
                }

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set[0]==0) {
                    set[0]=1;next[0]=1;
                    if (four.getText().toString().equals(m[0].getAnswer())) {
                        four.setBackground(gradientDrawable);right++;
                        Toast.makeText(getApplicationContext(), "Right!!", Toast.LENGTH_LONG).show();


                    } else {
                        four.setBackground(gradientDrawablew);
                        Toast.makeText(getApplicationContext(), "OOPS!!", Toast.LENGTH_LONG).show();
                        if (one.getText().toString().equals(m[0].getAnswer())) {
                            one.setBackground(gradientDrawable);
                        } else if (two.getText().toString().equals(m[0].getAnswer())) {
                            two.setBackground(gradientDrawable);
                        } else {
                            three.setBackground(gradientDrawable);
                        }

                    }
                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next[0]==1)
                {
                    Intent i=new Intent(questionh.this,questioni.class);
                    Intent j=getIntent();
                    int res=j.getIntExtra("res",0);
                    right=res+right;
                    i.putExtra("res",
                            right);
                    startActivity(i);
                    customType(questionh.this,"Right To Left");

                }
            }
        });




    }



}
