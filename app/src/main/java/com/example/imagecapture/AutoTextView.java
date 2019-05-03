package com.example.imagecapture;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class AutoTextView extends Activity
{
    private static final String[] TEAMSLIST = new String[] {"Barcelona", "Juventus", "Real Madrid", "Manchesters United", "PSG", "Liverpool", "Bayern München", "Atlético Madrid", "Manchester City"};
    AutoCompleteTextView teams;
    Button getTxt;
    TextView displayTxt;
    String search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_text_view);
        getTxt=findViewById(R.id.btnGet);
        displayTxt=findViewById(R.id.textview1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, TEAMSLIST);
        teams = findViewById(R.id.autoTxt);
        teams.setAdapter(adapter);

        getTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                search= teams.getText().toString();
                displayTxt.setText(search);
            }
        });

    }
}
