package coins;

public enum Coins {


    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    POUND(100),
    TWOPOUND(200);

    private final int value;

    Coins(int value) {
        this.value = value;
    }

    public int getValueFromEnum() {
        return this.value;
    }
}

