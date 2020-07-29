package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
}
