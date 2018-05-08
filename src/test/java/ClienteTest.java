import Excepciones.*;
import org.junit.Test;
import main.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import main.tarifa.*;

import static org.junit.Assert.assertEquals;


public class ClienteTest {

    @Test
    public void setLlamadaTest() throws DniNotValidException,  PhoneNoValidException {
        Tarifa tar= new Basica();
        Direccion dir=new Direccion("Castellón","Alcora", 12550);
        Cliente c= new Particular("Josep",tar,dir,"Guardiola","53785377S");
        c.setLlamada(677015090, LocalDateTime.now(),10.5);

        assertEquals(c.getLlamadas().size(),1);

    }
    @Test
    public void añadirFacturaTest() throws DniNotValidException, PhoneNoValidException{
        Tarifa tar= new Basica();
        Direccion dir=new Direccion("Castellón","Alcora", 12550);
        Cliente c= new Particular("Josep",tar,dir,"Guaridola","53785377S");
        c.setLlamada(677015090, LocalDateTime.now(),10.5);
        c.anadirFactura(1,LocalDateTime.now());

        assertEquals(c.getFacturas().get(0).getCodigo(),1);
    }
    @Test
    public void añadirClienteTest() throws DniNotValidException,  PhoneNoValidException{
        Tarifa tar= new Basica();
        Direccion dir=new Direccion("Castellón","Alcora", 12550);
        Cliente c= new Particular("Josep",tar,dir,"Guardiola","53785377S");
        LinkedList<Cliente> listaClientes= new LinkedList<Cliente>();
        if(listaClientes.isEmpty())    listaClientes.add(c);
        assertEquals(1,listaClientes.size());
    }

}