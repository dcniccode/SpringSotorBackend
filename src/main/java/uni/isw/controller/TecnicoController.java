package uni.isw.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uni.isw.model.Tecnico;
import uni.isw.service.TecnicoService;

@RestController
@RequestMapping(path = "api/v1/tecnico")
public class TecnicoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TecnicoService tecnicoService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tecnico>> getTecnicos() {
        List<Tecnico> listaTecnicos = null;
        try {
            listaTecnicos = tecnicoService.getTecnicos();
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(listaTecnicos, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tecnico> buscarTecnico(@RequestBody Optional<Tecnico> tecnico) {
        try {
            tecnico = tecnicoService.getTecnico(tecnico.get().getId_tecnico());
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(tecnico.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tecnico> insertarTecnico(@RequestBody Tecnico tecnico) {
        try {
            tecnicoService.saveOrUpdateTecnico(tecnico);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(tecnico, HttpStatus.OK);
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tecnico> actualizarTecnico(@RequestBody Tecnico tecnico) {
        try {
            tecnicoService.saveOrUpdateTecnico(tecnico);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(tecnico, HttpStatus.OK);
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tecnico> eliminarTecnico(@RequestBody Optional<Tecnico> tecnico) {
        try {
            tecnico = tecnicoService.getTecnico(tecnico.get().getId_tecnico());
            if (tecnico.isPresent()) {
                tecnicoService.deleteTecnico(tecnico.get().getId_tecnico());
            }
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(tecnico.get(), HttpStatus.OK);
    }
}