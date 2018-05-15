package main.Vista;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import Excepciones.*;
import main.IModelo;
import main.IControlador;

import main.IVista;
import main.Llamada;
import main.Direccion;
import main.tarifa.TipoTarifa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Vista implements IVista, Serializable {
    private IControlador controlador;
    private IModelo modelo;


    // Menú Clientes

    private JRadioButton jParticular;
    private JRadioButton jEmpresa;
    private JRadioButton jBasica;
    private JRadioButton jTardes;
    private JRadioButton jDomingos;
    private JTextField jApellidos;
    private JTextField jNombre;
    private JTextField jDNI;
    private JTextField jProvincia;
    private JTextField jPoblacion;
    private JTextField jcp;
    private JTextField jDiaInicio;
    private JTextField jMesInicio;
    private JTextField jAnyoInicio;
    private JTextField jDiaFin;
    private JTextField jMesFin;
    private JTextField jAnyoFin;
    private String nombre;
    private String apellidos;
    private String DNI;
    private String provincia;
    private String poblacion;
    private int cp;
    private String datosCliente;
    private String[] dnis;
    private String diaInicio;
    private String mesInicio;
    private String anyoInicio;
    private String diaFin;
    private String mesFin;
    private String anyoFin;
    private String[] listaEntreFechas;


    // Menú Llamadas

    private JTextField jDNILlam;
    private JTextField jTelefonoDestino;
    private JTextField jDuracion;
    private JTextField jDNITLlam;
    private JTextField jDiaInicioLL;
    private JTextField jMesInicioLL;
    private JTextField jAnyoInicioLL;
    private JTextField jDiaFinLL;
    private JTextField jMesFinLL;
    private JTextField jAnyoFinLL;
    private String diaInicioLL;
    private String mesInicioLL;
    private String anyoInicioLL;
    private String diaFinLL;
    private String mesFinLL;
    private String anyoFinLL;
    private String DNILlam;
    private String DNITLlam;
    private int telefonoDestino;
    private double duracion;
    private String[] listaLlamadas=null;
    String[] listaLlamadasEntreFechas;

    // Menú Facturas

    private JTextField jCodigo;
    private JTextField jDNIFac;
    private JTextField jCliente;
    private JTextField jDiaInicioF;
    private JTextField jMesInicioF;
    private JTextField jAnyoInicioF;
    private JTextField jDiaFinF;
    private JTextField jMesFinF;
    private JTextField jAnyoFinF;
    private String diaInicioF;
    private String mesInicioF;
    private String anyoInicioF;
    private String diaFinF;
    private String mesFinF;
    private String anyoFinF;
    private String DNIFac;
    private int codigo;
    private String[] facturaRecuperada= null;
    private String[] facturas;
    private String[] facturasEntreFechas;
    private String DNICliente;

    public Vista() {

    }


    public void setControlador(IControlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(IModelo modelo) {
        this.modelo = modelo;
    }

    private void GUI() {
        JFrame ventana = new JFrame("Menu Principal");;
        creaMenuPrincipal(ventana);
        ventana.setResizable(false);
        ventana.setSize(1200,675);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private void creaMenuPrincipal(JFrame ventana) {
        JTabbedPane pestañas = new JTabbedPane();

        // Menú Clientes

        Container contenedorMenuClientes = new Container();
        contenedorMenuClientes.setLayout(new BoxLayout(contenedorMenuClientes,BoxLayout.Y_AXIS));


        // Tipo de Cliente

        JPanel tipoCliente = new JPanel();
        TitledBorder tituloTipoCliente = new TitledBorder("SELECCIONA TIPO CLIENTE");
        tipoCliente.setBorder(tituloTipoCliente);


        jParticular=new JRadioButton("Particular");
        jEmpresa=new JRadioButton("Empresa");

        tipoCliente.add(jParticular);
        tipoCliente.add(jEmpresa);


        jParticular.setSelected(true);
        jParticular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jApellidos.setEnabled(true);
            }
        });
        jEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jApellidos.setEnabled(false);
            }
        });


        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jParticular);
        buttonGroup.add(jEmpresa);


        // Introducir Datos
        JPanel introducirDatos = new JPanel();
        TitledBorder introDatos = new TitledBorder("INTRODUCCIÓN DE DATOS DEL CLIENTE");
        introDatos.setBorder(introDatos);
        introducirDatos.setLayout(new GridLayout(8,0));

        introducirDatos.add(new JLabel("Nombre:"));
        introducirDatos.add(jNombre = new JTextField(10));
        introducirDatos.add(new JLabel("Apellidos:"));
        introducirDatos.add(jApellidos = new JTextField(15));
        introducirDatos.add(new JLabel("DNI / NIF (Empresa):"));
        introducirDatos.add(jDNI = new JTextField(9));
        introducirDatos.add(new JLabel("Provincia:"));
        introducirDatos.add(jProvincia = new JTextField(15));
        introducirDatos.add(new JLabel("Población:"));
        introducirDatos.add(jPoblacion = new JTextField(20));
        introducirDatos.add(new JLabel("Código Postal:"));
        introducirDatos.add(jcp = new JTextField(5));



        // Tarifas

        JPanel tarifas=new JPanel();
        TitledBorder tarifa = new TitledBorder("SELECCIÓN TARIFAS DE UN CLIENTE");
        tarifa.setBorder(introDatos);
        tarifas.setLayout(new GridLayout(4,0));

        jBasica=new JRadioButton("Básica, todos los días 15c/min");
        jTardes=new JRadioButton("Tarifa Tardes, todos los días 5c/min");
        jDomingos=new JRadioButton("Domingos, todos los domingos 0/min");

        tarifas.add(jBasica);
        tarifas.add(jTardes);
        tarifas.add(jDomingos);

        jBasica.setSelected(true);
        jBasica.setEnabled(false);




        // Botón añadir cliente
        JPanel anyadeyborra= new JPanel();
        TitledBorder añadirYBorrar = new TitledBorder("SELECCIÓN TARIFAS DE UN CLIENTE");
        añadirYBorrar.setBorder(añadirYBorrar);

        JButton añadir= new JButton("Añadir");
        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre=jNombre.getText();
                apellidos=jApellidos.getText();
                DNI=jDNI.getText();
                provincia=jProvincia.getText();
                poblacion=jPoblacion.getText();
                cp=Integer.parseInt(jcp.getText());

                if(jParticular.isSelected()){
                    try {
                        controlador.añadirParticular(nombre,apellidos,DNI,new Direccion(provincia,poblacion,cp), LocalDateTime.now());
                    } catch (DniNotValidException e1) {
                        e1.printStackTrace();
                    }

                } else if(jEmpresa.isSelected()){
                    try {
                        controlador.añadirEmpresa(nombre,DNI,new Direccion(provincia,poblacion,cp), LocalDateTime.now());
                    } catch (DniNotValidException e1) {
                        e1.printStackTrace();
                    }
                }
                borrarDatos();
            }
        });

        // Botón borrar cliente

        JButton borrar = new JButton("Borrar");
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(DNI.equals("")){
                    try {
                        throw new DNInoSelectedException();
                    } catch (DNInoSelectedException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        controlador.borrarCliente(DNI);
                    } catch (DniNoExixstException e) {
                        e.printStackTrace();
                    }
                }
                borrarDatos();
            }
        });

        anyadeyborra.add(añadir);
        anyadeyborra.add(borrar);

        // Listas de clientes y datos de clientes
        JPanel listarYRecuperar = new JPanel();
        JButton recuperadatos=new JButton("RECUPERAR DATOS DE CLIENTE");
        recuperadatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    controlador.recuperaCliente(DNI);
                } catch (DniNoExixstException e) {
                    e.printStackTrace();
                }
                JFrame ventanaRecuperar = new JFrame("Recuperar datos");
                ventanaRecuperar.getContentPane().add(new JLabel(datosCliente));
                borrarDatos();
            }
        });
        JButton listarClientes= new JButton("LISTAR TODOS LOS CLIENTES");
        listarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    controlador.listarClientes();
                } catch (DniNoExixstException e) {
                    e.printStackTrace();
                }
                JFrame ventanaLista = new JFrame("Lista clientes");
                JList listaDNIS = new JList(dnis);
                ventanaLista.getContentPane().add(listaDNIS);
                ventanaLista.pack();
                ventanaLista.setVisible(true);
            }
        });

        listarYRecuperar.add(recuperadatos);
        listarYRecuperar.add(listarClientes);

        // Listar por fecha

        JPanel listarPorFecha = new JPanel();
        TitledBorder listaPorFecha = new TitledBorder("LISTA POR FECHA");
        listaPorFecha.setBorder(listaPorFecha);
        listarPorFecha.setLayout(new GridLayout(8,0));


        listarPorFecha.add(new JLabel("Dia inicio (dd):"));
        listarPorFecha.add(jDiaInicio = new JTextField(2));
        listarPorFecha.add(new JLabel("Mes Inicio (mm):"));
        listarPorFecha.add(jMesInicio = new JTextField(2));
        listarPorFecha.add(new JLabel("Año inicio (yyyy):"));
        listarPorFecha.add(jAnyoInicio = new JTextField(4));


        listarPorFecha.add(new JLabel("Dia Fin (dd) :"));
        listarPorFecha.add(jDiaFin = new JTextField(2));
        listarPorFecha.add(new JLabel("Mes Fin (mm):"));
        listarPorFecha.add(jMesFin = new JTextField(2));
        listarPorFecha.add(new JLabel("Año Fin (yyyy):"));
        listarPorFecha.add(jAnyoFin = new JTextField(4));


        JButton listar=new JButton("LISTAR ENTRE ESTAS FECHAS");
        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                diaInicio=jDiaInicio.getText();
                mesInicio=jMesInicio.getText();
                anyoInicio=jAnyoInicio.getText();
                diaFin=jDiaFin.getText();
                mesFin=jMesFin.getText();
                anyoFin=jAnyoFin.getText();

                String fechaInicio= anyoInicio+"-"+mesInicio+"-"+diaInicio+ " 00:00";
                String fechaFin= anyoFin+"-"+mesFin+"-"+diaFin+ " 00:00";

                DateTimeFormatter formatterInicio = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime inicio = LocalDateTime.parse(fechaInicio,formatterInicio);

                DateTimeFormatter formatterFin = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime fin = LocalDateTime.parse(fechaFin, formatterFin);

                controlador.listaEntreFechas(inicio,fin);
                JFrame ventanaEntreFechas = new JFrame("Lista Entre Fechas");

                JList listaFechas = new JList(listaLlamadasEntreFechas);
                ventanaEntreFechas.getContentPane().add(listaFechas);
