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

import static org.junit.Assert.*;

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
    private Coin two;
    private Coin one;
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
        drawerA1.addItem(drink);
        drawerA2.addItem(crisps);
        drawerA3.addItem(sweet);
        vendingMachine.addDrawer(drawerA1);
        vendingMachine.addDrawer(drawerA2);
        vendingMachine.addDrawer(drawerA3);
        twoPound = new Coin(CoinType.TWOPOUND);
        pound = new Coin(CoinType.POUND);
        fifty = new Coin(CoinType.FIFTY);
        twenty = new Coin(CoinType.TWENTY);
        ten = new Coin(CoinType.TEN);
        five = new Coin(CoinType.FIVE);
        two = new Coin(CoinType.TWO);
        one = new Coin(CoinType.ONE);

    }

    @Test
    public void canAddCoin() {
        vendingMachine.addCoin(twenty);
        assertEquals(20, vendingMachine.getUsedCoinsTotal());
    }

    @Test
    public void canNotAdd1p(){
        vendingMachine.addCoin(one);
        assertEquals(0, vendingMachine.getUsedCoinsTotal());
        assertEquals(1, vendingMachine.getReturnedCoinsTotal());
    }

    @Test
    public void canNotAdd2p(){
        vendingMachine.addCoin(two);
        assertEquals(0, vendingMachine.getUsedCoinsTotal());
        assertEquals(2, vendingMachine.getReturnedCoinsTotal());
    }

    @Test
    public void canAdd5p(){
        vendingMachine.addCoin(five);
        assertEquals(5, vendingMachine.getUsedCoinsTotal());
    }

    @Test
    public void canAffordItem(){
        vendingMachine.addCoin(pound);
        assertTrue(vendingMachine.canAffordItem(drawerA1));
    }

    @Test
    public void canNotAffordItem(){
        vendingMachine.addCoin(twenty);
        assertFalse(vendingMachine.canAffordItem(drawerA2));
    }



}
