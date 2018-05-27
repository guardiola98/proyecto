package Interfaces;

import Excepciones.DniNotValidException;
import Excepciones.DniNoExixstException;
import Excepciones.PhoneNoValidException;
import main.Direccion;

import java.time.LocalDateTime;
public interface IControlador {
    void guarda();
    void carga() throws ClassNotFoundException;
    void anadirParticular(String nombre, String apellidos, String DNI, Direccion direccion, LocalDateTime fechaAlta) throws DniNotValidException;
    void anadirEmpresa(String nombre, String dni, Direccion direccion, LocalDateTime now) throws DniNotValidException;
    void borrarCliente(String dni) throws DniNoExixstException;
    void recuperaCliente(String dni) throws DniNoExixstException;
    void listarClientes() throws DniNoExixstException;
    void listaEntreFechas(LocalDateTime inicio, LocalDateTime fin);
    void addLlamada(String dniFac, int telefonoDestino, double duracion) throws PhoneNoValidException;
    void getLlamadas(String dnitLlam);
    void listaLlamadasEntreFechas(LocalDateTime inicio, LocalDateTime fin);
    void anadirFactura(String dniFac);
    void recuperaFactura(int codigo);
    void recuperaFacturas(String dniCliente);
    void listaFacturasEntreFechas(LocalDateTime inicio, LocalDateTime fin);
}






