package validate;

import model.User;
import service.UserService;
import utils.Console;
import utils.Share;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserValidate {

    public static String inputUserName(Scanner sc) {
        while (true) {
            Console.message("Nhập vào tên người dùng: ");
            String userName = sc.nextLine().trim();
            if (userName.length() > 6 && userName.length() < 100 && userName.matches("^[a-zA-Z0-9]*$")) {
                boolean check=true;
                for(User u: UserService.usersPath){
                    if(u.getUserName().equals(userName)){
                        check=false;
                        Console.error("userName bạn nhập bị trùng!!!");
                        break;
                    }
                }
                if(check){
                    return userName;
                }
            }
            Console.error("Tên người dùng nhập không hợp lệ, cần tối thiểu 6 ký tự + tối đa 100 kí tự, không có kí tự đặc biệt!!!");
        }
    }




    public static String inputUserEmail(Scanner sc) {
        while (true) {
            Console.message("Nhập email: ");
            String userEmail = sc.nextLine().trim();
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (userEmail.matches(emailRegex)) {
                boolean isExist = UserService.usersPath.stream().anyMatch(user -> user.getUserEmail().equals(userEmail));
                if (!isExist) {
                    return userEmail;
                }
                else {
                    Console.error("Email đã tồn tại!!!");
                }
            }
            Console.error("Email không đúng định dạng!!!");
        }
    }

    public static String inputUserFullName(Scanner sc) {
        return Share.inputString(sc,"Hãy nhập vào fullName: ","Không được để rỗng fullName!!!");
    }

    public static boolean inputUserStatus(Scanner sc) {
        while (true) {

            try {
                Console.message("Hãy nhập true-hoạt động/false-khóa: ");
                boolean status = sc.nextBoolean();
                sc.nextLine();
                return status;

            }catch (Exception e) {
                Console.error("Không đúng định dạng!!! Hãy nhập lại true-hoạt động/false-khóa!!!");
                sc.nextLine();
            }
        }
    }

    public static String inputUserPassword(Scanner sc) {
        while (true) {
            String pass= Share.inputString(sc,"Nhập mật khẩu 6-25 ký tự chữ Hoa+ thường + số và gồm ký tự đặc biệt: ","Mật khẩu không được để trống!!!");
            String passPattern = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[\\W]).{6,25}$";
            if (pass.matches(passPattern)) {
                return pass;
            }
            Console.error("Mật khẩu từ 6-25 ký tự chữ Hoa+ thường + số và gồm ký tự đặc biệt!!!");
        }
    }

    public static String inputUserPhone(Scanner sc) {
        while (true) {
            String phone= Share.inputString(sc,"Nhập số điện thoại của bạn: ","Số điện thoại không được để trống !!!");
            if(phone.matches("^0[235789][0-9]{8}$")){
                boolean isExist = UserService.usersPath.stream()
                        .anyMatch(user -> user.getUserPhone().equals(phone));
                if(!isExist){
                    return phone;
                }
                Console.error("Số điện thoại đã tồn tại.!!!!");
            }
            Console.error("Số điện thoại không đúng định dạng!!!");
        }
    }

    public static String inputUserAddress(Scanner sc) {
        return Share.inputString(sc,"Hãy nhập vào địa chỉ : ","Không được để trống!!!");
    }

    public static LocalDate inputUserCreateDate() {
        return LocalDate.now();
    }

    public static LocalDate inputUserUpdateDate() {
        return LocalDate.now();
    }

    public static LocalDate inputUserBirthDate(Scanner sc) {

//        while (true) {
//            try {
//                int year = Share.inputNumber(sc, "Nhập vào năm sinh (yyyy): ", "Không được để trống năm sinh!!! ");
//                int month = Share.inputNumber(sc, "Nhập vào tháng sinh (mm): ", "Không được để trống tháng sinh!!! ");
//                int day = Share.inputNumber(sc, "Nhập vào ngày sinh (dd): ", "Không được để trống ngày sinh!!! ");
//
//                LocalDate birthDate = LocalDate.of(year, month, day);
//                if (year > 1900 && year < 2024) {
//                    return birthDate;
//                } else {
//                    Console.error("Năm sinh không hợp lệ!!!");
//                }
//            } catch (DateTimeException e) {
//                Console.error("Ngày sinh không hợp lệ. Vui lòng nhập lại!!!");
//            }
//        }
        while (true) {
            int year=  Share.inputNumber(sc,"Nhập vào năm sinh (yyyy): ","Không được để trống năm sinh!!! ");
            if(0<year && year<2024){
                int month=Share.inputNumber(sc,"Nhập vào tháng sinh (MM): ","Không được để trống tháng sinh!!!");
                if(0<=month && month<12){
                    int day =Share.inputNumber(sc,"Nhập vào ngày sinh(dd): ","Không được để trống ngày sinh");
                    if(0<day && day<31){
                        return LocalDate.of(year,month+1,day);
                    }else {
                        Console.error("Ngày sinh không hợp lệ!!!");
                    }
                }else {
                    Console.error("Tháng sinh không hợp lệ!!!");
                }
            }else {
                Console.error("Năm sinh không hợp lệ!!!");
            }
        }
    }

    public static String inputUserEmailLogin(Scanner sc) {

            Console.message("Nhập email: ");
            String userEmail = sc.nextLine().trim();
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (userEmail.matches(emailRegex)) {
                boolean isExist = UserService.usersPath.stream().anyMatch(user -> user.getUserEmail().equals(userEmail));
                if (isExist) {
                    return userEmail;
                }
            }else {
                Console.error("2 không đúng định dạng!!!");
            }
        return userEmail;
    }



//    public static int inputUserIsDeleted(Scanner sc) {
//        while (true) {
//            int number=  Share.inputNumber(sc,"Hãy nhập 0=Hoạtđộng /1= khóa"," Kí tự nhập phải là số !!!");
//            if(number==0||number==1){
//                return number;
//            }
//            Console.error("Không đúng định dạng 0=Hoạtđộng /1= khóa");
//        }
//    }
}