//            ventanaEntreFechas.pack();
                ventanaEntreFechas.setVisible(true);
                borrarDatos();
            }
        });
        listarPorFecha.add(listar);

        // Menú Facturas

        // Emitir Factura

        Container contenedorMenuFacturas = new Container();
        contenedorMenuFacturas.setLayout(new BoxLayout(contenedorMenuFacturas,BoxLayout.Y_AXIS));


        JPanel emitirFactura=new JPanel();
        TitledBorder tEmiteFactura = new TitledBorder("EMITIR FACTURA");
        emitirFactura.setBorder(tEmiteFactura);

        emitirFactura.add(new JLabel(" Cliente cuya factura va a ser emitida (DNI/NIF/CIF): "));
        emitirFactura.add(jDNIFac = new JTextField(9));

        JButton emitir= new JButton("EMITIR");
        emitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DNIFac=jDNIFac.getText();
                controlador.añadirFactura(DNIFac);
                borrarDatosFactura();
            }
        });
        emitirFactura.add(emitir);

        // Recuperar datos de una factura a partir de su codigo

        JPanel recuperarFactura=new JPanel();
        TitledBorder tRecuperarFactura = new TitledBorder("RECUPERAR FACTURA");
        recuperarFactura.setBorder(tRecuperarFactura);

        recuperarFactura.add(new JLabel("Introduce el código de la factura: "));
        recuperarFactura.add(jCodigo = new JTextField(10));

        JButton recuperar = new JButton("Recuperar");
        recuperar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                codigo=Integer.parseInt(jCodigo.getText());
                controlador.recuperaFactura(codigo);

                JFrame ventanaFacturaRecuperada = new JFrame("Factura Recuperada");
                JList listaFacturaRecuperada = new JList(facturaRecuperada);
                ventanaFacturaRecuperada.getContentPane().add(listaFacturaRecuperada);
                ventanaFacturaRecuperada.pack();
                ventanaFacturaRecuperada.setVisible(true);
                borrarDatosFactura();
            }
        });
        recuperarFactura.add(recuperar);


        // Recuperar todas las facturas de un cliente

        JPanel recuperarTFac=new JPanel();
        TitledBorder tRecTFacturas = new TitledBorder("RECUPERAR TODAS LAS FACTURAS DE UN CLIENTE");
        recuperarTFac.setBorder(tRecTFacturas);

        recuperarTFac.add(new JLabel(" Introduce DNI/NIF/CIF de cliente: "));
        recuperarTFac.add(jCliente=new JTextField(9));

        JButton recuperaFacturas=new JButton("RECUPERA TODAS LAS FACTURAS");
        recuperaFacturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DNICliente=jCliente.getText();
                controlador.recuperaFacturas(DNICliente);

                JFrame ventanaFacturas = new JFrame("Facturas de Cliente");
                JList listaFacturas = new JList(facturas);
                ventanaFacturas.getContentPane().add(listaFacturas);
                ventanaFacturas.pack();
                ventanaFacturas.setVisible(true);
                borrarDatosFactura();
            }
        });
        recuperarTFac.add(recuperaFacturas);

        // Listar Facturas Por Fecha

        JPanel listarFacturasEntreFechas = new JPanel();
        TitledBorder tFacturasEntreFechas = new TitledBorder("LISTAR FACTURAS ENTRE DOS FECHAS");
        listarFacturasEntreFechas.setBorder(tFacturasEntreFechas);

        listarFacturasEntreFechas.add(new JLabel("Dia inicio (dd):"));
        listarFacturasEntreFechas.add(jDiaInicioF = new JTextField(2));
        listarFacturasEntreFechas.add(new JLabel("Mes Inicio (mm):"));
        listarFacturasEntreFechas.add(jMesInicioF = new JTextField(2));
        listarFacturasEntreFechas.add(new JLabel("Año inicio (yyyy):"));
        listarFacturasEntreFechas.add(jAnyoInicioF = new JTextField(4));


        listarFacturasEntreFechas.add(new JLabel("Dia Fin (dd) :"));
        listarFacturasEntreFechas.add(jDiaFinF = new JTextField(2));
        listarFacturasEntreFechas.add(new JLabel("Mes Fin (mm):"));
        listarFacturasEntreFechas.add(jMesFinF = new JTextField(2));
        listarFacturasEntreFechas.add(new JLabel("Año Fin (yyyy):"));
        listarFacturasEntreFechas.add(jAnyoFinF = new JTextField(4));

        JButton listaFacFechas= new JButton("LISTAR ENTRE FECHAS");
        listaFacFechas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                diaInicioF=jDiaInicioF.getToolTipText();
                diaFinF=jDiaFinF.getText();
                mesInicioF=jMesInicioF.getText();
                mesFinF= jMesFinF.getText();
                anyoInicioF=jAnyoInicioF.getText();
                anyoFinF=jAnyoFinF.getText();

                String fechaInicio= anyoInicioF+"-"+mesInicioF+"-"+diaInicioF+" 00:00";
                String fechaFin= anyoFinF+"-"+mesFinF+"-"+diaFinF+" 00:00";

                DateTimeFormatter formatterInicio = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime inicio = LocalDateTime.parse(fechaInicio, formatterInicio);

                DateTimeFormatter formatterFin = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime fin = LocalDateTime.parse(fechaFin, formatterFin);

                controlador.listaFacturasEntreFechas(inicio,fin);

                JFrame ventanaFacturasEntreFechas = new JFrame("Lista Entre Fechas");
                JList listaFechas = new JList(facturasEntreFechas);
                ventanaFacturasEntreFechas.getContentPane().add(listaFechas);
                ventanaFacturasEntreFechas.pack();
                ventanaFacturasEntreFechas.setVisible(true);
                borrarDatosFactura();


            }
        });
        listarFacturasEntreFechas.add(listaFacFechas);


        // Menú Llamadas

        Container contenedorMenuLlamadas = new Container();
        contenedorMenuLlamadas.setLayout(new BoxLayout(contenedorMenuLlamadas,BoxLayout.Y_AXIS));

        // Almacenar Llamada

        JPanel datosLlamada = new JPanel();
        TitledBorder tDatosLlamada = new TitledBorder("ALMACENAR LLAMADA");
        datosLlamada.setBorder(tDatosLlamada);



        datosLlamada.add(new JLabel(" Origen de la llamada (DNI/NIF/CIF) :"));
        datosLlamada.add(jDNILlam = new JTextField(9));
        datosLlamada.add(new JLabel(" Destino de la llamada (teléfono) :"));
        datosLlamada.add(jTelefonoDestino = new JTextField(9));
        datosLlamada.add(new JLabel(" Duración de la llamada :"));
        datosLlamada.add(jDuracion = new JTextField(8));


        JButton almacenar= new JButton("ALMACENAR");
        almacenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DNILlam = jDNILlam.getText();
                telefonoDestino=Integer.parseInt(jTelefonoDestino.getText());
                duracion=Double.parseDouble(jDuracion.getText());

                try {
                    controlador.addLlamada(DNILlam,telefonoDestino,duracion);
                } catch (PhoneNoValidException e) {
                    e.printStackTrace();
                }
                borrarDatosLlamada();
            }
        });
        datosLlamada.add(almacenar);


        // Botón listar todas las llamadas de un cliente

        JPanel listaTDeCliente= new JPanel();
        TitledBorder tLlamadasDeCliente = new TitledBorder(" LISTAR TODAS LAS LLAMADAS DE UN CLIENTE ");
        listaTDeCliente.setBorder(tLlamadasDeCliente);

        listaTDeCliente.add(new JLabel(" Introducir cliente (DNI/NIF/CIF) :"));
        listaTDeCliente.add(jDNITLlam = new JTextField(9));

        JButton listarLlamadasCliente = new JButton(" LISTA TODAS LAS LLAMADAS DE UN CLIENTE ");
        listarLlamadasCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DNITLlam=jDNITLlam.getText();

                controlador.getLlamadas(DNITLlam);

                JFrame ventanaLlamadas = new JFrame("Lista Llamadas");
                JList listaFechas = new JList(listaEntreFechas);
                ventanaLlamadas.getContentPane().add(listaFechas);
                ventanaLlamadas.pack();
                ventanaLlamadas.setVisible(true);
                borrarDatosLlamada();
            }
        });
        listaTDeCliente.add(listarLlamadasCliente);


        // Listar Llamadas entre fechas

        JPanel listarLlamadasPorFecha = new JPanel();
        TitledBorder listaLlamadasPorFecha = new TitledBorder("LISTA LLAMADAS POR FECHA");
        listarLlamadasPorFecha.setBorder(listaLlamadasPorFecha);
        listarLlamadasPorFecha.setLayout(new GridLayout(8,0));


        listarLlamadasPorFecha.add(new JLabel("Dia inicio (dd):"));
        listarLlamadasPorFecha.add(jDiaInicioLL = new JTextField(2));
        listarLlamadasPorFecha.add(new JLabel("Mes Inicio (mm):"));
        listarLlamadasPorFecha.add(jMesInicioLL = new JTextField(2));
        listarLlamadasPorFecha.add(new JLabel("Año inicio (yyyy):"));
        listarLlamadasPorFecha.add(jAnyoInicioLL = new JTextField(4));


        listarLlamadasPorFecha.add(new JLabel("Dia Fin (dd) :"));
        listarLlamadasPorFecha.add(jDiaFinLL = new JTextField(2));
        listarLlamadasPorFecha.add(new JLabel("Mes Fin (mm):"));
        listarLlamadasPorFecha.add(jMesFinLL = new JTextField(2));
        listarLlamadasPorFecha.add(new JLabel("Año Fin (yyyy):"));
        listarLlamadasPorFecha.add(jAnyoFinLL = new JTextField(4));


        JButton listarLL=new JButton("LISTAR ENTRE ESTAS FECHAS");
        listarLL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                diaInicioLL=jDiaInicioLL.getText();
                mesInicioLL=jMesInicioLL.getText();
                anyoInicioLL=jAnyoInicioLL.getText();
                diaFinLL=jDiaFinLL.getText();
                mesFinLL=jMesFinLL.getText();
                anyoFinLL=jAnyoFinLL.getText();

                String fechaInicio= anyoInicioLL+"-"+mesInicioLL+"-"+diaInicioLL+" 00:00";
                String fechaFin= anyoFinLL+"-"+mesFinLL+"-"+diaFinLL+ " 00:00";

                DateTimeFormatter formatterInicio = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime inicio = LocalDateTime.parse(fechaInicio, formatterInicio);

                DateTimeFormatter formatterFin = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime fin = LocalDateTime.parse(fechaFin, formatterFin);

                controlador.listaLlamadasEntreFechas(inicio,fin);
                JFrame ventanaLlamadasEntreFechas = new JFrame("Lista Entre Fechas");
                JList listaFechas = new JList(listaLlamadasEntreFechas);
                ventanaLlamadasEntreFechas.getContentPane().add(listaFechas);
                ventanaLlamadasEntreFechas.pack();
                ventanaLlamadasEntreFechas.setVisible(true);
                borrarDatosLlamada();
            }
        });
        listarLlamadasPorFecha.add(listarLL);



        pestañas.add("MENÚ CLIENTES", contenedorMenuClientes);
        contenedorMenuClientes.add(tipoCliente);
        contenedorMenuClientes.add(introducirDatos);
        contenedorMenuClientes.add(tarifas);
        contenedorMenuClientes.add(anyadeyborra);
        contenedorMenuClientes.add(listarYRecuperar);
        contenedorMenuClientes.add(listarPorFecha);

        pestañas.add("MENÚ LLAMADAS", contenedorMenuLlamadas);
        contenedorMenuLlamadas.add(datosLlamada);
        contenedorMenuLlamadas.add(listaTDeCliente);
        contenedorMenuLlamadas.add(listarLlamadasPorFecha);

        pestañas.add("MENÚ FACTURAS", contenedorMenuFacturas);
        contenedorMenuFacturas.add(emitirFactura);
        contenedorMenuFacturas.add(recuperarFactura);
        contenedorMenuFacturas.add(recuperarTFac);
        contenedorMenuFacturas.add(listarFacturasEntreFechas);


        Container contenedorMenuGuardar = new Container();
        contenedorMenuGuardar.setLayout(new BoxLayout(contenedorMenuGuardar,BoxLayout.Y_AXIS));

        JPanel guardar=new JPanel();
        TitledBorder tGuardar = new TitledBorder("GUARDAR DATOS");
        guardar.setBorder(tGuardar);
        JButton guardarr = new JButton("GUARDAR DATOS");
        guardarr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controlador.guarda();
            }
        });
        guardar.add(guardarr);


        JPanel cargar=new JPanel();
        TitledBorder tCargar = new TitledBorder("CARGAR DATOS");
        cargar.setBorder(tCargar);
        JButton cargarr = new JButton("CARGAR DATOS");
        cargarr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    controlador.carga();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        cargar.add(cargarr);


        pestañas.add("GUARDAR DATOS",contenedorMenuGuardar);
        contenedorMenuGuardar.add(cargar);
        contenedorMenuGuardar.add(guardar);

        ventana.add(pestañas);

    }

    private void borrarDatosFactura() {
        jCodigo.setText("");
        jDNIFac.setText("");
        jAnyoFinF.setText("");
        jAnyoInicioF.setText("");
        jMesFinF.setText("");
        jMesInicioF.setText("");
        jDiaInicioF.setText("");
        jDiaFinF.setText("");

    }

    private void borrarDatosLlamada() {
        jDNILlam.setText("");
        jDuracion.setText("");
        jTelefonoDestino.setText("");
        jDNITLlam.setText("");
        jAnyoFinLL.setText("");
        jAnyoInicioLL.setText("");
        jMesFinLL.setText("");
        jMesInicioLL.setText("");
        jDiaInicioLL.setText("");
        jDiaFinLL.setText("");
    }

    private void borrarDatos() {
        jParticular.setSelected(true);
        jTardes.setSelected(false);
        jDomingos.setSelected(false);
        jcp.setText("");
        jNombre.setText("");
        jApellidos.setText("");
        jApellidos.setEnabled(true);
        jPoblacion.setText("");
        jProvincia.setText("");
        jDNI.setText("");
        jMesInicio.setText("");
        jMesFin.setText("");
        jDiaInicio.setText("");
        jDiaFin.setText("");
        jAnyoFin.setText("");
        jAnyoInicio.setText("");
    }



    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI();
            }
        });
    }

    public TipoTarifa getTipoTarifa(){
        if(jDomingos.isSelected()) return TipoTarifa.DOMINGOS;
        else if(jTardes.isSelected()) return TipoTarifa.TARDES;
        else return TipoTarifa.BASICA;
    }

    @Override
    public void setDatosdeCliente(String s) {
        datosCliente=s;
    }

    @Override
    public void setListaDNI(String[] listaDNI) {
        dnis=listaDNI;
    }

    @Override
    public void setListaEntreFechas(String[] listaDNI) {
        listaEntreFechas=listaDNI;
    }

    @Override
    public void setLlamadas(String[] listaL) {
        listaLlamadas=listaL;
    }

    @Override
    public void setLlamadasEntreFechas(String[] listaLlamadasEntreF) {
        listaLlamadasEntreFechas=listaLlamadasEntreF;
    }

    @Override
    public void setFacturaRecuperada(String s) {
        facturaRecuperada[0]=s;
    }

    @Override
    public void setFacturas(String[] listaFacturas) {
        facturas=listaFacturas;
    }

    @Override
    public void setFacturasEntreFechas(String[] listaFacturasEntreF) {
        facturasEntreFechas=listaFacturasEntreF;
    }
}
