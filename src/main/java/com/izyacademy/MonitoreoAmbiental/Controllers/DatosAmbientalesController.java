package com.izyacademy.MonitoreoAmbiental.Controllers;

import com.izyacademy.MonitoreoAmbiental.Entities.DatosAmbientales;
import com.izyacademy.MonitoreoAmbiental.Entities.NivelRiesgo;
import com.izyacademy.MonitoreoAmbiental.Services.DatosAmbientalesService;
import com.izyacademy.MonitoreoAmbiental.Services.NivelRiesgoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class DatosAmbientalesController {

    @Autowired

    private DatosAmbientalesService datosAmbientalesService;
    @Autowired
    private NivelRiesgoService nivelRiesgoService;

    @GetMapping("/datos")
    @ResponseBody
    public List<DatosAmbientales> getDatosAmbientales() {
        return datosAmbientalesService.getAllDatosAmbientales();
    }

    @PostMapping("/datos/save")
    @ResponseBody
    public ResponseEntity<DatosAmbientales> saveDatosAmbientales(@RequestBody DatosAmbientales datosAmbientales) {
        if (datosAmbientales.getFecha() == null || datosAmbientales.getConcentracionParticulas() ==  null ||
                datosAmbientales.getRadiacionUV() == null || datosAmbientales.getGasesToxicos() == null ||
                datosAmbientales.getUbicacionGeografica() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        if (datosAmbientales.getConcentracionParticulas() < 0.0 || datosAmbientales.getRadiacionUV() < 0.0 || datosAmbientales.getGasesToxicos() < 0.0) {
            return ResponseEntity.badRequest().body(null);
        }

        if (datosAmbientales.getUbicacionGeografica().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        DatosAmbientales savedDatosAmbientales = datosAmbientalesService.saveDatosAmbientales(datosAmbientales);
        return ResponseEntity.ok(savedDatosAmbientales);
    }

    @GetMapping("/datos/{id}/nivel-riesgo")
    @ResponseBody
    public ResponseEntity<NivelRiesgo> getNivelRiesgo(@PathVariable Long id) {
        DatosAmbientales datosAmbientales = datosAmbientalesService.getDatosAmbientalesById(id);
        if (datosAmbientales == null) {
            return ResponseEntity.notFound().build();
        }

        NivelRiesgo nivelRiesgo = nivelRiesgoService.calcularNivelRiesgo(datosAmbientales);
        return ResponseEntity.ok(nivelRiesgo);
    }

    @GetMapping("/datos/{id}/nivel-riesgo-general")
    @ResponseBody
    public ResponseEntity<Double> getNivelRiesgoGeneral(@PathVariable Long id) {
        DatosAmbientales datosAmbientales = datosAmbientalesService.getDatosAmbientalesById(id);
        if (datosAmbientales == null) {
            return ResponseEntity.notFound().build();
        }

        NivelRiesgo nivelRiesgo = nivelRiesgoService.calcularNivelRiesgo(datosAmbientales);
        double nivelRiesgoGeneral = nivelRiesgoService.calcularNivelRiesgoGeneral(nivelRiesgo);
        return ResponseEntity.ok(nivelRiesgoGeneral);
    }
}
