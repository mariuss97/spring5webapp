package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Buch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuchRepository extends CrudRepository<Buch, Long> {
}
