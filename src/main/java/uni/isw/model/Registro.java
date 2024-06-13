package uni.isw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import lombok.Data;

@Data
@Entity
@Table(name = "registro")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registro;
    
    private Long idusuario; // Asumiendo que la clave primaria de Usuario es de tipo Long
    private Long idincidencia; // Asumiendo que la clave primaria de Incidencia es de tipo Long
    
    private Date fecha_registro;
    private Time hora_registro;
    
    @ManyToOne
    @JoinColumn(name="idusuario", referencedColumnName="id_usuario", insertable=false, updatable=false)
    private Usuario user;
    
    @ManyToOne
    @JoinColumn(name="idincidencia", referencedColumnName="id_incidencia", insertable=false, updatable=false)
    private Incidencia incidencia;
}
