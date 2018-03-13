import java.time.LocalDateTime;
import java.util.LinkedList;


public class Empresa extends Cliente{

    public Empresa(String nombre, Tarifa tarifa, Direccion direccion,String CIF) {
        super(nombre, tarifa, direccion,CIF);
    }

    public boolean isEmpresa(){
        return true;
    }
}
