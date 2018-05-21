package main;

import java.time.LocalDateTime;
import Excepciones.*;
import Interfaces.Transaction;
import main.tarifa.Tarifa;
import java.io.Serializable;

public class Llamada extends PhoneNoValidException implements Transaction,Serializable {
    private Tarifa tarifa;
    private int telefono;
    private LocalDateTime fecha;
    private double duracion;

    public Llamada(Tarifa tar,int llamado,LocalDateTime momento, double tarda) throws PhoneNoValidException {
        tarifa=tar;
        telefono=llamado;
        fecha=momento;
        duracion=tarda;
        if(telefono<100000000 || telefono>999999999) throw new PhoneNoValidException();
    }
    public double getDuracion(){
        return duracion;
    }
    @Override
    public LocalDateTime getFecha(){
        return fecha;
    }
    public Tarifa getTarifa(){return tarifa; }
    public String toString(){
        String cadena= " Teléfono al que llama: "+telefono+", con fecha: "+fecha.toString()+", y duración: "+duracion;
        System.out.println(cadena);
        return cadena;
    }

}
