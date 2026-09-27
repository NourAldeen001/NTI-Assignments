public class Book {

    String title;
    String author;
    int pages;
    double price;

    Book() {

    }

    Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author +
                ", pages: " + pages + ", price:" + price);
    }

    boolean isLongBook() {
        return pages > 300;
    }



}
