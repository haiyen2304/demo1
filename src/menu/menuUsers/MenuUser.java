package menu.menuUsers;

import feature.ProductFeature;
import utils.Console;
import utils.Share;

import java.util.Scanner;

public class MenuUser {
    public static void userMenu(Scanner sc) {
        while (true){
            Console.info(
                    """ 
                    ********* MENU người dùng ********
                    1. Hiển thị danh sách sản phẩm
                    2. Xem thông tin cá nhân
                    3. Quản lý giỏ hàng
                    4. Quản lý đơn hàng
                    5. Quản lý danh sách yêu thích
                    6. Đăng xuất
                    **********************************
                    """);
            int choice = Share.inputNumber(sc,"Hãy nhập lựa chọn của bạn: ","Lựa chọn phải là số !!!");
            switch(choice){
                case 1:
                    ProductFeature.showProductFeature(sc);
                    break;
                case 2:
                    Console.message("(2). Xem thông tin cá nhân \n");
                    boolean check= InformationMenu.menuViewPersonalInformation(sc);
                    if(!check){
                        return;
                    }
                    break;
                case 3:
                    Console.message("(3). Quản lý giỏ hàng \n");
                    CartUserMenu.menuCart(sc);
                    break;
                case 4:
                    Console.message("(4). Quản lý đơn hàng \n");
                    break;
                case 5:
                    Console.message("(5). Quản lý danh sách yêu thích");
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
