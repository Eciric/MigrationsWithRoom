package com.example.migrationswithroom.Room.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.migrationswithroom.R;
import com.example.migrationswithroom.Room.model.Owner;
import com.example.migrationswithroom.Room.relations.OwnerItem;

import java.util.ArrayList;
import java.util.List;

public class OwnerAdapter extends RecyclerView.Adapter<OwnerAdapter.OwnerHolder> {
    private List<OwnerItem> owners = new ArrayList<>();

    @NonNull
    @Override
    public OwnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ownerView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.owner_item, parent, false);
        return new OwnerHolder(ownerView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull OwnerHolder holder, int position) {
        OwnerItem currentOwner = owners.get(position);
        holder.textViewOwnerId.setText(Long.toString(currentOwner.getOwner().getOwnerId()));
        holder.textViewOwnerName.setText(currentOwner.getOwner().getName());
        holder.textViewPhoneNumber.setText(currentOwner.getOwner().getPhoneNumber());
        holder.textViewOwnerItem.setText(currentOwner.getItem().getName());
    }

    @Override
    public int getItemCount() {
        return owners.size();
    }

    public void setOwners(List<OwnerItem> owners){
        this.owners = owners;
        notifyDataSetChanged();
    }

    public Owner getOwnerAt(int position){
        return owners.get(position).getOwner();
    }

    class OwnerHolder extends RecyclerView.ViewHolder{
        TextView textViewOwnerId;
        TextView textViewOwnerName;
        TextView textViewPhoneNumber;
        TextView textViewOwnerItem;

        public OwnerHolder(@NonNull View itemView) {
            super(itemView);
            textViewOwnerId = itemView.findViewById(R.id.textViewOwnerId);
            textViewOwnerName = itemView.findViewById(R.id.textViewOwnerName);
            textViewPhoneNumber = itemView.findViewById(R.id.textViewOwnerPhoneNumber);
            textViewOwnerItem = itemView.findViewById(R.id.textViewOwnerItem);
        }
    }
}
