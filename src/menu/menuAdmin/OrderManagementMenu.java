package menu.menuAdmin;

import utils.Console;
import utils.Share;

import java.util.Scanner;

public class OrderManagementMenu {
    public static void orderManagementMenu(Scanner sc) {
        while (true){
            Console.info(
                    """ 
                    *************** MENU  đơn hàng **************
                    1. Hiển thị danh sách đơn hàng
                    2. Tìm kiếm theo mã đơn hàng
                    3. Tìm kiếm theo trạng thái đơn hàng
                    4. Xem chi tiết đơn hàng theo mã đơn hàng
                    5. Thay đổi trạng thái đơn hàng
                    6. Quay lại
                    *********************************************
                    """);
            int choice = Share.inputNumber(sc,"Hãy nhập lựa chọn của bạn: ","Lựa chọn phải là số !!!");
            switch(choice){
                case 1:
                    Console.message("(1). Hiển thị danh sách đơn hàng \n");

                    break;
                case 2:
                    Console.message("(2). Tìm kiếm theo mã đơn hàng \n");

                    break;
                case 3:
                    Console.message("(3). Tìm kiếm theo trạng thái đơn hàng \n");


                    break;
                case 4:
                    Console.message("(4). Xem chi tiết đơn hàng theo mã đơn hàng \n");

                    break;
                case 5:
                    Console.message("(5). Thay đổi trạng thái đơn hàng");

                    break;
                case 6:
                    Console.message("(6). Quay lại \n");
                    return;
                default:
                    Console.error("Hãy lựa chọn từ 1-6 !!!");
                    break;
            }
        }
    }
}
