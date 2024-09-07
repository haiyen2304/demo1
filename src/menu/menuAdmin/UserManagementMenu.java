package menu.menuAdmin;

import utils.Console;
import utils.Share;

import java.util.Scanner;

public class UserManagementMenu {
    public static void userManagementMenu(Scanner sc) {
        while (true){
            Console.info(
                    """ 
                   **************** MENU quản lý người dùng *************
                   1. Hiển thị người dùng
                   2. Sửa thay đổi trạng thái
                   3. Xóa người dùng
                   4. Tìm kiếm người dùng
                   5. Sắp xếp theo tên theo chiều giảm dần hoặc tăng dần
                   6. Quay lại
                   *******************************************************
                    """);
            int choice = Share.inputNumber(sc,"Hãy nhập lựa chọn của bạn: ","Lựa chọn phải là số !!!");
            switch(choice){
                case 1:
                    Console.message("(1). Hiển thị người dùng \n");

                    break;
                case 2:
                    Console.message("(2). Sửa thay đổi trạng thái \n");


                    break;
                case 3:
                    Console.message("(3). Xóa người dùng\n");


                    break;
                case 4:
                    Console.message("(4). Tìm kiếm người dùng \n");

                    break;
                case 5:
                    Console.message("(5). Sắp xếp theo tên theo chiều giảm dần hoặc tăng dần");

                    break;
                case 6:
                    Console.message("(6). Quay lại\n");

                    return;
                default:
                    Console.error("Hãy lựa chọn từ 1-6 !!!");
                    break;
            }
        }
    }
}
