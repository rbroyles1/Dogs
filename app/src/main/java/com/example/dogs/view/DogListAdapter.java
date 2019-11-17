package com.example.dogs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogs.R;
import com.example.dogs.databinding.ItemDogBinding;
import com.example.dogs.model.DogBreed;

import java.util.ArrayList;
import java.util.List;

public class DogListAdapter extends RecyclerView.Adapter<DogListAdapter.DogViewHolder> implements DogClickListener {
    private ArrayList<DogBreed> dogsList;
    public DogListAdapter(ArrayList<DogBreed> dogsList) {
        this.dogsList = dogsList;
    }
    public void updateDogList(List<DogBreed> newDogsList) {
        dogsList.clear();
        dogsList.addAll(newDogsList);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemDogBinding view = DataBindingUtil.inflate(inflater, R.layout.item_dog, parent, false);
        return new DogViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        holder.itemView.setDog(dogsList.get(position));
        holder.itemView.setListener(this);
    }
    @Override
    public int getItemCount() {
        return dogsList.size();
    }
    @Override
    public void onDogClicked(View v) {
        String uuidString = ((TextView)v.findViewById(R.id.dogUUID)).getText().toString();
        int uuid = Integer.valueOf(uuidString);
        ListFragmentDirections.ActionDetails action = ListFragmentDirections.actionDetails();
        action.setDogUuid(uuid);
        Navigation.findNavController(v).navigate(action);
    }
    class DogViewHolder extends RecyclerView.ViewHolder {
        public ItemDogBinding itemView;
        public DogViewHolder(@NonNull ItemDogBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
