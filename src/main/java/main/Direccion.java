package main;

public class Direccion {
    private String provincia;
    private String poblacion;
    private int codpostal;
    public Direccion() {
        provincia = "";
        poblacion = "";
        codpostal = 0;
    }

    public Direccion(String prov,String  pobl, int cod) {
        provincia = prov;
        poblacion = pobl;
        codpostal = cod;
    }
    public String getProvincia(){
        return provincia;
    }
    public String getPoblacion(){
        return poblacion;
    }
    public int getCodPostal(){
        return codpostal;
    }
}
