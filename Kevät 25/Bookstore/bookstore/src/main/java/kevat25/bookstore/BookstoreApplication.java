package kevat25.bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kevat25.bookstore.domain.Book;
import kevat25.bookstore.domain.BookRepository;
import kevat25.bookstore.domain.Category;
import kevat25.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository bRepo, CategoryRepository cRepo){
		return (args) -> {
			log.info("Tallenna kategoriat");

			Category category1 =new Category("Drama");
			Category category2 =new Category("Horror");
			Category category3 =new Category("Thriller");

			cRepo.save(category1);
			cRepo.save(category2);
			cRepo.save(category3);




			log.info("tallenna esimerkkikirjat");
			bRepo.save(new Book("Lehmä synnyttää yöllä","Pajtim Statovci",2025,"9789511357759",31.90,category1));
			bRepo.save(new Book("Viisikko","Hannu Väisänen",2025,"9789523882928",32.90,category2));
			bRepo.save(new Book("Suliko","Pirkko Saisio",2025,"9789523883376",32.90,category3));
			bRepo.save(new Book("Kaupunki ja sen epävakaa muuri","Haruki Murakami",2025,"9789520463526",32.90,category2));
			bRepo.save(new Book("Älä jätä hyvästejä","Han Kang",2024,"9789512431144",31.90,category1));

			log.info("tulosta kirjat");
			for (Book book: bRepo.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
