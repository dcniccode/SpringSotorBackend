package uni.isw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.isw.model.HistorialTecnico;

@Repository
public interface HistorialTecnicoRepository extends JpaRepository<HistorialTecnico, Long> {
    // Se pueden añadir métodos de consulta personalizados si es necesario
}
