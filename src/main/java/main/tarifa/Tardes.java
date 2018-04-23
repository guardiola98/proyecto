package main.tarifa;
import main.Llamada;
import java.io.Serializable;

public class Tardes extends Especial implements Serializable {
    public Tardes(Tarifa tar) {
        super(tar, 5);
    }
    @Override
    public double getPrecio(){ return 5.0;}

    @Override
    public double precioLlamada(Llamada llamada) {
        double valorMin;
        if (llamada.getFecha().getHour() >= 16.0 && llamada.getFecha().getHour() <= 20.0) {

            valorMin = llamada.getDuracion() * super.getPrecio();
            if (getRecubierta().precioLlamada(llamada) < valorMin) {
                return getRecubierta().precioLlamada(llamada);
            } else {
                return valorMin;
            }
        } return getRecubierta().precioLlamada(llamada);
    }
}
