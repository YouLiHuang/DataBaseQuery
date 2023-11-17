package com.example.mainui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_05 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

/*        View view = inflater.inflate(inflater, R.layout.activity_main, savedInstanceState);
        return view;*/
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
