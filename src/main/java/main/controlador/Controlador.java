package main.controlador;


import Excepciones.DniNoExixstException;
import Excepciones.DniNotValidException;
import Excepciones.PhoneNoValidException;
import Interfaces.IModelo;
import Interfaces.IControlador;
import Interfaces.IVista;
import main.Direccion;
import main.modelo.Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
public class Controlador implements IControlador, Serializable{

    private IVista vista;
    private IModelo modelo;

    public Controlador() {
        modelo=new Modelo();
    }



    public void setModelo(IModelo modelo) {
        this.modelo = modelo;
    }

    public void setVista(IVista vista) {
        this.vista = vista;
    }

    @Override
    public void guarda() {
        modelo.guardaDatos();
    }

    @Override
    public void carga() throws ClassNotFoundException {
        modelo.cargaDatos();

    }

    @Override
    public void anadirParticular(String nombre, String apellidos, String DNI, Direccion direccion, LocalDateTime fechaAlta) throws DniNotValidException {
        modelo.anadeParticular(nombre,apellidos,DNI,direccion,fechaAlta);
    }

    @Override
    public void anadirEmpresa(String nombre, String dni, Direccion direccion, LocalDateTime now) throws DniNotValidException {
        modelo.anadeEmpresa(nombre,dni,direccion,now);
    }

    @Override
    public void borrarCliente(String dni) throws DniNoExixstException {
        modelo.borrarCliente(dni);
    }

    @Override
    public void recuperaCliente(String dni) throws DniNoExixstException {
        modelo.recuperaCliente(dni);
    }

    @Override
    public void listarClientes() throws DniNoExixstException {
        modelo.listarClientes();
    }

    @Override
    public void listaEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        modelo.listaEntreFechas(inicio,fin);
    }

    @Override
    public void addLlamada(String dniFac, int telefonoDestino, double duracion) throws PhoneNoValidException {
        modelo.addLlamada(dniFac,telefonoDestino,duracion);
    }

    @Override
    public void getLlamadas(String dnitLlam) {
        modelo.getLlamadas(dnitLlam);
    }

    @Override
    public void listaLlamadasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        modelo.listarLlamadasEntreFechas(inicio,fin);
    }

    @Override
    public void anadirFactura(String dniFac) {
        modelo.anadirFactura(dniFac);
    }

    @Override
    public void recuperaFactura(int codigo) {
        modelo.recuperaFactura(codigo);
    }

    @Override
    public void recuperaFacturas(String dniCliente) {
        modelo.recuperaFacturas(dniCliente);
    }

    @Override
    public void listaFacturasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        modelo.listaFacturasEntreFechas(inicio,fin);
    }

}
