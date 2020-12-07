package com.julieandco.bcwebapplication.repo;

import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Book findByAuthor(String author);
}