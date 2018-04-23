package main.tarifa;
import java.io.Serializable;
import main.Llamada;
public abstract class Tarifa implements Serializable {
        private double precio;

        public Tarifa(double precio){
            this.precio =precio;
        }

        public double getPrecio(){
            return precio;
        }
        //    public abstract String toString();
        public abstract double precioLlamada(Llamada llamada);
    }

