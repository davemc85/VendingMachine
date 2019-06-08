package coinTests;

import coins.Coin;
import coins.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    private Coin twoPound;
    private Coin pound;
    private Coin fifty;
    private Coin twenty;
    private Coin ten;
    private Coin five;

    @Before
    public void setUp(){
        twoPound = new Coin(CoinType.TWOPOUND);
        pound = new Coin(CoinType.POUND);
        fifty = new Coin(CoinType.FIFTY);
        twenty = new Coin(CoinType.TWENTY);
        ten = new Coin(CoinType.TEN);
        five = new Coin(CoinType.FIVE);
    }

    @Test
    public void canGetTwoPound(){
        assertEquals(200, twoPound.getValue());
    }

    @Test
    public void canGetPound(){
        assertEquals(100, pound.getValue());
    }

    @Test
    public void canGetFifty(){
        assertEquals(50, fifty.getValue());
    }

    @Test
    public void canGetTwenty(){
        assertEquals(20, twenty.getValue());
    }

    @Test
    public void canGetTen(){
        assertEquals(10, ten.getValue());
    }

    @Test
    public void canGetFive(){
        assertEquals(5, five.getValue());
    }
}
