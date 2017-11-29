package com.example.addy.colorandfontchanging;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityFont extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button btnSendFont;
    int choice = -1;
    public final int BOLD = 0;
    final int ITALIC = 1;
    final int UNDERLINE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);

        textView = findViewById(R.id.text);
//        textView.setTypeface(null, Typeface.BOLD);
        btnSendFont = findViewById(R.id.btnSendFont);
        btnSendFont.setOnClickListener(this);
        registerForContextMenu(textView);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("font", choice);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId() == R.id.text){
            menu.add(0, BOLD, 0, "ЖЫРНЫЙ");
            menu.add(0, ITALIC, 0, "КУРСИВ ?");
            menu.add(0, UNDERLINE, 0, "ПОДЧЕРКНУТЬ");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int result = item.getItemId();
//        switch(item.getItemId()){ //по уму, конечно, надо бы так
//            case BOLD:
//                result = BOLD;
//                break;
//            case ITALIC:
//                result = ITALIC;
//                break;
//            case UNDERLINE:
//                result = UNDERLINE;
//                break;
//            default:
//                break;
//        }
        choice = result;
        return super.onContextItemSelected(item);
    }
}
