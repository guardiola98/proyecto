package main.entradasalida;

import java.io.Serializable;
import Excepciones.*;
import main.controlador.Controlador;
import main.Vista.Vista;
import main.modelo.Modelo;
public class main implements Serializable {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vista.creaGUI();
    }
}
