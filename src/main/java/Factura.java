import java.time.LocalDateTime;


public class Factura {
    private Tarifa tarifa;
    private int codigo;
    private double importe;
    private double tiempo;

    public Factura(Tarifa tar, int cod, LocalDateTime inicio,double minutos){
        tarifa=tar;
        codigo=cod;
        importe=minutos*tar.getTarifa();
        tiempo=minutos;
    }

    public double getImporte(){
        return importe;
    }
    public int getCodigo(){
        return codigo;
    }
}
