package cl.camila;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import cl.camila.DTO.BookDTO;
import cl.camila.controller.BookController;
import cl.camila.service.BookServiceImpl;

@WebMvcTest(BookController.class)
class BooksChallengeApplicationTests {
	
	@Autowired
	BookController bookController;
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	BookServiceImpl bookService;
	
	
	@Test	
	void getUserByIdTest() {
		
		//mock the data return by the user service class
		BookDTO book = new BookDTO();
		book.setTitle("Dune");
		book.setAuthor("Frank Hebert");
		book.setLocation("1a");
		
		when(bookService.findById(anyInt())).thenReturn(Optional.of(book));
		
		//create a mock Http request to verify the expected result
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.Title").value("Dune"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.Author").value("Frank Hebert"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.Location").value("1a"))
		.andExpect(status().isOk());
	}
	
	
	

//	@Mock
//	BookService bookServiceMock;
//		
//    @InjectMocks
//    BookController bookController = new BookController();
//
//    MockMvc mockMvc;
//    
//    @Before
//    public void getATestBook() {
//    	BookDTO testBook = new BookDTO();
//    	
//    }
//    
//    @Before
//    public void setup(){
//        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//    }
//	
//    @Test
//    public void testInsertStudent(){
//
//        BookDTO book = new BookDTO();
//
//        bookController.save(book);
//
//        verify(bookServiceMock, times(1)).save(book);
//    }
//	


}
