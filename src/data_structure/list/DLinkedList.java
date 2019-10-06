package data_structure.list;

public class DLinkedList<E> {
	private DNode<E> head;
	private DNode<E> tail;
	private long size;

	public DLinkedList() {
		// TODO Auto-generated constructor stub
		head = null;
		tail = null;
		size = 0;
	}

	public long size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public DNode first() {
		return tail;
	}

	public DNode last() {
		return head;
	}

	public void addAfter(DNode currentNode, DNode newNode) {
		DNode next = currentNode.getNext();
		newNode.setPrev(currentNode);
		newNode.setNext(next);
		next.setPrev(newNode);
		currentNode.setNext(newNode);
		size++;
	}

	public void addFirst(DNode node) {
		if (tail == null) {
			// first time add node
			tail = node;
		}
		node.setNext(head);
		head.setPrev(node);
		head = node;
		size++;
	}

	public void addLast(DNode node) {
		if (head == null) {
			head = node;
		}
		node.setNext(null);
		node.setPrev(tail);
		tail.setNext(node);
		tail = node;
		size++;
	}

	public void remove(DNode node) {
		if (node == null) {
			return;
		}
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		node.setNext(null);
		node.setPrev(null);
		size--;
	}
	public void printList() {
		if (size <= 0) {
			System.out.println("Empty.");
			return;
		}
		System.out.print(head.getElement());
		DNode pointer = head;
		while (pointer.getNext() != null) {
			System.out.print(", " + pointer.getNext().getElement());
			pointer = pointer.getNext();
		}
		System.out.println();
	}
}
