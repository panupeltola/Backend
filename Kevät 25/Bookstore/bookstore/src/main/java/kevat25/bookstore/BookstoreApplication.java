package kevat25.bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kevat25.bookstore.domain.Book;
import kevat25.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository){
		return (args) -> {
			log.info("tallenna esimerkkikirjat");
			bookRepository.save(new Book("Lehmä synnyttää yöllä","Pajtim Statovci",2025,"9789511357759",31.90));
			bookRepository.save(new Book("Viisikko","Hannu Väisänen",2025,"9789523882928",32.90));
			bookRepository.save(new Book("Suliko","Pirkko Saisio",2025,"9789523883376",32.90));
			bookRepository.save(new Book("Kaupunki ja sen epävakaa muuri","Haruki Murakami",2025,"9789520463526",32.90));
			bookRepository.save(new Book("Älä jätä hyvästejä","Han Kang",2024,"9789512431144",31.90));

			log.info("tulosta kirjat");
			for (Book book: bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
