package coins;

public enum CoinType {

    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    POUND(100),
    TWOPOUND(200);

    private final int value;

    CoinType(int value) {
        this.value = value;
    }

    public int getValueFromEnum() {
        return this.value;
    }

}
