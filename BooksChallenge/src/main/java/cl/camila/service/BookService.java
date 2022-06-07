package cl.camila.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.camila.DTO.BookDTO;
import cl.camila.DTO.MessageDTO;
import cl.camila.model.Book;

@Service
public interface BookService {
	
	public Optional<Book> findById(Integer id);
	
	public MessageDTO save(BookDTO bookDTO);

}
