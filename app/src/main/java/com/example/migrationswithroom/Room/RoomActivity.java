package com.example.migrationswithroom.Room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.migrationswithroom.R;
import com.example.migrationswithroom.Room.adapter.ViewPagerAdapter;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        ViewPager2 viewPagerEntity = findViewById(R.id.viewPager2Entity);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPagerEntity.setAdapter(adapter);
        adapter.createFragment(0);
    }
}