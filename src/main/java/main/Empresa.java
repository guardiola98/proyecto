package main;


import Excepciones.DniNotValidException;
import main.tarifa.Tarifa;

import java.io.Serializable;

public class Empresa extends Cliente implements Serializable, Clientes{

    public Empresa(String nombre, Tarifa tarifa, Direccion direccion, String CIF) throws DniNotValidException {
        super(nombre, tarifa, direccion,CIF);
    }

    public boolean isEmpresa(){
        return true;
    }
}
