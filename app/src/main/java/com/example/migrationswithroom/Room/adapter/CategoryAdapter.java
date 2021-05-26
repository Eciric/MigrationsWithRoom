package com.example.migrationswithroom.Room.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.migrationswithroom.R;
import com.example.migrationswithroom.Room.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    private List<Category> categoryList = new ArrayList<>();

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);
        return new CategoryHolder(categoryView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category currentCategory = categoryList.get(position);
        holder.textViewCategoryId.setText(Double.toString(currentCategory.getCategoryId()));
        holder.textViewCategoryName.setText(currentCategory.getName());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setCategoryList(List<Category> categoryList){
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

    class CategoryHolder extends RecyclerView.ViewHolder{
        public TextView textViewCategoryId;
        public TextView textViewCategoryName;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            textViewCategoryId = itemView.findViewById(R.id.textViewCategoryId);
            textViewCategoryName = itemView.findViewById(R.id.textViewCategoryName);
        }
    }
}
