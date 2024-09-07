package service;

import model.Product;
import utils.IOFile;
import utils.Path;
import utils.Share;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService implements IProduct{

    public static ArrayList<Product> productsPath = new ArrayList<> (IOFile.readFromFile(Path.PATH_PRODUCT));

    public static void showProduct(Scanner sc) {
        Share.chooseAndDisplayPage(sc,productsPath,3);
    }


    @Override
    public void add(Integer t) {

    }

    @Override
    public void update(Integer t) {

    }

    @Override
    public void delete(Integer t) {

    }

    @Override
    public void search(Integer t) {

    }

    @Override
    public void sort(Integer t) {

    }
}
