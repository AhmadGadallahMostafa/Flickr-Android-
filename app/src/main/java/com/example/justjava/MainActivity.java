package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import static android.app.Activity.RESULT_OK;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private static final int Request_Img_View=101 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.Imageview);

    }
    public void camera(View view)
    {

        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(imageTakeIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(imageTakeIntent,Request_Img_View);
        }
    }
    @Override
    protected void onActivityResult(int RequestCode,int resultCode,Intent data) {
        super.onActivityResult(RequestCode, resultCode, data);
        if (RequestCode == Request_Img_View && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    public void onButtonShowPopupWindowClick(View view) {
        startActivity(new Intent(this, PopupActivity.class));
    }
    public void showAbout(View view) {
        startActivity(new Intent(this, AboutActivity.class));
    }
    public void showHelp(View view) {
        startActivity(new Intent(this, HelpActivity.class));
    }
}