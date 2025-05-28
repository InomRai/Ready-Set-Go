package erum;

public enum BreadType {
    WHITE(5.50),
    WHEAT(5.50),
    RYE(5.50),
    WRAP(5.50);

    private final double price;

    BreadType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
