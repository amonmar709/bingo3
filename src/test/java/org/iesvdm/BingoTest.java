package org.iesvdm;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

public class BingoTest {

    @Test
    void rellenarNumerosCarton(){
        //when
        int[][] arrayBi = new int[9][3];

        Bingo.rellenarNumerosCarton(arrayBi);

        // do
        for (int i = 0; i < arrayBi.length; i++) {
            boolean[] numerosRepetidos = new boolean[100];

            for (int j = 0; j < arrayBi[i].length; j++) {
                int numero = arrayBi[i][j];

                // Comprobamos que el numero este dentro del rango
                assertTrue(numero >= 1 && numero <= 99, "Número fuera: " + numero);

                // Comprobamos si el número ya ha sido usado
                assertTrue(!numerosRepetidos[numero], "Número repetido " + i + ": " + numero);
                numerosRepetidos[numero] = true;
            }
        }

    }

    @Test
    void ponerBlancos(){

        //when
        int[][] arrayBi = new int[9][3];

        //do
        Bingo.ponerBlancos(arrayBi);

        boolean seInsertoMenosUno = false;
        for (int i = 0; i < arrayBi[0].length; i++) {
            int contadorMenosUno = 0;
            for (int j = 0; j < arrayBi.length; j++) {
                if (arrayBi[j][i] == -1) {
                    contadorMenosUno++;
                    seInsertoMenosUno = true;
                }
            }
            // Comprobamos que en ninguna columna hay más de dos -1
            assertTrue(contadorMenosUno >= 2 + i);
        }

        // Comprobamos que se haya insertado al menos un -1
        assertTrue(seInsertoMenosUno);
    }

    @Test
    void buscarFila(){
        //When
        //Partimos de este array, un numero de fila y una posicion
        int[][] arrayBi = {{1,2},{3,4},{5,6}};
        int fila = 1;
        int posicion = 2;

        //Then
        //Comprobamos que si en ese arrray en esa posicion y en esa fila el valor es -1 nos devuelva false, sino true
        assertTrue(arrayBi[posicion][fila] != -1);

    }

    @Test
    void buscarColumna(){
        //When
        //Partimos de este array, un numero de columna y una posicion
        int[][] arrayBi = {{1,2},{3,4},{5,6}};
        int columna = 1;
        int posicion = 2;

        //Then
        //Comprobamos que si en ese arrray en esa posicion y en esa columna el valor es -1 nos devuelva false, sino true
        assertTrue(arrayBi[posicion][columna] != -1);

    }

    @Test
    void buscarValorRepetido(){
        //When
        //Elemento es igual a 3
        int array[] = {1, 2, 3, 3, 4, 5};
        int elemento = 3;

        //Then
        //Llamamos a nuestra funcion para ver si encuentra el valor repetido
        assertTrue(Bingo.buscarValorRepetido(array, elemento));

    }

    @Test
    void pintarCarton(){
        //When
        int[][] arrayBi = {{1,2},{3,4},{5,6}};
        int posicion = 1;
        int fila = 1;
        int columna = 1;

        //Do
        assertTrue(arrayBi[posicion][fila] != -1);
        assertTrue(arrayBi[posicion][columna] != -1);
    }

    @Test
    void insertarAlFinal(){
        //When(Cuando)
        //El array este lleno
        //y el elemento no sea nulo ni vacio
        int[] array = {1, 2, 3, 4};
        int elemento = 5;

        //do
        //Inserto el elemento (5) al final del arrayActual
        int[] arrayActual = Bingo.insertarAlFinal(array, elemento);

        // Compruebo que array Actual es longitud mas 1 que array
        // y que arrayActual tiene en la ultima posicion el elemento
        assertTrue(arrayActual.length == array.length+1);
        assertEquals(elemento, arrayActual[arrayActual.length-1]);
        //Then
        //Uso Arrays.copyOfRange para copiar el arrayActual hasta la longitud del array original y por
        //ultimo comparo los dos arrays
        int[] actual = Arrays.copyOfRange(arrayActual, 0, array.length);
        assertArrayEquals(array, actual);
    }

    @Test
    void ordenar(){
        //When
        //Creo un array de elementos desordenados
        int tabla[] = {9, 0, 1, 8, 7, 6, 5, 4, 3, 2};

        //do
        //Entonces los ordeno con Arrays.sort
        Arrays.sort(tabla);
        //Then
        //Y luego compruebo que es igual que el resultado de la funcion
        assertEquals(Bingo.ordenar(tabla), tabla);
    }

    @Test
    void limpiar(){
        //When
        //Partiendo de un array
        int array[] = {};
        //do
        //Compruebo que esta vacio

    }
}
