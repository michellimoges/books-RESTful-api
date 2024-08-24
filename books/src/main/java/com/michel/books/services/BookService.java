package com.michel.books.services;

import com.michel.books.domain.Book;
import com.michel.books.domain.BookEntity;

public interface BookService {

    BookEntity create(Book book);
}
