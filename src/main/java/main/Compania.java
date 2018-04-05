package main;
import Excepciones.*;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import main.entradasalida.*;

public class Compania implements Serializable {

    public static LinkedList<Cliente> listaClientes;
    public Compania(){
        listaClientes=new LinkedList<Cliente>();
    }


    public  void addCliente(Cliente c){
        listaClientes.add(c);
    }

    public static LinkedList<Cliente> getClientes(){
        return listaClientes;
    }

}
