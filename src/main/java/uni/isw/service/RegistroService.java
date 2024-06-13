package uni.isw.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.model.Registro;
import uni.isw.repository.RegistroRepository;

@Service
public class RegistroService {
    @Autowired
    private RegistroRepository registroRepository;

    public List<Registro> getRegistros() {
        return registroRepository.findAll();
    }

    public Optional<Registro> getRegistro(Long id) {
        return registroRepository.findById(id);
    }

    public void saveOrUpdateRegistro(Registro registro) {
        registroRepository.save(registro);
    }

    public void deleteRegistro(Long id) {
        registroRepository.deleteById(id);
    }
}
