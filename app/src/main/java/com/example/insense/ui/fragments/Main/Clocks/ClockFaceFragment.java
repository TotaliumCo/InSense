package com.example.insense.ui.fragments.Main.Clocks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClockFaceFragment extends Fragment {

    public static ClockFaceFragment newInstance() {
        return new ClockFaceFragment();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        return new DrawView(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}