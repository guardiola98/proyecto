package main;

import Interfaces.Transaction;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Factura implements Transaction, Serializable {
    private int codigo;
    private double importe;
    private double tiempo;
    private LocalDateTime fechaFacturacion;

    public Factura(double imp,int cod, LocalDateTime inicio,double minutos){
        codigo=cod;
        importe=imp;
        tiempo=minutos;
        fechaFacturacion=inicio;
    }

    public double getImporte(){
        return importe;
    }
    public int getCodigo() {
        return codigo;
    }
    @Override
    public LocalDateTime getFecha(){
        return fechaFacturacion;
    }
    public String toString(){

        String cadena=" Factura de código: "+codigo+", lo cual hace un importe de "+importe+"y con fecha de facturación: "+fechaFacturacion.toString();
        System.out.println(cadena);
        return cadena;
    }
}
