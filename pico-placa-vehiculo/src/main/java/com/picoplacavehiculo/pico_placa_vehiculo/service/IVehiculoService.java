package com.picoplacavehiculo.pico_placa_vehiculo.service;

import com.picoplacavehiculo.pico_placa_vehiculo.model.VehiculoModel;

public interface IVehiculoService{
    public int save(VehiculoModel vehiculoModel);
    public String ComprovarVehiculo(VehiculoModel vehiculoModel);
}
