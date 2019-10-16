package ch3_stacks_queues;

/**
 * How would you design a stack which, in addition to push and pop, has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in 0(1) time.
 * 
 * solution: If we kept track of the minimum at each state, we would be able to
 * easily know the minimum. We can do this by having each node record what the
 * minimum beneath itself is. Then, to find the min, you just look at what the
 * top element thinks is the min.
 * 
 * @author Forest
 *
 */
public class Q3_2_StackMin {
	public static void main(String[] args) {
		StackMin stack = new StackMin();
		for (int i = 0; i < 10; i++) {
			int val = (int) (Math.random() * 10 + 1);
			stack.push(val);
			System.out.println(stack.min());
			System.out.println(stack.toString());
		}
		System.out.println("======================================");
		for (int i = 0; i < 9; i++) {
			stack.pop();
			System.out.println(stack.min());
			System.out.println(stack.toString());
		}
	}
}

class StackMin {
	private Node top;
	private int size;
	private int min;

	public StackMin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "[";
		Node current = top;
		if (current != null) {
			s += current.element + "(" + current.min + ")";
		}
		current = current.getNext();
		while (current != null) {
			s += ",";
			s += current.element + "(" + current.min + ")";
			current = current.getNext();
		}
		s += "]";
		return s;
	}

	public void push(int value) {
		if (top == null) {
			min = value;
		} else if (value < min) {
			min = value;
		}
		Node val = new Node(value);
		val.setNext(top);
		top = val;
		size++;
		val.setMin(min);
	}

	public int pop() {
		int ele = top.getElement();
		top = top.getNext();
		size--;
		min = top.getMin();
		return ele;
	}

	private class Node {
		private int element;
		private Node next;
		private int min;

		public Node(int element) {
			// TODO Auto-generated constructor stub
			this.element = element;
		}

		public void setElement(int element) {
			this.element = element;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getElement() {
			return element;
		}

		public Node getNext() {
			return next;
		}

		public void setMin(int min) {
			this.min = min;
		}

		public int getMin() {
			return min;
		}
	}

	public int min() {
		return min;
	}

}
