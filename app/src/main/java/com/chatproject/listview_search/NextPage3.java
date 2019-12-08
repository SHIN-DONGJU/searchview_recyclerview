package com.chatproject.listview_search;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NextPage3 extends AppCompatActivity {
    private static final String TAG = "NextPage3";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.next_page3);

        Log.d(TAG, "onCreate: called");
    }
}
