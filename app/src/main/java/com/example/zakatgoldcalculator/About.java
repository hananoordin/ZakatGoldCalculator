package com.example.zakatgoldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class About extends AppCompatActivity {
    private ImageView  ws, ws1, github;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ImageView jiv_link=(ImageView) findViewById(R.id.ws);
        jiv_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlws="https://wa.link/u1l7yq";
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(urlws));
                startActivity(i);
            }
        });
        ImageView jiv1_link=(ImageView) findViewById(R.id.ws1);
        jiv1_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlws1="https://wa.link/ibk2zo";
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(urlws1));
                startActivity(i);
            }
        });
        ImageView jiv2_link=(ImageView) findViewById(R.id.github);
        jiv2_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlgithub="https://github.com/MrAntiFun11/Zakat_Apps";
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(urlgithub));
                startActivity(i);
            }
        });


    }
}