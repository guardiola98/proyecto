import Excepciones.*;
import org.junit.Test;
import static org.junit.Assert.*;
import main.*;
import main.tarifa.*;
import main.entradasalida.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

public class GenericidadTest {
    @Test
    public void GenericidadClienteTest() throws DniNotValidException  {
        LinkedList<Cliente> listaClientes=new LinkedList<Cliente>();
        Cliente jose=new Particular("Josep", new Basica(),new Direccion("Castellón","Alcora",12550),"Guillamon","53785377S",LocalDateTime.now());
        String fechaJose="2001-12-31 23:59";
        DateTimeFormatter formatterJose = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fechaAltaJose = LocalDateTime.parse(fechaJose, formatterJose);
        jose.setFechaAlta(fechaAltaJose);
        listaClientes.add(jose);

        Cliente javi=new Particular("Javier", new Basica(),new Direccion("Castellón","Alcora",12110),"Gasch","20901800Y",LocalDateTime.now());
        String fechaDani="2016-12-31 23:59";
        DateTimeFormatter formatterDani = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fechaAltaDani = LocalDateTime.parse(fechaDani, formatterDani);
        javi.setFechaAlta(fechaAltaDani);
        listaClientes.add(javi);

        String fecha3="2010-12-31 23:59";
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime inicio = LocalDateTime.parse(fecha3, formatter3);

        String fecha4="2017-12-31 23:59";
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fin = LocalDateTime.parse(fecha4, formatter4);

        LinkedList<Cliente> enFranja = new LinkedList<>();
        enFranja.add(javi);


        /*assertEquals(1,Menu.listaEntreFechas(listaClientes,inicio,fin).size());*/

        assertTrue(Menu.listaContenedora(listaClientes,inicio,fin).containsAll(enFranja));
    }
    @Test
    public void GenericidadLlamadasTest() throws DniNotValidException,  PhoneNoValidException {
        LinkedList<Llamada> listaLlamada=new LinkedList<Llamada>();
        String fechaJose="2001-12-31 23:59";
        DateTimeFormatter formatterJose = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime llamadaJose = LocalDateTime.parse(fechaJose, formatterJose);
        Llamada jose=new Llamada(new Basica(),677015090,llamadaJose,10.2);
        listaLlamada.add(jose);

        String fechaDani="2016-12-31 23:59";
        DateTimeFormatter formatterDani = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime llamadaDani = LocalDateTime.parse(fechaDani, formatterDani);
        Llamada dani=new Llamada(new Basica(),678288366,llamadaDani,10.2);
        listaLlamada.add(dani);

        String fecha3="2010-12-31 23:59";
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime inicio = LocalDateTime.parse(fecha3, formatter3);

        String fecha4="2017-12-31 23:59";
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fin = LocalDateTime.parse(fecha4, formatter4);



        assertEquals(1,Menu.listaContenedora(listaLlamada,inicio,fin).size());

    }
    @Test
    public void GenericidadFacturasTest() throws DniNotValidException,  PhoneNoValidException {
        LinkedList<Factura> listaFacturas=new LinkedList<Factura>();
        String fechaJose="2001-12-31 23:59";
        DateTimeFormatter formatterJose = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime facturaJose = LocalDateTime.parse(fechaJose, formatterJose);
        Factura jose=new Factura(50,1,facturaJose,10);
        listaFacturas.add(jose);

        String fechaDani="2016-12-31 23:59";
        DateTimeFormatter formatterDani = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime facturaDani = LocalDateTime.parse(fechaDani, formatterDani);
        Factura dani=new Factura(50,2,facturaDani,10);
        listaFacturas.add(dani);

        String fecha3="2010-12-31 23:59";
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime inicio = LocalDateTime.parse(fecha3, formatter3);

        String fecha4="2017-12-31 23:59";
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fin = LocalDateTime.parse(fecha4, formatter4);



        assertEquals(1,Menu.listaContenedora(listaFacturas,inicio,fin).size());

    }
}
