package kevat25.bookstore.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import kevat25.bookstore.domain.Book;
import kevat25.bookstore.domain.BookRepository;
import kevat25.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BookRestController {

 private static final Logger log = LoggerFactory.getLogger(BookRestController.class);

    private final BookRepository bookRepository;
    private CategoryRepository categoryRepository; 
    
    public BookRestController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;

    }

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        log.info("//fetch books");
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    Optional<Book> getBook(@PathVariable Long id) {
        log.info("find book, id = " + id);
        return bookRepository.findById(id);
    

}

    @PostMapping("books")
    Book newCar(@RequestBody Book newBook) {
        log.info("save new car " + newBook);
        return bookRepository.save(newBook);
    }

}
