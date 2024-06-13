
package uni.isw.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.model.Asignacion;
import uni.isw.repository.AsignacionRepository;

@Service

public class AsignacionService {
    @Autowired
    private AsignacionRepository asignacionRepository;

    public List<Asignacion> getAsignacions() {
        return asignacionRepository.findAll();
    }

    public Optional<Asignacion> getAsignacion(Long id) {
        return asignacionRepository.findById(id);
    }

    public void saveOrUpdateAsignacion(Asignacion asignacion) {
        asignacionRepository.save(asignacion);
    }

    public void deleteAsignacion(Long id) {
        asignacionRepository.deleteById(id);
    }
}
