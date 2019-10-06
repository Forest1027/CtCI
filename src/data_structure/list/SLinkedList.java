package data_structure.list;

public class SLinkedList<E> {
	private SNode<E> head;
	private SNode<E> tail;
	private long size;

	public SLinkedList() {
		// TODO Auto-generated constructor stub
		head = null;
		size = 0;
		tail = null;
	}

	public long size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public SNode first() {
		return tail;
	}

	public SNode last() {
		return head;
	}

	public SNode prev(SNode sNode) {
		return null;
	}

	public SNode next(SNode sNode) {
		return null;
	}

	public void set(SNode sNode, String element) {

	}

	public void addBefore(SNode sNode, String element) {

	}

	public void addAfter(SNode currentNode, SNode newNode) {
		if (currentNode == tail) {
			tail = newNode;
		}
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		size++;
	}

	public void addFirst(SNode sNode) {
		if (tail == null) {
			// first time add element
			tail = sNode;
		}
		sNode.setNext(head);
		head = sNode;
		size++;
	}

	public void addLast(SNode sNode) {
		if (head == null) {
			// first time add element
			head = sNode;
		}
		sNode.setNext(null);
		tail.setNext(sNode);
		tail = sNode;
		size++;
	}

	public void remove(SNode sNode) {
		if (size == 0) {
			throw new IndexOutOfBoundsException("Remove element from an empty list.");
		}
		System.out.println("head:" + head.getElement());
		SNode pointer = head;
		if (pointer.getElement() == sNode.getElement()) {
			head = head.getNext();
			size--;
			return;
		}
		// System.out.println("log:" + pointer.getNext().getElement() + " ");
		while (pointer.getNext() != null) {
			if (pointer.getNext().getElement() == sNode.getElement()) {
				pointer.setNext(pointer.getNext().getNext());

				size--;
				if (pointer.getNext().getNext() == null) {
					tail = pointer;
				}
				pointer = pointer.getNext().getNext();
			} else {
				pointer = pointer.getNext();
			}

		}

	}

	public void printList() {
		if (size <= 0) {
			System.out.println("Empty.");
			return;
		}
		System.out.print(head.getElement());
		SNode pointer = head;
		while (pointer.getNext() != null) {
			System.out.print(", " + pointer.getNext().getElement());
			pointer = pointer.getNext();
		}
		System.out.println();
	}

}
