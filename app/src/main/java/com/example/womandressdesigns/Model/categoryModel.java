package com.example.womandressdesigns.Model;

public class categoryModel {
    int categoryImages;
    String categoryName;

    public categoryModel(int categoryImages, String categoryName) {
        this.categoryImages = categoryImages;
        this.categoryName = categoryName;
    }

    public int getCategoryImages() {
        return categoryImages;
    }

    public void setCategoryImages(int categoryImages) {
        this.categoryImages = categoryImages;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
