package main;

import Excepciones.DniNotValidException;
import Excepciones.PhoneNoValidException;
import main.tarifa.Tarifa;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class Cliente implements Fecha{
    private String nombre;
    private String NIF;
    private Tarifa tarifa;
    private Tarifa nueva;
    private Direccion direccion;
    private LocalDateTime fechaAlta;
    public LinkedList<Factura> listaFacturas;
    public LinkedList<Llamada> listaLLamadas;
    private LinkedList<Llamada> listaLLamadasMes;

    public Cliente(){

    }

    public Cliente(String nombre, Tarifa tarifa, Direccion direccion,String NIF) throws DniNotValidException {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.direccion = direccion;
        this.NIF=NIF;
        if(NIF.length()!=9) throw new DniNotValidException();listaLLamadasMes=new LinkedList<Llamada>();
        listaLLamadas=new LinkedList<Llamada>();
        listaFacturas=new LinkedList<Factura>();

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
    public void setLlamada(int telefono, LocalDateTime fechaLlamada, double duracion) throws PhoneNoValidException {
        Llamada auxiliar= new Llamada(tarifa,telefono,fechaLlamada,duracion);
        listaLLamadas.add(auxiliar);
        listaLLamadasMes.add(auxiliar);
    }
    public LinkedList<Llamada> getLlamadas(){
        return listaLLamadas;
    }
    public LinkedList<Factura> getFacturas(){
        return listaFacturas;
    }



    public void anadirFactura(int cod, LocalDateTime actual){
        double suma=0;
        double importe;
        for(int i=0;i<listaLLamadasMes.size();i++){
            suma+=listaLLamadasMes.get(i).getTarifa().getPrecio()*listaLLamadasMes.get(i).getDuracion();
            listaLLamadasMes.remove(i);
        }
        importe=suma;
        listaFacturas.add(new Factura(importe,cod,actual,suma));

    }
    public void setTarifa(Tarifa n){
        nueva=n;
    }

}
