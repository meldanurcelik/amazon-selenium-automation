import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Card {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    public void search_a_product(){
        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productsPage.isOnProductPage(), "Not on products page!");
    }

    @Test
    public void select_a_product(){
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not on product detail page!");
    }

    @Test
    public void add_product_to_cart(){
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(), "Product count did not increase!");
    }

    @Test
    public void go_to_cart(){
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(), "Product was not addes to card!");
    }
}
