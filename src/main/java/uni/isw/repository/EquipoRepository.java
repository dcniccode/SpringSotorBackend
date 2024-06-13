package uni.isw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.isw.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    // Se pueden añadir métodos de consulta personalizados si es necesario
}
