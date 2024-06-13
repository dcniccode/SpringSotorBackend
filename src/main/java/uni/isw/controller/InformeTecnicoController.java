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

import uni.isw.model.InformeTecnico;
import uni.isw.service.InformeTecnicoService;

@RestController
@RequestMapping(path = "api/v1/informe_tecnico")
public class InformeTecnicoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InformeTecnicoService informeTecnicoService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InformeTecnico>> getInformesTecnicos() {
        List<InformeTecnico> listaInformesTecnicos = null;
        try {
            listaInformesTecnicos = informeTecnicoService.getInformesTecnicos();
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(listaInformesTecnicos, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InformeTecnico> searchInformeTecnico(@RequestBody Optional<InformeTecnico> informeTecnico) {
        try {
            informeTecnico = informeTecnicoService.getInformeTecnico(informeTecnico.get().getId_informe());
            if (informeTecnico.isPresent()) {
                return new ResponseEntity<>(informeTecnico.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InformeTecnico> insertInformeTecnico(@RequestBody InformeTecnico informeTecnico) {
        try {
            informeTecnicoService.saveOrUpdateInformeTecnico(informeTecnico);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(informeTecnico, HttpStatus.OK);
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InformeTecnico> updateInformeTecnico(@RequestBody InformeTecnico informeTecnico) {
        try {
            informeTecnicoService.saveOrUpdateInformeTecnico(informeTecnico);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(informeTecnico, HttpStatus.OK);
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InformeTecnico> deleteInformeTecnico(@RequestBody Optional<InformeTecnico> informeTecnico) {
        try {
            informeTecnico = informeTecnicoService.getInformeTecnico(informeTecnico.get().getId_informe());
            if (informeTecnico.isPresent()) {
                informeTecnicoService.deleteInformeTecnico(informeTecnico.get().getId_informe());
                return new ResponseEntity<>(informeTecnico.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
