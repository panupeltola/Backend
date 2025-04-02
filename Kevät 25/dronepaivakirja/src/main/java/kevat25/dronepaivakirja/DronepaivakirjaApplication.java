package kevat25.dronepaivakirja;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kevat25.dronepaivakirja.domain.Lento;
import kevat25.dronepaivakirja.domain.LentoRepository;
import kevat25.dronepaivakirja.domain.Lentopaikka;
import kevat25.dronepaivakirja.domain.LentopaikkaRepository;

@SpringBootApplication
public class DronepaivakirjaApplication {

	private static final Logger log = LoggerFactory.getLogger(DronepaivakirjaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DronepaivakirjaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(LentoRepository lentoRepo, LentopaikkaRepository paikkaRepo){
		return (args) -> {
			log.info("Tallenna esimerkkipaikat");

			Lentopaikka paikka1 = new Lentopaikka("Kruunusilta", "Helsinki", 60.1742745911264, 25.00188530118451) ;
			Lentopaikka paikka2 = new Lentopaikka("Keilaniemi", "Espoo", 60.17485416804947, 24.830906886272572) ;
			Lentopaikka paikka3 = new Lentopaikka("Lentokenttä", "Vantaa", 60.31294040323603, 24.956458203698194) ;
			paikkaRepo.save(paikka1);
			paikkaRepo.save(paikka2);
			paikkaRepo.save(paikka3);
			



			log.info("Tallenna esimerkkilennot");
			Lento lento1 = new Lento("Panu Peltola", "18:28", "30.3.2025", paikka1, 17.28);
			Lento lento2 = new Lento("Matti Möttönen", "19:38", "31.3.2025", paikka2, 19);
			Lento lento3 = new Lento("Harri Hylje", "13:28", "28.3.2025", paikka3, 12);

			lentoRepo.save(lento1);
			lentoRepo.save(lento2);
			lentoRepo.save(lento3);

			log.info("tulosta kirjat");
			for (Lento lento: lentoRepo.findAll()) {
				log.info(lento.toString());
			}


	};


}
}
