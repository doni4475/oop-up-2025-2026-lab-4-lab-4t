package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill extends GroceryBill {

    private int discountCount;
    private double discountAmount;
    private final boolean regularCustomer;

    public DiscountBill(final Employee clerk, final boolean isRegularCustomer) {
        super(clerk);
        this.regularCustomer = isRegularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(final Item i) {
        super.add(i);
        if (regularCustomer && i.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        if (!regularCustomer) {
            return super.getTotal();
        } else {
            return super.getTotal() - discountAmount;
        }
    }

    public int getDiscountCount() {
        if (regularCustomer) {
            return discountCount;
        } else {
            return 0;
        }
    }

    public double getDiscountAmount() {
        if (regularCustomer) {
            return discountAmount;
        } else {
            return 0.0;
        }
    }

    public double getDiscountPercent() {
        if (regularCustomer) {
            return (discountAmount * 100) / super.getTotal();
        } else {
            return 0.0;
        }
    }
}