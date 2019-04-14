package stream.api.streamexample;

public class Book {
    private Author author;
    private String title;
    private Genre genre;

    public Book(Author author, String title, Genre genre) {
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                '}';
    }
}
