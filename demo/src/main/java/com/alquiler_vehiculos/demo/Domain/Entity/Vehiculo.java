package com.alquiler_vehiculos.demo.Domain.Entity;


import com.alquiler_vehiculos.demo.Domain.Enum.EstadoVehiculo;
import com.alquiler_vehiculos.demo.Domain.Enum.TipoCombustible;
import com.alquiler_vehiculos.demo.Domain.Enum.TipoTransmision;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vehiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private CategoriaVehiculo categoria;

    @Column(length = 15, unique = true)
    private String placa;

    @Column(length = 80)
    private String marca;

    @Column(length = 80)
    private String modelo;

    private Short anio;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoTransmision transmision;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_combustible", length = 20)
    private TipoCombustible tipoCombustible;

    private Short asientos;

    private Short puertas;

    @Column(name = "precio_por_dia", precision = 10, scale = 2)
    private BigDecimal precioPorDia;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @Builder.Default
    private EstadoVehiculo estado = EstadoVehiculo.DISPONIBLE;

    @Builder.Default
    private Integer kilometraje = 0;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    /**
     * Galería de fotos como lista de URLs.
     * Se decidió no crear tabla aparte (vehiculo_foto).
     * Almacenada como JSONB en PostgreSQL.
     */
    @ElementCollection
    @CollectionTable(
            name = "vehiculo_fotos",
            joinColumns = @JoinColumn(name = "vehiculo_id")
    )
    @Column(name = "url", length = 500)
    private List<String> fotos;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}