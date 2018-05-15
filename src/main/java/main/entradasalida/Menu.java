package main.entradasalida;
import  java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import Excepciones.*;
import main.*;
import main.tarifa.Tarifa;
import main.tarifa.*;
import main.Compania;


public class Menu implements Serializable {
    Compania com= new Compania();
    private LinkedList<Cliente> listaCli;
    int codigo=0;
    Scanner entrada;
    int contador =0;

    public Menu(LinkedList<Cliente> listaClientesT){

        listaCli =listaClientesT;
    }

    public Menu(){
        listaCli =new LinkedList<Cliente>();
    }



    public void showMenu() throws OptionNoValidExcepction, DniNotValidException, IOException, ClassNotFoundException, DniNoExixstException, PhoneNoValidException {
        if(contador == 0) {
            Scanner entr=new Scanner(System.in);
            String inicio;
            System.out.println("¿Antes de empezar desea cargar los datos de la aplicación desde un fichero(fichero.bin)?s/n");
            inicio = entr.nextLine();
            if (inicio.equals("s")){
                cargarDatos();
            }
        }

        int opcion = mainMenu();
        contador+=1;
        switch (opcion){
            case 1:
                opcion=clientsMenu();//llamamos al menu de clientes

                switch (opcion){
                    case 1:
                        almacenarCliente();
                        break;
                    case 2:
                        borrarCliente();
                        break;
                    case 3:
                        cambiarTarifa();
                        break;
                    case 4:
                       recuperarDatos();
                        break;
                    case 5:
                        recuperarLista();
                        break;
                    case 6:
                        recuperarEntreDosFechas();
                        break;
                    }
                    break;
            case 2:

                opcion=menuLlamadas();

                switch (opcion) {
                    case 1:
                        altaLlamada();
                        break;
                    case 2:
                        listarLlamada();
                        break;
                    case 3:
                        llamadaEntreDosFechas();
                        break;
                }
            case 3:

                opcion=menuFactura();

                switch (opcion){
                    case 1:
                        emitirFactura();
                        break;
                    case 2:
                        recuperarFacturaCod();
                        break;
                    case 3:
                        recuperarFacturasCli();
                        break;
                    case 4:
                        facturasEntreDosFechas();
                        break;

                }



        }

    }
    private int mainMenu() throws OptionNoValidExcepction{
        System.out.println(" Menú principal ");
        System.out.println(" 1.- Clientes. ");
        System.out.println(" 2.- Llamadas. ");
        System.out.println(" 3.- Facturas. ");
        System.out.println("-------------");

        System.out.println(" Seleccione una opción: ");
        Scanner entrada;
        entrada = new Scanner(System.in);
        int opcion= entrada.nextInt();
        if(opcion<=0 || opcion>4) throw new OptionNoValidExcepction ();
        return opcion;
    }
    private int clientsMenu() throws OptionNoValidExcepction{
        System.out.println(" Menú clientes. Seleccione una opción. ");
        System.out.println(" 1.- Dar de alta un nuevo cliente. ");
        System.out.println(" 2.- Borrar un cliente existente. ");
        System.out.println(" 3.- Cambiar la tarifa de un cliente. ");
        System.out.println(" 4.- Recuperar datos a partir del NIF. ");
        System.out.println(" 5.- Recuperar listado de los clientes. ");
        System.out.println(" 6.- Recuperar listado de los clientes dados de alta entre dos fechas. ");
        System.out.println("------------------------------------------------");

        System.out.println(" Seleccione una opción: ");
        Scanner entrada;
        entrada = new Scanner(System.in);
        int opcion=entrada.nextInt();
        if(opcion<=0 || opcion>6) throw new OptionNoValidExcepction ();
        return opcion;
    }

    private void almacenarCliente()throws DniNotValidException{
        Fabrica fabrica= new FabricaCliente();
        entrada = new Scanner(System.in);
        System.out.println("Introduce datos del nuevo cliente: ");
        System.out.println("Nombre: ");
        String nombre= entrada.next();
        System.out.println("NIF/CIF: ");
        String codigo= entrada.next();
        if(codigo.length()!=9) throw new DniNotValidException();
        Tarifa tar= new Basica();
        System.out.println("Provincia: ");
        String provincia= entrada.next();
        System.out.println("Nombre poblacion: ");
        String poblacion= entrada.next();
        System.out.println("Código postal: ");
        int codpostal= entrada.nextInt();
        Direccion dir=new Direccion(provincia,poblacion,codpostal);
        System.out.println(" ¿Es una empresa? s/n ");
        String c=entrada.next();
        if(c.equals("s")){
            if(listaCli.isEmpty()) {
                if (listaCli.contains(fabrica.getNuevaEmpresa(nombre, tar, dir, codigo,LocalDateTime.now())));
            }
            Cliente empresa = fabrica.getNuevaEmpresa(nombre, tar, dir, codigo,LocalDateTime.now());
            Compania.addCliente(empresa);
            listaCli.add(empresa);

        }
        else if (c.equals("n")){
            System.out.println("Apellidos: ");
            String apellidos= entrada.next();
            Cliente particular=fabrica.getNuevoParticular(nombre,tar,dir,apellidos,codigo,LocalDateTime.now());
            Compania.addCliente(particular);
            listaCli.add(particular);
        }
    }

