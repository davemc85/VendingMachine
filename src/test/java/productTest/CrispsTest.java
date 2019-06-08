package productTest;

import org.junit.Before;
import org.junit.Test;
import products.Crisps;

import static org.junit.Assert.assertEquals;

public class CrispsTest {

    private Crisps crisps;

    @Before
    public void setUp(){
        crisps = new Crisps("Wotsits", "Walkers");
    }

    @Test
    public void canGetName(){
        assertEquals("Wotsits", crisps.getName());
    }

    @Test
    public void canGetBrand(){
        assertEquals("Walkers", crisps.getBrand());
    }
}
