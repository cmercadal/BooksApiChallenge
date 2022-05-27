package cl.camila.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import cl.camila.DTO.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookId;
	private String title;
	private String author;
	private String location;
	
	public BookDTO toBookDTO() {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle(this.getTitle());
		bookDTO.setAuthor(this.getAuthor());
		bookDTO.setLocation(this.getLocation());
		return bookDTO;
		
	}

}

