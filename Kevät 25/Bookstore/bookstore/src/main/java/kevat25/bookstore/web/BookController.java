package kevat25.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import kevat25.bookstore.domain.Book;
import kevat25.bookstore.domain.BookRepository;
import kevat25.bookstore.domain.CategoryRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BookController {

    @Autowired
    private BookRepository bRepo;

    @Autowired
    private CategoryRepository cRepo;

  
    @GetMapping("index")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = {"/","/booklist"} )
    public String bookList(Model model) {
        model.addAttribute("books", bRepo.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepo.findAll());
        return "addbook";
    } 
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bRepo.save(book);
        return "redirect:booklist";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	bRepo.deleteById(bookId);
        return "redirect:../booklist";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bRepo.findById(bookId));
        model.addAttribute("categories", cRepo.findAll());
        return "editbook";
    }
    
    

}
