package feature;

import model.Product;
import service.ProductService;
import utils.Console;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductFeature {

    public static void showProductFeature(Scanner sc) {
        Console.message("(1). Hiển thị danh sách sản phẩm \n");
        System.out.println("Đây là danh sách sản phẩm trong của hàng.");
        ProductService.showProduct(sc);

    }


}
