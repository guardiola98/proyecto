package main;

import Excepciones.DniNotValidException;
import main.Fabrica;
import main.tarifa.Tarifa;

public class FabricaCliente implements Fabrica {
    public FabricaCliente(){
        super();
    }


    @Override
    public Cliente getNuevaEmpresa(String nombre, Tarifa tarifa, Direccion direccion, String CIF) throws DniNotValidException {
        return new Empresa(nombre,tarifa,direccion,CIF);
    }

    @Override
    public Cliente getNuevoParticular(String nombre, Tarifa tarifa, Direccion direccion, String apellidos, String nif) throws DniNotValidException {
        return new Particular(nombre,tarifa,direccion,apellidos,nif);
    }

}
