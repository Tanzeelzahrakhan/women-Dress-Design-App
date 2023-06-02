package com.example.womandressdesigns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.womandressdesigns.Adapter.categoryAdapter;
import com.example.womandressdesigns.Model.categoryModel;
import com.example.womandressdesigns.databinding.ActivityAllDressDesignBinding;

import java.util.ArrayList;

public class All_dress_design extends AppCompatActivity {
ActivityAllDressDesignBinding binding;
    ArrayList<categoryModel>categoryList;
    categoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_dress_design);
        binding=ActivityAllDressDesignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.categoriesRecyclerview.setLayoutManager(layoutManager);

        categoryList=new ArrayList<>();
        categoryList.add(new categoryModel(R.drawable.madi,"Mahndi Dresses Designs"));
        categoryList.add(new categoryModel(R.drawable.bridal,"Bridal Dresses Designs"));
        categoryList.add(new categoryModel(R.drawable.wilmapic,"Walima Dresses Designs"));
        categoryList.add(new categoryModel(R.drawable.partypic,"Party Dresses Designs"));
        categoryList.add(new categoryModel(R.drawable.birthdayparty,"Birthday Dresses Designs"));

        adapter=new categoryAdapter(this,categoryList);
        binding.categoriesRecyclerview.setAdapter(adapter);



    }
}