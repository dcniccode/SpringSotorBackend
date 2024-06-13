package uni.isw.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.repository.EquipoRepository;
import uni.isw.model.Equipo;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> getEquipos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> getEquipo(Long id) {
        return equipoRepository.findById(id);
    }

    public void saveOrUpdateEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
}
