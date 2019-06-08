package productTest;

import org.junit.Before;
import org.junit.Test;
import products.Sweet;

import static org.junit.Assert.assertEquals;

public class SweetTest {

    private Sweet sweet;

    @Before
    public void setUp(){
        sweet = new Sweet("Wispa", "Cadburys");
    }

    @Test
    public void canGetName(){
        assertEquals("Wispa", sweet.getName());
    }

    @Test
    public void canGetBrand(){
        assertEquals("Cadburys", sweet.getBrand());
    }
}
