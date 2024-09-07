package model;

import validate.UserValidate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class User implements Serializable {
    private static int count=1;
    private int userId;
    private String userName;
    private String userEmail;
    private String userFullName;
    private boolean userStatus;
    private String userPassword;
    private String userPhone;
    private String userAddress;
    private LocalDate userCreateDate;
    private LocalDate userUpdateDate;
    private LocalDate userBirthDate;
    private boolean userIsDeleted = false;
    private Role role;

    public User() {
    }

    public User(int userId, String userName, String userEmail, String userFullName, boolean userStatus, String userPassword, String userPhone, String userAddress, LocalDate userCreateDate, LocalDate userUpdateDate, LocalDate userBirthDate,Role role) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userFullName = userFullName;
        this.userStatus = userStatus;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userCreateDate = userCreateDate;
        this.userUpdateDate = userUpdateDate;
        this.userBirthDate = userBirthDate;
        this.role = role;
    }



    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        User.count = count;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public LocalDate getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(LocalDate userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public LocalDate getUserUpdateDate() {
        return userUpdateDate;
    }

    public void setUserUpdateDate(LocalDate userUpdateDate) {
        this.userUpdateDate = userUpdateDate;
    }

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public boolean getUserIsDeleted() {
        return userIsDeleted;
    }

    public void setUserIsDeleted(boolean userIsDeleted) {
        this.userIsDeleted = userIsDeleted;
    }

    public void inputDataUser(Scanner sc){
        this.userId = count++;

        this.userName = UserValidate.inputUserName(sc);
        this.userEmail = UserValidate.inputUserEmail(sc);
        this.userFullName = UserValidate.inputUserFullName(sc);
        this.userStatus = true;
        this.userPassword = UserValidate.inputUserPassword(sc);
        this.userPhone = UserValidate.inputUserPhone(sc);
        this.userAddress = UserValidate.inputUserAddress(sc);
        this.userCreateDate = UserValidate.inputUserCreateDate();
        this.userUpdateDate = UserValidate.inputUserUpdateDate();
        this.userBirthDate = UserValidate.inputUserBirthDate(sc);
        this.userIsDeleted = false;
    }

    public void inputUpdateUser(Scanner sc){
        this.userName = UserValidate.inputUserName(sc);
        this.userEmail = UserValidate.inputUserEmail(sc);
        this.userFullName = UserValidate.inputUserFullName(sc);
//        this.userStatus = UserValidate.inputUserStatus(sc);
        this.userPhone = UserValidate.inputUserPhone(sc);
        this.userAddress = UserValidate.inputUserAddress(sc);
        this.userUpdateDate = UserValidate.inputUserUpdateDate();
        this.userBirthDate = UserValidate.inputUserBirthDate(sc);
//        this.userIsDeleted = false;
    }



    public void login(Scanner sc){
        System.out.println("Nhập email: ");
        this.userEmail = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        this.userPassword = sc.nextLine();
    }

    @Override
    public String toString() {
        return String.format("[ ID: %-5d | userName: %-15s |  userEmail: %-20s |  userFullName:%-25s |  userStatus:%-7s |  userPhone:%-15s|  userAddress:%-20s|  userBirthDate:%-10s]\n",
            this.userId,
            this.userName,
            this.userEmail,
            this.userFullName,
            this.userStatus ?"Hoạt Động": "Không hoạt động",
            this.userPhone,
            this.userAddress,
            this.userBirthDate);
    }

}

