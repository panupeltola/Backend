package kevat25.bookstore.domain;

public class Book {
    String title, author;
    int publicationYear, isbn;
    float price;
    
    
    
    public Book() {
    }



    public Book(String title, String author, int publicationYear, int isbn, float price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }



    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public String getAuthor() {
        return author;
    }



    public void setAuthor(String author) {
        this.author = author;
    }



    public int getPublicationYear() {
        return publicationYear;
    }



    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }



    public int getIsbn() {
        return isbn;
    }



    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }



    public float getPrice() {
        return price;
    }



    public void setPrice(float price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", price=" + price + "]";
    }

    

    
}
