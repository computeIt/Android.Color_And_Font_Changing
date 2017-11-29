package com.example.addy.colorandfontchanging;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button btnColor, btnFont;
    public int COLOR = 1;
    public int FONT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        btnColor = findViewById(R.id.btnColor);
        btnFont = findViewById(R.id.btnFont);

        btnColor.setOnClickListener(this);
        btnFont.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnColor) {
            intent = new Intent(this, ActivityColor.class);
            startActivityForResult(intent, COLOR);
        } else if (v.getId() == R.id.btnFont) {
            intent = new Intent(this, ActivityFont.class);
            startActivityForResult(intent, FONT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null)
            return;
        if (resultCode != RESULT_OK)
            return;

        if (requestCode == COLOR) {
            int color = data.getIntExtra("color", -1);
            switch (color){
                case 0:
                    textView.setTextColor(Color.BLUE);
                    break;
                case 1:
                    textView.setTextColor(Color.RED);
                    break;
                case 2:
                    textView.setTextColor(Color.GREEN);
                    break;
                default:
                    break;
            }

        } else if (requestCode == FONT){

            int font = data.getIntExtra("font", 0);
            textView.setPaintFlags(0);
            switch (font){
                case 0: {//это уже второй раз хардкод, и так неприлично, но никто этого не увидит
                    textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                    break;
                }
                case 1: {
                    textView.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                    break;
                }
                case 2:{
                    textView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
                    break;
                }
                default:
                    break;
            }
        }
    }
}
