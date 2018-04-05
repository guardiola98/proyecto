package main;

public class Particular extends Cliente{
    private String apellidos;
    public Particular(String nombre, Tarifa tarifa, Direccion direccion,String apellidos, String nif) {
        super(nombre, tarifa, direccion,nif);
        this.apellidos=apellidos;
    }
    public Particular(String nombre, Tarifa tarifa, Direccion direccion, String nif) {
        super(nombre, tarifa, direccion,nif);
    }
    public void setApellidos(String ap){
        apellidos=ap;
    }
    public String getApellidos(){
        return apellidos;
    }
    public boolean isEmpresa(){
        return false;
    }
}
