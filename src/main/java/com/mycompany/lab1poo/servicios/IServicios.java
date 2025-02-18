package com.mycompany.lab1poo.servicios;

package servicios;

import java.util.List;

public interface Servicios {

    /**
     * Devuelve una representación en String del elemento que se encuentra en la posición indicada.
     * @param posicion la posición (índice) del elemento en el listado.
     * @return Cadena con la información del elemento en esa posición.
     */
    String imprimirPosicion(int posicion);

    /**
     * Retorna la cantidad actual de elementos presentes en el listado.
     * @return Un entero que representa la cantidad actual de elementos.
     */
    int cantidadActual();

    /**
     * Devuelve un listado de cadenas, donde cada cadena es la representación de un elemento del listado.
     * @return Una lista de String con la información de cada elemento.
     */
    List<String> imprimirListado();
}

