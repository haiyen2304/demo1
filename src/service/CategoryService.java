package service;

import model.Category;
import utils.Console;
import utils.IOFile;
import utils.Path;
import utils.Share;
import validate.CategoryValidate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryService implements ICategory {
    public static ArrayList<Category> categoriesPath = new ArrayList<> (IOFile.readFromFile(Path.PATH_CATEGORY));

    static {
        if (categoriesPath.isEmpty()){
            categoriesPath.add(new Category(1,"Giay","deppppppppp",true));
            categoriesPath.add(new Category(2,"Dep","deppppppppp",true));
            categoriesPath.add(new Category(3,"Quan","deppppppppp",true));
            categoriesPath.add(new Category(4,"Ao","deppppppppp",true));
            categoriesPath.add(new Category(5,"Tui","deppppppppp",true));
            categoriesPath.add(new Category(6,"Cap","deppppppppp",true));
            categoriesPath.add(new Category(7,"Khan","deppppppppp",true));
            IOFile.writeToFile(categoriesPath, Path.PATH_CATEGORY);
        }
    }


    public static void showCategory(Scanner sc) {
        Share.chooseAndDisplayPage(sc,categoriesPath,3);
    }

    public static void addNewCategory(Scanner sc) {

        int number= Share.inputNumber(sc,"Hãy nhập vào số danh mục mà bạn muốn thêm: ","Lựa chọn phải là số !!!");
        Console.message("Bạn đang bắt đầu thêm danh mục, Hãy điền theo yêu cầu dưới đây : ");
        for (int i = 1; i <= number; i++) {
            System.out.println("Bạn đã thêm sản phẩm thứ "+i +"\n");
            Category newCategory = new Category();
            newCategory.inputDataCategory(sc);
            categoriesPath.add(newCategory);
        }
        IOFile.writeToFile(categoriesPath, Path.PATH_CATEGORY);
        Console.message("Bạn đã thêm tất cả sản phẩm thành công");
    }

    public static void updateCategory(Scanner sc) {
        int idCategoryUpdate= Share.inputNumber(sc,"Hãy điền ID của Category mà bạn muốn cập nhật: ","Lựa chọn phải là số");
        boolean check=true;
        for(Category category : categoriesPath) {
            if(category.getCategoryId()!=idCategoryUpdate){
                check=false;
                Console.error(  " ID bạn nhập không tồn tại !!!");
                break;
            }
            Console.message( " Tìm thầy ID bạn nhập !!!");
            Console.message("Bắt đầu cập nhật Category. Vui lòng điền thông tin theo yêu cầu dưới đây. ");
            category.inputUpdateCategory(sc);
            Console.info("Cập nhật Category có số ID là: "+idCategoryUpdate+ " THÀNH CÔNG ");
            System.out.println(category.toString());
        }


    }

    public static void deleteCategory(Scanner sc) {

    }


    @Override
    public void displayAndPagination(Scanner sc, ArrayList<Category> categories) {
        return ;
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
