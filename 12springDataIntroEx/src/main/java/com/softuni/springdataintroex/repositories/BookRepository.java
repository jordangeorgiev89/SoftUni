package com.softuni.springdataintroex.repositories;
import com.softuni.springdataintroex.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    List<Book> findAllByReleaseDateAfter(LocalDate localDate);
}
