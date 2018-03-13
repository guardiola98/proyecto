import java.time.LocalDateTime;


public class Llamada {
    private int telefono;
    private LocalDateTime fecha;
    private double duracion;

    public Llamada(int llamado,LocalDateTime momento, double tarda){
        telefono=llamado;
        fecha=momento;
        duracion=tarda;
    }
    public double getDuracion(){
        return duracion;
    }
    public LocalDateTime getFecha(){
        return fecha;
    }

}
