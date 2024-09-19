public class Main {
    public static void main(String[] args) {
        // Initialize the library system
        LibrarySystem library = new LibrarySystem();

        // Add media to catalog
        Media book = new SubMedia("The Great Gatsby", "PhysicalBook");
        Media dvd = new SubMedia("Inception", "DVD");
        Media ebook = new SubMedia("Digital Fortress", "EBook");

        library.addMedia(book);
        library.addMedia(dvd);
        library.addMedia(ebook);

        // Create users
        User student = new User("John Doe", "Student", 3, 1);  // 1 renewal for students
        User teacher = new User("Jane Smith", "Teacher", 6, 3);  // 3 renewals for teachers

        library.addUser(student);
        library.addUser(teacher);

        // Student borrows a book
        System.out.println(library.loanMedia(student, "The Great Gatsby"));

        // Teacher borrows an ebook
        System.out.println(library.loanMedia(teacher, "Digital Fortress"));

        // Return a book
        System.out.println(library.returnMedia(student, "The Great Gatsby"));

        // Renew an ebook for the teacher
        System.out.println(library.renewMedia(teacher, "Digital Fortress"));
    }
}
