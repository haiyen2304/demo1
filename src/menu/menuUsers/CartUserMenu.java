package menu.menuUsers;

import feature.CartFeature;
import feature.ProductFeature;
import utils.Console;
import utils.Share;

import java.util.Scanner;

public class CartUserMenu {

    public static void menuCart(Scanner sc) {
        while (true){
            Console.info(
                    """ 
                    ********* MENU rỏ hàng ********
                    1. Hiển thị danh sách giỏ hàng
                    2. Thêm mới sản phẩm vào giỏ hàng
                    3. Thay đổi số lượng sản phẩm trong giỏ hàng
                    4. Xóa sản phẩm trong giỏ hàng
                    5. Xóa toàn bộ sản phẩm trong giỏ hàng
                    6. Đặt hàng
                    7. Quay lại
                    **********************************
                    """);
            int choice = Share.inputNumber(sc,"Hãy nhập lựa chọn của bạn: ","Lựa chọn phải là số !!!");
            switch(choice){
                case 1:
                    CartFeature.showProductInCartFeature(sc);
                    break;
                case 2:
                    CartFeature.addProductInCartFeature(sc);
                    break;
                case 3:
                    CartFeature.updateProductInCartFeature(sc);
                    break;
                case 4:
                    Console.message("(4). Xóa sản phẩm trong giỏ hàng \n");
                    break;
                case 5:
                    Console.message("(5). Xóa toàn bộ sản phẩm trong giỏ hàng");
                    break;
                case 6:
                    Console.message("(6). Đặt hàng");
                    break;
                case 7:
                    Console.message("(7). Quay lại \n");
                    return;
                default:
                    Console.error("Hãy lựa chọn từ 1-6 !!!");
                    break;
            }
        }

    }
}
