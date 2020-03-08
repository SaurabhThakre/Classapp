package com.example.classapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    Button button, button1;
    EditText et, tv;
    CharSequence str = "Null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.popup);

        tv = findViewById(R.id.text);
        et = findViewById(R.id.edit);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Activity2.this, button);
                popup.getMenuInflater().inflate(R.menu.dialog_signin, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.one) {
                            str = tv.getText();
                        } else if (id == R.id.two) {
                            tv.setText(str);
                        }
                        Toast.makeText(Activity2.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup1 = new PopupMenu(Activity2.this, button1);
                popup1.getMenuInflater().inflate(R.menu.dialog_signin, popup1.getMenu());

                popup1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.one) {
                            str = et.getText();
                        } else if (id == R.id.two) {
                            et.setText(str);
                        }
                        Toast.makeText(Activity2.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup1.show();
            }
        });
    }
}
