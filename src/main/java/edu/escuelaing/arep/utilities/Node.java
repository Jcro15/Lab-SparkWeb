package edu.escuelaing.arep.utilities;

/***
 * Unidad minima de la lista encadenada, se encarga de almacenar un valor y apuntar a un valor siguiente y un valor anterior
 * @param <T> el tipo del objeto que se va a almacenar
 */
public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> prev;

    /**
     * Crea un Nodo que contiene un valor y punteros hacia el Nodo anterior y el nodo siguiente en la lista,
     * los valores null representan el fin o el inicio de la lista
     * @param value el valor que va a alojar el nodo
     * @param next Nodo siguiente al que se esta construyendo
     * @param prev Nodo anterior al que se esta construyendo
     */
    public Node(T value, Node<T> next, Node<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }


    /**
     *
     * @return el valor almacenado por el nodo
     */
    public T getValue() {
        return value;
    }

    /**
     * establece el valor que almacena el nodo
     * @param value el nuevo valor que va a almacenar el nodo
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     *
     * @return el Nodo que esta en la siguiente posición en la lista
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * establece el nodo que estará después del nodo actual
     * @param next el nodo que estará en la siguiente posición
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     *
     * @return el nodo que esta en la posición anterior en la lista
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * establece el nodo que estará antes del nodo actual
     * @param prev el nodo que estará en la posición anterior
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * compara si dos nodos son iguales comparando  los valores que alojan
     * @param o el objeto con el que se quiere comparar
     * @return true si los valores son iguales , false si no
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return getValue().equals(node.getValue());
    }

}
