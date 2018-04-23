package main.tarifa;

public enum TipoTarifa {
    BASICA("Tarifa básica"),
    DOMINGOS("Tarifa domingos"),
    TARDES("Tarifa tardes");

    private String descripcion;

    TipoTarifa(String descripcion) {
        this.descripcion=descripcion;
    }

    public static String opciones(){
        StringBuilder sb = new StringBuilder();
        for(TipoTarifa tipo: values()){
            sb.append(tipo.ordinal() + ".- " + tipo.descripcion + "\n");
        }
        return sb.toString();
    }

    public static TipoTarifa enteroATipo(int posicion){
        return values()[posicion];
    }
}
