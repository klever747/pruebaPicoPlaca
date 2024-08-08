package com.picoplacavehiculo.pico_placa_vehiculo.service;

import com.picoplacavehiculo.pico_placa_vehiculo.model.VehiculoModel;
import com.picoplacavehiculo.pico_placa_vehiculo.repository.IPicoplacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
@Service
public class VehiculoService implements IVehiculoService {
    @Autowired
    private IPicoplacaRepository picoplacaRepository;
    @Override
    public int save(VehiculoModel vehiculo) {
        int row;
        try {
            row =picoplacaRepository.save(vehiculo);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public String ComprovarVehiculo(VehiculoModel vehiculoModel) {
        String placa = vehiculoModel.getPlaca_vehiculo();
        //obtener el ultimo digito de la placa
        char ultimodigito = placa.charAt(placa.length()-1);
        Date fecha = vehiculoModel.getFecha();
        Time horas = vehiculoModel.getHora();
        //obtener el dia de la semana
        int diaSemana= fecha.getDay();
        //obtener la hora del dia
        int hora = horas.getHours();
        int minutos = horas.getMinutes();
       // System.out.println("ultimo digito"+ultimodigito+"hora"+hora+"minutos"+minutos);

        if(diaSemana == 6 || diaSemana == 7){
            return "El vehiculo con placa"+placa+"Puede circular";
        }else{
            if(ValidarDiasHora(diaSemana,hora,minutos,ultimodigito)){
                return "El vehiculo con placa"+placa+"Puede circular";
            }else{
                return "El vehiculo con placa"+placa+" No Puede circular";
            }
        }

    }
    public Boolean ValidarDiasHora(int diaSemana, int hora, int minutos, char ultimoDigito){
        boolean respuesta = true;
        if (hora >= 06  && hora<= 9 && minutos <= 30
                || hora>= 16  && hora <= 20 ){
            System.out.println("vehiculo placa"+ultimoDigito);
            switch (diaSemana){
                case 1:
                        if(ultimoDigito=='1'||ultimoDigito=='2') {
                            respuesta = false;
                        }
                    break ;
                case 2:
                    if(ultimoDigito=='3'||ultimoDigito=='4') {
                        respuesta = false;
                    }
                    break;
                case 3:
                    if(ultimoDigito=='5'||ultimoDigito=='6') {
                        respuesta = false;
                    }
                    break;
                case 4:
                    if(ultimoDigito == '7' || ultimoDigito == '8') {
                        respuesta = false;

                    }

                    break;
                case 5:
                    if(ultimoDigito=='9'||ultimoDigito=='0') {
                        respuesta = false;
                    }
                    break;

            }
        }
        System.out.println("verificacion"+respuesta);
        return respuesta;

    }

}
