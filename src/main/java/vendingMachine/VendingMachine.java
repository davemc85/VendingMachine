package vendingMachine;

import coins.Coin;
import coins.CoinReturn;
import coins.CoinType;
import drawer.Drawer;
import drawer.ItemCode;
import products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawers;
    private ArrayList<Coin> usedCoins;
    private ArrayList<Coin> returnedCoins;
    private CoinReturn coinReturn;
    private Coin twoPound;
    private Coin pound;
    private Coin fifty;
    private Coin twenty;
    private Coin ten;
    private Coin five;


    public VendingMachine() {
        this.drawers = new ArrayList<Drawer>();
        this.usedCoins = new ArrayList<Coin>();
        this.returnedCoins = new ArrayList<Coin>();
        this.coinReturn = new CoinReturn();
        twoPound = new Coin(CoinType.TWOPOUND);
        pound = new Coin(CoinType.POUND);
        fifty = new Coin(CoinType.FIFTY);
        twenty = new Coin(CoinType.TWENTY);
        ten = new Coin(CoinType.TEN);
        five = new Coin(CoinType.FIVE);
    }

    public void addDrawer(Drawer drawer){
        this.drawers.add(drawer);
    }

    public ArrayList<Coin> getReturnedCoins(){
        return this.returnedCoins;
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

    public String sellItem(Drawer drawer){
        if(canAffordItem(drawer)){
            dispenseItem(drawer.getCode());
            return "Your item is on its way";
        } else {
            return "Insert more money";
        }
    }

    public void workOutChange(int change){
         ArrayList<Coin> returnedCoins = new ArrayList<Coin>();
        if(change >= 200){
            this.returnedCoins.add(twoPound);
            change -= 200;
        } if(change >= 100){
            this.returnedCoins.add(pound);
            change -= 100;
        } if (change >= 50){
            this.returnedCoins.add(fifty);
            change -= 50;
        } if (change >= 20){
            this.returnedCoins.add(twenty);
            change -= 20;
            if (change >= 20){
                this.returnedCoins.add(twenty);
                change -= 20;
            }
        } if (change >= 10){
            this.returnedCoins.add(ten);
            change -= 10;
            if (change >= 10){
                this.returnedCoins.add(twenty);
                change -= 10;
            }
        } if (change >= 5){
            this.returnedCoins.add(five);
            change -= 5;
        }
    }


}
