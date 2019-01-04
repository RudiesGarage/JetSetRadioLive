package com.example.dem.jetsetradiolive;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


//This Class handles all Data between the Chat and Radio Fragments
public class CustomFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    //takes a fragment manager
    CustomFragmentStatePagerAdapter( FragmentManager fm) {
        super(fm);
    }
    //fragment handler
    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new RadioFragment(); //load radio Fragment
        }
        return new ChatFragment(); //load chat Fragment
    }

    //get the count of fragments (one for music player one for chat)
    @Override
    public int getCount() {
        return 2;
    }
}
