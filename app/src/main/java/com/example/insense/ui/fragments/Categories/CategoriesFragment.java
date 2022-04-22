package com.example.insense.ui.fragments.Categories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.application.App;
import com.example.insense.databinding.FragmentCategoriesBinding;
import com.example.insense.repository.room.categoryDB.Category;
import com.example.insense.ui.fragments.Calendar.CalendarFragment;

import java.util.ArrayList;


public class CategoriesFragment extends Fragment {

    private FragmentCategoriesBinding fragmentCategoriesBinding;
    protected RecyclerView mRecyclerView;
    protected CategoriesAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    private void initDataset() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = new Bundle();
        fragmentCategoriesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false);
        mRecyclerView = fragmentCategoriesBinding.categoriesRecview;
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new CategoriesAdapter(App.getInstance().getCategoryRepository().getDatabase().categoryDAO().getAll());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                // this will be called multiple times for single click - for MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP, and MotionEvent.ACTION_MOVE
                // So restricting the call only for ACTION_DOWN,
                if (e.getAction() == MotionEvent.ACTION_DOWN) {

                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }


            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });


        fragmentCategoriesBinding.buttonCategoriesMain.setOnClickListener(v -> NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_mainFragment));
        fragmentCategoriesBinding.buttonCategoriesProfile.setOnClickListener(v -> NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_profileFragment));
        fragmentCategoriesBinding.buttonCategoriesCalendar.setOnClickListener(v -> NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_calendarFragment));

/*
        fragmentCategoriesBinding.buttonOther.setOnClickListener(v -> {

            bundle.putString("arg1", "other");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
        });
*/

        return fragmentCategoriesBinding.getRoot();

    }
}