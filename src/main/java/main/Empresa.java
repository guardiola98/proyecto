package main;


import Excepciones.DniNotValidException;

public class Empresa extends Cliente{

    public Empresa(String nombre, Tarifa tarifa, Direccion direccion,String CIF) throws DniNotValidException {
        super(nombre, tarifa, direccion,CIF);
    }

    public boolean isEmpresa(){
        return true;
    }
}
