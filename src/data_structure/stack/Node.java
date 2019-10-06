package data_structure.stack;

/**
 * Node of Singly Linked List
 * 
 * @author Forest
 *
 */
public class Node<E> {
	private E element;
	private Node next;

	public Node(E element, Node next) {
		this.element = element;
		this.next = next;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public E getElement() {
		return element;
	}

	public Node getNext() {
		return next;
	}

	public boolean hasNext() {
		return this.getNext() != null;
	}
}
