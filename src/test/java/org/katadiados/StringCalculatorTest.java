package org.katadiados;

import org.junit.jupiter.api.Test;
import org.katadiados.exeptions.NegativeNumberExeption;
import org.katadiados.utils.StringCalculator;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    /*
    *   Casos de uso :
    *
    *       - Si la cadena está vacía que devuelva 0.
    *
    *       - Si introduce un número devolver el mismo número.
    *
    *       - Si se introducen más de un número devolver la suma de estos.
    *
    *       - Si se introducen números separados con ',' o '\n' realizar su suma.
    *
    *       - Si se introduce un delimitador devolver la suma de todos lor números
    *         separandolos por el delimitador, ',' y '\n'.
    *
    *       - Si uno de los números introducidos es mayor que 1000 ignorarlo.
    *
    *       - Si se introducen números negativos devolver un throw error.
    */

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    void give_empty_string_return_zero() throws NegativeNumberExeption {

        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void give_one_number_return_the_same_number() throws NegativeNumberExeption {

        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void give_numbers_return_their_sum() throws NegativeNumberExeption {

        assertEquals(12, stringCalculator.add("2,3,6,1"));
    }

    @Test
    void give_numbers_with_coma_and_line_break_return_their_sum() throws NegativeNumberExeption {

        assertEquals(12, stringCalculator.add("2,3\n6\n1,0"));
    }

    @Test
    void give_delimiter_and_numbers_return_their_sum() throws NegativeNumberExeption {

        assertEquals(10, stringCalculator.add("//;\n1;3;6"));
    }

    @Test
    void give_numbers_bigger_than_1000_and_ignore_then_return_sum_of_the_rest_numbers() throws NegativeNumberExeption {

        assertEquals(10, stringCalculator.add("//;\n1002;3;6021,7"));
    }

    //@Test(expected = NegativeNumberExeption.class)
    @Test
    void give_negative_numbers_return_throw_error() throws NegativeNumberExeption {

        String errorResponse = "ERROR : Negatives not allowed : [-10] [-9]";

        NegativeNumberExeption thrown = assertThrows(NegativeNumberExeption.class, () ->
                stringCalculator.add("//|,2000,-10,2|7|-9"));

        assertTrue(thrown.getMessage().contentEquals(errorResponse));
    }

}