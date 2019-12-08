package com.chatproject.listview_search;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NextPage extends AppCompatActivity {

    private static final String TAG = "NextPage";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.next_page);

        Log.d(TAG, "onCreate: called");
    }
}
