package com.example.broadcastreceiverpart1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ExampleBroadcastReceiver exampleBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleBroadcastReceiver = new ExampleBroadcastReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(exampleBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

//        unregisterReceiver(exampleBroadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(exampleBroadcastReceiver);
    }
}