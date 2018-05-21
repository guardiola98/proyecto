package main;

import Excepciones.DniNotValidException;
import Interfaces.Clientes;
import main.tarifa.Tarifa;
import java.io.Serializable;
import java.time.LocalDateTime;
public class Particular extends Cliente implements Serializable, Clientes {
    private String apellidos;
    public Particular(String nombre, Tarifa tarifa, Direccion direccion, String apellidos, String nif, LocalDateTime fecha) throws DniNotValidException {
        super(nombre, tarifa, direccion,nif,fecha);
        this.apellidos = apellidos;
    }
    public void setApellidos(String ap){
        apellidos=ap;
    }
    public String getApellidos(){
        return apellidos;
    }
    @Override
    public boolean isEmpresa(){
        return false;
    }
}
