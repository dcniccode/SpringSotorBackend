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
import uni.isw.model.Equipo;
import uni.isw.service.EquipoService;

@RestController
@RequestMapping(path = "api/v1/equipo")
public class EquipoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EquipoService equipoService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Equipo>> getEquipos() {
        List<Equipo> listaEquipos = null;
        try {
            listaEquipos = equipoService.getEquipos();
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(listaEquipos, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipo> buscarEquipo(@RequestBody Optional<Equipo> equipo) {
        try {
            equipo = equipoService.getEquipo(equipo.get().getId_equipo());
            if (equipo.isPresent()) {
                return new ResponseEntity<>(equipo.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipo> insertarEquipo(@RequestBody Equipo equipo) {
        try {
            equipoService.saveOrUpdateEquipo(equipo);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(equipo, HttpStatus.OK);
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipo> actualizarEquipo(@RequestBody Equipo equipo) {
        try {
            equipoService.saveOrUpdateEquipo(equipo);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(equipo, HttpStatus.OK);
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipo> eliminarEquipo(@RequestBody Optional<Equipo> equipo) {
        try {
            equipo = equipoService.getEquipo(equipo.get().getId_equipo());
            if (equipo.isPresent()) {
                equipoService.deleteEquipo(equipo.get().getId_equipo());
                return new ResponseEntity<>(equipo.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
