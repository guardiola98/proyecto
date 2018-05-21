package main;

import Excepciones.DniNotValidException;
import Excepciones.PhoneNoValidException;
import Interfaces.Transaction;
import main.tarifa.Tarifa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;


public abstract class Cliente extends DniNotValidException implements Transaction, Serializable {
    private String nombre;
    private String NIF;
    private Tarifa tarifa;
    private Direccion direccion;
    private LocalDateTime fechaAlta;
    private LinkedList<Factura> listaFacturas;
    private LinkedList<Llamada> listaLLamadas;
    private LinkedList<Llamada> listaLLamadasMes;
    private Compania gestor;


    public Cliente(String nombre, Tarifa tarifa, Direccion direccion,String NIF,LocalDateTime fecha) throws DniNotValidException{
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.direccion = direccion;
        this.NIF=NIF;
        this.fechaAlta=fecha;
        if(NIF.length()!=9) throw new DniNotValidException();
        listaLLamadasMes=new LinkedList<Llamada>();
        listaLLamadas=new LinkedList<Llamada>();
        listaFacturas=new LinkedList<Factura>();
        gestor=new Compania();
    }
    public String getNIF(){
        return NIF;
    }
    public String toString(){
        String cadena="Nombre: "+nombre+" tarifa: "+tarifa+" dirección: "+direccion.toString()+" NIF/CIF: "+NIF;
        System.out.println(cadena);
        return cadena;
    }

    public void setFechaAlta(LocalDateTime fecha){
        fechaAlta=fecha;
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


    public void setLlamada(int telefono, LocalDateTime fechaLlamada, double duracion) throws PhoneNoValidException {
        Llamada auxiliar= new Llamada(tarifa,telefono,fechaLlamada,duracion);
        listaLLamadas.add(auxiliar);
        listaLLamadasMes.add(auxiliar);
        gestor.addLlamada(auxiliar);
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
        gestor.addFactura(new Factura(importe,cod,actual,suma));
    }
    public void setTarifa(Tarifa n){
        tarifa=n;
    }
    public LinkedList<Cliente> listaPorFecha(LinkedList<Cliente> agenda,LocalDateTime inicio,LocalDateTime fin){
        LinkedList<Cliente> definitivo = new LinkedList<Cliente>();
        for (int i=0; i<agenda.size();i++ ) {


            if (agenda.get(i).getFecha().compareTo(inicio) >= 0 && agenda.get(i).getFecha().compareTo(fin) <= 0) {
                definitivo.add(agenda.get(i));
            }
        }
        return definitivo;
    }
    public abstract boolean isEmpresa();

}
