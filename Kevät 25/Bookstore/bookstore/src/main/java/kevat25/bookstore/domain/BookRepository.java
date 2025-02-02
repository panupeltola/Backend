package kevat25.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>  
//Long luokan vastattava Book luokan ID:n tyyppiä
{

    
} 