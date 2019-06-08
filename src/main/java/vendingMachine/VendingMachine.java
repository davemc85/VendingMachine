package vendingMachine;

import coins.Coin;
import coins.CoinReturn;
import drawer.Drawer;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawers;
    private ArrayList<Coin> usedCoins;
    private CoinReturn coinReturn;

    public VendingMachine() {
        this.drawers = new ArrayList<Drawer>();
        this.usedCoins = new ArrayList<Coin>();
        this.coinReturn = new CoinReturn();
    }

    public void addDrawer(Drawer drawer){
        this.drawers.add(drawer);
    }

    public void addCoin(Coin coin) {
        this.usedCoins.add(coin);
    }


    public int getEnteredCoinsTotal() {
        int total = 0;
        for (Coin coin : this.usedCoins) {
            total += coin.getValue();
        }
        return total;
    }
}
