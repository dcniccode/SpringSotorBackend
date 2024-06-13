package uni.isw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tecnico")
public class Tecnico {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_tecnico;
    
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private Integer numarreglos;
    private String incidencia;
    private String experiencia;
    private Boolean disponibilidad;
}
