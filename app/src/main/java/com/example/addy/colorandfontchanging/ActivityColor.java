package com.example.addy.colorandfontchanging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityColor extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button sendColor;
    public final int MENU_BLUE = 0;
    public final int MENU_RED = 1;
    public final int MENU_GREEN = 2;
    int choice = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        textView = findViewById(R.id.text);

        sendColor = findViewById(R.id.btnSendColor);
        sendColor.setOnClickListener(this);
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.text:{
                menu.add(0, MENU_BLUE, 0, "blue");
                menu.add(0, MENU_RED, 0, "red");
                menu.add(0, MENU_GREEN, 0, "green");
                break;
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int result = -1;
        switch (item.getItemId()){
            case MENU_BLUE:
                result = MENU_BLUE;
                break;
            case MENU_RED:
                result = MENU_RED;
                break;
            case MENU_GREEN:
                result = MENU_GREEN;
                break;
            default:
                break;
        }
        choice = result;
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("color", choice);
        setResult(RESULT_OK, intent);
        finish();
    }
}
