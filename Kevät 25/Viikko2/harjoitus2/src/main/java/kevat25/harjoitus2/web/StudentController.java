package kevat25.harjoitus2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import kevat25.harjoitus2.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class StudentController {

    public static List<Student> students =new ArrayList<Student>();
        
    
        static{
            students.add(new Student("Janne", "Virtanen"));
            students.add(new Student("Lassi", "Lipponen"));
            students.add(new Student("Venla", "Volpio"));

    }


    @GetMapping("/hello")
    public String showStudents(Model model) {
        model.addAttribute("students", students);
        return "studentlist";
    }
    

}
