package vendingMachine;

import coins.Coin;
import coins.CoinReturn;
import drawer.Drawer;
import drawer.ItemCode;
import products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawers;
    private ArrayList<Coin> usedCoins;
    private ArrayList<Coin> returnedCoins;
    private CoinReturn coinReturn;

    public VendingMachine() {
        this.drawers = new ArrayList<Drawer>();
        this.usedCoins = new ArrayList<Coin>();
        this.returnedCoins = new ArrayList<Coin>();
        this.coinReturn = new CoinReturn();
    }

    public void addDrawer(Drawer drawer){
        this.drawers.add(drawer);
    }

    public int getUsedCoinsTotal() {
        int total = 0;
        for (Coin coin : this.usedCoins) {
            total += coin.getValue();
        }
        return total;
    }

    public int getReturnedCoinsTotal() {
        int total = 0;
        for (Coin coin : this.returnedCoins) {
            total += coin.getValue();
        }
        return total;
    }

    public boolean isCoinValid(Coin coin) {
        if (coin.getValue() >= 5) {
            return true;
        }
        return false;
    }

    public void addCoin(Coin coin) {
        if (this.isCoinValid(coin) == true) {
            this.usedCoins.add(coin);
        } else {
            this.returnedCoins.add(coin);
        }
    }

    public Product dispenseItem(ItemCode code){
        for (Drawer drawer : drawers){
            if ( drawer.getCode() == code){
                return drawer.returnProduct();
            }
        } return null;
    }

    public boolean canAffordItem(Drawer drawer) {
        if (getUsedCoinsTotal() >= drawer.getPrice()){
            return true;
        } else {
            return false;
        }
    }

}
