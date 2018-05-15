package main;


import Excepciones.DniNotValidException;
import main.tarifa.Tarifa;

import java.io.Serializable;

import java.time.LocalDateTime;


public class Empresa extends Cliente implements Serializable, Clientes{

    public Empresa(String nombre, Tarifa tarifa, Direccion direccion, String CIF, LocalDateTime fecha) throws DniNotValidException {
        super(nombre, tarifa, direccion,CIF,fecha);
    }

    public boolean isEmpresa(){
        return true;
    }
}
