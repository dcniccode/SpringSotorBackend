package uni.isw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.model.JefeDelArea;
import uni.isw.repository.JefeDelAreaRepository;

@Service
public class JefeDelAreaService {
    @Autowired
    JefeDelAreaRepository jefeDelAreaRepository;
    
    public List<JefeDelArea> getJefesDelArea() {
        return jefeDelAreaRepository.findAll();
    }
    
    public Optional<JefeDelArea> getJefeDelArea(Long id) {
        return jefeDelAreaRepository.findById(id);
    }
    
    public void saveOrUpdateJefeDelArea(JefeDelArea jefeDelArea) {
        jefeDelAreaRepository.save(jefeDelArea);
    }
    
    public void deleteJefeDelArea(Long id) {
        jefeDelAreaRepository.deleteById(id);
    }
}
