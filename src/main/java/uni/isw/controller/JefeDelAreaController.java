package uni.isw.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uni.isw.model.JefeDelArea;
import uni.isw.service.JefeDelAreaService;

@RestController
@RequestMapping(path="api/v1/jefe-del-area")
public class JefeDelAreaController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    JefeDelAreaService jefeDelAreaService;
    
    @RequestMapping(value="/listar", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JefeDelArea>> getJefesDelArea() {
        List<JefeDelArea> listaJefesDelArea = null;
        try {
            listaJefesDelArea = jefeDelAreaService.getJefesDelArea();
        } catch(Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(listaJefesDelArea, HttpStatus.OK);
    }
    
    @RequestMapping(value="/buscar", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JefeDelArea> buscarJefeDelArea(@RequestBody Optional<JefeDelArea> jefeDelArea) {
        try {
            jefeDelArea = jefeDelAreaService.getJefeDelArea(jefeDelArea.get().getId_jefedelarea());
        } catch(Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(jefeDelArea.get(), HttpStatus.OK);
    }
    
    @RequestMapping(value="/insertar", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JefeDelArea> insertarJefeDelArea(@RequestBody JefeDelArea jefeDelArea) {
        try {
            jefeDelAreaService.saveOrUpdateJefeDelArea(jefeDelArea);
        } catch(Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(jefeDelArea, HttpStatus.OK);
    }
    
    @RequestMapping(value="/actualizar", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JefeDelArea> actualizarJefeDelArea(@RequestBody JefeDelArea jefeDelArea) {
        try {
            jefeDelAreaService.saveOrUpdateJefeDelArea(jefeDelArea);
        } catch(Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(jefeDelArea, HttpStatus.OK);
    }
    
    @RequestMapping(value="/eliminar", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JefeDelArea> eliminarJefeDelArea(@RequestBody Optional<JefeDelArea> jefeDelArea) {
        try {
            jefeDelArea = jefeDelAreaService.getJefeDelArea(jefeDelArea.get().getId_jefedelarea());
            if(jefeDelArea.isPresent())
                jefeDelAreaService.deleteJefeDelArea(jefeDelArea.get().getId_jefedelarea());
        } catch(Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(jefeDelArea.get(), HttpStatus.OK);
    }
}
