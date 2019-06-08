package coinTests;

import coins.Coin;
import coins.CoinReturn;
import coins.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinReturnTest {

    private CoinReturn coinReturn;
    private Coin twoPound;
    private Coin pound;
    private Coin fifty;
    private Coin twenty;
    private Coin ten;
    private Coin five;

    @Before
    public void setUp(){
        coinReturn = new CoinReturn();
        twoPound = new Coin(CoinType.TWOPOUND);
        pound = new Coin(CoinType.POUND);
        fifty = new Coin(CoinType.FIFTY);
        twenty = new Coin(CoinType.TWENTY);
        ten = new Coin(CoinType.TEN);
        five = new Coin(CoinType.FIVE);
    }

    @Test
    public void canAddCoin() {
        coinReturn.addCoin(twoPound);
        assertEquals(200, coinReturn.getTotal());
    }

    @Test
    public void canGetTotal() {
        coinReturn.addCoin(five);
        coinReturn.addCoin(ten);
        coinReturn.addCoin(twenty);
        coinReturn.addCoin(fifty);
        coinReturn.addCoin(pound);
        coinReturn.addCoin(twoPound);
        assertEquals(385, coinReturn.getTotal());
    }

}
