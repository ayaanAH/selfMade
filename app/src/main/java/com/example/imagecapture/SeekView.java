package com.example.imagecapture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekView extends AppCompatActivity
{

    SeekBar seek;
    TextView Mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_view);

        seek=findViewById(R.id.seekM);
        Mood=findViewById(R.id.mood2);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            int seekBarProgress=0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                seekBarProgress=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                Mood.setText(""+seekBarProgress);
                toastMessage(seekBarProgress);
            }
        });

    }

    private void toastMessage(int sliderValue)
    {

        String message="";

        if (sliderValue<=1)
            message="I think you are having a horrible day";

        if (sliderValue < 5 && sliderValue > 1)
            message="Looks like you are not in a very good mood";

        if (sliderValue>=5 && sliderValue<=8)
            message="nice score! have a great day.";

        if (sliderValue>=9)
            message="WOW! looks like your day is going wonderfully";

        Toast.makeText(SeekView.this, message, Toast.LENGTH_LONG).show();

    }
}
