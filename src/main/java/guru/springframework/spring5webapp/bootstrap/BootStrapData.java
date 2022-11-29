package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;

import java.util.HashSet;
import java.util.Set;

public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans",new HashSet<>());
        Book bk = new Book("Hello bk", "123123", new HashSet<>());

        eric.getBooks().add(bk);
        bk.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(bk);

        System.out.println("Started in Bootstrap");
        System.out.println("No of Books: " + bookRepository.count());

    }
}
