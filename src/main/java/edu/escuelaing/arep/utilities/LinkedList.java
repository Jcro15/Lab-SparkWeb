package edu.escuelaing.arep.utilities;

import java.util.Iterator;

/**
 * Lista doblemente encadenada que puede almacenar cualquier tipo de objeto  implementada usando nodos
 * @param <T> el tipo de los objetos que se van a almacenar
 */
public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;


    /**
     * crea una nueva LinkedList vacia
     */
    public LinkedList () {
        size=0;
    }

    /**
     * Añade un nuevo elemento al final de la lista
     * @param value el elemento a añadir
     */
    public void add(T value) {
        Node<T> newNode;
        if(size==0){
            newNode= new Node<>(value,null,null);
            this.head=newNode;
        }
        else{
            newNode=new Node<>(value,null,tail);
            tail.setNext(newNode);
        }
        this.tail=newNode;
        size++;
    }

    /**
     * elimina un elemento de la lista
     * @param element el elemento a eliminar
     */
    public void remove(T element){
        if(head!=null && head.getValue().equals(element)){
            removeHead();
        }
        else if (tail!=null && tail.getValue().equals(element)){
            removeTail();
        }
        else {
            Node<T> current =head;
            while (current!=null){
                if(current.getValue().equals(element)){
                    Node<T> prev=current.getPrev();
                    Node<T> next=current.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);
                    size--;
                }
                current=current.getNext();
            }
        }
    }

    /**
     *
     * @return la primera posicion de la lista
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     *
     * @return la ultima posicion de la lista
     */
    public Node<T> getTail() {
        return tail;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }

    /**
     *
     * @return el tamaño de la lista
     */
    public int size() {
        return this.size;
    }

    private void removeHead(){
        if(size==1){
            head=null;
            tail=null;
        }
        else {
            Node<T>second=head.getNext();
            second.setPrev(null);
            head=second;
        }
        size--;
    }
    private void removeTail(){
        if(size==1){
            head=null;
            tail=null;
        }
        else {
            Node<T>prevTail=tail.getPrev();
            prevTail.setNext(null);
            tail=prevTail;
        }
        size--;

    }
}
