package com.example.classapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    public static int x = 0;
    ConstraintLayout cl;
    LinearLayout ll;
    Button bt, tb, list, popup, notify;
    int i = 0;
    TextView tv;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_main);


        cl = findViewById(R.id.outlayout);
        ll = findViewById(R.id.linlayout);
        bt = findViewById(R.id.play);
        tb = findViewById(R.id.toggle);
        list = findViewById(R.id.list);
        tv = findViewById(R.id.txt);
        popup = findViewById(R.id.popup);
        notify = findViewById(R.id.notify);

    }

    public void notifytext(View v) {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public void pop(View v) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }


    public void dialog1(View view) {

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog prdialog = new ProgressDialog(MainActivity.this, R.style.AlertDialogCustom);
                prdialog.setMax(100);
                prdialog.setMessage("Please wait...");
                prdialog.setTitle("Downloading the File");
                prdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                prdialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                Toast.makeText(getBaseContext(), "OK clicked!", Toast.LENGTH_SHORT).show();
                            }
                        });
                prdialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                Toast.makeText(getBaseContext(), "Cancel clicked!", Toast.LENGTH_SHORT).show();
                            }
                        });
                prdialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (prdialog.getProgress() <= prdialog.getMax()) {
                                Thread.sleep(200);
                                prdialog.incrementProgressBy(5);
                                if (prdialog.getProgress() == prdialog.getMax()) {
                                    prdialog.dismiss();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });


    }


    public void theme(View v) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, R.style.AlertDialogCustom);
        alertDialogBuilder.setMessage("Are you sure, You want to Change Theme");

        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

                if (x == 0) {
                    tb.setText("Light Theme");
                    cl.setBackgroundColor(Color.parseColor("#1F1B24"));
                    tb.setBackgroundColor(Color.parseColor("#BB86FC"));
                    bt.setBackgroundColor(Color.parseColor("#BB86FC"));
                    popup.setBackgroundColor(Color.parseColor("#BB86FC"));
                    notify.setBackgroundColor(Color.parseColor("#BB86FC"));
                    list.setBackgroundColor(Color.parseColor("#BB86FC"));
                    tb.setTextColor(Color.parseColor("#000000"));
                    bt.setTextColor(Color.parseColor("#000000"));
                    popup.setTextColor(Color.parseColor("#000000"));
                    notify.setTextColor(Color.parseColor("#000000"));
                    list.setTextColor(Color.parseColor("#000000"));
                    tv.setTextColor(Color.parseColor("#00ff00"));
                    //Status Bar Color
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#BB86FC"));
                    x = 1;
                } else {
                    tb.setText("Dark Theme");
                    cl.setBackgroundColor(Color.parseColor("#BBDEFB"));
                    tb.setBackgroundColor(Color.parseColor("#00897B"));
                    bt.setBackgroundColor(Color.parseColor("#00897B"));
                    popup.setBackgroundColor(Color.parseColor("#00897B"));
                    notify.setBackgroundColor(Color.parseColor("#00897B"));
                    list.setBackgroundColor(Color.parseColor("#00897B"));
                    tb.setTextColor(Color.parseColor("#ffffff"));
                    bt.setTextColor(Color.parseColor("#ffffff"));
                    popup.setTextColor(Color.parseColor("#ffffff"));
                    notify.setTextColor(Color.parseColor("#ffffff"));
                    list.setTextColor(Color.parseColor("#ffffff"));
                    tv.setTextColor(Color.parseColor("#800080"));
                    // Status Bar Color
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#00897B"));
                    x = 0;
                }

                Toast.makeText(MainActivity.this, "You clicked yes button", Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You clicked no button", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    public void list(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a day");

        String[] animals = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        builder.setMultiChoiceItems(animals, null, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int item, boolean isChecked) {
                i++;
                tv.setText("You have selected " + i + " items");
            }
        });


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();

    }


}
