package data_structure;

public class DNode<E> {
	private E element;
	private DNode prev;
	private DNode next;

	public DNode(E element) {
		// TODO Auto-generated constructor stub
		this.element = element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public void setNext(DNode next) {
		this.next = next;
	}

	public void setPrev(DNode prev) {
		this.prev = prev;
	}

	public E getElement() {
		return element;
	}

	public DNode getNext() {
		return next;
	}

	public DNode getPrev() {
		return prev;
	}
}
