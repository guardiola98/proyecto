import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


public class ClienteTest {
    @Test
    public void setLlamadaTest(){
        Tarifa tar= new Tarifa(4);
        Direccion dir=new Direccion("Castellón","Almazora", 12550);
        Cliente c= new Cliente("Jose",tar,dir,"20922218S");
        c.setLlamada(677015090, LocalDateTime.now(),10.5);

        assertEquals(10.5,c.getLlamadas().get(0).getDuracion(),0);

    }
    @Test
    public void añadirFacturaTest(){
        Tarifa tar= new Tarifa(4);
        Direccion dir=new Direccion("Castellón","Almazora", 12550);
        Cliente c= new Cliente("Jose",tar,dir,"20922218S");
        c.setLlamada(677015090, LocalDateTime.now(),10.5);
        c.añadirFactura(1,LocalDateTime.now());

        assertEquals(c.getFacturas().get(0).getCodigo(),1);
    }

}
