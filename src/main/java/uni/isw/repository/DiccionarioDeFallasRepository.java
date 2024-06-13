package uni.isw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.isw.model.DiccionarioDeFallas;

@Repository
public interface DiccionarioDeFallasRepository extends JpaRepository<DiccionarioDeFallas, Long> {
}
