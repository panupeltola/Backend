package kevat25.dronepaivakirja.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kevat25.dronepaivakirja.domain.Kayttaja;
import kevat25.dronepaivakirja.domain.KayttajaRepository;
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

    @Autowired
    private KayttajaRepository KRepo;



    @RequestMapping(value = {"/","/lentolista"} )
    public String lentolista(Model model, @AuthenticationPrincipal User kayttaja){
        String kayttajanimi = kayttaja.getUsername();
        Kayttaja kirjautunutKayttaja = KRepo.findByUsername(kayttajanimi);
        String rooli = kirjautunutKayttaja.getRole();

        List<Lento> kaikkiLennot = (List<Lento>) lentoRepo.findAll(); 

        List<Lento> suodatetutLennot = new ArrayList<>();
        if ("USER".equals(rooli)) {
            for (Lento lento : kaikkiLennot) {
                if (lento.getLentaja().equals(kirjautunutKayttaja.getHenkilonimi())) {
                    suodatetutLennot.add(lento);
                }
            }
        } else {
            suodatetutLennot = kaikkiLennot; 
        }
       
        


        model.addAttribute("lennot", suodatetutLennot);
        return "lentolista";
        
    }

    @RequestMapping(value = "/lisaalento")
    public String lisaaLento(Model model, @AuthenticationPrincipal User kayttaja){
        String kayttajanimi = kayttaja.getUsername();
        Kayttaja kirjautunutKayttaja = KRepo.findByUsername(kayttajanimi);

        Lento uusiLento = new Lento(kirjautunutKayttaja.getHenkilonimi());
        

    	model.addAttribute("lento", uusiLento);
        model.addAttribute("lentopaikat", paikkaRepo.findAll());
        return "lisaalento";
    }

    @RequestMapping(value = "/tallennalento", method = RequestMethod.POST)
    public String tallennalento(Lento lento){
        lentoRepo.save(lento);
        return "redirect:lentolista";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/lisaalentopaikka")
    public String lisaaLentopaikka(Model model){
    	model.addAttribute("lentopaikka", new Lentopaikka());
        return "lisaalentopaikka";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
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

@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/muokkaa/{id}")
    public String muokkaaLentoa(@PathVariable("id") Long Id, Model model) {
        model.addAttribute("lento", lentoRepo.findById(Id));
        model.addAttribute("lentopaikat", paikkaRepo.findAll());
        return "muokkaalentoa";


    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/poista/{id}", method = RequestMethod.GET)
    public String poistaLento(@PathVariable("id") Long Id, Model model) {
    	lentoRepo.deleteById(Id);
        return "redirect:../lentolista";
    }

@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	    

}


