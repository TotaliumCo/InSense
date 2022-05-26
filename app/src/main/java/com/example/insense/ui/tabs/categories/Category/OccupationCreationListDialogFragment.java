package com.example.insense.ui.tabs.categories.Category;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.example.insense.application.App;
import com.example.insense.repository.room.occupationDB.Occupation;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;

import com.example.insense.databinding.FragmentItemListDialogListDialogBinding;

public class OccupationCreationListDialogFragment extends BottomSheetDialogFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    private FragmentItemListDialogListDialogBinding binding;
    private ExpandableListAdapter expandableListAdapter;
    public String category;
    public OccupationCreationListDialogFragment(String category, ExpandableListAdapter expandableListAdapter){
        this.category = category;
        this.expandableListAdapter = expandableListAdapter;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentItemListDialogListDialogBinding.inflate(inflater, container, false);
        binding.textView4.setOnClickListener(view -> {
            Occupation occupation = new Occupation();
            occupation.name = binding.textView.getText().toString();
            occupation.category = category;
            App.instance.getOccupationRepository().getOccupationDAO().insert(occupation);
            App.instance.getOccupationRepository().getOccupationDAO().updateOccupation(occupation);
            this.dismiss();
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private DialogInterface.OnDismissListener onDismissListener;

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

}