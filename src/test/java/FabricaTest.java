import Excepciones.*;
import java.time.LocalDateTime;

import Interfaces.Fabrica;
import Interfaces.FabricaTar;
import org.junit.Test;
import main.*;
import main.tarifa.*;
import static junit.framework.TestCase.assertEquals;
import java.util.LinkedList;
public class FabricaTest {
    @Test
    public void fabricaClientesTest() throws  DniNotValidException {
        Fabrica fabrica = new FabricaCliente();
        Cliente cliente=fabrica.getNuevaEmpresa("Pamesa",new Basica(),new Direccion("Castellon","Castellon",12000),"20202020T",LocalDateTime.now());
        assertEquals(true,cliente.isEmpresa());

        cliente=fabrica.getNuevoParticular("Josep",new Basica(),new Direccion("Castellón","Alcora",12110),"Guardiola","53785377S",LocalDateTime.now());
        assertEquals(false,cliente.isEmpresa());

    }

    @Test
    public void listaconFabricaTest() throws  DniNotValidException {
        FabricaTar fabrica = new FabricaTarifas();
        Fabrica fabricacli = new FabricaCliente();
        LinkedList<Cliente> listaClientes = new LinkedList<Cliente>();


        listaClientes.add(fabricacli.getNuevoParticular("Josep",new Basica(),new Direccion("Castellón","Alcora",12110),"Guardiola","53785377S",LocalDateTime.now()));
        assertEquals(listaClientes.size(),1);
    }


}
