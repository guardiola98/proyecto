package Interfaces;
import main.Llamada;
import main.tarifa.TipoTarifa;

import java.util.LinkedList;
public interface IVista {
    TipoTarifa getTipoTarifa();
    void setDatosdeCliente(String s);
    void setListaDNI(String[] listaDNI);
    void setListaEntreFechas(String[] listaDNI);
    void setLlamadas(String[] listaLlamadas);
    void setLlamadasEntreFechas(String[] listaLlamadasEntreFechas);
    void setFacturaRecuperada(String s);
    void setFacturas(String[] listaFacturas);
    void setFacturasEntreFechas(String[] listaFacturasEntreFechas);

}
