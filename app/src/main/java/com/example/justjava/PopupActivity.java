package com.example.justjava;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class PopupActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
    }
}
