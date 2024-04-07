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
        //do
        int[] tabla = UtilesArrays.limpiar();
        //Compruebo que esta vacio
        assertThat(tabla.length).isEqualTo(0);
    }

    @Test
    void rellenarConCeros(){
        //When
        int[] nuevo = {};
        int[] tabla = {1,2,3};
        int numeroElementos = 3;
        int posicion = 1;

        //do
        tabla = UtilesArrays.rellenar(nuevo, numeroElementos);

        //Compueblo que la longitud del array es igual al numero de elementos
        assertThat( tabla.length).isEqualTo(numeroElementos);
        //Compruebo que en una posición aleatoria el elemento sea cero
        assertThat(tabla[posicion] ==0).isTrue();
    }

    @Test
    void rellenar(){
        //When
        int[] nuevo = {};
        int[] tabla = {1,2,3};
        int numeroElementos = 3;
        int valor = 3;

        //do
        nuevo = UtilesArrays.rellenar(tabla, numeroElementos, valor);

        //Compueblo que la longitud del array es igual al numero de elementos
        assertThat( tabla.length).isEqualTo(valor);
    }

    @Test
    void insertarAlFinal(){
        //When
        int[] tabla = {1, 2, 3, 4, 5};
        int elemento = 5;

        //do
       tabla = UtilesArrays.insertarAlFinal(tabla, elemento);

        //Then
        assertThat(tabla.length-1 == elemento).isTrue();
    }

    @Test
    void insertarAlPrincipio(){
        //When
        int[] tabla = {2, 3, 4, 5};
        int elemento = 1;

        //do
        tabla = UtilesArrays.insertarAlPrincipio(tabla, elemento);

        //Then
        assertThat(tabla[0]).isEqualTo(elemento);
    }

    @Test
    void insertarEnPosicion(){
        //When
        int[] tabla = {6, 3, 7, 5};
        int elemento = 2;
        int posicion = 2;

        //do
        tabla = UtilesArrays.insertarEnPosicion(tabla, elemento, posicion);

        //Then
        assertThat(tabla[posicion] !=elemento).isFalse();
    }

    @Test
    void insertarOrdenado(){
        //When
        int[] tabla = {1, 3, 4, 5};
        int elemento = 2;
        int posicion = 1;

        //do
        tabla = UtilesArrays.insertarOrdenado(tabla, elemento);

        //Then
        assertThat(tabla[posicion]).isEqualTo(elemento);

    }

    @Test
    void eliminarUltimo(){
        //When
        int[] tabla = {1, 2, 3, 4, 5};

        //do
        tabla = UtilesArrays.eliminarUltimo(tabla);

        //Then
        //Comprobamos que ahora el ultimo elemento es el cuatro
        assertThat(tabla[tabla.length-1] == 4 ).isTrue();
    }


    @Test
    void eliminarPrimero(){
        //When
        int[] tabla = {1, 2, 3, 4, 5};

        //do
        tabla = UtilesArrays.eliminarPrimero(tabla);

        //Then
        //Comprobamos que ahora el primer elemento es dos
        assertThat(tabla[0] == 2).isTrue();
    }

    @Test
    void eliminarPosicion(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6};
        int posicion = 1;

        //do
        tabla = UtilesArrays.eliminarPosicion(tabla, posicion);

        //Then
        //Comprobamos que ahora en la posicion 1 hay un 3
        assertThat(tabla[posicion]).isEqualTo(3);
    }

    @Test
    void eliminar(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6};
        int elemento = 6;

        //do
        tabla = UtilesArrays.eliminar(tabla, elemento);

        //Then
        //Comprobamos que en la ultima posicion ahora esta el 5
        assertThat(tabla[tabla.length-1] == 5).isTrue();
    }

    @Test
    void ordenar(){
        //When
        int[] tabla = {6, 4, 5, 3, 2, 1};

        //do
        tabla = UtilesArrays.ordenar(tabla);

        //Then
        //Comprobamos que ahora en la primera posicion esta el 1 y en la ultima
        //esta el 6
        assertThat(tabla[0]).isEqualTo(1);
        assertThat(tabla[tabla.length-1] == 6).isTrue();
    }

    @Test
    void desordenar(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6};

        //do
        UtilesArrays.desordenar(tabla);

        //Then
        //Comprobamos varias posiciones para ver que han cambiado
        assertThat(tabla[0]).isNotEqualTo(1);
        assertThat(tabla[1]).isNotEqualTo(2);
        assertThat(tabla[tabla.length-1] != 6).isTrue();
    }

    @Test
    void invertir(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6};

        //do
        tabla = UtilesArrays.invertir(tabla);

        //Then
        //Comprobamos que la primera y la ultima posicion se han cambiado
        assertThat(tabla[0]).isEqualTo(6);
        assertThat(tabla[tabla.length-1] == 1).isTrue();
    }

    @Test
    void imprimir(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outContent));
        //When
        //declaramos e inicializamos la variable que vamos a imprimir
        int[] tabla= {1, 2, 3};

        //Llamamos a nuestra funcion
        UtilesArrays.imprimir(tabla);
        //Then
        //Comprobamos que el mensaje se muestra

        assertThat(outContent.toString()).startsWith("\t[1, 2, 3]").endsWith("\n");
        System.setOut(originalOut);

    }

    @Test
    void buscar(){
        //When
        int[] tabla = {9, 1, 8, 7, 2, 6};
        int elemento = 1;

        //do
        UtilesArrays.buscar(tabla, elemento);

        //Then
        //Comprobamos que el elemento encontrado al buscar sea el que le hemos pasado
        assertThat(UtilesArrays.buscar(tabla, elemento)).isEqualTo(1);

    }

    @Test
    void partirPor(){
        //When
        int[] tabla = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int posicionInicio = 1;
        int posicionCorte = 5;

        //do
        tabla = UtilesArrays.partirPor(tabla, posicionInicio, posicionCorte);

        //Then
        //Comprobamos que ahora la posicion inicial es 2 y la ultima 4
        assertThat(tabla[0]).isEqualTo(2);
        assertThat(tabla[tabla.length-1]).isEqualTo(5);

    }

    @Test
    void sonIguales(){
        //When
        int[] tabla1 = {1, 2, 3, 4, 5};
        int[] tabla2 = {1, 2, 3, 4, 5};

        //Then
        //Comprobamos que los dos arrays son iguales
        assertThat((tabla1[0])).isEqualTo(tabla2[0]);
        assertThat((tabla1[tabla1.length-1])).isEqualTo((tabla2[tabla2.length-1]));
    }

    @Test
    void noSonIguales(){
        //When
        int[] tabla1 = {1, 2, 3, 6, 5};
        int[] tabla2 = {1, 2, 3, 4, 5};

        //Then
        //Comprobamos que los dos arrays son iguales
        assertThat(!UtilesArrays.sonIguales(tabla1, tabla2)).isTrue();
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
        assertThat(UtilesArrays.elementosIguales(tabla1, tabla2, posicionAcomparar)).isTrue();

    }

    @Test
    void concatenarArrays(){
        //When
        int[] tabla1 = {1, 2, 3, 4, 5};
        int[] tabla2 = {1, 2, 3, 4, 5};
        int[] tablaUnion = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        //do
        UtilesArrays.concatenarArrays(tabla1, tabla2);

        //Then
        //Comprobamos que la union de las tablas es igual a la tabla que las engloba
        assertThat(UtilesArrays.concatenarArrays(tabla1, tabla2)).isEqualTo(tablaUnion);
    }

}
