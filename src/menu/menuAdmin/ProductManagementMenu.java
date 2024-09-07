package menu.menuAdmin;

import utils.Console;
import utils.Share;

import java.util.Scanner;

public class ProductManagementMenu {
    public static void productManagementMenu(Scanner sc) {
        while (true){
            Console.info(
                    """ 
                    *********************** MENU quản lý sản phẩm **********************
                    1. Hiển thị sản phẩm 
                    2. Thêm mới sản phẩm
                    3. Sửa thông tin sản phẩm
                    4. Xóa sản phẩm
                    5. Tìm kiếm sản phẩm
                    6. Sắp xếp theo giá hoặc tên theo chiều giảm dần hoặc tăng dần
                    7. Quay lại
                    ********************************************************************
                    """);
            int choice = Share.inputNumber(sc,"Hãy nhập lựa chọn của bạn: ","Lựa chọn phải là số !!!");
            switch(choice){
                case 1:
                    Console.message("(1). Hiển thị sản phẩm  \n");

                    break;
                case 2:
                    Console.message("(2). Thêm mới sản phẩm \n");


                    break;
                case 3:
                    Console.message("(3). Sửa thông tin sản phẩm \n");


                    break;
                case 4:
                    Console.message("(4). Xóa sản phẩm \n");

                    break;
                case 5:
                    Console.message("(5). Tìm kiếm sản phẩm");

                    break;
                case 6:
                    Console.message("(6). Sắp xếp theo giá hoặc tên theo chiều giảm dần hoặc tăng dần");

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
