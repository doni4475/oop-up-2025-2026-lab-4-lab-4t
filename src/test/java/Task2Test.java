public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int balance = getBalance();
        this.minBalance = balance;
        this.maxBalance = balance;
    }

    @Override
    public void credit(int amount) {
        super.credit(amount);
        updateMinMax();
    }

    @Override
    public void debit(int amount) {
        super.debit(amount);
        updateMinMax();
    }

    private void updateMinMax() {
        int balance = getBalance();
        if (balance < minBalance) minBalance = balance;
        if (balance > maxBalance) maxBalance = balance;
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}
