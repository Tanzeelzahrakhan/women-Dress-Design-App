package com.example.womandressdesigns.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.womandressdesigns.Category_detailsActivity;
import com.example.womandressdesigns.Model.categoryModel;
import com.example.womandressdesigns.R;
import com.example.womandressdesigns.databinding.DressCategoryItemBinding;

import java.util.ArrayList;


public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.categoryViewHolder> {
  Context context;
    ArrayList<categoryModel>categoryList;

    public categoryAdapter(Context context, ArrayList<categoryModel> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dress__category_item,parent,false);
        return new categoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, int position) {
        categoryModel model=categoryList.get(position);
          holder.binding.imageView2.setImageResource(model.getCategoryImages());
          holder.binding.tvMhndi.setText(model.getCategoryName());


          holder.binding.nextArrow.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(context,Category_detailsActivity.class);
                  intent.putExtra("name",model.getCategoryName());
                  context.startActivity(intent);
              }
          });

    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder {
      DressCategoryItemBinding binding;
        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
          binding=DressCategoryItemBinding.bind(itemView);

        }
    }
}
