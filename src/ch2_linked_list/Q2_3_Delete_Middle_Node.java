package ch2_linked_list;

import java.util.Arrays;
import java.util.List;

import data_structure.list.SLinkedList;
import data_structure.list.SNode;

/**
 * Implement an algorithm to delete a node in the middle (i.e., any node but the
 * first and last node, not necessarily the exact middle) of a singly linked
 * list, given only access to that node.
 * 
 * @author Forest
 *
 */
public class Q2_3_Delete_Middle_Node {
	public static void main(String[] args) {
		String[] arr = { "a", "b", "c", "d", "e", "f" };
		List<String> list = Arrays.asList(arr);
		SLinkedList<String> nodeList = new SLinkedList<String>();
		nodeList.addList(list);
		nodeList.printList();
		deleteMiddleNode(nodeList, "c");
		nodeList.printList();

	}

	/**
	 * My solution, didn't realize only given the access to the node needs to be
	 * deleted, no access to head node
	 * 
	 * @param list
	 * @param val
	 */
	public static <E> void deleteMiddleNode(SLinkedList<E> list, E val) {
		SNode head = list.last();
		SNode tail = list.first();
		if (head.getElement().equals(val) || tail.getElement().equals(val)) {
			return;
		}
		SNode current = head;
		while (current.getNext() != null) {
			SNode prev = current;
			current = current.getNext();
			if (val.equals(current.getElement())) {
				prev.setNext(current.getNext());
			}
		}
	}

	/**
	 * right solution
	 * 
	 * @param node
	 * @return
	 */
	public static <E> boolean deleteMiddleNode(SNode node) {
		if (node == null || node.getNext() == null) {
			return false;
		}
		// copy the content of the next node to the node we have access to
		SNode next = node.getNext();
		node.setElement(next.getElement());
		node.setNext(next.getNext());
		return true;
	}
}
