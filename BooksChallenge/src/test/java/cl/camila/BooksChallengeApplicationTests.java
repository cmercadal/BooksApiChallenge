package cl.camila;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cl.camila.model.Book;
import cl.camila.service.BookService;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestCase.class, WebAppConfiguration.class})
@WebAppConfiguration
class BooksChallengeApplicationTests {

	//	private static RepositorioPersona repositorioPersona = mock(RepositorioPersona.class); //se le pasa la clase pero sin la palabra Test

	@Autowired
	BookService bookServiceMock;
	
	@Test
	public void findByIdTest() {
		Book first = new Book();
		first.setBookId(1);
		first.setTitle("Dune");
		first.setAuthor("Frank Herbert");
		first.setLocation("1a");
		
		when(bookServiceMock.findById(1)).thenReturn(Optional.of(first));
		
	}

}
