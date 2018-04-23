import Excepciones.DniNotValidException;
import main.Cliente;
import main.Direccion;
import main.tarifa.Basica;
import main.tarifa.Tarifa;
import org.junit.Test;
public class DniNotValidTest {
    @Test(expected = DniNotValidException.class)
    public void DNINoValidTest() throws DniNotValidException {
        Cliente aux= new Cliente("JOSE",new Basica(),new Direccion("Castellón","Almazora",12550),"20922218");
    }
}
