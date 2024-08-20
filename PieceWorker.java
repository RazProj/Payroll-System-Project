public class PieceWorker extends Employee {
    private double pricePerItem;
    private int amountOfItems;

    public PieceWorker(String firstName, String lastName, int year, int month, int day, double pricePerItem, int amountOfItems) {
        super(firstName, lastName, year, month, day);

        if (pricePerItem < 0.0) {
            throw new IllegalArgumentException("Not a valid price");
        }

        if (amountOfItems < 0) {
            throw new IllegalArgumentException("Not a valid amount");
        }

        this.pricePerItem = pricePerItem;
        this.amountOfItems = amountOfItems;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem < 0.0) { // validate wage
            throw new IllegalArgumentException("Not a valid price");
        }

        this.pricePerItem = pricePerItem;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setAmountOfItems(int amountOfItems) {
        if (amountOfItems < 0) {
            throw new IllegalArgumentException("Not a valid amount");
        }
        this.amountOfItems = amountOfItems;
    }

    public int getAmountOfItems() {
        return amountOfItems;
    }

    @Override
    public double earnings() {
        return amountOfItems * pricePerItem;
    }

    @Override
    public String toString() {
        return String.format("piece worker: %s%n%s: %.2f; %s: %d", super.toString(), "price per item", getPricePerItem(), "amount of items", getAmountOfItems());
    }
}