import Excepciones.PhoneNoValidException;
import main.Llamada;
import main.tarifa.Basica;
import main.tarifa.Tarifa;
import java.time.LocalDateTime;
import org.junit.Test;
public class PhoneNoValidTest {
    @Test(expected = PhoneNoValidException.class)
    public void DNINoValidTest() throws PhoneNoValidException {
        Llamada llamada=new Llamada(new Basica(),69911069, LocalDateTime.now(),10);
    }
}
