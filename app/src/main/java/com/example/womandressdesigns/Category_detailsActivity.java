package com.example.womandressdesigns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.example.womandressdesigns.Adapter.SliderAdapter;
import com.example.womandressdesigns.Model.SliderModel;
import com.example.womandressdesigns.databinding.ActivityCategoryDetailsBinding;
import com.smarteist.autoimageslider.SliderView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Category_detailsActivity extends AppCompatActivity {
ActivityCategoryDetailsBinding binding;
SliderAdapter adapter;
int currentPosition;
SliderModel currentImageRes;
BitmapDrawable bitmapDrawable;
Bitmap bitmap;
String ctgryname;
int i=0;
ArrayList<SliderModel>imageslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        binding=ActivityCategoryDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ctgryname=getIntent().getStringExtra("name");
        binding.ctgryname.setText(ctgryname);
        imageslist=new ArrayList<>();



        if (ctgryname.equals("Mahndi Dresses Designs")){

            imageslist.add(new SliderModel(R.drawable.madi));
            imageslist.add(new SliderModel(R.drawable.bueaty));
            imageslist.add(new SliderModel(R.drawable.green));
            imageslist.add(new SliderModel(R.drawable.mbridal));
            imageslist.add(new SliderModel(R.drawable.mhndibridal));
            imageslist.add(new SliderModel(R.drawable.mhndidesign));
            imageslist.add(new SliderModel(R.drawable.orange));
            imageslist.add(new SliderModel(R.drawable.orangegreen));
            imageslist.add(new SliderModel(R.drawable.simple));
            imageslist.add(new SliderModel(R.drawable.yellow));
            imageslist.add(new SliderModel(R.drawable.yellowgreen));
            imageslist.add(new SliderModel(R.drawable.yellowlanga));
            imageslist.add(new SliderModel(R.drawable.yellowlook));
            imageslist.add(new SliderModel(R.drawable.yellowpink));
            imageslist.add(new SliderModel(R.drawable.beautifulgirl));
            imageslist.add(new SliderModel(R.drawable.bluepink));
            imageslist.add(new SliderModel(R.drawable.bridalgreen));
            imageslist.add(new SliderModel(R.drawable.brown));
            imageslist.add(new SliderModel(R.drawable.darkgreen));
            imageslist.add(new SliderModel(R.drawable.darkmahron));
            imageslist.add(new SliderModel(R.drawable.frock));
            imageslist.add(new SliderModel(R.drawable.frontdesign));
            imageslist.add(new SliderModel(R.drawable.greensuit));
            imageslist.add(new SliderModel(R.drawable.hideface));
            imageslist.add(new SliderModel(R.drawable.hijab));
            imageslist.add(new SliderModel(R.drawable.lightyellow));
            imageslist.add(new SliderModel(R.drawable.mahron));
            imageslist.add(new SliderModel(R.drawable.nimra));
            imageslist.add(new SliderModel(R.drawable.orangegirl));
            imageslist.add(new SliderModel(R.drawable.orangelangha));
            imageslist.add(new SliderModel(R.drawable.pink));
            imageslist.add(new SliderModel(R.drawable.red));
            imageslist.add(new SliderModel(R.drawable.shortshairt));
            imageslist.add(new SliderModel(R.drawable.smiling));
            imageslist.add(new SliderModel(R.drawable.smilinggirl));
            imageslist.add(new SliderModel(R.drawable.parpelgirl));
            imageslist.add(new SliderModel(R.drawable.grayyellow));
            adapter=new SliderAdapter(imageslist);
            binding.imageSlider.setSliderAdapter(adapter);

        }
        else if (ctgryname.equals("Walima Dresses Designs")){
            imageslist.add(new SliderModel(R.drawable.madi));
            imageslist.add(new SliderModel(R.drawable.bueaty));
            adapter=new SliderAdapter(imageslist);
            binding.imageSlider.setSliderAdapter(adapter);
        }


        else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }



        binding.rightArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = binding.imageSlider.getCurrentPagePosition();
                if (currentPosition < adapter.getCount() - 1) {
                    binding.imageSlider.setCurrentPagePosition(currentPosition + 1);
                }
            }
        });

binding.Arrowimg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int currentPosition = binding.imageSlider.getCurrentPagePosition();
        if (currentPosition > 0) {
            binding.imageSlider.setCurrentPagePosition(currentPosition - 1);
        }
    }
});

        binding.savedimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Category_detailsActivity.this,SavedActivity.class);

                startActivity(intent);

            }
        });




        binding.shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap image=getBitmapFromView(binding.imageSlider);
                 shareImageAndText(image);
            }
        });

       }

    private void shareImageAndText(Bitmap image) {
        Uri uri=getImageToShare(image);
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM,uri);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Dress design");
        intent.setType("images/jpg");
        startActivity(Intent.createChooser(intent,"Shared image Via:"));
    }

    private Uri getImageToShare(Bitmap image) {
        File imageFolder=new File(getCacheDir(),"images");
        Uri uri=null;
        try {
            imageFolder.mkdirs();
            File file=new File(imageFolder,"shared_image.jpg");
            FileOutputStream outputStream=new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
            outputStream.flush();
            outputStream.close();
            uri= FileProvider.getUriForFile(this,"com.dress.shareImage.fileProvider",file);

        }catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return uri;

    }

    private Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap=Bitmap.createBitmap(view.getWidth(),view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas convas=new Canvas(returnedBitmap);
        Drawable background=view.getBackground();
        if (background!=null){
            background.draw(convas);

        }else {
            convas.drawColor(Color.WHITE);
        }
        view.draw(convas);
        return returnedBitmap;

    }
}