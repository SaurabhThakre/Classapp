package com.example.classapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class NotificationView extends AppCompatActivity {

    String[] string1 ={"absolutely","beaming","calm","dazzling ","earnest","fabulous","generous","happy","idea","jovial","kind","laugh ",
            "marvelous","natural","one","positive","quality","ready","safe","terrific ","unleashed","valued","warm","xmas","yes","zeal"};
    AutoCompleteTextView ac;
    TextView tv;
    Button btn;
    ProgressBar pb;
    int progress = 0, x = 0, y = 0, z = 0;
    RadioGroup rg;
    CheckBox ck1, ck2, ck3;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifyform);

        ac = findViewById(R.id.etext);
        btn = findViewById(R.id.submited);
        tv = findViewById(R.id.counter);
        pb = findViewById(R.id.progress);
        rg = findViewById(R.id.rdgrp);
        ck1 = findViewById(R.id.cb1);
        ck2 = findViewById(R.id.cb2);
        ck3 = findViewById(R.id.cb3);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,string1);
        ac.setThreshold(1);
        ac.setAdapter(adapter);

        ac.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0)
                    if(y != 1) {
                        progress++;
                        pb.setProgress(progress);
                        y = 1;
                    }
            }

        });


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(z != 1) {
                    progress++;
                    pb.setProgress(progress);
                    z = 1;
                }
            }
        });

        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(x != 1)
                {
                    progress++;
                    pb.setProgress(progress);
                    x = 1;
                }
            }
        });

        ck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(x != 1)
                {
                    progress++;
                    pb.setProgress(progress);
                    x = 1;
                }
            }
        });

        ck3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(x != 1)
                {
                    progress++;
                    pb.setProgress(progress);
                    x = 1;
                }
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                tv.setText(Integer.toString(i));
            }
        });


    }


}
