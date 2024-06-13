package uni.isw.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.model.Usuario;
import uni.isw.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> getUsuario(Long id){
        return usuarioRepository.findById(id);
    }
    
    public void saveOrUpdateUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    
    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
