public class DiscountBill extends GroceryBill {
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;
    private double discountPercent;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        if (regularCustomer && i.getDiscount() > 0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double total = super.getTotal();
        if (regularCustomer) {
            return total - discountAmount;
        }
        return total;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        double full = super.getTotal();
        return (regularCustomer && full > 0)
            ? 100 - ((getTotal() * 100) / full)
            : 0.0;
    }
}
