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

import uni.isw.model.Tecnico;
import uni.isw.service.TecnicoService;

@RestController
@RequestMapping(path="api/v1/tecnico")
public class TecnicoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TecnicoService tecnicoService;    

    @RequestMapping(value="/listar", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tecnico>> getTecnicos(){
        List<Tecnico> listaTecnicos = null;
        try {
            listaTecnicos = tecnicoService.getTecnicos();
            return new ResponseEntity<>(listaTecnicos, HttpStatus.OK);
        } catch(Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/buscar/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tecnico> buscarTecnico(@PathVariable("id") Long id) {
        try {
            Optional<Tecnico> tecnico = tecnicoService.getTecnico(id);
            if (tecnico.isPresent()) {
                return new ResponseEntity<>(tecnico.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/insertar", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tecnico> insertarTecnico(@RequestBody Tecnico tecnico){
        try {
            tecnicoService.saveOrUpdateTecnico(tecnico);
            return new ResponseEntity<>(tecnico, HttpStatus.CREATED);
        } catch(Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/actualizar", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tecnico> actualizarTecnico(@RequestBody Tecnico tecnico){
        try {
            tecnicoService.saveOrUpdateTecnico(tecnico);
            return new ResponseEntity<>(tecnico, HttpStatus.OK);
        } catch(Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/eliminar/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tecnico> eliminarTecnico(@PathVariable("id") Long id){
        try {
            Optional<Tecnico> tecnico = tecnicoService.getTecnico(id);
            if(tecnico.isPresent()) {
                tecnicoService.deleteTecnico(id);
                return new ResponseEntity<>(tecnico.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
