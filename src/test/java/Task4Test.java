public class DiscountBill2 {
    private GroceryBill bill;
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public void add(Item i) {
        bill.add(i);
        if (regularCustomer && i.getDiscount() > 0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    public double getTotal() {
        double total = bill.getTotal();
        return regularCustomer ? total - discountAmount : total;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        double full = bill.getTotal();
        return (regularCustomer && full > 0)
            ? 100 - ((getTotal() * 100) / full)
            : 0.0;
    }
}
