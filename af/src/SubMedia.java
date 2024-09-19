public class SubMedia extends Media {

    public SubMedia(String title, String type) {
        super(title, type, calculateCopies(type), calculateDuration(type));
    }

    // Calculate the number of copies based on the media type
    private static int calculateCopies(String type) {
        switch (type) {
            case "PhysicalBook":
                return 3;  // Example: 3 copies of books
            case "DVD":
                return 2;  // Example: 2 copies of DVDs
            case "EBook":
                return Integer.MAX_VALUE;  // Infinite copies for eBooks
            default:
                return 1;
        }
    }

    // Calculate the borrowing duration based on the media type
    private static int calculateDuration(String type) {
        switch (type) {
            case "PhysicalBook":
                return 14;  // 14 days for books
            case "DVD":
                return 7;  // 7 days for DVDs
            case "EBook":
                return 21;  // 21 days for eBooks
            default:
                return 0;
        }
    }
}
