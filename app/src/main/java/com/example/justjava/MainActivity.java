package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private static final int Request_Img_View=101 ;  // da hena netsaraf feeh ezay


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.Imageview);

    }

    @Override
    protected void onActivityResult(int RequestCode,int resultCode,Intent data) {
        super.onActivityResult(RequestCode, resultCode, data);

        Camera.onCameraResult(RequestCode, resultCode, data, imageView);
    }

    public void onClickCamera(View view)
    {
         Camera.onClickCamera(view, getPackageManager(),this);
    }



    public void onButtonShowPopupWindowClick(View view) {
        startActivity(new Intent(this, NotificationsActivity.class));
    }
    public void showAbout(View view) {
        startActivity(new Intent(this, AboutActivity.class));
    }
    public void showHelp(View view) {
        startActivity(new Intent(this, HelpActivity.class));
    }
}