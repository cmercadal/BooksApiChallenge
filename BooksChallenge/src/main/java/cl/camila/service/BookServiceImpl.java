package cl.camila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camila.DTO.BookDTO;
import cl.camila.DTO.MessageDTO;
import cl.camila.mapper.BookDTOMapper;
import cl.camila.model.Book;
import cl.camila.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepo;


	@Override
	public Optional<Book> findById(Integer id) {
		return bookRepo.findById(id);
	}


	@Override
	public MessageDTO save(BookDTO bookDTO) {
		
		MessageDTO message = new MessageDTO();
		
		try {
			bookRepo.save(BookDTOMapper.toEntity(bookDTO));
			message.setMessage(String.format("%s guardado correctamente", bookDTO.getTitle()));
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			message.setMessage("Error al guardar el libro");
			return message;
		}
		
		
		
	}

}
