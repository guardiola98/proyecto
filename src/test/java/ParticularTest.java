import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


public class ParticularTest {
    @Test
    public void setApellidosTest(){
        Tarifa tar= new Tarifa(4);
        Direccion dir=new Direccion("Castellón","Alcora", 12110);
        Particular p= new Particular("Josep",tar,dir,"53785377S");
        p.setApellidos("Guardiola Guillamon");

        assertEquals(p.getApellidos(),"Guardiola Guillamon");

	Tarifa tar2= new Tarifa(5);
        Direccion dir2=new Direccion("Castellón","Alcora", 12110);
        Particular p2= new Particular("Javier",tar2,dir2,"20909927Y");
        p2.setApellidos("Gasch Ruiz");

        assertEquals(p2.getApellidos(),"Gasch Ruiz");

    }
	@Test
    public void isEmpresaTest(){
        Tarifa tar= new Tarifa(4);
        Direccion dir=new Direccion("Castellón","Almazora", 12550);
        Particular e = new Particular("Juan",tar,dir,"20922");
       

        assertEquals(e.isEmpresa(),false);
    }
}
