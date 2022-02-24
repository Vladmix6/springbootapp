package com.vladblagoci.springbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vladblagoci.springbootapp.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);
}
