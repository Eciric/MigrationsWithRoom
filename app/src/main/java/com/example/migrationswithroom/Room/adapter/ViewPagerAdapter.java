package com.example.migrationswithroom.Room.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.migrationswithroom.Room.fragments.CategoryFragment;
import com.example.migrationswithroom.Room.fragments.ItemFragment;
import com.example.migrationswithroom.Room.fragments.OwnerFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return  new ItemFragment();
            case 1:
                return new CategoryFragment();
            default:
                return  new OwnerFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
