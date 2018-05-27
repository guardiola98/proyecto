package Interfaces;

import Excepciones.DniNoExixstException;
import Excepciones.DniNotValidException;
import Excepciones.PhoneNoValidException;
import main.Cliente;
import main.Direccion;

import java.time.LocalDateTime;

public interface IModelo {
    void cargaDatos() throws ClassNotFoundException;
    void guardaDatos();
    void anadeParticular(String nombre, String apellidos, String dni, Direccion direccion, LocalDateTime fechaAlta) throws DniNotValidException;
    void anadeEmpresa(String nombre, String dni, Direccion direccion, LocalDateTime now) throws DniNotValidException;
    void borrarCliente(String dni) throws DniNoExixstException;
    void recuperaCliente(String dni) throws DniNoExixstException;
    void listarClientes() throws DniNoExixstException;
    void listaEntreFechas(LocalDateTime inicio, LocalDateTime fin);
    void addLlamada(String dniFac, int telefonoDestino, double duracion) throws PhoneNoValidException;
    void getLlamadas(String dnitLlam);
    void listarLlamadasEntreFechas(LocalDateTime inicio, LocalDateTime fin);
    void anadirFactura(String dniFac);
    void recuperaFactura(int codigo);
    void recuperaFacturas(String dniCliente);
    void listaFacturasEntreFechas(LocalDateTime inicio, LocalDateTime fin);
}
