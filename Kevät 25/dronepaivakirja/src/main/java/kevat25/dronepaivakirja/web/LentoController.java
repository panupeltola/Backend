package kevat25.dronepaivakirja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kevat25.dronepaivakirja.domain.Lento;
import kevat25.dronepaivakirja.domain.LentoRepository;
import kevat25.dronepaivakirja.domain.Lentopaikka;
import kevat25.dronepaivakirja.domain.LentopaikkaRepository;

@Controller
public class LentoController {

    @Autowired
    private LentoRepository lentoRepo;

    @Autowired
    private LentopaikkaRepository paikkaRepo;



    @RequestMapping(value = {"/","/lentolista"} )
    public String lentolista(Model model){
        model.addAttribute("lennot", lentoRepo.findAll());
        return "lentolista";
        
    }

    @RequestMapping(value = "/lisaalento")
    public String lisaaLento(Model model){
    	model.addAttribute("lento", new Lento());
        model.addAttribute("lentopaikat", paikkaRepo.findAll());
        return "lisaalento";
    }

    @RequestMapping(value = "/tallennalento", method = RequestMethod.POST)
    public String tallennalento(Lento lento){
        lentoRepo.save(lento);
        return "redirect:lentolista";
    }
    
    @RequestMapping(value = "/lisaalentopaikka")
    public String addStudent(Model model){
    	model.addAttribute("lentopaikka", new Lentopaikka());
        return "lisaalentopaikka";
    }

    @RequestMapping(value = "/tallennalentopaikka", method = RequestMethod.POST)
    public String tallennalentopaikka(Lentopaikka paikka){
        paikkaRepo.save(paikka);
        return "redirect:lentolista";
}

@RequestMapping(value = "/nayta/{id}")
public String naytaLento(@PathVariable("id") Long id, Model model) {
    Lento lento = lentoRepo.findById(id).orElse(null);
    if (lento == null) {
        model.addAttribute("Virhe", "Lentoa ei löydy!");
        return "error"; 
    }
    model.addAttribute("lento", lento);
    return "naytalento"; 
}

@RequestMapping(value = "/muokkaa/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("lento", lentoRepo.findById(bookId));
        model.addAttribute("lentopaikat", paikkaRepo.findAll());
        return "muokkaalentoa";


    }

}


