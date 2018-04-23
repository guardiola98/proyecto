package main;

import main.tarifa.Tarifa;

import java.time.LocalDateTime;


public class Factura implements Fecha {
    private Tarifa tarifa;
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
    public int getCodigo(){
        return codigo;
    }

    @Override
    public LocalDateTime getFecha(){
        return fechaFacturacion;
    }
}
