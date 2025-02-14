package com.example.sqlite_project2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite_project2.ItemsModel;
import com.example.sqlite_project2.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    private final RecyclerViewClickListener recyclerViewClickListener;
    private final ArrayList<ItemsModel>itemsModels;

    public ItemsAdapter(ArrayList<ItemsModel> itemsModels,
                        RecyclerViewClickListener recyclerViewClickListener){
        this.itemsModels=itemsModels;
        this.recyclerViewClickListener=recyclerViewClickListener;

    }
    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder holder, int position) {
    ItemsModel itemsModel=itemsModels.get(position);

    }

    @Override
    public int getItemCount() {
        return itemsModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView textname,textDescription;
        public ItemViewHolder(View itemview){
            super(itemview);
            imageView=itemview.findViewById(R.id.profile_image);
            textname=itemview.findViewById(R.id.name);
            textDescription=itemview.findViewById(R.id.msg);
            itemview.setOnClickListener(this::itemViewClick);
        }

        private void itemViewClick(View view) {
          recyclerViewClickListener.onItemClick(view,getAdapterPosition());
        }
    }
}
