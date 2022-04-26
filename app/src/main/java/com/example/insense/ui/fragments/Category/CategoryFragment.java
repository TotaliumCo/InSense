package com.example.insense.ui.fragments.Category;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.insense.R;
import com.example.insense.application.App;
import com.example.insense.databinding.FragmentCategoriesBinding;
import com.example.insense.databinding.FragmentCategoryBinding;
import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.CategoryRepository;
import com.example.insense.repository.OccupationRepository;
import com.example.insense.repository.room.categoryDB.Category;
import com.example.insense.repository.room.categoryDB.CategoryDAO;
import com.example.insense.repository.room.categoryDB.CategoryDB;
import com.example.insense.repository.room.occupationDB.Occupation;
import com.example.insense.repository.room.occupationDB.OccupationDAO;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {
    private FragmentCategoryBinding fragmentCategoryBinding;

    /*CategoryDB db = App.getInstance().getDatabase_category();*/
    /*CategoryDAO categoryDAO = db.user_categ();*/
    OccupationRepository repository = App.instance.getOccupationRepository();
    OccupationDAO occupationDAO;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCategoryBinding = FragmentCategoryBinding.inflate(inflater, container, false);
        fragmentCategoryBinding.buttonBackCategory.setOnClickListener(v -> NavHostFragment.findNavController(CategoryFragment.this).navigate(R.id.action_categoryFragment_to_categoriesFragment));
        String text = getArguments() != null ? getArguments().getString("arg1") : null;
        LinearLayout linLayout = fragmentCategoryBinding.linearLayoutOccupations.findViewById(R.id.linear_layout_occupations);

        LayoutInflater ltInflater = getLayoutInflater();
        List<String> occupations_String = repository.occupation_by_category(text);
        for (int i = 0; i < occupations_String.size(); i++) {
            Log.d("myLogs", "i = " + i);
            View item = ltInflater.inflate(R.layout.one_occupation_sample, linLayout, false);
            Button tvName =  item.findViewById(R.id.button_occupation);
            tvName.setText(occupations_String.get(i));

            int finalI = i;
            tvName.setOnClickListener(view1-> {
                Log.d("myLol", "lol");
             /*   savedInstanceState.putString("argCat", text);
                savedInstanceState.putString("argOccupation", occupations_String.get(finalI));
              */  NavHostFragment.findNavController(this).navigate(R.id.occupationFragment, savedInstanceState);

            });
            linLayout.addView(item);
        }

        TextView tv = fragmentCategoryBinding.textViewCategory;
        switch (text) {
            case "спорт":
                tv.setText(text);
                break;
            case "музыка":
                tv.setText(text);
            case "учеба":
                tv.setText(text);
            case "работа":
                tv.setText(text);
            case "хобби":
                tv.setText(text);
            case "семья":
                tv.setText(text);
            case "другое":
                tv.setText(text);
        }

        return fragmentCategoryBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}