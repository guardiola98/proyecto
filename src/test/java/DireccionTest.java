import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DireccionTest {
    @Test
    public void construcorTest() {
        Direccion alma = new Direccion("Castellón","Almazora", 12550);

        assertEquals("Almazora",alma.getPoblacion());
        assertEquals("Castellón",alma.getProvincia());
        assertEquals(12550,alma.getCodPostal());

        Direccion alc=new Direccion("Castellón","Alcora",12110);

        assertEquals("Alcora",alc.getPoblacion());
        assertEquals("Castellón",alc.getProvincia());
        assertEquals(12550,alc.getCodPostal());


    }
}
