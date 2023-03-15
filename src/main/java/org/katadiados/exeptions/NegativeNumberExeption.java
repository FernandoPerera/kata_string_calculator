package org.katadiados.exeptions;

public class NegativeNumberExeption extends Exception{

    /*
    *   Creo la clase que extiende de 'Exception' y el constructor recibe
    *   el mensaje de error que se desea mostrar
    */

    public NegativeNumberExeption(String message){
        super(message);
    }

}
