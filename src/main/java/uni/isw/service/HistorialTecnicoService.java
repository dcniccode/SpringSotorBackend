package uni.isw.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.model.HistorialTecnico;
import uni.isw.repository.HistorialTecnicoRepository;

@Service
public class HistorialTecnicoService {
    @Autowired
    private HistorialTecnicoRepository historialTecnicoRepository;

    public List<HistorialTecnico> getHistorialesTecnicos() {
        return historialTecnicoRepository.findAll();
    }

    public Optional<HistorialTecnico> getHistorialTecnico(Long id) {
        return historialTecnicoRepository.findById(id);
    }

    public void saveOrUpdateHistorialTecnico(HistorialTecnico historialTecnico) {
        historialTecnicoRepository.save(historialTecnico);
    }

    public void deleteHistorialTecnico(Long id) {
        historialTecnicoRepository.deleteById(id);
    }
}
