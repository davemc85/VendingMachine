package productTest;

import org.junit.Before;
import org.junit.Test;
import products.Drink;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    private Drink drink;

    @Before
    public void setUp(){
        drink = new Drink("Irn Bru", "Barrs");
    }

    @Test
    public void canGetName(){
        assertEquals("Irn Bru", drink.getName());
    }

    @Test
    public void canGetBrand(){
        assertEquals("Barrs", drink.getBrand());
    }

}
