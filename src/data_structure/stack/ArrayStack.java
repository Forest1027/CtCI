package data_structure.stack;

public class ArrayStack<E> implements Stack<E> {
	private E[] arr;
	private int top = -1;
	private int capacity;

	public ArrayStack() {
	}

	public ArrayStack(int cap) {
		this.capacity = cap;
		this.arr = (E[]) new Object[cap];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top < 0;
	}

	@Override
	public E top() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyStackException("Empty Stack");
		}
		return arr[top];
	}

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		if (size() == capacity) {
			throw new FullStackException("Full Stack");
		}
		arr[++top] = element;
	}

	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyStackException("Empty Stack");
		}
		E element = arr[top];
		arr[top--] = null;
		return element;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "";
		s += "[";
		if (size() > 0) {
			s += arr[0];
			for (int i = 1; i < arr.length; i++) {
				s += ", " + arr[i];
			}
		}
		s += "]";
		return s;
	}

}
