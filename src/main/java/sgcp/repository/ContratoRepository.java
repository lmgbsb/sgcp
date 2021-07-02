package sgcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgcp.model.Contrato;
import sgcp.model.ContratoKey;

@Repository
public interface ContratoRepository extends JpaRepository <Contrato, ContratoKey>{

}
