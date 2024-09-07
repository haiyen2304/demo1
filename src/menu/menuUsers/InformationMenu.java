package menu.menuUsers;

import feature.UserFeature;
import run.Main;
import utils.Console;
import utils.Share;

import java.util.Scanner;

public class InformationMenu {

    public static boolean menuViewPersonalInformation(Scanner sc) {

        while (true){
            Console.info(
                    """ 
                    ********* MENU  xem thông tin cá nhân ********
                    1. Hiển thị thông tin
                    2. Cập nhật thông tin
                    3. Thay đổi mật khẩu
                    4. Quay lại
                    ***********************************************
                    """);
            int choice = Share.inputNumber(sc,"Hãy nhập lựa chọn của bạn: ","Lựa chọn phải là số !!!");
            switch(choice){
                case 1:
                    UserFeature.viewPersonalInformationFeature(sc);
                    break;
                case 2:
                    UserFeature.updateInformationUser(sc);
                    break;
                case 3:
                    UserFeature.updatePassWordUser(sc);
                    return false;
                case 4:
                    Console.message("(4). Quay lại");
                    return true;
                default:
                    Console.error("Hãy lựa chọn từ 1-4 !!!");
                    break;
            }
        }
    }
}
