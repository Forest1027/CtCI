package data_structure.list;

/**
 * Node of Singly Linked List
 * 
 * @author Forest
 *
 */
public class SNode<E> {
	private E element;
	private SNode next;

	public SNode(E element) {
		this.element = element;
		this.next = null;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public void setNext(SNode next) {
		this.next = next;
	}

	public E getElement() {
		return element;
	}

	public SNode getNext() {
		return next;
	}

}
