package drawer;

import org.junit.Before;
import org.junit.Test;
import products.Crisps;
import products.Drink;
import products.Sweet;

import static org.junit.Assert.assertEquals;

public class DrawerTest {

    private Drawer drawer;
    private Crisps crisps;
    private Drink drink;
    private Sweet sweet;

    @Before
    public void setUp(){
        crisps = new Crisps("Wotsits", "Walkers");
        drink = new Drink("Irn Bru", "Barrs");
        sweet = new Sweet("Wispa", "Cadburys");
        drawer =  new Drawer(ItemCode.A1, 100);
    }

    @Test
    public void hasCode() {
        assertEquals(ItemCode.A1, drawer.getCode());
    }

    @Test
    public void drawerHasPrice() {
        assertEquals(100, drawer.getPrice());
    }

    @Test
    public void canAddProduct() {
        drawer.addItem(sweet);
        assertEquals(1, drawer.stockCount());
    }

    @Test
    public void canReturnProduct() {
        drawer.addItem(crisps);
        assertEquals(crisps, drawer.returnProduct());
        assertEquals(0, drawer.stockCount());
    }

    @Test
    public void canChangeProduct() {
        drawer.addItem(crisps);
        drawer.returnProduct();
        drawer.addItem(drink);
        assertEquals(drink, drawer.returnProduct());
    }

}
