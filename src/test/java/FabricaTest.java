import Excepciones.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import main.*;
import main.tarifa.*;
import static junit.framework.TestCase.assertEquals;
public class FabricaTest {
    @Test
    public void fabricaClientesTest() throws  DniNotValidException {
        Fabrica fabrica = new FabricaCliente();
        Cliente cliente=fabrica.getNuevaEmpresa("Pamesa",new Basica(),new Direccion("Castellon","Castellon",12000),"20202020T");
        assertEquals(true,cliente.isEmpresa());


        cliente=fabrica.getNuevoParticular("Josep",new Basica(),new Direccion("Castellón","Alcora",12110),"Guardiola","53785377S");
        assertEquals(false,cliente.isEmpresa());

    }


}
