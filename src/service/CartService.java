package service;

import model.Product;
import model.ShoppingCart;
import model.User;
import utils.Console;
import utils.IOFile;
import utils.Path;
import utils.Share;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartService {
    public static ArrayList<ShoppingCart> shoppingCartList = new ArrayList<> ( IOFile.readFromFile(Path.PATH_CART));

    public static void showProductInCart(Scanner sc) {
        List<User> usersLogin = IOFile.readFromFile(Path.PATH_LOGIN);
        User userLogin=  usersLogin.getFirst();

        for (ShoppingCart cartItem : shoppingCartList) {
            if(cartItem.getUserID()==userLogin.getUserId()){

                for (Product pro : ProductService.productsPath) {
                    if(pro.getProductId()==cartItem.getProductID()){
                        System.out.println("Tên sản phẩm: "+pro.getProductName() + "Giá: "+pro.getUnitPrice()+" Số lượng: "+cartItem.getOrderQuantity());
                    }
                }
            }
        }




    }

    public static void addProductInCart(Scanner sc) {
        System.out.println("Đây là danh sách các sản phẩm ");
        ProductService.showProduct(sc);
        while (true){
            int choiceProduct= Share.inputNumber(sc,"Hãy điền ID sản phẩm bạn muốn thêm vào rỏ hàng: ","Lưu ý lựa chọn ID sản phẩm phải là sô!!!");
            boolean check=false;
            for (Product pro : ProductService.productsPath) {
                if(pro.getProductId()==choiceProduct){
                    check=true;
                    System.out.println("ID sản phẩm bạn chọn có tồn tại");
                    Console.message("Hiện tại trong kho có tổng: " +pro.getProductStockQuantity());

                    while (true){
                        int quantity = Share.inputNumber(sc,"Bạn muốn thêm bao nhiêu số lượng của product có ID  "+choiceProduct+" vào rỏ hàng : ","Lựa chọn số lượng phải là số.");
                        // add sản phẩm vào rỏ có 2 trường họp

                        int userIdLogin=UserService.usersLoginPath.getFirst().getUserId();
                        boolean check2=false;
                        for(ShoppingCart cartItem : shoppingCartList){
                            if(cartItem.getUserID()  ==  userIdLogin){
                                check2=true;
                                System.out.println("Bạn đã có sản phẩm này trong rỏ hàng. ");
                                Console.message("Với số lượng hiện tại trong rỏ là: "+cartItem.getOrderQuantity());

                                if(cartItem.getOrderQuantity()+quantity< pro.getProductStockQuantity()){
                                    pro.setProductStockQuantity(pro.getProductStockQuantity()-quantity-cartItem.getOrderQuantity());
                                    cartItem.setOrderQuantity(cartItem.getOrderQuantity()+quantity);

                                    IOFile.writeToFile(shoppingCartList,Path.PATH_CART);
                                    IOFile.writeToFile(ProductService.productsPath,Path.PATH_PRODUCT);
                                    Console.info("Đã thêm thành công");
                                    break;
                                }else {
                                    Console.error("Số lượng bạn cần lớn hơn số lượng hiện tại có trong kho!!!");
                                    Console.message("Hiện tại trong kho có: " +pro.getProductStockQuantity()+" Vui lòng nhập lại ");
                                }
                            }
                        }
                        if(!check2){
                            System.out.println("Bạn chưa có sản phẩm này trong rỏ hàng. ");
                            if(quantity<pro.getProductStockQuantity()){
                                // // rỏ ID của người login chưa có sản phẩm thì add mới.
                                ShoppingCart cartItem = new ShoppingCart();
                                cartItem.dataShoppingCart(choiceProduct,userIdLogin,quantity);
                                shoppingCartList.add(cartItem);
                                pro.setProductStockQuantity(pro.getProductStockQuantity()-quantity);

                                IOFile.writeToFile(shoppingCartList,Path.PATH_CART);
                                IOFile.writeToFile(ProductService.productsPath,Path.PATH_PRODUCT);
                                Console.info("Đã thêm thành công");
                                break;
                            }else {
                                Console.error("Số lượng bạn cần lớn hơn số lượng hiện tại có trong kho!!!");
                                Console.message("Hiện tại trong kho có: " +pro.getProductStockQuantity()+" Vui lòng nhập lại ");
                            }
                        }
                    }
                }
            }
            if(check){
                return;
            }Console.error("ID sản phẩm bạn chọn không tồn tại!!!");
        }
    }

    public static void addProductInCart2(Scanner sc) {
        System.out.println("Đây là danh sách các sản phẩm");
        ProductService.showProduct(sc);

        while (true) {
            int choiceProduct = Share.inputNumber(sc, "Hãy điền ID sản phẩm bạn muốn thêm vào rỏ hàng: ", "Lưu ý lựa chọn ID sản phẩm phải là số!!!");
            Product selectedProduct = ProductService.productsPath.stream()
                    .filter(pro -> pro.getProductId() == choiceProduct)
                    .findFirst()
                    .orElse(null);

            if (selectedProduct != null) {
                System.out.println("ID sản phẩm bạn chọn có tồn tại");
                Console.message("Hiện tại trong kho có tổng: " + selectedProduct.getProductStockQuantity());
                int quantity = Share.inputNumber(sc, "Bạn muốn thêm bao nhiêu sản phẩm vào rỏ hàng: ", "Lựa chọn số lượng phải là số.");
                int userIdLogin =UserService.usersLoginPath.getFirst().getUserId();

                ShoppingCart existingCartItem = shoppingCartList.stream()
                        .filter(cartItem -> cartItem.getUserID() == userIdLogin && cartItem.getProductID() == choiceProduct)
                        .findFirst()
                        .orElse(null);

                if (existingCartItem != null) {
                    Console.message("Sản phẩm này đã có trong rỏ hàng với số lượng: " + existingCartItem.getOrderQuantity());
                    updateCartItem(existingCartItem, selectedProduct, quantity);
                } else {
                    addNewCartItem(selectedProduct, choiceProduct, userIdLogin, quantity);
                }
                return;
            } else {
                Console.error("ID sản phẩm bạn chọn không tồn tại!!!");
            }
        }
    }

    private static void updateCartItem(ShoppingCart cartItem, Product product, int quantity) {
        if (cartItem.getOrderQuantity() + quantity <= product.getProductStockQuantity()) {
            product.setProductStockQuantity(product.getProductStockQuantity() - quantity);
            cartItem.setOrderQuantity(cartItem.getOrderQuantity() + quantity);
            saveData();
            Console.info("Đã thêm thành công");
        } else {
            Console.error("Số lượng yêu cầu vượt quá số lượng trong kho!");
        }
    }

    private static void addNewCartItem(Product product, int productId, int userId, int quantity) {
        if (quantity <= product.getProductStockQuantity()) {
            ShoppingCart cartItem = new ShoppingCart();
            cartItem.dataShoppingCart(productId, userId, quantity);
            shoppingCartList.add(cartItem);
            product.setProductStockQuantity(product.getProductStockQuantity() - quantity);
            saveData();
            Console.info("Đã thêm thành công");
        } else {
            Console.error("Số lượng yêu cầu vượt quá số lượng trong kho!");
        }
    }

    private static void saveData() {
        IOFile.writeToFile(shoppingCartList, Path.PATH_CART);
        IOFile.writeToFile(ProductService.productsPath, Path.PATH_PRODUCT);
    }


}
