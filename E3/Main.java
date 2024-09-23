package E3;

import E3.Author.Author;
import E3.Author.Gender;
import E3.Book.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Vinh", "vinhle5620@gmail.com", Gender.Male));
        authors.add(new Author("ABC", "123@gmail.com", Gender.Female));

        List<Book> books = new ArrayList<>();
//        for(Author a : authors){
//            System.out.println(a);
//        }
        books.add(new Book("Book1", authors.get(0), 2200, 5));
        books.add( new Book("Aook2", authors.get(1), 2500, 5));
//        for (Book a : books) {
//            System.out.println(a);
//        }
        System.out.println("\nSap xep ten sach:");
        books.stream()
                .sorted(Comparator.comparing(Book::getName).reversed())
                .forEach(System.out::println);

        System.out.println("\nGia tien sach cao nhat:");
        books.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .ifPresent(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nNhap ten tac gia: ");
        String authorName = scanner.nextLine();

        System.out.println("\nSach viet boi" + authorName + ":");
        books.stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .forEach(System.out::println);
    }
}
