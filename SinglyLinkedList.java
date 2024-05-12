/**
 * SinglyLinkedList represents a generic singly linked list.
 *
 * @param <E> the type of elements in the list
 */
public class SinglyLinkedList<E> {
    
    /**
     * Nested Node class representing a node in the singly linked list.
     */
    public static class Node<E> {
        private E element;
        private Node<E> next;
        
        /**
         * Constructs a node with the given element and reference to the next node.
         *
         * @param e the element to be stored in this node
         * @param n the reference to the next node
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        
        /**
         * Retrieves the element stored in this node.
         *
         * @return the element stored in this node
         */
        public E getElement() {
            return element;
        }
        
        /**
         * Retrieves the reference to the next node.
         *
         * @return the reference to the next node
         */
        public Node<E> getNext() {
            return next;
        }
        
        /**
         * Sets the reference to the next node.
         *
         * @param n the reference to the next node
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    /**
     * Constructs an empty singly linked list.
     */
    public SinglyLinkedList() {}
    
    /**
     * Retrieves the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }
    
    /**
     * Retrieves the reference to the head node of the list.
     *
     * @return the reference to the head node of the list
     */
    public Node<E> getHead() {
        return head;
    }
    
    /**
     * Retrieves the reference to the tail node of the list.
     *
     * @return the reference to the tail node of the list
     */
    public Node<E> getTail() {
        return tail;
    }
    
    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Retrieves the element stored in the head node of the list.
     *
     * @return the element stored in the head node of the list, or null if the list is empty
     */
    public E first() {
        if (isEmpty())
            return null;
        return head.getElement();
    }
    
    /**
     * Retrieves the element stored in the tail node of the list.
     *
     * @return the element stored in the tail node of the list, or null if the list is empty
     */
    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }
    
    /**
     * Inserts a new node with the given element at the beginning of the list.
     *
     * @param e the element to be inserted
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }
    
    /**
     * Inserts a new node with the given element at the end of the list.
     *
     * @param e the element to be inserted
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
    
    /**
     * Removes and returns the element stored in the head node of the list.
     *
     * @return the element stored in the head node of the list, or null if the list is empty
     */
    public E removeFirst() {
        if (isEmpty())
            return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }
    
    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            current = current.getNext();
            if (current != null)
                sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
