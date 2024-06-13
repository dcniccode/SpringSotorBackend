package uni.isw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.isw.model.InformeTecnico;

@Repository
public interface InformeTecnicoRepository extends JpaRepository<InformeTecnico, Long> {
}
