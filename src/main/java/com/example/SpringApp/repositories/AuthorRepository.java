package com.example.SpringApp.repositories;

import com.example.SpringApp.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
