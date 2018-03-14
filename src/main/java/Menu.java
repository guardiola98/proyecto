import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;



public class Menu extends Cliente {
    private LinkedList<Cliente> listaClientes;
    int codigo=0;
    Scanner entrada;

    public Menu(LinkedList<Cliente> listaClientesT){

        listaClientes=listaClientesT;
    }

    public Menu(){
        listaClientes=new LinkedList<Cliente>();
    }

    public void showMenu(){
        int opcion = mainMenu();

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
                        System.out.println("Introduce NIF/CIF: ");
                        String nif=entrada.nextLine();
                        for (int i = 0; i < listaClientes.size(); i++) {
                            Cliente aux = listaClientes.get(i);
                            if (aux.getNIF() == nif) {
                                listaClientes.get(i).añadirFactura(codigo,LocalDateTime.now());
                                codigo+=1;
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Introduce codigo: ");
                        int codigo=entrada.nextInt();
                        for (int i = 0; i < listaClientes.size(); i++) {
                            Cliente aux = listaClientes.get(i);
                            for (int j=0; j<aux.getFacturas().size();j++){
                                if(aux.getFacturas().get(j).getCodigo()==codigo){
                                    aux.getFacturas().get(j).toString();
                                }
                            }
                        }
                        break;
                    case 3:
                        for (int i = 0; i < listaClientes.size(); i++) {
                            Cliente aux = listaClientes.get(i);
                            for (int j=0; j<aux.getFacturas().size();j++){
                                    aux.getFacturas().get(j).toString();
                            }
                        }
                        break;


                }
                break;

        }
        System.out.println("Deseas realizar alguna otra opción?s/n");
        String fin=entrada.nextLine();
        if(fin=="s"){
            showMenu();
        }
        else{
            System.out.println("Gracias y que pase un buen día.");
        }

    }
    private int mainMenu()  {
        System.out.println(" Menú principal ");
        System.out.println(" 1.- Clientes. ");
        System.out.println(" 2.- Llamadas. ");
        System.out.println(" 3.- Facturas. ");
        System.out.println("-------------");

        System.out.println(" Seleccione una opción: ");
        Scanner entrada;
        entrada = new Scanner(System.in);
        int opcion= entrada.nextInt();
        return opcion;
    }
    private int clientsMenu(){
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
        return opcion;
    }

    private void almacenarCliente(){
        System.out.println("Introduce datos del nuevo cliente: ");
        System.out.println("Nombre: ");
        String nombre= entrada.nextLine();
        System.out.println("NIF/CIF: ");
        String codigo= entrada.nextLine();
        System.out.println("Introduce tarifa: ");
        Tarifa tar= new Tarifa(entrada.nextInt());
        System.out.println("Provincia: ");
        String provincia= entrada.nextLine();
        System.out.println("Nombre poblacion: ");
        String poblacion= entrada.nextLine();
        System.out.println("Código postal: ");
        int codpostal= entrada.nextInt();
        Direccion dir=new Direccion(provincia,poblacion,codpostal);
        System.out.println(" ¿Es una empresa? s/n ");
        String c=entrada.nextLine();
        if(c=="s"){
            Empresa empresa=new Empresa(nombre,tar,dir,codigo);
            listaClientes.add(empresa);
        }
        else if (c=="n"){
            System.out.println("Apellidos: ");
            String apellidos= entrada.nextLine();
            Particular particular=new Particular(nombre,tar,dir,apellidos,codigo);
            listaClientes.add(particular);

        }
    }

    private void borrarCliente(){
        entrada = new Scanner(System.in);
        System.out.println("Introduce el NIF/CIF del cliente a borrar: ");
        String nif= entrada.nextLine();
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            if (aux.getNIF().equals(nif)){
                listaClientes.remove(i);
                break;
            }
        }
    }
    private void cambiarTarifa(){
        entrada = new Scanner(System.in);
        System.out.println("Introduce el NIF/CIF del cliente cuya tarifa quiere ser modificada: ");
        String nif= entrada.nextLine();
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            if (aux.getNIF().equals(nif)){
                System.out.println("Introduce el importe de la nueva tarifa");
                Tarifa tarifa=new Tarifa(entrada.nextDouble());
                aux.setTarifa(tarifa);
            }
        }
    }
    private void recuperarDatos(){
        entrada = new Scanner(System.in);
        System.out.println("Introduce el NIF/CIF del cliente : ");
        String nif= entrada.nextLine();
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
            if (aux.getNIF()==nif){
                String recuperacion= listaClientes.get(i).toString();
            }
        }
    }

    private void recuperarLista(){
        for (int i=0;i<listaClientes.size();i++){
            Cliente aux= listaClientes.get(i);
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


        LinkedList<Cliente> listadef=listaContenedora(listaClientes, inicio, fin);
        for(int i=0;i<listadef.size();i++){
            listadef.get(i).toString();
        }
    }


    private static <T extends Fecha> LinkedList <T> listaContenedora(LinkedList<T> lista, LocalDateTime inicio, LocalDateTime fin){
        LinkedList<T> res =new LinkedList<>();
        for(T elementos:lista){
            if (elementos.getFecha().isBefore(fin) && elementos.getFecha().isAfter(inicio)) {
                res.add((T) elementos);
            }
        }
        return res;
    }

    private int menuLlamadas(){
        entrada = new Scanner(System.in);
        System.out.println(" Menú Llamadas. Seleccione una opción. ");
        System.out.println(" 1.- Dar de alta una llamada. ");
        System.out.println(" 2.- Listar las llamadas de un cliente. ");
        System.out.println(" 2.- Listar las llamadas de un cliente comprendidas entre dos fechas. ");

        System.out.println("-------------------------------------------");
        System.out.println(" Seleccione una opción: ");

        int opcion=entrada.nextInt();
        return opcion;
    }
    private void altaLlamada(){
        entrada = new Scanner(System.in);
        System.out.println("Quien llama? introduce NIF/CIF: ");
        String salida = entrada.nextLine();
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente aux = listaClientes.get(i);
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
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente aux = listaClientes.get(i);
            if (aux.getNIF() == salida) {
                LinkedList<Llamada> lLlamadas = aux.getLlamadas();
                for (int j = 0; j < lLlamadas.size(); j++) {
                    lLlamadas.get(j).toString();
                }
            }
            break;
        }
    }
    private void llamadaEntreDosFechas(){
        entrada=new Scanner(System.in);
        System.out.println("Introduce fecha de inicio con formato año-mes-dia hora:minutos");
        String str=entrada.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime inicio = LocalDateTime.parse(str, formatter);
        System.out.println("Introduce fecha de inicio con formato año-mes-dia hora:minutos");
        str=entrada.next();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fin = LocalDateTime.parse(str, formatter2);


        LinkedList<Llamada> listadef=listaContenedora(listaLLamadas, inicio, fin);
        for(int i=0;i<listadef.size();i++){
            listadef.get(i).toString();
        }
    }

    private int menuFactura(){
        System.out.println(" Menú Facturas. Seleccione una opción. ");
        System.out.println(" 1.- Emitir una factura para un cliente, calculando el importe de la misma en función de las llamadas.");
        System.out.println(" 2.- Recuperar los datos de una factura a partir de su código. ");
        System.out.println(" 3.- Recuperar todas las facturas de un cliente. ");
        System.out.println(" 4.- Recuperar facturas comprendidas entre dos fechas. ");
        System.out.println("-------------------------------------------");
        System.out.println(" Seleccione una opción: ");
        int opcion=entrada.nextInt();
        return opcion;
    }


}



