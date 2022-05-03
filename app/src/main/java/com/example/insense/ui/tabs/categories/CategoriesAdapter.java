package com.example.insense.ui.fragments.Categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.insense.R;
import com.example.insense.repository.room.categoryDB.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder>{
    private List<Category> localDataSet;
    public CategoriesAdapter(List<Category> localDataSet){
        this.localDataSet = localDataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        static TextView TextName;
        static TextView TextDescription;
        static TextView TextLOL;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            TextName = (TextView) view.findViewById(R.id.Name);
        }

        public TextView getTextView() {
            return TextName;
        }

        public  TextView getTextDescription() {
            return TextDescription;
        }

        public  TextView getTextLOL() {
            return TextLOL;
        }

        public  TextView getTextName() {
            return TextName;
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_row_item, viewGroup, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextName().setText(localDataSet.get(position).name);
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

}
