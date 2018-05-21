package Interfaces;

import Excepciones.DniNotValidException;
import main.Cliente;
import main.Direccion;
import main.tarifa.Tarifa;
import main.tarifa.TipoTarifa;
import java.time.LocalDateTime;


public interface Fabrica {

    Cliente getNuevaEmpresa(String nombre, Tarifa tarifa, Direccion direccion, String CIF, LocalDateTime fecha) throws DniNotValidException;
    Cliente getNuevoParticular(String nombre, Tarifa tarifa, Direccion direccion, String apellidos, String nif,LocalDateTime fecha) throws DniNotValidException;
}