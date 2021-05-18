package com.example.justjava;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static android.app.Activity.RESULT_OK;

public class Camera {
    private static final int Request_Img_View=101 ;
    public static void onCameraResult(int RequestCode, int resultCode, Intent data, ImageView imageView) {
        if (RequestCode == Request_Img_View && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    public static void onClickCamera(View view, PackageManager pm, Activity a)
    {
        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(imageTakeIntent.resolveActivity(pm)!=null)
        {
            a.startActivityForResult(imageTakeIntent,Request_Img_View);
        }
    }

}
