package com.michel.books.services;

import com.michel.books.domain.Book;
import com.michel.books.domain.BookEntity;
import com.michel.books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity create(final Book book) {
        final BookEntity bookEntity = bookToBookEntity(book);
        return bookEntityToBook(bookRepository.save(bookEntity));
    }

    private BookEntity bookToBookEntity(Book book) {
        return BookEntity.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    private BookEntity bookEntityToBook(BookEntity bookEntity) {
        return BookEntity.builder()
                .isbn(bookEntity.getIsbn())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .build();
    }
}
