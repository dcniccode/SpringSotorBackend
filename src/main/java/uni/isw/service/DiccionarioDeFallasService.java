package uni.isw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.model.DiccionarioDeFallas;
import uni.isw.repository.DiccionarioDeFallasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiccionarioDeFallasService {
    @Autowired
    private DiccionarioDeFallasRepository diccionarioDeFallasRepository;

    public List<DiccionarioDeFallas> getDiccionariosDeFallas() {
        return diccionarioDeFallasRepository.findAll();
    }

    public Optional<DiccionarioDeFallas> getDiccionarioDeFallas(Long id) {
        return diccionarioDeFallasRepository.findById(id);
    }

    public void saveOrUpdateDiccionarioDeFallas(DiccionarioDeFallas diccionarioDeFallas) {
        diccionarioDeFallasRepository.save(diccionarioDeFallas);
    }

    public void deleteDiccionarioDeFallas(Long id) {
        diccionarioDeFallasRepository.deleteById(id);
    }
}
