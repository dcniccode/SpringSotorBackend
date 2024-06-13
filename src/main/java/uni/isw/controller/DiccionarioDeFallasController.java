package uni.isw.controller;

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
import uni.isw.model.DiccionarioDeFallas;
import uni.isw.service.DiccionarioDeFallasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/diccionario-de-fallas")
public class DiccionarioDeFallasController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DiccionarioDeFallasService diccionarioDeFallasService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiccionarioDeFallas>> getDiccionariosDeFallas() {
        List<DiccionarioDeFallas> listaDiccionariosDeFallas = null;
        try {
            listaDiccionariosDeFallas = diccionarioDeFallasService.getDiccionariosDeFallas();
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(listaDiccionariosDeFallas, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiccionarioDeFallas> buscarDiccionarioDeFallas(@RequestBody Optional<DiccionarioDeFallas> diccionarioDeFallas) {
        try {
            diccionarioDeFallas = diccionarioDeFallasService.getDiccionarioDeFallas(diccionarioDeFallas.get().getId_diccionario());
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(diccionarioDeFallas.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiccionarioDeFallas> insertarDiccionarioDeFallas(@RequestBody DiccionarioDeFallas diccionarioDeFallas) {
        try {
            diccionarioDeFallasService.saveOrUpdateDiccionarioDeFallas(diccionarioDeFallas);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(diccionarioDeFallas, HttpStatus.OK);
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiccionarioDeFallas> actualizarDiccionarioDeFallas(@RequestBody DiccionarioDeFallas diccionarioDeFallas) {
        try {
            diccionarioDeFallasService.saveOrUpdateDiccionarioDeFallas(diccionarioDeFallas);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(diccionarioDeFallas, HttpStatus.OK);
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiccionarioDeFallas> eliminarDiccionarioDeFallas(@RequestBody Optional<DiccionarioDeFallas> diccionarioDeFallas) {
        try {
            diccionarioDeFallas = diccionarioDeFallasService.getDiccionarioDeFallas(diccionarioDeFallas.get().getId_diccionario());
            if (diccionarioDeFallas.isPresent())
                diccionarioDeFallasService.deleteDiccionarioDeFallas(diccionarioDeFallas.get().getId_diccionario());
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(diccionarioDeFallas.get(), HttpStatus.OK);
    }
}
