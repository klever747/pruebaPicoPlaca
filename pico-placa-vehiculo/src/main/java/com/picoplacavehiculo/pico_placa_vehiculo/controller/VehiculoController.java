package com.picoplacavehiculo.pico_placa_vehiculo.controller;

import com.picoplacavehiculo.pico_placa_vehiculo.model.ServiceResponse;
import com.picoplacavehiculo.pico_placa_vehiculo.model.VehiculoModel;
import com.picoplacavehiculo.pico_placa_vehiculo.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("api/v1/vehiculo")
@CrossOrigin("*")
public class VehiculoController {
    @Autowired
    private IVehiculoService iVehiculoService;
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse>save(@RequestBody VehiculoModel vehiculoModel){
        ServiceResponse serviceResponse = new ServiceResponse();

        String mensajeComprobacion = iVehiculoService.ComprovarVehiculo(vehiculoModel);
        vehiculoModel.setMensaje(mensajeComprobacion);
        System.out.println("valor enviado"+vehiculoModel.getFecha()+"hora"+vehiculoModel.getHora()+"placa"+vehiculoModel.getPlaca_vehiculo());
        int result = iVehiculoService.save(vehiculoModel);
        if(result==1){
            serviceResponse.setMessage(mensajeComprobacion);
        }
        return  new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
