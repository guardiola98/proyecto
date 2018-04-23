package main;

import java.time.LocalDateTime;
import Excepciones.*;
import main.tarifa.Tarifa;


public class Llamada implements Fecha {
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

}
