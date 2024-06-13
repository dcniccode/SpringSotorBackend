package uni.isw.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.model.InformeTecnico;
import uni.isw.repository.InformeTecnicoRepository;

@Service
public class InformeTecnicoService {
    @Autowired
    InformeTecnicoRepository informeTecnicoRepository;
    
    public List<InformeTecnico> getInformesTecnicos() {
        return informeTecnicoRepository.findAll();
    }

    public Optional<InformeTecnico> getInformeTecnico(Long id) {
        return informeTecnicoRepository.findById(id);
    }

    public void saveOrUpdateInformeTecnico(InformeTecnico informeTecnico) {
        informeTecnicoRepository.save(informeTecnico);
    }   

    public void deleteInformeTecnico(Long id) {
        informeTecnicoRepository.deleteById(id);
    }
}
