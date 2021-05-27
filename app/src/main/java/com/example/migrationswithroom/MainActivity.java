package com.example.migrationswithroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.migrationswithroom.Room.RoomActivity;
import com.example.migrationswithroom.SQLite.SqliteActivity;

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

        final Button btnSqlite = findViewById(R.id.btnGoToSQLiteActivity);
        btnSqlite.setOnClickListener(v->{
            Intent intent = new Intent(this, SqliteActivity.class);
            startActivity(intent);
        });
    }
}