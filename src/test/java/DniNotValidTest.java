import Excepciones.DniNotValidException;
import main.Cliente;
import main.Direccion;
import main.Particular;
import main.tarifa.Basica;
import main.tarifa.Tarifa;
import org.junit.Test;
public class DniNotValidTest {
    @Test(expected = DniNotValidException.class)
    public void DNINoValidTest() throws DniNotValidException {
        Cliente aux= new Particular("JOSEP",new Basica(),new Direccion("Castellón","Alcora",12110),"53785377");
    }
}
