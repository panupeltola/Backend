package kevat25.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {

    @GetMapping("index")
    public String getIndex() {
        return "index";
    }
    

}
