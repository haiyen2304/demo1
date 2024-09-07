package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface IProduct extends IGenericService<Product,Integer> {

    void add(Integer t);
    void update(Integer t);
    void delete(Integer t);
    void search(Integer t);
    void sort(Integer t);
}
