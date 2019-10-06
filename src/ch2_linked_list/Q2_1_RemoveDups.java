package ch2_linked_list;

import java.util.HashMap;

import data_structure.list.SLinkedList;
import data_structure.list.SNode;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * @author Forest
 *
 */
public class Q2_1_RemoveDups {
	public static void main(String[] args) {
		SLinkedList list = new SLinkedList();
		SNode node1 = new SNode("asf");
		SNode node2 = new SNode("asa");
		SNode node3 = new SNode("asf");
		SNode node4 = new SNode("asg");
		SNode node5 = new SNode("ath");
		SNode node6 = new SNode("asf");
		list.addFirst(node1);
		list.addFirst(node2);
		list.addFirst(node3);
		list.addFirst(node4);
		list.addFirst(node5);
		list.addFirst(node6);
		removeDups(list);
	}

	public static void removeDups(SLinkedList list) {
		HashMap dict = new HashMap();
		if (list.last() != null) {
			SNode pointer = list.last();
			dict.put(pointer.getElement(), 1);
			while (pointer.getNext() != null) {
				pointer = pointer.getNext();
				System.out.println("pointer:" + pointer.getElement());
				Object ele = pointer.getElement();
				if (dict.containsKey(ele)) {
					System.out.println("duplicate:" + ele);
					list.remove(pointer);
				}
				list.printList();
			}
		}
	}

	/**
	 * No buffer allowed
	 * 
	 * have a runner to check if any duplicate for every element
	 * 
	 * @param list
	 */
	public static void removeDupsFollowUp(SLinkedList list) {
		list.printList();
		SNode current = list.last();
		while (current != null) {
			SNode runner = current;
			while (runner.getNext() != null) {
				if (runner.getNext().getElement() == current.getElement()) {
					list.remove(current);
					list.printList();
				}
				runner = runner.getNext();
			}
			current = current.getNext();
		}
	}
}
