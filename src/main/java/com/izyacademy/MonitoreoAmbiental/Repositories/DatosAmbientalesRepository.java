package com.izyacademy.MonitoreoAmbiental.Repositories;

import com.izyacademy.MonitoreoAmbiental.Entities.DatosAmbientales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DatosAmbientalesRepository extends JpaRepository<DatosAmbientales, Long> {

}
