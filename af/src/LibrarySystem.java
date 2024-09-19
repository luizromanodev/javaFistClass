import java.util.ArrayList;

public class LibrarySystem {
    private ArrayList<Media> catalog;
    private ArrayList<User> users;

    public LibrarySystem() {
        catalog = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Add media to the catalog
    public void addMedia(Media media) {
        catalog.add(media);
    }

    // Register a new user
    public void addUser(User user) {
        users.add(user);
    }

    // Loan media to a user
    public String loanMedia(User user, String mediaTitle) {
        for (Media media : catalog) {
            if (media.title.equals(mediaTitle)) {
                if (media.borrowMedia(user)) {
                    return mediaTitle + " borrowed successfully.";
                } else {
                    return "Cannot borrow: limit reached or no available copies.";
                }
            }
        }
        return "Media not found.";
    }

    // Return media from a user
    public String returnMedia(User user, String mediaTitle) {
        for (Media media : user.getLoans()) {
            if (media.title.equals(mediaTitle)) {
                media.returnMedia(user);
                return mediaTitle + " returned successfully.";
            }
        }
        return "Media not found in user's loans.";
    }

    // Renew media for a user
    public String renewMedia(User user, String mediaTitle) {
        for (Media media : user.getLoans()) {
            if (media.title.equals(mediaTitle)) {
                if (user.canRenew()) {
                    user.reduceRenewals();
                    return mediaTitle + " renewed successfully.";
                } else {
                    return "Renewal limit reached.";
                }
            }
        }
        return "Media not found in user's loans.";
    }
}
