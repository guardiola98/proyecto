package Interfaces;
import main.tarifa.Tarifa;
import main.tarifa.TipoTarifa;
public interface FabricaTar {
    Tarifa getNuevaTarifa(TipoTarifa tipo);
}
