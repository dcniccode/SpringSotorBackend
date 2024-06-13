package uni.isw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.isw.model.Tecnico;
import uni.isw.repository.TecnicoRepository;

@Service
public class TecnicoService {
    @Autowired
    TecnicoRepository tecnicoRepository;
    
    public List<Tecnico> getTecnicos(){
        return tecnicoRepository.findAll();
    }
    
    public Optional<Tecnico> getTecnico(Long id){
        return tecnicoRepository.findById(id);
    }
    
    public void saveOrUpdateTecnico(Tecnico tecnico){
        tecnicoRepository.save(tecnico);
    }   
    
    public void deleteTecnico(Long id){
        tecnicoRepository.deleteById(id);
    }
}
