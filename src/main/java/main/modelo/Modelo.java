package main.modelo;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;

import Excepciones.DniNoExixstException;
import Excepciones.DniNotValidException;
import Excepciones.PhoneNoValidException;
import Interfaces.FabricaTar;
import Interfaces.IModelo;
import Interfaces.IVista;
import main.Vista.Vista;
import main.*;
import main.Compania;
import main.tarifa.FabricaTarifas;
import main.tarifa.TipoTarifa;

public class Modelo implements IModelo, Serializable {
    private LinkedList<Cliente> listaClientes;
    private IVista vista;
    private FabricaCliente fabricaClientes;
    private FabricaTar fabricaTarifas;
    private TipoTarifa tipo;
    private String [] listaDNI;
    private String[] listaFacturas;
    private String[] listaLlamadasEntreFechas;
    private String[] listaFacturasEntreFechas;
    private String[] listaLlamadas;
    private int codigo=0;

    public Modelo(){
        listaClientes= new LinkedList<Cliente>();
        fabricaClientes=new FabricaCliente();
        fabricaTarifas=new FabricaTarifas();
        vista= new Vista();
    }

    public void setVista(IVista vista) {
        this.vista = vista;
    }


    @Override
    public void cargaDatos() throws ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("agenda.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaClientes = (LinkedList<Cliente>)ois.readObject();
            ois.close();
            Compania.cargaFacturas(listaClientes);
            Compania.cargaLlamadas(listaClientes);
        } catch (IOException e){
            System.out.println("No hay archivo que leer");
        }
    }

    @Override
    public void guardaDatos() {
        try {
            FileOutputStream fos = new FileOutputStream("agenda.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaClientes);
            oos.close();
        } catch (IOException e){
            System.out.println("Nada que guardar");
        }
    }


    @Override
    public void anadeParticular(String nombre, String apellidos, String dni, Direccion direccion, LocalDateTime fechaAlta) throws DniNotValidException {
        tipo=vista.getTipoTarifa();
        listaClientes.add(fabricaClientes.getNuevoParticular(nombre,fabricaTarifas.getNuevaTarifa(tipo),direccion,apellidos,dni,fechaAlta));
    }

    @Override
    public void anadeEmpresa(String nombre, String dni, Direccion direccion, LocalDateTime now) throws DniNotValidException {
        listaClientes.add(fabricaClientes.getNuevaEmpresa(nombre,fabricaTarifas.getNuevaTarifa(tipo),direccion,dni,now));
    }

    @Override
    public void borrarCliente(String dni) throws DniNoExixstException {
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            if (aux.getNIF().equals(dni)){
                listaClientes.remove(i);
                break;
            }
            if(i==listaClientes.size()-1) throw new DniNoExixstException();
        }
    }

    @Override
    public void recuperaCliente(String dni) throws DniNoExixstException {
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            if (aux.getNIF().equals(dni)){
                vista.setDatosdeCliente(aux.toString());
                break;
            }
            if(i==listaClientes.size()-1) throw new DniNoExixstException();
        }
    }

    @Override
    public void listarClientes() throws DniNoExixstException {
        listaDNI=new String[listaClientes.size()];
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            listaDNI[i]=aux.getNIF()+"  ----------> "+aux.getNombre();
        }
        vista.setListaDNI(listaDNI);
    }

    @Override
    public void listaEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        listaDNI=new String[listaClientes.size()];
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            if (aux.getFecha().isAfter(inicio) && aux.getFecha().isBefore(fin)) {
                listaDNI[i] = aux.getNIF()+"  ----------> "+aux.getNombre();
            }
        }
        vista.setListaEntreFechas(listaDNI);
    }

    @Override
    public void addLlamada(String dniFac, int telefonoDestino, double duracion) throws PhoneNoValidException {
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            if (aux.getNIF().equals(dniFac)) {
                aux.setLlamada(telefonoDestino,LocalDateTime.now(),duracion);
            }
        }
    }

    @Override
    public void getLlamadas(String dnitLlam) {

        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            if (aux.getNIF().equals(dnitLlam)) {
                listaLlamadas = new String[aux.getLlamadas().size()];
                for(int j=0;j<aux.getLlamadas().size();j++){
                    listaLlamadas[j]=aux.getLlamadas().get(j).toString();
                }
            }
        }
        vista.setLlamadas(listaLlamadas);
    }

    @Override
    public void listarLlamadasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        int contador=0;
        listaLlamadasEntreFechas =new String[1000];
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            for(int j=0;j<aux.getLlamadas().size();j++){
                if(listaClientes.get(i).getLlamadas().get(j).getFecha().isBefore(fin) && listaClientes.get(i).getLlamadas().get(j).getFecha().isAfter(inicio))
                    listaLlamadasEntreFechas[contador]=aux.getLlamadas().get(j).toString();
                contador++;
            }

        }
        vista.setLlamadasEntreFechas(listaLlamadasEntreFechas);
    }

    @Override
    public void anadirFactura(String dniFac) {
        for(int i=0;i<listaClientes.size();i++) {
            if (listaClientes.get(i).getNIF().equals(dniFac)) {
                listaClientes.get(i).anadirFactura(codigo, LocalDateTime.now());
                codigo++;
            }
        }
    }

    @Override
    public void recuperaFactura(int codigo) {
        for(int i=0;i<listaClientes.size();i++) {
            Cliente aux=listaClientes.get(i);
            for (int j=0;j<listaClientes.get(i).getFacturas().size();j++){
                if(listaClientes.get(i).getFacturas().get(j).getCodigo()==codigo)
                    vista.setFacturaRecuperada(listaClientes.get(i).getFacturas().get(j).toString());
            }
        }
    }

    @Override
    public void recuperaFacturas(String dniCliente) {

        int contador=0;
        for(int i=0;i<listaClientes.size();i++) {
            Cliente aux=listaClientes.get(i);
            if(aux.getNIF().equals(dniCliente))
                listaFacturas=new String[aux.getFacturas().size()];
            for(int j=0;j<aux.getFacturas().size();j++){
                listaFacturas[contador]=aux.getFacturas().get(j).toString();
            }
        }
        vista.setFacturas(listaFacturas);
    }

    @Override
    public void listaFacturasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        int contador=0;
        listaFacturasEntreFechas = new String[1000];
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            for(int j=0;j<aux.getLlamadas().size();j++){
                if(listaClientes.get(i).getFacturas().get(j).getFecha().isBefore(fin) && listaClientes.get(i).getFacturas().get(j).getFecha().isAfter(inicio))
                    listaFacturasEntreFechas[contador]=aux.getFacturas().get(j).toString();
                contador++;
            }

        }
        vista.setFacturasEntreFechas(listaFacturasEntreFechas);
    }
}
