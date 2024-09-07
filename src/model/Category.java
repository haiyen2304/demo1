package model;

import validate.CategoryValidate;

import java.io.Serializable;
import java.util.Scanner;

public class Category implements Serializable {
    private static int count = 1;
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    private boolean categoryStatus;

    public Category() {
    }

    public Category(int categoryId, String categoryName, String categoryDescription,Boolean categoryStatus) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryStatus = categoryStatus;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Category.count = count;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public void inputDataCategory(Scanner sc) {
        this.categoryId = count++;
        this.categoryName = CategoryValidate.inputCategoryName(sc);
        this.categoryDescription = CategoryValidate.inputCategoryDescription(sc);
        this.categoryStatus=CategoryValidate.inputCategoryStatus(sc);
    }

    public void inputUpdateCategory(Scanner sc) {
        this.categoryName = CategoryValidate.inputCategoryName(sc);
        this.categoryDescription = CategoryValidate.inputCategoryDescription(sc);
        this.categoryStatus=CategoryValidate.inputCategoryStatus(sc);
    }

    @Override
    public String toString() {
        return String.format("[ ID: %-5d | Name: %-15s |  Description: %-20s |  Status: %-5s ]",
            this.categoryId,
            this.categoryName,
            this.categoryDescription,
            this.categoryStatus ? "Active" : "Inactive");
    }


}
