package data_structure;

public class SLinkedList {
	private Node head;
	private Node tail;
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

	public Node first() {
		return tail;
	}

	public Node last() {
		return head;
	}

	public Node prev(Node node) {
		return null;
	}

	public Node next(Node node) {
		return null;
	}

	public void set(Node node, String element) {

	}

	public void addBefore(Node node, String element) {

	}

	public void addAfter(Node currentNode, Node newNode) {
		if (currentNode == tail) {
			tail = newNode;
		}
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		size++;
	}

	public void addFirst(Node node) {
		if (tail == null) {
			// first time add element
			tail = node;
		}
		node.setNext(head);
		head = node;
		size++;
	}

	public void addLast(Node node) {
		if (head == null) {
			// first time add element
			head = node;
		}
		node.setNext(null);
		tail.setNext(node);
		tail = node;
		size++;
	}

	public void remove(Node node) {
		if (size == 0) {
			throw new IndexOutOfBoundsException("Remove element from an empty list.");
		}
		System.out.println("head:" + head.getElement());
		Node pointer = head;
		if (pointer.getElement() == node.getElement()) {
			head = head.getNext();
			size--;
			return;
		}
		//System.out.println("log:" + pointer.getNext().getElement() + " ");
		while (pointer.getNext() != null) {
			if (pointer.getNext().getElement() == node.getElement()) {
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
		Node pointer = head;
		while (pointer.getNext() != null) {
			System.out.print(", " + pointer.getNext().getElement());
			pointer = pointer.getNext();
		}
		System.out.println();
	}

}
