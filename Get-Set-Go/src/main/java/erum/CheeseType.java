package erum;

public enum CheeseType {
    AMERICAN(0.75),
    PROVOLONE(0.75),
    CHEDDAR(0.75),
    SWISS(0.75);

    private final double price;

    CheeseType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
