package model;

import validate.ProductValidate;

import java.time.LocalDate;

import java.util.Scanner;

public class Product {
    private static int count = 1;
    private int productId;
    private String sku;
    private String productName;
    private String productDescription;
    private double unitPrice;
    private int productStockQuantity;
    private int categoryID;
    private LocalDate productDateCreated;
    private LocalDate productDateUpdated;

    public Product() {
    }

    public Product(int productId, String sku, String productName, String productDescription, double unitPrice, int productStockQuantity, int categoryID, LocalDate productDateCreated, LocalDate productDateUpdated) {
        this.productId = productId;
        this.sku = sku;
        this.productName = productName;
        this.productDescription = productDescription;
        this.unitPrice = unitPrice;
        this.productStockQuantity = productStockQuantity;
        this.categoryID = categoryID;
        this.productDateCreated = productDateCreated;
        this.productDateUpdated = productDateUpdated;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getProductStockQuantity() {
        return productStockQuantity;
    }

    public void setProductStockQuantity(int productStockQuantity) {
        this.productStockQuantity = productStockQuantity;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public LocalDate getProductDateCreated() {
        return productDateCreated;
    }

    public void setProductDateCreated(LocalDate productDateCreated) {
        this.productDateCreated = productDateCreated;
    }

    public LocalDate getProductDateUpdated() {
        return productDateUpdated;
    }

    public void setProductDateUpdated(LocalDate productDateUpdated) {
        this.productDateUpdated = productDateUpdated;
    }

    public void inputDataProduct(Scanner sc){
        this.productId = count++;
        this.sku = ProductValidate.inputSku();
        this.productName = ProductValidate.inputProductName(sc);
        this.productDescription = ProductValidate.inputProductDescription(sc);
        this.unitPrice = ProductValidate.inputUnitPrice(sc);
        this.productStockQuantity = ProductValidate.inputProductStockQuantity(sc);
        this.categoryID = ProductValidate.inputCategoryID(sc);
        this.productDateCreated = ProductValidate.inputProductDateCreated();
    }

    public void inputUpdateProduct(Scanner sc){
        this.productName = ProductValidate.inputProductName(sc);
        this.productDescription = ProductValidate.inputProductDescription(sc);
        this.unitPrice = ProductValidate.inputUnitPrice(sc);
        this.productStockQuantity = ProductValidate.inputProductStockQuantity(sc);
        this.categoryID = ProductValidate.inputCategoryID(sc);
        this.productDateUpdated = ProductValidate.inputProductDateUpdated();
    }

    @Override
    public String toString() {
        return String.format("[ ID: %-5d | SKU: %-25s | Name: %-20s | Description: %-25s |  Price: %-8f |  StockQuantity:%-5d |  categoryID:%-5d|  DateCreated:%-8s|  DateUpdated:%-8s]\n",
            this.productId,
            this.sku,
            this.productName,
            this.productDescription,
            this.unitPrice,
            this.productStockQuantity,
            this.categoryID,
            this.productDateCreated,
            this.productDateUpdated);
    }


}
