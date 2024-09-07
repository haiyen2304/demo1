package menu.menuAdmin;

import feature.CartFeature;
import feature.CategoryFeature;
import utils.Console;
import utils.Share;

import java.util.Scanner;

public class CategoryManagementMenu {
    public static void categoryManagementMenu(Scanner sc) {
        while (true){
            Console.info(
                    """ 
                    *************** MENU quản lý danh mục ***************
                            1. Hiển thị danh mục 
                            2. Thêm mới danh mục
                            3. Sửa thông tin danh mục
                            4. Xóa danh mục
                            5. Tìm kiếm danh mục
                            6. Sắp xếp theo chiều giảm dần hoặc tăng dần
                            7. Quay lại
                    ******************************************************
                    """);
            int choice = Share.inputNumber(sc,"Hãy nhập lựa chọn của bạn: ","Lựa chọn phải là số !!!");
            switch(choice){
                case 1:
                    CategoryFeature.showCategoryFeature(sc);
                    break;
                case 2:
                    CategoryFeature.addCategoryFeature(sc);
                    break;
                case 3:
                    CategoryFeature.updateCategoryFeature(sc);
                    break;
                case 4:
                    CategoryFeature.deleteCategoryFeature(sc);
                    break;
                case 5:
                    CategoryFeature.searchCategoryFeature(sc);
                    break;
                case 6:
                    CategoryFeature.sortCategoryFeature(sc);
                    break;
                case 7:
                    Console.message("(7). Quay lại \n");
                    return;
                default:
                    Console.error("Hãy lựa chọn từ 1-7 !!!");
                    break;
            }
        }

    }
}
