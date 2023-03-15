package org.katadiados.utils;

import org.katadiados.exeptions.NegativeNumberExeption;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    /*
    *   Creamos un método llamado 'add' que reciba una cadena de texto con
    *   números separados por comas, saltos de línea, o algún delimitador que
    *   venga expresado en la propia cadena.
    *
    *   Debemos devolver la suma de todos estos números.
    */

    public int add( String numbers ) throws NegativeNumberExeption {

        String delimiter = "";

        if ( numbers.equals("") ){
            return 0;
        }

        if (numbers.startsWith("//")){
            delimiter = numbers.substring(2,3);
            numbers = numbers.substring(4);
        }

        List<String> numbersToSum = List.of(numbers.split("[\n," + delimiter + "]"));
        List<String> negativeNumbers = new ArrayList<>();

        addNegativeNumbers(negativeNumbers, numbersToSum);

        if (negativeNumbers.isEmpty()){
            return numbersToSum.stream().filter(number -> Integer.parseInt(number) < 1000).mapToInt(Integer::parseInt).sum();
        } else {
            String message = "ERROR : Negatives not allowed : ";

            for (int index = 0; index < negativeNumbers.size() ; index++) {
                message += "[" + negativeNumbers.get(index) + "] ";
            }

            throw new NegativeNumberExeption(message.trim());
        }
    }

    private void addNegativeNumbers(List<String> negativeNumbers, List<String> numbersList) {

        numbersList.forEach( (number) -> {
            if (Integer.parseInt(number) < 0) {
                negativeNumbers.add(number);
            }
        });

    }

}