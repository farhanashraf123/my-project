package com.example.lenovo.homeautomation;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectLocation extends Activity {
    private static final String TAG = "bluetooth";

    private BluetoothAdapter btAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location);
        Button b1=(Button)findViewById(R.id.btn4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectLocation.this,Searchfordevice.class);
                startActivity(i);
            }
        });
        Button b2 = (Button)findViewById(R.id.btn1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectLocation.this,RoomNo1.class);
                startActivity(i);
            }
        });
        Button b3=(Button)findViewById( R.id.btn2);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectLocation.this, RoomNo2.class);
                startActivity(i);
            }
        });
        Button b4 = (Button)findViewById(R.id.btn3);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectLocation.this, Tvlaunch.class);
                startActivity(i);
            }
        });
        btAdapter = btAdapter.getDefaultAdapter();
        checkBTState();
    }
    private void checkBTState() {


        if(btAdapter==null) {
            Toast.makeText(SelectLocation.this, "bluetooth not sported", Toast.LENGTH_SHORT).show();
        } else {
            if (btAdapter.isEnabled()) {
                Log.d(TAG, "...Bluetooth ON...");
            } else {

                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
    }
}
