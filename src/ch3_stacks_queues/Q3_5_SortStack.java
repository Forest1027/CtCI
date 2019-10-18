package ch3_stacks_queues;

import data_structure.stack.NodeStack;

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements
 * into any other data structure (such as an array). The stack supports the
 * following operations: push, pop, peek, and is Empty.
 * 
 * @author Forest
 *
 */
public class Q3_5_SortStack {
	public static void main(String[] args) {
		NodeStack<Integer> stack = new NodeStack();
		for (int i = 0; i < 10; i++) {
			stack.push((int) (Math.random() * 100 + 1));
		}
		System.out.println(stack);
		System.out.println("====================");
		System.out.println("final: "+sort(stack));
	}

	public static NodeStack sort(NodeStack stack) {
		NodeStack<Integer> buffer = new NodeStack<Integer>();
		NodeStack<Integer> result = new NodeStack<Integer>();
		// put first element into result
		while (stack != null && stack.top() != null) {
			Integer pop = (Integer) stack.pop();
			System.out.println("pop:" + pop);
			if (result.top() == null || result.top() >= pop) {
				result.push(pop);
				System.out.println("origin stack!: " + stack);
				System.out.println("result stack!: " + result);
			} else {
				int count = 0;
				buffer.push(pop);

				// put element smalled than current element to stack
				while (result.top() != null && result.top() < pop) {
					Integer temp = (Integer) result.pop();
					stack.push(temp);
					count++;
					System.out.println("origin stack: " + stack);
					System.out.println("result stack: " + result);
				}
				// insert current element to right place
				result.push((Integer) buffer.pop());
				System.out.println("----------------------------");
				// put back element from stack to result
				while (count > 0) {
					stack.push((Integer) stack.pop());
					count--;
					System.out.println("origin stack: " + stack);
					System.out.println("result stack: " + result);
				}

			}
		}

		return result;
	}
}
