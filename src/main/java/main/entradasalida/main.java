package main.entradasalida;

import java.io.Serializable;
import Excepciones.*;
import main.Compania;
import java.io.IOException;
import java.util.Scanner;
public class main implements Serializable {
    public static void main(String[] args) throws DniNoExixstException, DniNotValidException, OptionNoValidExcepction,
            PhoneNoValidException, IOException, ClassNotFoundException {
        Menu nuevo= new Menu();
        nuevo.showMenu();
        Scanner entrada=new Scanner(System.in);
        System.out.println("Deseas realizar alguna otra opción?s/n");
        String fin=entrada.nextLine();
        if(fin.equals("s")){
            nuevo = new Menu(Compania.getClientes());
            nuevo.showMenu();
        }
        else{
            System.out.println("Quiere guardar los datos de la aplicación en un fichero?s/n");
            String guardar=entrada.nextLine();
            if(guardar.equals("s")){
                nuevo.guardarDatos();
                System.out.println("Se han guardado los datos de la aplicación en el fichero agenda.bin. Gracias y que pase un buen día.");
            }else {
                System.out.println("No se han guardado los datos de la aplicación en ningún fichero. Gracias y que pase un buen día.");
            }
        }

    }
}
