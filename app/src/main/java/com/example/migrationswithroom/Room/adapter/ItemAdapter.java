package com.example.migrationswithroom.Room.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.migrationswithroom.R;
import com.example.migrationswithroom.Room.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    private List<Item> items = new ArrayList<>();

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_item, parent, false);
        return new ItemHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item currentItem = items.get(position);
        holder.textViewId.setText(Long.toString(currentItem.getCategory_Id()));
        holder.textViewName.setText(currentItem.getName());
        holder.textViewDescription.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Item> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public Item getItemAt(int position){
        return items.get(position);
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        private TextView textViewId;
        private TextView textViewName;
        private TextView textViewDescription;
        private TextView textViewCategory;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewItemId);
            textViewName = itemView.findViewById(R.id.textViewItemName);
            textViewDescription = itemView.findViewById(R.id.textViewItemDescription);
            textViewCategory = itemView.findViewById(R.id.textViewItemCategory);
        }
    }
}
