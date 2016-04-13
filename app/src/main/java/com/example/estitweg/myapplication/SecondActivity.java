package com.example.estitweg.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by estitweg on 16-03-21.
 */
public class SecondActivity extends AppCompatActivity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }

    public void onDestroy() {
// Log.i(Tag-String, Message_String);
        Log.i("Comp1601", "Comp1601 Activity is being destroyed");
        super.onDestroy();
    }
}
