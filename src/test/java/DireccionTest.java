import main.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class DireccionTest {
    @Test
    public void construcorTest()  {
        Direccion alc = new Direccion("Castellon","Alcora", 12110);

        assertEquals("Alcora",alc.getPoblacion());
        assertEquals("Castellon",alc.getProvincia());
        assertEquals(12110,alc.getCodPostal());



    }
}
