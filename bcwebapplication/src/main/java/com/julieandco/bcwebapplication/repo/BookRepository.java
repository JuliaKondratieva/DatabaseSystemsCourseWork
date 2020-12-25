package com.julieandco.bcwebapplication.repo;

import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.Bookorder;
import com.julieandco.bcwebapplication.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Book findByAuthor(String author);
    Optional<Book> findById(Long id);
}