    private void borrarCliente(){
        entrada = new Scanner(System.in);
        System.out.println("Introduce el NIF/CIF del cliente a borrar: ");
        String nif= entrada.nextLine();
        for (int i = 0; i< listaCli.size(); i++){
            Cliente aux= listaCli.get(i);
            if (aux.getNIF().equals(nif)){
                listaCli.remove(i);
                break;
            }
        }
    }
    private void cambiarTarifa(){
        entrada = new Scanner(System.in);
        System.out.println("Introduce el NIF/CIF del cliente cuya tarifa quiere ser modificada: ");
        String nif= entrada.nextLine();
        for (int i = 0; i< listaCli.size(); i++){
            Cliente aux= listaCli.get(i);
            if (aux.getNIF().equals(nif)){
                System.out.println("Introduce el importe de la nueva tarifa");
                Tarifa tarifa=new Basica();
                aux.setTarifa(tarifa);
            }
        }
    }
    private void recuperarDatos(){
        entrada = new Scanner(System.in);
        System.out.println("Introduce el NIF/CIF del cliente : ");
        String nif= entrada.nextLine();
        for (int i = 0; i< listaCli.size(); i++){
            Cliente aux= listaCli.get(i);
            if (aux.getNIF().equals(nif)){
                String recuperacion= listaCli.get(i).toString();
            }
        }
    }

    private void recuperarLista(){
        for (int i = 0; i< listaCli.size(); i++){
            Cliente aux= listaCli.get(i);
            String recuperacion= aux.toString();
        }
    }
    private void recuperarEntreDosFechas(){
        entrada=new Scanner(System.in);
        System.out.println("Introduce fecha de inicio con formato año-mes-dia hora:minutos");
        String str=entrada.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime inicio = LocalDateTime.parse(str, formatter);
        System.out.println("Introduce fecha de inicio con formato año-mes-dia hora:minutos");
        str=entrada.next();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fin = LocalDateTime.parse(str, formatter2);


        LinkedList<Cliente> listadef=listaContenedora(listaCli, inicio, fin);
        for(int i=0;i<listadef.size();i++){
            listadef.get(i).toString();
        }
    }


    public static <T extends Transaction> LinkedList <T> listaContenedora(LinkedList<T> lista, LocalDateTime inicio, LocalDateTime fin){
        LinkedList<T> res =new LinkedList<>();
        for(T elementos:lista){
            if (elementos.getFecha().isBefore(fin) && elementos.getFecha().isAfter(inicio)) {
                res.add((T) elementos);
            }
        }
        return res;
    }

    private int menuLlamadas() throws OptionNoValidExcepction{
        entrada = new Scanner(System.in);
        System.out.println(" Menú Llamadas. Seleccione una opción. ");
        System.out.println(" 1.- Dar de alta una llamada. ");
        System.out.println(" 2.- Listar las llamadas de un cliente. ");
        System.out.println(" 3.- Listar las llamadas de un cliente comprendidas entre dos fechas. ");

        System.out.println("-------------------------------------------");
        System.out.println(" Seleccione una opción: ");

        int opcion=entrada.nextInt();
        if(opcion<=0 || opcion>3) throw new OptionNoValidExcepction ();
        return opcion;
    }
    private void altaLlamada() throws PhoneNoValidException {
        entrada = new Scanner(System.in);
        System.out.println("Quien llama? introduce NIF/CIF: ");
        String salida = entrada.nextLine();
        for (int i = 0; i < listaCli.size(); i++) {
            Cliente aux = listaCli.get(i);
            if (aux.getNIF() == salida) {
                System.out.println("Introduce telefono al que se llama: ");
                int telefono = entrada.nextInt();
                System.out.println("Introduce en minutos la duración de la llamada: ");
                double duracion = entrada.nextDouble();
                aux.setLlamada(telefono, LocalDateTime.now(), duracion);
                break;
            }
        }
    }

