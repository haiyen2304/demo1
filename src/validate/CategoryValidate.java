package validate;

import utils.Console;

import java.util.Scanner;

public class CategoryValidate {
    public static String inputCategoryName(Scanner sc) {
        while (true) {
            System.out.println("Hãy nhập Name category: ");
            String categoryName = sc.nextLine().trim();
            if(!categoryName.isEmpty()){
                return categoryName;
            }
            Console.error("Không được để tên Name category rỗng !!!");
        }

    }
    public static String inputCategoryDescription(Scanner sc) {
        while (true) {
            System.out.println("Hãy nhập vào mô tả Description của Category : ");
            String categoryDescription = sc.nextLine().trim();
            if(!categoryDescription.isEmpty()){
                return categoryDescription;
            }
            Console.error("Không được để mô tả Description Category rỗng !!!");
        }
    }

    public static boolean inputCategoryStatus(Scanner sc) {
        while (true) {
            try{
                System.out.println("Hãy nhập trạng thái Status category (True - Active / False Inactive): ");
                return  sc.nextBoolean();
            }catch (Exception e){
                Console.error("Hãy nhập đúng định dạng  (True - Active / False Inactive) : ");
                sc.nextLine();
            }
        }
    }
}
