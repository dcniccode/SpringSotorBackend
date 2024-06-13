package uni.isw.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.model.Incidencia;
import uni.isw.repository.IncidenciaRepository;

@Service
public class IncidenciaService {
    @Autowired
    private IncidenciaRepository incidenciaRepository;

    public List<Incidencia> getIncidencias() {
        return incidenciaRepository.findAll();
    }

    public Optional<Incidencia> getIncidencia(Long id) {
        return incidenciaRepository.findById(id);
    }

    public void saveOrUpdateIncidencia(Incidencia incidencia) {
        incidenciaRepository.save(incidencia);
    }

    public void deleteIncidencia(Long id) {
        incidenciaRepository.deleteById(id);
    }
}
