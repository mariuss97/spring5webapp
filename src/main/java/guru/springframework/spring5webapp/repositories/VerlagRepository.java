package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Verlag;
import org.springframework.data.repository.CrudRepository;

public interface VerlagRepository extends CrudRepository<Verlag, Long> {
}
