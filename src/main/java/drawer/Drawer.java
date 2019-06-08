package drawer;

import products.Product;

import java.util.ArrayList;

public class Drawer {

    private ItemCode code;
    private int price;
    private ArrayList<Product> products;

    public Drawer(ItemCode code, int price) {
        this.code = code;
        this.price = price;
        this.products = new ArrayList<Product>();
    }

    public ItemCode getCode() {
        return code;
    }

    public void setCode(ItemCode code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addItem(Product product){
        this.products.add(product);
    }

    public int stockCount(){
        return this.products.size();
    }

    public Product returnProduct() {
        if (this.products.size() > 0) {
            return this.products.remove(0);
        }
        return null;
    }
}
