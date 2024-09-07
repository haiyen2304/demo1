package validate;

import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;
import utils.Console;
import utils.Share;


import java.time.LocalDate;

import java.util.Scanner;
import java.util.UUID;

public class ProductValidate {

    public static String inputSku() {
        while (true) {
            String sku = UUID.randomUUID().toString();
            if (sku.length() < 100) {
                boolean Check=true;
                for(Product p: ProductService.productsPath){
                    if(p.getSku().equals(sku)){
                        Check=false;
                        break;
                    }
                }if(Check) {
                    Console.message("Mã sản phẩm SKU của bạn là : "+sku);
                    return sku;
                }
                Console.error("Mã SKU bị trùng!!!");
            }else {
                Console.error("Mã SKU đang có độ dài lớn hơn 100");
            }
        }
    }

    public static String inputProductName(Scanner sc) {
        while (true) {
            String productName = sc.nextLine().trim();
            if(!productName.isEmpty()){
                boolean Check=true;
                for(Product p: ProductService.productsPath){
                    if(p.getProductName().equals(productName)){
                        Check=false;
                        break;
                    }
                }
                if(Check) {
                    Console.message("ProductName hợp lệ ");
                    return productName;
                }Console.error("ProductName không hợp lệ, BỊ TRÙNG!!!");
            }else {
                Console.error("ProductName không được để trống !!!");
            }
        }
    }

    public static String inputProductDescription(Scanner sc) {
        while (true) {
            String productDescription = sc.nextLine().trim();
            if(!productDescription.isEmpty()){
                return productDescription;
            }else {
                Console.error("Không được để trống Description");
            }
        }
    }

    public static double inputUnitPrice(Scanner sc) {
        while (true) {
            try{
                Console.message("Nhập Giá Product: ");
                double unitPrice = sc.nextDouble();
                if(unitPrice > 0){
                    return unitPrice;
                }Console.error("Giá không được nhỏ hơn 0!!!");
            }catch (Exception e){
                Console.error(e.getMessage()+"Giá phải là số!!!");
                sc.nextLine();
            }
        }
    }

    public static int inputProductStockQuantity(Scanner sc) {
        return Share.inputNumber(sc,"Nhập số lượng tồn kho stockQuantity","Số lượng phải là số !!!");
    }

    public static int inputCategoryID(Scanner sc) {
         Console.message("Danh sách Category");
         System.out.println("Danh sách Category");
                for(Category c: CategoryService.categoriesPath){
                    Console.message("ID : "+c.getCategoryId()+"NameCategory: "+c.getCategoryName() );
                }

        while(true){
            int categoryID = Share.inputNumber(sc,"Hãy nhập ID Category mà bạn chọn : ","ID Category chọn phải là số ");
            boolean Check=false;
            for(Category c: CategoryService.categoriesPath){
                if(c.getCategoryId() == categoryID){
                    Check=true;
                    break;
                }
            }
            if(Check) {
                Console.message("ID bạn chọn hợp lệ .");
                return categoryID;
            }Console.error("ID Category bạn chọn không tồn tại !!!");
        }
    }

    public static LocalDate inputProductDateCreated() {
        return LocalDate.now();
    }

    public static LocalDate inputProductDateUpdated() {
        return LocalDate.now();
    }
}
