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
			throw new EmptyStackException("Empty Stack");
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
			throw new EmptyStackException("Empty Stack");
		}
		E element = top.getElement();
		top = top.getNext();
		size--;
		return element;
	}

}
