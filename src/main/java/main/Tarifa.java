package main;

public class Tarifa {
    private double tarifa;

    public Tarifa(){
        tarifa=1;
    }
    public Tarifa(double precio){
        tarifa=precio;
    }

    public double getTarifa(){
        return tarifa;
    }
    public String toString(){
        String cadena;
        cadena=" "+tarifa;
        return cadena;
    }

    public double getPrecio(){
        return tarifa;
    }
}
