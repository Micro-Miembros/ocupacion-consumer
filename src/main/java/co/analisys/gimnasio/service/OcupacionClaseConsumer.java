package co.analisys.gimnasio.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import co.analisys.gimnasio.model.OcupacionClase;
import lombok.extern.slf4j.Slf4j;

@Service 
@Slf4j
public class OcupacionClaseConsumer { 

    @KafkaListener(topics = "ocupacion-clases", groupId = "gym-ocupacion-consumer") 
    public void consumirActualizacionOcupacion(OcupacionClase ocupacion) { 
        log.info("Actualizacion de ocupacion recibida en la clase " + ocupacion.getNombreClase()
        + " #" + ocupacion.getClaseId() + " hay un total de " + ocupacion.getOcupacionActual() 
        + " personas ocupando la clase (capacidad maxima: " + ocupacion.getCapacidadMaxima() 
        + ") a las " + ocupacion.getTimestamp());
    } 
} 