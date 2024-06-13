package uni.isw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.sql.Date;
import java.sql.Time;
import lombok.Data;

@Data
@Entity
@Table(name = "incidencia")
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_incidencia;
//    //private String descripcion;
//    private Date fecha;
//    private Time hora;
//    //private String estado;
//    private String gravedad;
//    //private Long idTecnico;
//    private Long usuario_id;
//    //private Long idEquipo;
//    // private Usuario[] usuarios;
//    // private Imagen imagen;
    private String area_afectada;
    private String descripcion;
    private Date fecha_incidencia;
    private Time hora_incidencia;
    private Integer idequipo;
    
    @ManyToOne
    @JoinColumn(name="idequipo", referencedColumnName="id_equipo", insertable=false,updatable=false)
    private Equipo equipo_afectado;

}
