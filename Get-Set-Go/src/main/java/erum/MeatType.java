package erum;

public enum MeatType {
    STEAK(1.00),
    HAM(1.00),
    SALAMI(1.00),
    ROAST_BEEF(1.00),
    CHICKEN(1.00),
    BACON(1.00);

    private final double price;

    MeatType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
