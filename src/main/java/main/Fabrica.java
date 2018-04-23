package main;

import Excepciones.DniNotValidException;
import main.Cliente;
import main.Direccion;
import main.tarifa.Tarifa;
import main.tarifa.TipoTarifa;


public interface Fabrica {

    Cliente getNuevaEmpresa(String nombre, Tarifa tarifa, Direccion direccion, String CIF) throws DniNotValidException;

    Cliente getNuevoParticular(String nombre, Tarifa tarifa, Direccion direccion, String apellidos, String nif) throws DniNotValidException;

}