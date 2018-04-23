package main.tarifa;
import java.io.Serializable;

public abstract class Especial extends Tarifa implements Serializable {
    private Tarifa recubierta;

    public Especial(Tarifa recubierta,double precio) {
        super(precio);
        this.recubierta =recubierta;
    }

    public Tarifa getRecubierta() {
        return recubierta;
    }
}
