import main.tarifa.Basica;
import main.tarifa.Domingos;
import main.tarifa.Tardes;
import main.tarifa.Tarifa;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static junit.framework.TestCase.assertEquals;
public class DecoradorTest {
    @Test
    public void testBasico() {
        Tarifa tarifa = new Basica();
        assertEquals(15.0, tarifa.getPrecio());
    }
    @Test
    public void DomingosTest(){
        Tarifa tarifa = new Basica();
        assertEquals(15.0, tarifa.getPrecio());
        tarifa= new Domingos(tarifa);
        assertEquals(0.0,tarifa.getPrecio());

    }
    @Test
    public void TardesTest(){
        Tarifa tarifa = new Basica();
        assertEquals(15.0, tarifa.getPrecio());
        tarifa= new Tardes(tarifa);
        assertEquals(5.0,tarifa.getPrecio());
    }
}
