package com.example.SpringApp.repositories;

import com.example.SpringApp.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {



}
