package uni.isw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name="jefe_del_area")
public class JefeDelArea {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_jefedelarea;  // Ajustado para que coincida con el nombre de la columna en la base de datos
    
    private String apellido_paterno;
    private String apellido_materno;
    private String nombres;
    private Date fecha_nacimiento;
    private Integer id_tipo_documento;
    private String ndocumento;
    private String direccion;
    private String idubigeo;
}
