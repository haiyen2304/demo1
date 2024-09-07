package menu.menuAdmin;

import feature.CategoryFeature;
import feature.ProductFeature;
import menu.menuUsers.CartUserMenu;
import menu.menuUsers.InformationMenu;
import utils.Console;
import utils.Share;

import java.util.Scanner;

public class MenuAdmin {
    public static void adminMenu(Scanner sc) {
        while (true){
            Console.info(
                    """ 
                    ************ MENU ADMIN ***********
                    1. Quản lý danh mục
                    2. Quản lý sản phẩm
                    3. Quản lý đơn hàng
                    4. Quản lý người dùng
                    5. Thống kê
                    6. Đăng xuất
                    ***********************************
                    """);
            int choice = Share.inputNumber(sc,"Hãy nhập lựa chọn của bạn: ","Lựa chọn phải là số !!!");
            switch(choice){
                case 1:
                    Console.message("(1). Quản lý danh mục \n");
                    CategoryManagementMenu.categoryManagementMenu(sc);
                    break;
                case 2:
                    Console.message("(2). Quản lý sản phẩm \n");
                    ProductManagementMenu.productManagementMenu(sc);

                    break;
                case 3:
                    Console.message("(3). Quản lý đơn hàng \n");
                    OrderManagementMenu.orderManagementMenu(sc);

                    break;
                case 4:
                    Console.message("(4). Quản lý người dùng \n");
                    UserManagementMenu.userManagementMenu(sc);
                    break;
                case 5:
                    Console.message("(5). Thống kê");
                    StatisticsMenu.statisticsMenu(sc);
                    break;
                case 6:
                    Console.message("(6). Đăng xuất \n");
                    // cần xóa dữ liệu trên Login
                    return;
                default:
                    Console.error("Hãy lựa chọn từ 1-6 !!!");
                    break;
            }
        }
    }
}
