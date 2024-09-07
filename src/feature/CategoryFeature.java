package feature;

import service.CategoryService;
import utils.Console;

import java.util.Scanner;

public class CategoryFeature {

    public static void showCategoryFeature(Scanner sc) {
        Console.message("(1). Hiển thị danh mục \n");
        CategoryService.showCategory(sc);
    }

    public static void addCategoryFeature(Scanner sc) {
        Console.message("(2). Thêm mới danh mục \n");
        CategoryService.addNewCategory(sc);
    }

    public static void updateCategoryFeature(Scanner sc) {
        Console.message("(3). Sửa thông tin danh mục \n");
//        Console.message("Đây là danh sách Category : ");
//        CategoryService.showCategory(sc);
        CategoryService.updateCategory(sc);

    }

    public static void deleteCategoryFeature(Scanner sc) {
        Console.message("(4). Xóa danh mục \n");
//        Console.message("Đây là danh sách Category : ");
//        CategoryService.showCategory(sc);
        CategoryService.deleteCategory(sc);

    }

    public static void searchCategoryFeature(Scanner sc) {
        Console.message("(5). Tìm kiếm danh mục");

    }

    public static void sortCategoryFeature(Scanner sc) {
        Console.message("(6). Sắp xếp theo chiều giảm dần hoặc tăng dần");

    }
}
