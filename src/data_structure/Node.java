package data_structure;

/**
 * Node of Singly Linked List
 * 
 * @author Forest
 *
 */
public class Node<E> {
	private E element;
	private Node next;

	public Node(E element) {
		this.element = element;
		this.next = null;
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

}
