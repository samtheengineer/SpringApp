package com.example.SpringApp.bootstrap;

import com.example.SpringApp.models.Author;
import com.example.SpringApp.models.Book;
import com.example.SpringApp.models.Publisher;
import com.example.SpringApp.repositories.AuthorRepository;
import com.example.SpringApp.repositories.BookRepository;
import com.example.SpringApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        Author stephen = new Author("Stephen", "Covey");
        Book sevenHabits = new Book("The 7 Habits of Highly Effective People", "315542");
        Publisher pub =new Publisher();
        pub.setName("SFG Publishing");
        pub.setCity("St Petersburg");
        pub.setState("FL");

        publisherRepository.save(pub);

        System.out.println("Publisher Count: " + publisherRepository.count());

        stephen.getBooks().add(sevenHabits);
        sevenHabits.getAuthors().add(stephen);

        authorRepository.save(stephen);
        bookRepository.save(sevenHabits);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "645642");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());

    }

}
