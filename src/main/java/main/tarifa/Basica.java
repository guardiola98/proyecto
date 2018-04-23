package main.tarifa;

import java.io.Serializable;
import main.Llamada;

public class Basica extends Tarifa implements Serializable {
    public Basica() {
        super(15);
    }
    @Override
    public double precioLlamada(Llamada llamada) {
        return getPrecio() * llamada.getDuracion();
    }
}
