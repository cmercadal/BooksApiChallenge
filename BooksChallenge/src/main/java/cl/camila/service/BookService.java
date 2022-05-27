package cl.camila.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.camila.DTO.BookDTO;
import cl.camila.model.Book;

@Service
public interface BookService {
	
	public Optional<Book> findById(Integer id);
	
	public String save(BookDTO bookDTO);

}
