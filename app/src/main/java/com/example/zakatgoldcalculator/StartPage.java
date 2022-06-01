package com.example.zakatgoldcalculator;

import static com.example.zakatgoldcalculator.R.layout.*;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StartPage extends AppCompatActivity implements View.OnClickListener{
    private TextView zakat,zpay,zvalue;
    private EditText gram,type,price;
    private Button calculate, about,reset;
    SharedPreferences sharedPref;
    SharedPreferences sharedPref2;
    float weight;
    float current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_start_page);

        zakat=(TextView) findViewById(R.id.zakat);
        zpay=(TextView) findViewById(R.id.zpay);
        zvalue=(TextView) findViewById(R.id.zvalue);
        gram=(EditText) findViewById(R.id.gram);
        type=(EditText) findViewById(R.id.type);
        price=(EditText) findViewById(R.id.price);
        calculate=(Button) findViewById(R.id.calculate);
        about=(Button) findViewById(R.id.about);
        reset=(Button) findViewById(R.id.reset);

        calculate.setOnClickListener(this);
        reset.setOnClickListener(this);

        sharedPref = this.getSharedPreferences("weight", Context.MODE_PRIVATE);
        weight = sharedPref.getFloat("weight", 0.0F);

        sharedPref2 = this.getSharedPreferences("price", Context.MODE_PRIVATE);
        current= sharedPref2.getFloat("price", 0.0F);

        gram.setText(""+weight);
        price.setText(""+current);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAbout();
            }
        });
    }
    public void openAbout(){
        Intent intent =new Intent(this, About.class);
        startActivity(intent);
    };

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {

                case R.id.calculate:
                    calc();
                    break;

                case R.id.reset:
                    gram.setText("");
                    price.setText("");
                    zakat.setText("");
                    zpay.setText("");
                    zvalue.setText("");

                    break;

            }
        } catch (java.lang.NumberFormatException nfe) {
            Toast.makeText(this, "Incomplete input!", Toast.LENGTH_SHORT).show();

        } catch (Exception exp) {
            Toast.makeText(this,"Unknown Exception" + exp.getMessage(),Toast.LENGTH_SHORT).show();

            Log.d("Exception",exp.getMessage());

        }
    }

    public void calc(){

        float weight = Float.parseFloat(gram.getText().toString());
        String cate = type.getText().toString();
        float current = Float.parseFloat(price.getText().toString());
        double t=0, pay=0, value=0,u=0;
        int k=85, w=200;
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat("weight", weight);
        editor.apply();
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putFloat("price", current);
        editor2.apply();

        value=weight*current;
        zvalue.setText(Double.toString(value));

        if(cate.equals("keep") ){

            pay=(weight-k)*current;}

        else if (cate.equals("wear")){

            pay=(weight-w)*current;


        }
        t=pay*0.025;
        zpay.setText(Double.toString(pay));
        zakat.setText(Double.toString(t));
    }
    }

