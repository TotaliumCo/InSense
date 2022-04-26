package com.example.insense.ui.fragments.Category;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

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
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCategoryBinding = FragmentCategoryBinding.inflate(inflater, container, false);


        fragmentCategoryBinding.buttonBackCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(CategoryFragment.this).navigate(R.id.action_categoryFragment_to_categoriesFragment);
            }
        });


        return fragmentCategoryBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = view.findViewById(R.id.textView_category);


        String text = getArguments().getString("arg1");
        tv.setText(text);
        List<String> all_ocuppations;
        List<String> all_descriptions;


        all_ocuppations = repository.occupation_by_category(text);
        all_descriptions = repository.discription_of_occupation(text);
        for (int i = 0; i < all_ocuppations.size(); i++) {
            LinearLayout layout = (LinearLayout) view.findViewById(R.id.linear_layout_occupations);
            View view1 = getLayoutInflater().inflate(R.layout.one_occupation_sample, null, false);
            TextView textView = (TextView) view1.findViewById(R.id.button_occupation);
            TextView textView1 = (TextView) view1.findViewById(R.id.textView_description_of_occupation);
            textView.setText(all_ocuppations.get(i));
            textView1.setText(all_descriptions.get(i));
            layout.addView(view1);


        }

    }
}


