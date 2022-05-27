package cl.camila.mapper;

import cl.camila.DTO.BookDTO;
import cl.camila.model.Book;

public class BookDTOMapper {
	
	
	public BookDTOMapper() {
	}
	
	
	public static void toEntity(BookDTO bookDTO, Book book) {
		
		book.setBookId(null);
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setLocation(bookDTO.getLocation());
	}
	
	public static Book toEntity(BookDTO bookDTO) {
		Book book = new Book();
		
		toEntity(bookDTO, book);
		return book;
	
	}

}
