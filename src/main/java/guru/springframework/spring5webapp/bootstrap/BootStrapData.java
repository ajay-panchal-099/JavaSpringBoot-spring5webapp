package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book bk = new Book("Hello bk", "123123");

        eric.getBooks().add(bk);
        bk.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(bk);

        System.out.println("Started in Bootstrap");
        System.out.println("No of Books: " + bookRepository.count());

        Publisher savan = new Publisher("Savan", "New-Delhi", "City-Delhi", "State-Delhi","247776" );

        publisherRepository.save(savan);

        System.out.println("Size of Publisher Repository: " + publisherRepository.count());
        
    }
}
