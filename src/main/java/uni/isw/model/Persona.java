package uni.isw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_persona;
    
    private String apellido_paterno;
    private String apellido_materno;
    private String nombres;
    private Date fecha_nacimiento;
    private Integer id_tipo_documento;
    private String ndocumento;
    private String direccion;
    private String idubigeo;
    
}
