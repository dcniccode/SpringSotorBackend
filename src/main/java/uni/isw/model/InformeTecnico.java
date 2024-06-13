package uni.isw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;

import lombok.Data;

@Data
@Entity
@Table(name="informe_tecnico")
public class InformeTecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_informe;

    private Integer idtecnico;
    private Integer idregistro;
    
    private String solucion;  // Corrigiendo el nombre del campo
    private Date fecha_registro_informe;
    private String gravedad;
    private Float tiempo_horas;
    
    @ManyToOne
    @JoinColumn(name="idtecnico", referencedColumnName="id_tecnico", insertable=false,updatable=false)
    private Tecnico tecnico;
    
    @ManyToOne
    @JoinColumn(name="idregistro", referencedColumnName="id_registro", insertable=false,updatable=false)
    private Registro registro;
}
