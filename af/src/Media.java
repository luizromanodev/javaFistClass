public class Media {
    protected String title;
    protected String mediaType;
    protected int availableCopies;
    protected int borrowDuration;

    public Media(String title, String mediaType, int availableCopies, int borrowDuration) {
        this.title = title;
        this.mediaType = mediaType;
        this.availableCopies = availableCopies;
        this.borrowDuration = borrowDuration;
    }

    public boolean borrowMedia(User user) {
        if (availableCopies > 0 && user.canBorrow()) {
            availableCopies--;
            user.addLoan(this);
            return true;
        }
        return false;
    }

    public void returnMedia(User user) {
        availableCopies++;
        user.removeLoan(this);
    }

    public int getBorrowDuration() {
        return borrowDuration;
    }
}
