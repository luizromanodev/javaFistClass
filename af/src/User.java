import java.util.ArrayList;

public class User {
    protected String name;
    protected String userType;
    protected int borrowLimit;
    protected ArrayList<Media> loans;
    protected int fidelityBonus;
    protected int maxRenewals;

    public User(String name, String userType, int borrowLimit, int maxRenewals) {
        this.name = name;
        this.userType = userType;
        this.borrowLimit = borrowLimit;
        this.maxRenewals = maxRenewals;
        this.loans = new ArrayList<>();
        this.fidelityBonus = 1;  // Bônus de +1
    }

    public boolean canBorrow() {
        return loans.size() < borrowLimit + fidelityBonus;
    }

    public void addLoan(Media media) {
        loans.add(media);
    }

    public void removeLoan(Media media) {
        loans.remove(media);
    }

    public ArrayList<Media> getLoans() {
        return loans;
    }

    public boolean canRenew() {
        return maxRenewals > 0;
    }

    public void reduceRenewals() {
        if (maxRenewals > 0) {
            maxRenewals--;
        }
    }
}
