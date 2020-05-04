package com.example.unit_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class Buffer_one extends AppCompatActivity {
        RingProgressBar r1,r2;
        int progress=0;
        Handler handler=new Handler(){
@Override
public void handleMessage(Message msg)
        {
            if(msg.what==0)
            {
                if(progress<100)
                {
                    progress++;
                    r1.setProgress(progress);
                    r2.setProgress(progress);
                }
            }
        }
        };
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffer_one);
        r1=findViewById(R.id.pbar);
        r2=findViewById(R.id.pbar2);
        r1.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {
                Toast.makeText(getApplicationContext(),"Hold on for few more secs!",Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),Query.class);
                startActivity(i);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++)
                {
                    try {
                        Thread.sleep(42);
                        handler.sendEmptyMessage(0);
                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        }
        }
