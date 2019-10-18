package data_structure.stack;

public class NodeStack<E> implements Stack<E> {
	private Node<E> top;
	private int size;

	public NodeStack() {
		// TODO Auto-generated constructor stub
		size = 0;
		top = null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public E top() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		return top.getElement();
	}

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		Node<E> node = new Node(element, top);
		top = node;
		size++;
	}

	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		E element = top.getElement();
		top = top.getNext();
		size--;
		return element;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "[";
		Node current = top;
		if (current != null) {
			s += current.getElement();
			current = current.getNext();
			while (current != null) {
				s += ",";
				s += current.getElement();
				current = current.getNext();
			}
		}

		s += "]";
		return s;
	}

}
