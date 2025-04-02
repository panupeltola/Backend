package kevat25.dronepaivakirja;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kevat25.dronepaivakirja.domain.Kayttaja;
import kevat25.dronepaivakirja.domain.KayttajaRepository;
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
	public CommandLineRunner demoData(LentoRepository lentoRepo, LentopaikkaRepository paikkaRepo, KayttajaRepository KRepository){
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
			Lento lento4 = new Lento("Kaarlo Käyttäjä", "13:28", "28.3.2025", paikka2, 11);

			lentoRepo.save(lento1);
			lentoRepo.save(lento2);
			lentoRepo.save(lento3);
			lentoRepo.save(lento4);

			log.info("tulosta kirjat");
			for (Lento lento: lentoRepo.findAll()) {
				log.info(lento.toString());
			}
			

			log.info("Tallenna kayttajat");
			Kayttaja kayttaja1 = new Kayttaja("Antti Admin", "admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			Kayttaja kayttaja2 = new Kayttaja("Kaarlo Käyttäjä", "user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			Kayttaja kayttaja3 = new Kayttaja("Martti Moderaattori", "moderator","$2a$12$WyQfml4N0usI2dR3rGzKTehyvvNrWOex4X0f6UK8S/3EG47QdyRtW", "MODERATOR");

			KRepository.save(kayttaja1);
			KRepository.save(kayttaja2);
			KRepository.save(kayttaja3);






	};


}
}
