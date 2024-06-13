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

import uni.isw.model.Incidencia;
import uni.isw.service.IncidenciaService;

@RestController
@RequestMapping(path = "api/v1/incidencia")
public class IncidenciaController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IncidenciaService incidenciaService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Incidencia>> getIncidencias() {
        List<Incidencia> listaIncidencias = null;
        try {
            listaIncidencias = incidenciaService.getIncidencias();
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(listaIncidencias, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Incidencia> buscarIncidencia(@RequestBody Optional<Incidencia> incidencia) {
        try {
            incidencia = incidenciaService.getIncidencia(incidencia.get().getId_incidencia());
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(incidencia.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Incidencia> insertarIncidencia(@RequestBody Incidencia incidencia) {
        try {
            incidenciaService.saveOrUpdateIncidencia(incidencia);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(incidencia, HttpStatus.OK);
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Incidencia> actualizarIncidencia(@RequestBody Incidencia incidencia) {
        try {
            incidenciaService.saveOrUpdateIncidencia(incidencia);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(incidencia, HttpStatus.OK);
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Incidencia> eliminarIncidencia(@RequestBody Optional<Incidencia> incidencia) {
        try {
            incidencia = incidenciaService.getIncidencia(incidencia.get().getId_incidencia());
            if (incidencia.isPresent()) {
                incidenciaService.deleteIncidencia(incidencia.get().getId_incidencia());
            }
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(incidencia.get(), HttpStatus.OK);
    }
}
