package uni.isw.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uni.isw.model.Usuario;
import uni.isw.service.UsuarioService;

@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> getUsuarios() {
        try {
            List<Usuario> listaUsuarios = usuarioService.getUsuarios();
            return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable("id") Long id) {
        try {
            Optional<Usuario> usuario = usuarioService.getUsuario(id);
            if (usuario.isPresent()) {
                return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> insertarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.saveOrUpdateUsuario(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.saveOrUpdateUsuario(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable("id") Long id) {
        try {
            Optional<Usuario> usuario = usuarioService.getUsuario(id);
            if (usuario.isPresent()) {
                usuarioService.deleteUsuario(id);
                return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
