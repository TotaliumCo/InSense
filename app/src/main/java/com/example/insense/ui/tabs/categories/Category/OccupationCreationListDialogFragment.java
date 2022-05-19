package com.example.insense.ui.tabs.categories.Category;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.example.insense.application.App;
import com.example.insense.repository.room.occupationDB.Occupation;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.insense.databinding.FragmentItemListDialogListDialogItemBinding;
import com.example.insense.databinding.FragmentItemListDialogListDialogBinding;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     OccupationCreationListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class OccupationCreationListDialogFragment extends BottomSheetDialogFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    private FragmentItemListDialogListDialogBinding binding;
    public String category;
    public OccupationCreationListDialogFragment(String category){
        this.category = category;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentItemListDialogListDialogBinding.inflate(inflater, container, false);
        binding.textView4.setOnClickListener(view -> {
            Occupation occupation = new Occupation();
            occupation.name = binding.textView.getText().toString();
            occupation.description = binding.textView2.getText().toString();
            occupation.category = category;
            App.instance.getOccupationRepository().getOccupationDAO().insert(occupation);
            App.instance.getOccupationRepository().getOccupationDAO().updateOccupation(occupation);
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        /*
        final RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new OccupationCreationAdapter(1));*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

  /*  private class ViewHolder extends RecyclerView.ViewHolder {

        final TextView text;

        ViewHolder(FragmentItemListDialogListDialogItemBinding binding) {
            super(binding.getRoot());
            text = binding.text;
        }

    }

    private class OccupationCreationAdapter extends RecyclerView.Adapter<ViewHolder> {

        private final int mItemCount;

        OccupationCreationAdapter(int itemCount) {
            mItemCount = itemCount;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new ViewHolder(FragmentItemListDialogListDialogItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.text.setText(String.valueOf(position));
        }

        @Override
        public int getItemCount() {
            return mItemCount;
        }

    }*/
}