import Excepciones.*;
import org.junit.Test;
import main.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import main.tarifa.*;

import static org.junit.Assert.assertEquals;


public class ClienteTest {

    @Test
    public void anadirClienteTest() throws DniNotValidException{
        Tarifa tar= new Basica();
        Direccion dir=new Direccion("Castellón","Alcora", 12110);
        Cliente c= new Cliente("Josep",tar,dir,"53785377S");
        LinkedList<Cliente> listaClientes= new LinkedList<>();
        if(listaClientes.isEmpty())    listaClientes.add(c);
        assertEquals(1,listaClientes.size());
    }

}