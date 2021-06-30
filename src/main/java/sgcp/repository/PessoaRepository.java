package sgcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgcp.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String>{

}
