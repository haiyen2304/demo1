package run;

import feature.UserFeature;
import menu.menuUsers.MenuUser;
import utils.Console;
import utils.Share;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            Scanner sc = new Scanner(System.in);
            Console.info(
                    """ 
                    ********* MENU ban đầu ********
                    1. Đăng ký
                    2. Đăng nhập
                    3. Hiển thị sản phẩm được bán
                    4. Quên mật khẩu
                    5. Thoát
                    *******************************
                    """);
            int choice = Share.inputNumber(sc,"Hãy nhập lựa chọn của bạn: ","Lựa chọn phải là số !!!");
            switch(choice){
                case 1:
                    UserFeature.register(sc);
                    break;
                case 2:
                     UserFeature.login(sc);
                    break;
                case 3:
                    Console.message("(3). Hiển thị sản phẩm được bán \n");
                    break;
                case 4:
                    Console.message("(4). Quên mật khẩu \n");
                    break;
                case 5:
                    Console.message("(5). Thoát");
                    sc.close();
                    System.exit(0);
                default:
                    Console.error("Hãy lựa chọn từ 1-5 !!!");
                    break;
            }
        }
    }
}
