package com.izyacademy.MonitoreoAmbiental.Services;
import com.izyacademy.MonitoreoAmbiental.Entities.DatosAmbientales;
import com.izyacademy.MonitoreoAmbiental.Entities.NivelRiesgo;
import org.springframework.stereotype.Service;

@Service
public class NivelRiesgoService {

    public NivelRiesgo calcularNivelRiesgo(DatosAmbientales datosAmbientales) {
        NivelRiesgo nivelRiesgo = new NivelRiesgo();


        String nivelRiesgoParticulas = calcularNivelRiesgoParticulas(datosAmbientales.getConcentracionParticulas());
        System.out.println(nivelRiesgoParticulas);
        String nivelRiesgoRadiacionUV = calcularNivelRiesgoRadiacionUV(datosAmbientales.getRadiacionUV());
        System.out.println(nivelRiesgoRadiacionUV);
        String nivelRiesgoGasesToxicos = calcularNivelRiesgoGasesToxicos(datosAmbientales.getGasesToxicos());
        System.out.println(nivelRiesgoGasesToxicos);


        nivelRiesgo.setNivelRiesgoParticulas(nivelRiesgoParticulas);
        nivelRiesgo.setNivelRiesgoRadiacionUV(nivelRiesgoRadiacionUV);
        nivelRiesgo.setNivelRiesgoGasesToxicos(nivelRiesgoGasesToxicos);

        return nivelRiesgo;
    }

    private String calcularNivelRiesgoParticulas(double concentracionParticulas) {
        String nivelRiesgo;

        if (concentracionParticulas > 100) {
            nivelRiesgo = "Alto riesgo";
        } else if (concentracionParticulas >= 51 && concentracionParticulas <= 100) {
            nivelRiesgo = "Medio riesgo";
        } else {
            nivelRiesgo = "Bajo riesgo";
        }

        return nivelRiesgo;
    }

    private String calcularNivelRiesgoRadiacionUV(double radiacionUV) {
        String nivelRiesgo;

        if(radiacionUV > 6){
            nivelRiesgo = "Alto riesgo";
        }else if (radiacionUV >= 3 && radiacionUV <=6){
            nivelRiesgo = "Medio riesgo";
        }else{
            nivelRiesgo = "Bajo riesgo";
        }
        return nivelRiesgo;
    }

    private String calcularNivelRiesgoGasesToxicos(double gasesToxicos) {
        String nivelRiesgo;

        if(gasesToxicos>50){
            nivelRiesgo = "Alto riesgo";
        }else if (gasesToxicos>=11 && gasesToxicos<=50){
            nivelRiesgo="Medio riesgo";
        }else{
            nivelRiesgo = "Bajo riesgo";
        }

        return nivelRiesgo;
    }

    public double calcularNivelRiesgoGeneral(NivelRiesgo nivelRiesgo) {
        double nivelRiesgoParticulas = calcularPonderado(nivelRiesgo.getNivelRiesgoParticulas(), 0.6);
        System.out.println(nivelRiesgoParticulas);
        double nivelRiesgoRadiacionUV = calcularPonderado(nivelRiesgo.getNivelRiesgoRadiacionUV(), 0.1);
        System.out.println(nivelRiesgoRadiacionUV);
        double nivelRiesgoGasesToxicos = calcularPonderado(nivelRiesgo.getNivelRiesgoGasesToxicos(), 0.3);
        System.out.println(nivelRiesgoGasesToxicos);

        return nivelRiesgoParticulas + nivelRiesgoRadiacionUV + nivelRiesgoGasesToxicos;
    }

    private double calcularPonderado(String nivelRiesgo, double ponderado) {
        if (nivelRiesgo.equals("Alto riesgo")) {
            return 3 * ponderado;
        } else if (nivelRiesgo.equals("Medio riesgo")) {
            return 2 * ponderado;
        } else {
            return 1 * ponderado;
        }
    }
}