    private void listarLlamada(){
        entrada = new Scanner(System.in);
        System.out.println("Introduce NIF/CIF: ");
        String salida = entrada.nextLine();
        for (int i = 0; i < listaCli.size(); i++) {
            Cliente aux = listaCli.get(i);
            if (aux.getNIF() == salida) {
                LinkedList<Llamada> lLlamadas = aux.getLlamadas();
                for (int j = 0; j < lLlamadas.size(); j++) {
                    lLlamadas.get(j).toString();
                }
            }
            break;
        }
    }
    private void llamadaEntreDosFechas() throws DniNoExixstException {
        entrada=new Scanner(System.in);
        System.out.println("NIF del cliente del que quieres extraer las llamadas");
        String cli=entrada.next();
        System.out.println("Introduce fecha de inicio con formato año-mes-dia hora:minutos");
        String str=entrada.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime inicio = LocalDateTime.parse(str, formatter);
        System.out.println("Introduce fecha de inicio con formato año-mes-dia hora:minutos");
        str=entrada.next();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fin = LocalDateTime.parse(str, formatter2);
        boolean exists=false;
        for(int j = 0; j< listaCli.size(); j++) {
            if(listaCli.get(j).getNIF().equals(cli)) {
                exists=true;
                LinkedList<Llamada> listadef = listaContenedora(listaCli.get(j).getLlamadas(), inicio, fin);
                for (int i = 0; i < listadef.size(); i++) {
                    listadef.get(i).toString();
                }
                break;
            }
        }
        if(exists==false){
            throw new DniNoExixstException();
        }
    }

    private int menuFactura() throws OptionNoValidExcepction{
        entrada=new Scanner(System.in);
        System.out.println(" Menú Facturas. Seleccione una opción. ");
        System.out.println(" 1.- Emitir una factura para un cliente, calculando el importe de la misma en función de las llamadas.");
        System.out.println(" 2.- Recuperar los datos de una factura a partir de su código. ");
        System.out.println(" 3.- Recuperar todas las facturas de un cliente. ");
        System.out.println(" 4.- Recuperar facturas comprendidas entre dos fechas. ");
        System.out.println("-------------------------------------------");
        System.out.println(" Seleccione una opción: ");
        int opcion=entrada.nextInt();
        if(opcion<=0 || opcion>4) throw new OptionNoValidExcepction ();
        return opcion;
    }


    private void emitirFactura(){
        entrada=new Scanner(System.in);
        System.out.println("Introduce NIF/CIF: ");
        String nif=entrada.nextLine();
        for (int i = 0; i < listaCli.size(); i++) {
            Cliente aux = listaCli.get(i);
            if (aux.getNIF().equals(nif)) {
                listaCli.get(i).anadirFactura(codigo,LocalDateTime.now());
                codigo+=1;
                break;
            }
        }
    }

    private void recuperarFacturaCod(){
        entrada=new Scanner(System.in);
        System.out.println("Introduce codigo: ");
        int codigo=entrada.nextInt();
        for (int i = 0; i < listaCli.size(); i++) {
            Cliente aux = listaCli.get(i);
            for (int j=0; j<aux.getFacturas().size();j++){
                if(aux.getFacturas().get(j).getCodigo()==codigo){
                    aux.getFacturas().get(j).toString();
                }
            }
        }
    }

    private void recuperarFacturasCli(){
        for (int i = 0; i < listaCli.size(); i++) {
            Cliente aux = listaCli.get(i);
            for (int j=0; j<aux.getFacturas().size();j++){
                aux.getFacturas().get(j).toString();
            }
        }
    }
    public void facturasEntreDosFechas() throws DniNoExixstException {
        entrada=new Scanner(System.in);
        System.out.println("Introduce fecha de inicio con formato año-mes-dia hora:minutos");
        String str=entrada.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime inicio = LocalDateTime.parse(str, formatter);
        System.out.println("Introduce fecha de inicio con formato año-mes-dia hora:minutos");
        str=entrada.next();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fin = LocalDateTime.parse(str, formatter2);

        for(int j=0;j<listaCli.size();j++) {
            LinkedList<Factura> listadef = listaContenedora(listaCli.get(j).getFacturas(), inicio, fin);
            for (int i = 0; i < listadef.size(); i++) {
                listadef.get(i).toString();
            }
        }
    }
    public void guardarDatos() throws IOException{
        try{
            FileOutputStream fos = new FileOutputStream("fichero.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(com);
            oos.close();
        } catch (IOException e){
            System.out.println("Nada que guardar");
        }
    }

    public void cargarDatos() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(" fichero.bin ");
            ObjectInputStream ois = new ObjectInputStream(fis);
            com = (Compania) ois.readObject();
            listaCli=com.listaClientes;
            ois.close();
        }catch (IOException e){
            System.out.println("No hay archivo que leer");
        }
    }

}



