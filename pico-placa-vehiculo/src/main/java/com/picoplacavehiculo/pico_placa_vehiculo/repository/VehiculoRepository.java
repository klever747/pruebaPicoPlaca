package com.picoplacavehiculo.pico_placa_vehiculo.repository;

import com.picoplacavehiculo.pico_placa_vehiculo.model.VehiculoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VehiculoRepository implements IPicoplacaRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(VehiculoModel vehiculo) {
        String SQL = "INSERT INTO vehiculo VALUES(?,?,?,?)";
        return jdbcTemplate.update(SQL,new Object[]{vehiculo.getPlaca_vehiculo(),
                vehiculo.getHora(),vehiculo.getFecha(),
                vehiculo.getMensaje()});

    }
}
