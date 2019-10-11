package ch3_stacks_queues;

import javax.management.RuntimeErrorException;

/**
 * Describe how you could use a single array to implement three stacks.
 * 
 * @author Forest
 *
 */
public class Q3_1_ThreeInOne {
	public static void main(String[] args) {
		FixedStack<Integer> stack = new FixedStack(5);
		for (int i = 0; i < 10; i++) {
			int stackNum = (int) (Math.random() * 3 + 1);
			System.out.println("stack: " + stackNum);
			int num = (int) (Math.random() * 100);
			System.out.println("number: " + num);
			stack.push(num, stackNum);
			System.out.println(stack);
		}
		System.out.println("--------------------------");
		for (int i = 0; i < 10; i++) {
			int stackNum = (int) (Math.random() * 3 + 1);
			System.out.println("stack: " + stackNum);
			stack.pop(stackNum);
			System.out.println(stack);
		}
	}
}

class FixedStack<E> {
	private E[] values;
	private int stackNumber = 3;
	private int stackCapacity;
	private int[] sizes;

	public FixedStack(int stackCapacity) {
		// TODO Auto-generated constructor stub
		this.stackCapacity = stackCapacity;
		this.values = (E[]) new Object[stackNumber * stackCapacity];
		this.sizes = new int[stackNumber];
	}

	/**
	 * return size of a specific stack
	 * 
	 * @param stack
	 * @return
	 */
	public int size(int stack) {
		return sizes[stack];
	}

	/**
	 * return if a specific stack is empty
	 * 
	 * @param stack
	 * @return
	 */
	public boolean isEmpty(int stack) {
		return size(stack - 1) == 0;
	}

	/**
	 * return the top element of a specific stack
	 * 
	 * @param stack
	 * @return
	 */
	public E top(int stack) {
		int index = indexOfTop(stack);
		return values[index];
	}

	/**
	 * push element to a specific stack
	 * 
	 * @param element
	 * @param stack
	 */
	public void push(E element, int stack) {
		if (sizes[stack - 1] == stackCapacity) {
			throw new RuntimeErrorException(null, "stack " + stack + " is already full");
		}
		int top = indexOfTop(stack);
		values[++top] = element;
		sizes[stack - 1]++;
	}

	/**
	 * pop from a specific stack
	 * 
	 * @return
	 */
	public E pop(int stack) {
		if (isEmpty(stack)) {
			// throw new RuntimeErrorException(null, "stack " + stack + " is already
			// empty");
			return null;
		}
		int top = indexOfTop(stack);
		E value = values[top];
		values[top] = null;
		top--;
		sizes[stack - 1]--;
		return value;
	}

	public int indexOfTop(int stack) {
		return (stack - 1) * stackCapacity + sizes[stack - 1] - 1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "[";
		for (int i = 0; i < values.length; i++) {
			if (i == values.length - 1) {
				s += values[i];
				break;
			}
			s += values[i];
			s += ",";
		}
		s += "]";
		return s;
	}
}

/**
 * A second approach is to allow the stack blocks to be flexible in size. When
 * one stack exceeds its initial capacity, we grow the allowable capacity and
 * shift elements as necessary. We will also design our array to be circular,
 * such that the final stack may start at the end of the array and wrap around
 * to the beginning.
 * 
 * @author Forest
 *
 * @param <E>
 */
class FlexibleStack<E> {

}
