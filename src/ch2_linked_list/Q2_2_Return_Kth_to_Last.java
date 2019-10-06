package ch2_linked_list;

import data_structure.list.SLinkedList;
import data_structure.list.SNode;

/**
 * Implement an algorithm to find the kth to last element of a singly linked
 * list.
 * 
 * @author Forest
 *
 */
public class Q2_2_Return_Kth_to_Last {
	public static void main(String[] args) {
		SLinkedList list = new SLinkedList();
		SNode node1 = new SNode("asf");
		SNode node2 = new SNode("asa");
		SNode node3 = new SNode("asf");
		SNode node4 = new SNode("asg");
		SNode node5 = new SNode("ath");
		SNode node6 = new SNode("asaa");
		list.addFirst(node1);
		list.addFirst(node2);
		list.addFirst(node3);
		list.addFirst(node4);
		list.addFirst(node5);
		list.addFirst(node6);
		list.printList();
		int size = (int)list.size();
		for (int i = 1; i <= size-1; i++) {
			System.out.println(i+"th to last node is "+kthToLast(list, i).getElement());
		}

	}

	public static SNode kthToLast(SLinkedList list, int kth) {
		SNode current = list.last();
		System.out.println("last:"+current.getElement());
		while (kth > 0) {
			if(current.getNext() == null) {
				return null;
			}
			current = current.getNext();
			kth--;
		}
		return current;
	}

}
