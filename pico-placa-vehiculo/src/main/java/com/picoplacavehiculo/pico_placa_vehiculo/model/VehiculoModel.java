package com.picoplacavehiculo.pico_placa_vehiculo.model;

import lombok.Data;


import java.sql.Date;
import java.sql.Time;
@Data
public class VehiculoModel {
    int id_vehiculo;
    String placa_vehiculo;
    Time hora;
    Date fecha;
    String mensaje;
}
