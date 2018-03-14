import java.time.LocalDateTime;
import java.util.LinkedList;


public class Cliente implements Fecha{
    private String nombre;
    private String NIF;
    private Tarifa tarifa;
    private Tarifa nueva;
    private Direccion direccion;
    private LocalDateTime fechaAlta;
    private LinkedList<Factura> listaFacturas;
    private LinkedList<Llamada> listaLLamadas;
    private LinkedList<Llamada> listaLLamadasMes;



    public Cliente(String nombre, Tarifa tarifa, Direccion direccion,String NIF) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.direccion = direccion;
        this.NIF=NIF;
    }
    public String getNIF(){
        return NIF;
    }
    public String toString(){
        String cadena="Nombre: "+nombre+" tarifa: "+tarifa+" dirección: "+direccion.toString()+" NIF/CIF: "+NIF;
        System.out.println(cadena);
        return cadena;
    }

    public String getNombre(){  return nombre;}


    public Tarifa getTarifa(){
        return tarifa;
    }

    public Direccion getDireccion(){
        return direccion;
    }

    @Override
    public LocalDateTime getFecha(){
        return fechaAlta;
    }

    public LinkedList<Llamada> getLlamadas(){
        return listaLLamadas;
    }
    public LinkedList<Factura> getFacturas(){
        return listaFacturas;
    }


    public void setLlamada(int telefono, LocalDateTime fechaLlamada, double duracion){
        Llamada auxiliar= new Llamada(telefono,fechaLlamada,duracion);
        listaLLamadas.add(auxiliar);
        listaLLamadasMes.add(auxiliar);
    }
    public void añadirFactura(int cod, LocalDateTime actual){
        double suma=0;
        double importe;
        for(int i=0;i<listaLLamadasMes.size();i++){
            suma+=listaLLamadasMes.get(i).getDuracion();
            listaLLamadasMes.remove(i);
        }
        importe=suma*tarifa.getTarifa();
        listaFacturas.add(new Factura(tarifa,cod,actual,suma));
        tarifa=nueva;
    }
    public void setTarifa(Tarifa n){
        nueva=n;
    }

}
