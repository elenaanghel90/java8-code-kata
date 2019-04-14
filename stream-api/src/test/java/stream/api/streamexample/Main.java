package stream.api.streamexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Book> bookList;
    public static List<Author> authorList;

    public static void main(String[] args) {

        Author mihaiEminescu = new Author(36, "Mihai Eminescu", Gender.MALE);
        Author ioanaSaviana = new Author(26, "Ioana Saviana", Gender.FEMALE);
        Author mariaIoanaa = new Author(29, "Maria Ioana", Gender.FEMALE);
        Author elenaMaria = new Author(31, "Elena Maria", Gender.FEMALE);
        Author ionCreanga = new Author(86, "Ion Creanga", Gender.MALE);
        Book poems = new Book(mihaiEminescu, "Poezii", Genre.POEMS);
        Book poems2 = new Book(mihaiEminescu, "Poezii vol 2", Genre.POEMS);
        Book stories = new Book(ioanaSaviana, "Povesti", Genre.STORIES);
        Book novels = new Book(ionCreanga, "Nuvele", Genre.NOVELS);
        Book romancies = new Book(ionCreanga, "Romantice", Genre.ROMANCE);

        bookList = Arrays.asList(poems, poems2, stories, novels, romancies);
        authorList = Arrays.asList(mihaiEminescu, ioanaSaviana, mariaIoanaa, elenaMaria, ionCreanga);

        //showTheBookList();
//        showThePoemBooks();
        //showTheBookTitlesWrittenBy(ionCreanga);
        computeTheSumOfAgesOfAllFemalesAuthorsYoungerYoungerThan30();
    }

    public static void showTheBookList() {
        for (Book book : bookList) {
            System.out.println(book);
        }
        //echivalent cu for each de mai sus
        bookList.stream()
                .forEach(book -> System.out.println(book));

        //cu method reference, acelasi lucru ca for each si stream
        bookList.forEach(System.out::println);
    }

    public static void showThePoemBooks() {
        for (Book book : bookList) {
            if (book.getGenre() == Genre.POEMS) {
                System.out.println(book);
            }
        }
        //stream with lambdas
        bookList.stream()
                .filter(book -> book.getGenre() == Genre.POEMS)
                .forEach(book -> System.out.println(book));

        //stream with method reference
        bookList.stream()
                .filter(Main::isABookOfPoems)
                .forEach(System.out::println);
    }

    public static void showTheBookTitlesWrittenBy(Author author) {
        for (Book book : bookList) {
            if (theBookIsWrittenBy(book, author)) {
                String booksname = book.getTitle();
                System.out.println(booksname);
            }
        }
        //stream with lambdas
        bookList.stream()
                .filter(book -> theBookIsWrittenBy(book, author))
                .map(book -> book.getTitle())
                .forEach(bookTitle -> System.out.println(bookTitle));

        //stream with method reference
        bookList.stream()
                .filter(book -> theBookIsWrittenBy(book, author))
                .map(Book::getTitle)
                .forEach(System.out::println);

    }

    public static void computeTheSumOfAgesOfAllFemalesAuthorsYoungerYoungerThan30() {
        int sumOfAllAges = 0;
        for (Author author1 : authorList) {
            if (author1.getGender().equals(Gender.FEMALE) && author1.getAge() < 30) {
                sumOfAllAges += author1.getAge();
            }
        }
        System.out.println(sumOfAllAges);

        //stream with lambdas
        Integer sumOfAgesStreamLambda = authorList.stream()
                .filter(author -> author.getGender() == Gender.FEMALE)
                .filter(author -> author.getAge() < 30)
                .map(author -> author.getAge())
                .reduce(0, (a, b) -> a + b);

        System.out.println(sumOfAgesStreamLambda);

        //stream with method reference
        Integer sumOfAgesStreamLambdaMethodReference = authorList.stream()
                .filter(Author::isFemale)
                .filter(Main::isLessThan30YearsOld)
                .map(Author::getAge)
                .reduce(0, Integer::sum);
        System.out.println(sumOfAgesStreamLambdaMethodReference);
    }

    private static boolean isLessThan30YearsOld(Author author) {
        return author.getAge() < 30;
    }

    private static boolean theBookIsWrittenBy(Book book, Author author) {
        return book.getAuthor().getName().equals(author.getName());
    }


    private static boolean isABookOfPoems(Book book) {
        return book.getGenre() == Genre.POEMS;
    }
}
