package menu.menuAdmin;

import utils.Console;
import utils.Share;

import java.util.Scanner;

public class StatisticsMenu {
    public static void statisticsMenu(Scanner sc) {
        while (true){
            Console.info(
                    """ 
                    ************************* MENU thống kê ************************
                    1. Thống kê doanh thu theo tháng
                    2. Thông kê số lượng đơn hàng thành công, hủy theo tháng
                    3. Thông kê doanh thu từ ngày a đến ngày b
                    4. Quay lại
                    ****************************************************************
                    """);
            int choice = Share.inputNumber(sc,"Hãy nhập lựa chọn của bạn: ","Lựa chọn phải là số !!!");
            switch(choice){
                case 1:
                    Console.message("(1). Thống kê doanh thu theo tháng \n");

                    break;
                case 2:
                    Console.message("(2). Thông kê số lượng đơn hàng thành công, hủy theo tháng \n");

                    break;
                case 3:
                    Console.message("(3). Thông kê doanh thu từ ngày a đến ngày b \n");

                    break;
                case 4:
                    Console.message("(4). Quay lại \n");

                    return;
                default:
                    Console.error("Hãy lựa chọn từ 1-4 !!!");
                    break;
            }
        }
    }
}
