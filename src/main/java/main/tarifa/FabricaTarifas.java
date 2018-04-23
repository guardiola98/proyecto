package main.tarifa;

import main.tarifa.FabricaTar;

import java.io.Serializable;
public class FabricaTarifas implements FabricaTar {
    @Override
    public Tarifa getNuevaTarifa(TipoTarifa tipo) {
        Tarifa tarifa= new Basica();
        switch (tipo){
            case TARDES:
                tarifa=new Tardes(tarifa);
                break;
            case DOMINGOS:
                tarifa=new Domingos(tarifa);
                break;
        }
        return tarifa;
    }

}
