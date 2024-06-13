package uni.isw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.isw.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    // Se pueden añadir métodos de consulta personalizados si es necesario
}
