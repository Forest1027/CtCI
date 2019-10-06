package ch2_linked_list;

import java.util.HashMap;

import data_structure.Node;
import data_structure.SLinkedList;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * @author Forest
 *
 */
public class Q2_1_RemoveDups {
	public static void main(String[] args) {
		SLinkedList list = new SLinkedList();
		Node node1 = new Node("asf");
		Node node2 = new Node("asa");
		Node node3 = new Node("asf");
		Node node4 = new Node("asg");
		Node node5 = new Node("ath");
		Node node6 = new Node("asf");
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
			Node pointer = list.last();
			dict.put(pointer.getElement(), 1);
			while (pointer.getNext() != null) {
				pointer = pointer.getNext();
				System.out.println("pointer:"+pointer.getElement());
				Object ele = pointer.getElement();
				if(dict.containsKey(ele)) {
					System.out.println("duplicate:"+ele);
					list.remove(pointer);
				}
				list.printList();
			}
		}

	}
}
