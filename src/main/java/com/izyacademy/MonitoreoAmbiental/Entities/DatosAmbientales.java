package com.izyacademy.MonitoreoAmbiental.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="datos_ambientales")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosAmbientales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDateTime fecha;
    @Column
    private Double concentracionParticulas;
    @Column
    private Double radiacionUV;
    @Column
    private Double gasesToxicos;
    @Column
    private String ubicacionGeografica;

    public DatosAmbientales() {
    }

    public DatosAmbientales(Long id, LocalDateTime fecha, Double concentracionParticulas, Double radiacionUV, Double gasesToxicos, String ubicacionGeografica) {
        this.id = id;
        this.fecha = fecha;
        this.concentracionParticulas = concentracionParticulas;
        this.radiacionUV = radiacionUV;
        this.gasesToxicos = gasesToxicos;
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getConcentracionParticulas() {
        return concentracionParticulas;
    }

    public void setConcentracionParticulas(double concentracionParticulas) {
        this.concentracionParticulas = concentracionParticulas;
    }

    public Double getRadiacionUV() {
        return radiacionUV;
    }

    public void setRadiacionUV(double radiacionUV) {
        this.radiacionUV = radiacionUV;
    }

    public Double getGasesToxicos() {
        return gasesToxicos;
    }

    public void setGasesToxicos(double gasesToxicos) {
        this.gasesToxicos = gasesToxicos;
    }

    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }
}
