package org.iesvdm;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilesArraysTest {

    @Test
    void limpiar(){
        //When
        //Partiendo de un array
        int tabla[] = {9, 0, 1, 8, 7, 6, 5, 4, 3, 2};
        //do
        UtilesArrays.limpiar();
        //Compruebo que esta vacio
        assertThat(tabla.length == 0);
    }

    @Test
    void rellenarConCeros(){
        //When
        int tabla[] = {1,2,3};
        int numeroElementos = 3;
        int posicion = 1;

        //do
        UtilesArrays.rellenar(tabla, numeroElementos);

        //Compueblo que la longitud del array es igual al numero de elementos
        assertThat( tabla.length == numeroElementos);
        //Compruebo que en una posición aleatoria el elemento sea cero
        assertThat(tabla[posicion] == 0);
    }

    @Test
    void rellenar(){
        //When
        int tabla[] = {};
        int numeroElementos = 3;

        //do
        UtilesArrays.rellenar(tabla, numeroElementos);

        //Compueblo que la longitud del array es igual al numero de elementos
        assertThat( tabla.length == numeroElementos);
    }

    @Test
    void insertarAlFinal(){
        //When
        int tabla[] = {1, 2, 3, 4, 5};
        int elemento = 6;

        //do
        UtilesArrays.insertarAlFinal(tabla, elemento);

        //Then
        assertThat(tabla.length-1 == elemento);
    }

    @Test
    void insertarAlPrincipio(){
        //When
        int[] tabla = {2, 3, 4, 5};
        int elemento = 1;

        //do
        UtilesArrays.insertarAlPrincipio(tabla, elemento);

        //Then
        assertThat(tabla[0] == elemento);
    }

    @Test
    void insertarEnPosicion(){
        //When
        int[] tabla = {6, 3, 7, 5};
        int elemento = 2;
        int posicion = 2;

        //do
        UtilesArrays.insertarEnPosicion(tabla, elemento, posicion);

        //Then
        assertThat(tabla[posicion] == elemento);
    }

    @Test
    void insertarOrdenado(){
        //When
        int[] tabla = {1, 3, 4, 5};
        int elemento = 2;
        int posicion = 1;

        //do
        UtilesArrays.insertarOrdenado(tabla, elemento);

        //Then
        assertThat(tabla[posicion] == elemento);

    }

    @Test
    void eliminarUltimo(){
        //When
        int[] tabla = {1, 2, 3, 4, 5};

        //do
        UtilesArrays.eliminarUltimo(tabla);

        //Then
        //Comprobamos que ahora el ultimo elemento es el cuatro
        assertThat(tabla[tabla.length-1] == 4 );
    }


    @Test
    void eliminarPrimero(){
        //When
        int[] tabla = {1, 2, 3, 4, 5};

        //do
        UtilesArrays.eliminarPrimero(tabla);

        //Then
        //Comprobamos que ahora el primer elemento es dos
        assertThat(tabla[0] == 2);
    }

    @Test
    void eliminarPosicion(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6};
        int posicion = 1;

        //do
        UtilesArrays.eliminarPosicion(tabla, posicion);

        //Then
        //Comprobamos que ahora en la posicion 1 hay un 3
        assertThat(tabla[posicion] == 3);
    }

    @Test
    void eliminar(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6};
        int elemento = 6;

        //do
        UtilesArrays.eliminar(tabla, elemento);

        //Then
        //Comprobamos que en la ultima posicion ahora esta el 5
        assertThat(tabla[tabla.length-1] == 5);
    }

    @Test
    void ordenar(){
        //When
        int[] tabla = {6, 4, 5, 3, 2, 1};

        //do
        UtilesArrays.ordenar(tabla);

        //Then
        //Comprobamos que ahora en la primera posicion esta el 1 y en la ultima
        //esta el 6
        assertThat(tabla[0] == 1);
        assertThat(tabla[tabla.length-1] == 6);
    }

    @Test
    void desordenar(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6};

        //do
        UtilesArrays.desordenar(tabla);

        //Then
        //Comprobamos varias posiciones para ver que han cambiado
        assertThat(tabla[0] != 1);
        assertThat(tabla[1] != 2);
        assertThat(tabla[tabla.length-1] != 6);
    }

    @Test
    void invertir(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6};

        //do
        UtilesArrays.invertir(tabla);

        //Then
        //Comprobamos que la primera y la ultima posicion se han cambiado
        assertThat(tabla[0] == 6);
        assertThat(tabla[tabla.length-1] == 1);
    }

    @Test
    void imprimir(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outContent));
        //When
        //declaramos e inicializamos la variable que vamos a imprimir
        int[] tabla= {1, 2, 3, 4, 5, 6};

        //Llamamos a nuestra funcion
        UtilesArrays.imprimir(tabla);
        //Then
        //Comprobamos que el mensaje se muestra
        assertThat("\t" + Arrays.toString(tabla) == outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void buscar(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6};
        int elemento = 3;

        //do
        UtilesArrays.buscar(tabla, elemento);

        //Then
        //Comprobamos que el elemento encontrado al buscar sea el que le hemos pasado
        assertThat(UtilesArrays.buscar(tabla, elemento) == 3);

    }

    @Test
    void partirPor(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int posicionInicio = 1;
        int posicionCorte = 5;

        //do
        UtilesArrays.partirPor(tabla, posicionInicio, posicionCorte);

        //Then
        //Comprobamos que ahora la posicion inicial es 2 y la ultima 4
        assertThat(tabla[0] == 2);
        assertThat(tabla[tabla.length-1] == 4);

    }

    @Test
    void sonIguales(){
        //When
        int[] tabla1 = {1, 2, 3, 4, 5};
        int[] tabla2 = {1, 2, 3, 4, 5};

        //Then
        //Comprobamos que los dos arrays son iguales
        assertThat(UtilesArrays.sonIguales(tabla1, tabla2));
    }

    @Test
    void noSonIguales(){
        //When
        int[] tabla1 = {1, 2, 3, 6, 5};
        int[] tabla2 = {1, 2, 3, 4, 5};

        //Then
        //Comprobamos que los dos arrays son iguales
        assertThat(!UtilesArrays.sonIguales(tabla1, tabla2));
    }

    @Test
    void elementosIguales(){
        //When
        int[] tabla1 = {1, 2, 3, 4, 5};
        int[] tabla2 = {1, 2, 3, 4, 5};
        int posicionAcomparar = 1;

        //do
        UtilesArrays.elementosIguales(tabla1, tabla2, posicionAcomparar);

        //Then
        //Comprobamos que el elemento a comparar en ambas tablas es igual
        assertThat(UtilesArrays.elementosIguales(tabla1, tabla2, posicionAcomparar) == true);

    }

    @Test
    void concatenarArrays(){
        int[] tabla1 = {1, 2, 3, 4, 5};
        int[] tabla2 = {1, 2, 3, 4, 5};
        int[] tablaUnion = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        UtilesArrays.concatenarArrays(tabla1, tabla2);

        assertThat(UtilesArrays.concatenarArrays(tabla1, tabla2) == tablaUnion);
    }

}
