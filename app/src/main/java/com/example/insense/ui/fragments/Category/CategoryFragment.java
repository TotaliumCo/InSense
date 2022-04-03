package com.example.insense.ui.fragments.Category;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.insense.R;
import com.example.insense.databinding.FragmentCategoriesBinding;
import com.example.insense.databinding.FragmentCategoryBinding;


public class CategoryFragment extends Fragment {
    private FragmentCategoryBinding fragmentCategoryBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCategoryBinding = FragmentCategoryBinding.inflate(inflater, container, false);





        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = view.findViewById(R.id.button3);
        String text = getArguments().getString("arg1");

        switch (text){
            case "sport":
                tv.setText(text);
            case "music":
                tv.setText(text);
            case "study":
                tv.setText(text);
            case "work":
                tv.setText(text);
            case "hobby":
                tv.setText(text);
            case "family":
                tv.setText(text);
            case "other":
                tv.setText(text);
        }
    }
}