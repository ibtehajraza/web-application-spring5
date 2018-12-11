package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.modle.Author;
import com.example.spring5webapp.modle.Book;
import com.example.spring5webapp.modle.Publisher;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher pub1 = new Publisher("Harper Collins", "22B Street");
        Book ddd = new Book("Book number 1", "12563", pub1);

        authorRepository.save(eric);
        publisherRepository.save(pub1);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "James");
        Publisher pub2 = new Publisher("Worx", "21st Street, NewYork City");
        Book noEJB = new Book("J2EE With no EJB", "1568", pub2);

        authorRepository.save(rod);
        publisherRepository.save(pub2);
        bookRepository.save(noEJB);


    }
}

