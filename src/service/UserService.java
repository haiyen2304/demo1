package service;

import model.Role;
import model.User;
import utils.Console;
import utils.IOFile;
import utils.Path;
import validate.UserValidate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    public static List<User> usersPath       = new ArrayList<> (IOFile.readFromFile(Path.PATH_USER));
    public static ArrayList<User> usersLoginPath   = new ArrayList<> ( IOFile.readFromFile(Path.PATH_LOGIN));

    static {
        if (usersPath.isEmpty()) {
            usersPath.add(new User(0,"Admin","hhyhaiyen@gmail.com","Hoang Hai Yen",true,"123456","0987654321","poiuytrewq", LocalDate.now(), LocalDate.now(), LocalDate.of(2000,12,2), Role.ADMIN));
            IOFile.writeToFile(usersPath, Path.PATH_USER);
            System.out.println("Đã thêm một admin: (hhyhaiyen@gmail.com):(123456)");
        }
    }

    public static void registerUser(Scanner sc) {
        User user = new User();
        user.inputDataUser(sc);
        usersPath.add(user);
        IOFile.writeToFile(usersPath, Path.PATH_USER);

    }

    public static User loginUser(Scanner sc) {
            User userLogin = new User();
            userLogin.login(sc);

            List<User> userList=  IOFile.readFromFile(Path.PATH_USER);
            for (User user : userList) {
                if(user.getUserEmail().equals(userLogin.getUserEmail()) && user.getUserPassword().equals(userLogin.getUserPassword())) {
                    if(!user.isUserStatus()){
                        Console.error("Tài khoản đã khóa!!!");
                        return null;
                    }
                    if(user.getUserIsDeleted()){
                        Console.error("Tài khoản đã bị xóa!!!");
                        return null;
                    }
                    usersLoginPath.add(user);
                    IOFile.writeToFile(usersLoginPath, Path.PATH_LOGIN);
                    Console.info("Tài khoản đúng.");
                    return user;
                }
            }
        Console.error("Email hoặc mật khẩu không đúng!!!");
        return null;
    }

    public static void personalInformation(Scanner sc) {
        if(!usersLoginPath.isEmpty()){
            User user = usersLoginPath.getFirst();
            System.out.println(user.toString());
        }
    }


    public static void updateInformation(Scanner sc) {
        if(!usersLoginPath.isEmpty()){
            User user = usersLoginPath.getFirst();
            user.inputUpdateUser(sc);
            IOFile.writeToFile(usersLoginPath, Path.PATH_LOGIN);

            List<User> userLoginNews=  IOFile.readFromFile(Path.PATH_LOGIN);
            User newUser = userLoginNews.getFirst();
            for (User userOld : usersPath) {
                if(userOld.getUserEmail().equals(newUser.getUserEmail())) {

                    usersPath.remove(userOld);
                    usersPath.add(newUser);
                    IOFile.writeToFile(usersPath, Path.PATH_USER);
                    Console.info("Bạn đã thay đổi thông tin thành công");
                    break;
                }
            }
        }
    }


    public static void updatePassWord(Scanner sc) {
        if(!usersLoginPath.isEmpty()){
            User user = usersLoginPath.getFirst();
            String newPassword = UserValidate.inputUserPassword(sc);
            user.setUserPassword(newPassword);
            IOFile.writeToFile(usersLoginPath, Path.PATH_LOGIN);

            List<User> userLoginNews=  IOFile.readFromFile(Path.PATH_LOGIN);
            User newUser = userLoginNews.getFirst();
            for (User userOld : usersPath) {
                if(userOld.getUserEmail().equals(newUser.getUserEmail())) {
                    usersPath.remove(userOld);
                    usersPath.add(newUser);
                    IOFile.writeToFile(usersPath, Path.PATH_USER);
                    Console.info("Bạn đã thay đổi mật khẩu thành công");
                    break;
                }
            }
        }
    }
}
