import Excepciones.DniNotValidException;
import Excepciones.PhoneNoValidException;
import main.Cliente;
import main.Direccion;
import main.Llamada;
import main.Tarifa;
import java.time.LocalDateTime;
import org.junit.Test;
public class PhoneNoValidTest {
    @Test(expected = PhoneNoValidException.class)
    public void DNINoValidTest() throws PhoneNoValidException {
        Llamada llamada=new Llamada(new Tarifa(),69911069, LocalDateTime.now(),10);
    }
}
