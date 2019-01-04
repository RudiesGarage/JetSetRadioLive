package com.example.dem.jetsetradiolive;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


//this holds the Chat
//TODO add chat feature
public class ChatFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup viewGroup2 = (ViewGroup) inflater.inflate(R.layout.fragment_chat, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
