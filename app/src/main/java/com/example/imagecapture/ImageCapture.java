package com.example.imagecapture;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageCapture extends Activity
{
    public static final int IMG_REQUEST=9999;
    ImageView photoDisplay;
    Button capturePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_capture);

        photoDisplay=findViewById(R.id.photo);
        capturePhoto=findViewById(R.id.capturePic);

        capturePhoto.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent imgIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(imgIntent,IMG_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==IMG_REQUEST)
        {
            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            photoDisplay.setImageBitmap(bitmap);
        }

    }
}
