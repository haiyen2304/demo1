package feature;

import menu.menuAdmin.MenuAdmin;
import menu.menuUsers.MenuUser;
import model.Role;
import model.User;
import service.UserService;
import utils.Console;

import java.util.Scanner;

public class UserFeature {

    public static void register(Scanner sc) {
        Console.message("(1). Đăng ký \n");
        System.out.println("Bắt đầu nhập thông tin đăng kí tài khoản.");
        System.out.println("Hãy điền thông tin của bạn theo yêu cầu dưới đây. ");
        UserService.registerUser(sc);
    }


    public static void login(Scanner sc) {
        Console.message("(2). Đăng nhập \n");
        System.out.println("Bắt đầu đăng nhập.");
        System.out.println("Hãy điền tài khoản của bạn. ");

        User user = UserService.loginUser(sc);

        if(user!=null){
            Console.info("Đăng nhập thành công");
            if(user.getRole()== Role.USER){
                Console.message("Bạn đang ở trang người dùng. \n");
                MenuUser.userMenu(sc);
            }else {
                Console.message("Bạn đang ở trang người quản lý. \n");
                MenuAdmin.adminMenu(sc);
            }
        }else {
            Console.error("Đăng nhập không thành công!!!");
        }
    }


    public static void viewPersonalInformationFeature(Scanner sc) {
        Console.message("(1). Hiển thị thông tin \n");
        System.out.println("Đây là thông tin tài khoản của bạn. ");
        UserService.personalInformation(sc);
    }

    public static void updateInformationUser(Scanner sc) {
        Console.message("(2). Cập nhật thông tin \n");
        System.out.println("Bạn đang bắt đầu cập nhật thông tin, Hãy điền thông tin theo yêu cầu dưới đây.");
        UserService.updateInformation(sc);

    }

    public static void updatePassWordUser(Scanner sc) {
        Console.message("(3). Thay đổi mật khẩu \n");
        System.out.println("Bạn đang bắt đầu thay đổi mật khẩu, Hãy điền thông tin theo yêu cầu dưới đây.");
        UserService.updatePassWord(sc);
    }
}
