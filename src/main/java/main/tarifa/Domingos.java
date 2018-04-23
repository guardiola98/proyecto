package main.tarifa;
import main.Llamada;
import main.tarifa.Especial;
import main.tarifa.Tarifa;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Domingos  extends Especial implements Serializable{
    public Domingos(Tarifa tar) {
        super(tar, 0);
    }

    @Override
    public String toString() {
        return " 0 céntimos/minuto debido a ser domingo. ";
    }

    @Override
    public double precioLlamada(Llamada llamada) {
        if(llamada.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY)
            return 0;
        return getRecubierta().precioLlamada(llamada);
    }

    @Override
    public double getPrecio(){ return 0.0;   }
}
