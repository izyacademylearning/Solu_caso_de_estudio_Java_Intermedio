package com.izyacademy.MonitoreoAmbiental.Entities;

public class NivelRiesgo {
    private String nivelRiesgoParticulas;
    private String nivelRiesgoRadiacionUV;
    private String nivelRiesgoGasesToxicos;

    // Constructor, getters y setters para los campos

    public String getNivelRiesgoParticulas() {
        return nivelRiesgoParticulas;
    }

    public void setNivelRiesgoParticulas(String nivelRiesgoParticulas) {
        this.nivelRiesgoParticulas = nivelRiesgoParticulas;
    }

    public String getNivelRiesgoRadiacionUV() {
        return nivelRiesgoRadiacionUV;
    }

    public void setNivelRiesgoRadiacionUV(String nivelRiesgoRadiacionUV) {
        this.nivelRiesgoRadiacionUV = nivelRiesgoRadiacionUV;
    }

    public String getNivelRiesgoGasesToxicos() {
        return nivelRiesgoGasesToxicos;
    }

    public void setNivelRiesgoGasesToxicos(String nivelRiesgoGasesToxicos) {
        this.nivelRiesgoGasesToxicos = nivelRiesgoGasesToxicos;
    }
}