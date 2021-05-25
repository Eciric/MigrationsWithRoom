package com.example.migrationswithroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.migrationswithroom.Room.RoomActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnRoom = findViewById(R.id.btnGoToRoomActivity);
        btnRoom.setOnClickListener(v->{
            Intent intent = new Intent(this, RoomActivity.class);
            startActivity(intent);
        });
    }
}