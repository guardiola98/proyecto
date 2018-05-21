package main.tarifa;

import Interfaces.FabricaTar;

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
