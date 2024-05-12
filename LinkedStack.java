/**
 * LinkedStack represents a generic stack implementation using a singly linked list.
 *
 * @param <E> the type of elements stored in the stack
 */
public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    /**
     * Constructs an empty LinkedStack.
     */
    public LinkedStack() {
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size() {
        return list.size();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param e the element to be added to the stack
     */
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * Returns (but does not remove) the element at the top of the stack.
     *
     * @return the element at the top of the stack, or null if the stack is empty
     */
    public E top() {
        return list.first();
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element removed from the top of the stack, or null if the stack is empty
     */
    public E pop() {
        return list.removeFirst();
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return a string representation of the stack
     */
    public String toString() {
        return list.toString();
    }
}
