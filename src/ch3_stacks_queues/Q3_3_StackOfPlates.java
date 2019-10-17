package ch3_stacks_queues;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when the
 * previous stack exceeds some threshold. Implement a data structure SetOfStacks
 * that mimics this. SetO-fStacks should be composed of several stacks and
 * should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push() and SetOfStacks. pop() should behave identically to a
 * single stack (that is, pop () should return the same values as it would if
 * there were just a single stack).
 * 
 * @author Forest
 *
 */
public class Q3_3_StackOfPlates {
	public static void main(String[] args) {
		SetOfStacks stack = new SetOfStacks(10);
		for (int i = 0; i < 30; i++) {
			int value = (int) (Math.random() * 10+1);
			stack.push(value);
			System.out.println(stack);
		}
		System.out.println("==========================");
		for (int i = 0; i < 30; i++) {
			stack.pop();
			System.out.println(stack);
		}
	}

}

class SetOfStacks {
	private Node currentTop;
	private int stackNum;
	/**
	 * the size set for each stack(capacitys)
	 */
	private int stackSize;
	private int currentStackSize;

	public SetOfStacks(int stackSize) {
		// TODO Auto-generated constructor stub
		this.stackSize = stackSize;
	}

	public void push(int value) {
		Node current = new Node(value);
		if (currentTop == null) {
			currentTop = current;
			currentStackSize++;
			stackNum++;
			return;
		}
		// not yet exceed stack capacity limit
		if (currentStackSize < stackSize) {
			current.setNextEle(currentTop);
			current.setNextStack(currentTop.getNextStack());
			currentTop = current;
			currentStackSize++;
		} else if (currentStackSize == stackSize) {
			// create new stack
			current.setNextStack(currentTop);
			currentStackSize = 1;
			currentTop = current;
			stackNum++;
		}
	}

	public int pop() {
		if (currentTop == null) {
			return -1;
		}
		int element = currentTop.element;
		currentStackSize--;
		// whole stack has been removed
		if (currentStackSize == 0) {
			currentTop = currentTop.getNextStack();
			currentStackSize = stackSize;
			stackNum--;
		} else {
			currentTop = currentTop.getNextEle();

		}
		return element;
	}

	class Node {
		private Node nextEle;
		private int element;
		private Node nextStack;

		public Node(int element) {
			// TODO Auto-generated constructor stub
			this.element = element;
		}

		public void setElement(int element) {
			this.element = element;
		}

		public void setNextEle(Node nextEle) {
			this.nextEle = nextEle;
		}

		public void setNextStack(Node nextStack) {
			this.nextStack = nextStack;
		}

		public int getElement() {
			return element;
		}

		public Node getNextEle() {
			return nextEle;
		}

		public Node getNextStack() {
			return nextStack;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "";
		Node top = currentTop;
		while (top != null) {
			s += "[";
			Node current = top;
			if (current != null) {
				s += current.getElement();
			}
			while (current.getNextEle() != null) {
				current = current.getNextEle();
				s += "," + current.getElement();
			}
			s += "]";
			top = top.nextStack;
		}
		return s;
	}

}
