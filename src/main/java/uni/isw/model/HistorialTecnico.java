package uni.isw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "historial_tecnico")
public class HistorialTecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Suponiendo que tienes una relación con JefeDelArea
    private Long idjefedelarea;

    // Otros campos que puedan ser relevantes para el historial técnico
}
