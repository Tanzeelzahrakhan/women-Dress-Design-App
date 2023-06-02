package com.example.womandressdesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.womandressdesigns.databinding.ActivitySavedBinding;

public class SavedActivity extends AppCompatActivity {
int savedImg;
ActivitySavedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        binding=ActivitySavedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       /* savedImg=getIntent().getIntExtra("images",0);
        binding.imageView1.setImageResource(savedImg);
*/

    }
}