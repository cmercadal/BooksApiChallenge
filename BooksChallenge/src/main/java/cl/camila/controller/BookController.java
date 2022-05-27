package cl.camila.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.camila.DTO.BookDTO;
import cl.camila.model.Book;
import cl.camila.service.BookService;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/{bookId}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Book> findAById(@PathVariable Integer bookId){
		return bookService.findById(bookId);
	}

	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public String save(@RequestBody BookDTO bookDTO) {
		return bookService.save(bookDTO);
	}
	
}
