package uni.isw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "asignacion")
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignacion;
    private Long idtecnico;
    private Long idincidencia; // La columna en la tabla "asignacion" que es una clave foránea a "incidencia"
    
    @ManyToOne
    @JoinColumn(name = "idincidencia", referencedColumnName = "id_incidencia", insertable = false, updatable = false)
    private Incidencia incidencia;
    
    @ManyToOne
    @JoinColumn(name = "idtecnico", referencedColumnName = "id_tecnico", insertable = false, updatable = false)
    private Tecnico tecnicoasignado;
}
