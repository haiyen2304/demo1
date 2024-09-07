package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface ICategory extends  IGenericService<Category,Integer>{
    void displayAndPagination(Scanner sc, ArrayList<Category> categories);
    void add(Integer t);
    void update(Integer t);
    void delete(Integer t);
    void search(Integer t);
    void sort(Integer t);
}
