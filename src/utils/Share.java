package utils;

import model.Product;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.Field;

public class Share {
    public static int inputNumber(Scanner sc,String msg,String error){
        while(true){
            try{
                Console.message(msg);
                int number=sc.nextInt();
                sc.nextLine();
                if(number>0){
                    return number;
                }
                Console.error("Không được là số âm !!!");
            }catch (Exception e){
                Console.error(error);
                sc.nextLine();
            }
        }
    }

    public static String inputString(Scanner sc,String msg,String error){
        while(true){
             Console.message(msg);
             String inputString=sc.nextLine().trim();
             if(!inputString.isEmpty()){
                 return inputString;
             }
             Console.error(error);
        }
    }

    public static <T> void chooseAndDisplayPage(Scanner sc, ArrayList<T> list, int pageSize) {
        int listSize = list.size();
        int totalPages = (int) Math.ceil((double) listSize / pageSize);
        if (listSize == 0) {
            Console.message("Mảng rỗng ....");
            return;
        }
        while (true){
            int page = Share.inputNumber(sc,"(Tổng số trang hiện tại là: " + totalPages + ") Nhập trang bạn muốn: ","Lựa chọn phải là số !!!");
            if (page < 1 && page > totalPages) {
                Console.error("Số trang từ : " + 1 + " đến : " + totalPages + "vui lòng nhập lại !!!" );
                continue;
            }
            int startIndex = (page - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, listSize);
            list.subList(startIndex, endIndex).forEach(e -> System.out.println(e.toString()));
            return ;
        }
    }


}
