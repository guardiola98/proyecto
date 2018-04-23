package main;
import Excepciones.*;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import main.entradasalida.*;

public class Compania implements Serializable {


    private static LinkedList<Factura> facturasTotales;
    private static LinkedList<Llamada> llamadasTotales;
    public static LinkedList<Cliente> listaClientes;
    public Compania(){
        facturasTotales=new LinkedList<Factura>();
        llamadasTotales=new LinkedList<Llamada>();
        listaClientes=new LinkedList<Cliente>();
    }
    public LinkedList<Factura> listaFacturasPorFecha(LinkedList<Factura> agenda, LocalDateTime inicio, LocalDateTime fin){
        return Menu.listaContenedora(agenda, inicio, fin);
    }
    public LinkedList<Llamada> listaLlamadasPorFecha(LinkedList<Llamada> agenda, LocalDateTime inicio, LocalDateTime fin){
        return Menu.listaContenedora(agenda, inicio, fin);
    }
    public void addFactura(Factura f){
        facturasTotales.add(f);
    }
    public void addLlamada(Llamada l){
        llamadasTotales.add(l);
    }
    public static void addCliente(Cliente c){
        listaClientes.add(c);
    }
    public static void cargaFacturas(LinkedList<Cliente> lista){
        for(int i=0; i<lista.size();i++){
            Cliente auxiliar=lista.get(i);
            for(int j=0;j<lista.size();j++){
                facturasTotales.add(auxiliar.getFacturas().get(j));
            }
        }
    }
    public static void cargaLlamadas(LinkedList<Cliente> lista){
        for(int i=0; i<lista.size();i++){
            Cliente auxiliar=lista.get(i);
            for(int j=0;j<lista.size();j++){
                llamadasTotales.add(auxiliar.getLlamadas().get(j));
            }
        }
    }
    public static LinkedList<Cliente> getClientes(){
        return listaClientes;
    }

}
