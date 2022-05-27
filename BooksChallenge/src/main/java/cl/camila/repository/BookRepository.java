package cl.camila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.camila.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
