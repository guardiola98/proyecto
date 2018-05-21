package main;

import Excepciones.DniNotValidException;
import Interfaces.Fabrica;
import main.tarifa.Tarifa;
import java.time.LocalDateTime;

public class FabricaCliente implements Fabrica {
    public FabricaCliente(){
        super();
    }


    @Override
    public Cliente getNuevaEmpresa(String nombre, Tarifa tarifa, Direccion direccion, String CIF, LocalDateTime fecha) throws DniNotValidException {
        return new Empresa(nombre,tarifa,direccion,CIF,fecha);
    }

    @Override
    public Cliente getNuevoParticular(String nombre, Tarifa tarifa, Direccion direccion, String apellidos, String nif,LocalDateTime fecha) throws DniNotValidException {
        return new Particular(nombre,tarifa,direccion,apellidos,nif,fecha);
    }

}
