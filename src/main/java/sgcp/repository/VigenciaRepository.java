package sgcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgcp.model.Vigencia;

@Repository
public interface VigenciaRepository extends JpaRepository<Vigencia, Integer> {

}
