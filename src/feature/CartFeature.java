package feature;

import service.CartService;
import utils.Console;

import java.util.Scanner;

public class CartFeature {

    public static void showProductInCartFeature(Scanner sc) {
        Console.message("(1). Hiển thị danh sách giỏ hàng \n");
        Console.message("Đấy là danh sách giỏ hàng của bạn. ");
        CartService.showProductInCart(sc);
    }

    public static void addProductInCartFeature(Scanner sc) {
        Console.message("(2). Thêm mới sản phẩm vào giỏ hàng \n");
        CartService.addProductInCart(sc);
    }

    public static void updateProductInCartFeature(Scanner sc) {
        Console.message("(3). Thay đổi số lượng sản phẩm trong giỏ hàng \n");
//        CartService.updateProductInCart(sc);
    }


}
