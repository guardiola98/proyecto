import main.Llamada;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


public class LlamadaTest {
    @Test
    public void constructorTest(){
        int llamado= 677015090;
        Llamada primera=new Llamada(llamado,LocalDateTime.now(),19.8);

       assertEquals(19.8,primera.getDuracion(),0);

	int llamado2= 678288366;
        Llamada primera2=new Llamada(llamado2,LocalDateTime.now(),9.3);

        assertEquals(9.3,primera2.getDuracion(),0);

    }
}
