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

import java.util.ArrayList;
import java.util.List;

public class OwnerAdapter extends RecyclerView.Adapter<OwnerAdapter.OwnerHolder> {
    private List<Owner> owners = new ArrayList<>();

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
        Owner currentOwner = owners.get(position);
        holder.textViewOwnerId.setText(Double.toString(currentOwner.getOwnerId()));
        holder.textViewOwnerName.setText(currentOwner.getName());
        holder.textViewPhoneNumber.setText(currentOwner.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return owners.size();
    }

    public void setOwners(List<Owner> owners){
        this.owners = owners;
        notifyDataSetChanged();
    }

    public Owner getOwnerAt(int position){
        return owners.get(position);
    }

    class OwnerHolder extends RecyclerView.ViewHolder{
        TextView textViewOwnerId;
        TextView textViewOwnerName;
        TextView textViewPhoneNumber;

        public OwnerHolder(@NonNull View itemView) {
            super(itemView);
            textViewOwnerId = itemView.findViewById(R.id.textViewOwnerId);
            textViewOwnerName = itemView.findViewById(R.id.textViewOwnerName);
            textViewPhoneNumber = itemView.findViewById(R.id.textViewOwnerPhoneNumber);
        }
    }
}
