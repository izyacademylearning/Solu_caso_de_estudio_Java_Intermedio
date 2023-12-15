package com.izyacademy.MonitoreoAmbiental.Services;

import com.izyacademy.MonitoreoAmbiental.Entities.DatosAmbientales;
import com.izyacademy.MonitoreoAmbiental.Repositories.DatosAmbientalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DatosAmbientalesService {
    @Autowired
    private DatosAmbientalesRepository datosAmbientalesRepository;

    public List<DatosAmbientales> getAllDatosAmbientales(){
        return datosAmbientalesRepository.findAll();
    }

    public DatosAmbientales saveDatosAmbientales(DatosAmbientales datosambientales){
        return datosAmbientalesRepository.save(datosambientales);
    }

    public DatosAmbientales getDatosAmbientalesById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        Optional<DatosAmbientales> optionalDatosAmbientales = datosAmbientalesRepository.findById(id);
        return optionalDatosAmbientales.orElseThrow(() -> new NoSuchElementException("Datos Ambientales no encontrados con el ID: " + id));
    }
}
