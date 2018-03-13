import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


public class EmpresaTest {
    @Test
    public void isEmpresaTest(){
        Tarifa tar= new Tarifa(4);
        Direccion dir=new Direccion("Castellón","Almazora", 12550);
        Empresa e= new Empresa("Neumaticos Almazora",tar,dir,"20922");
       

        assertEquals(e.isEmpresa(),true);
    }
}
