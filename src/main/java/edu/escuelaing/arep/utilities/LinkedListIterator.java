package edu.escuelaing.arep.utilities;

import java.util.Iterator;

/**
 *  Iterador utilizado para recorrer la lista doblemente encadenada
 * @param <T> el tipo de los objetos almacenados en la lista
 */
public class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> current;

    /**
     * Crea un nuevo iterador para una LinkedList
     * @param linkedList la LinkedList que se va a iterar
     */
    public LinkedListIterator(LinkedList<T> linkedList) {
        current= linkedList.getHead();
    }


    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public T next() {
        T value =current.getValue();
        current=current.getNext();
        return value;
    }
}
