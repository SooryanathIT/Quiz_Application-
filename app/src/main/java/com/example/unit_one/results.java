package com.example.unit_one;

import androidx.appcompat.app.AppCompatActivity;
import com.example.unit_one.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class results extends AppCompatActivity {
    TextView scores;
    FloatingActionButton fab;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent=getIntent();
        int res=intent.getIntExtra("res",0);
        scores=findViewById(R.id.resbox);
        videoView=findViewById(R.id.vbox);
        fab=findViewById(R.id.bbox);
        getWindow().setFormat(PixelFormat.UNKNOWN);
        String path="android.resource://"+getPackageName()+"/"+R.raw.n;
        Uri uri=Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        scores.setText("YOU'VE SCORED "+String.valueOf(res) + "\nOUTTA 10 !");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(1);
            }
        });


    }
}
