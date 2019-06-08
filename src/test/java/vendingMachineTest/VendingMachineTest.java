package vendingMachineTest;

import coins.Coin;
import coins.CoinType;
import drawer.Drawer;
import drawer.ItemCode;
import org.junit.Before;
import org.junit.Test;
import products.Crisps;
import products.Drink;
import products.Sweet;
import vendingMachine.VendingMachine;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    private VendingMachine vendingMachine;
    private Drawer drawerA1;
    private Drawer drawerA2;
    private Drawer drawerA3;
    private Coin twoPound;
    private Coin pound;
    private Coin fifty;
    private Coin twenty;
    private Coin ten;
    private Coin five;
    private Crisps crisps;
    private Sweet sweet;
    private Drink drink;


    @Before
    public void setUp(){
        vendingMachine = new VendingMachine();
        crisps = new Crisps("Wotsits", "Walkers");
        drink = new Drink("Irn Bru", "Barrs");
        sweet = new Sweet("Wispa", "Cadburys");
        drawerA1 =  new Drawer(ItemCode.A1, 100);
        drawerA2 =  new Drawer(ItemCode.A2, 50);
        drawerA3 =  new Drawer(ItemCode.A3, 65);
        twoPound = new Coin(CoinType.TWOPOUND);
        pound = new Coin(CoinType.POUND);
        fifty = new Coin(CoinType.FIFTY);
        twenty = new Coin(CoinType.TWENTY);
        ten = new Coin(CoinType.TEN);
        five = new Coin(CoinType.FIVE);
        vendingMachine.addDrawer(drawerA1);
        vendingMachine.addDrawer(drawerA2);
        vendingMachine.addDrawer(drawerA3);
    }

    @Test
    public void canAddCoin() {
        vendingMachine.addCoin(twenty);
        assertEquals(20, vendingMachine.getEnteredCoinsTotal());
    }
}
