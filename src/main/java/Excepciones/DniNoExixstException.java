package Excepciones;

public class DniNoExixstException extends Exception {
    public DniNoExixstException(){
        super("Este DNI no existe en la lista");
    }
}
