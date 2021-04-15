package linkedList;

class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;
	}
}

public class ReverseLinkedList {
	Node reverseList(Node head) {
		Node prev = null;
		while (head != null) {
			Node p = head.next;
			head.next = prev;
			prev = head;
			head = p;
		}
		return prev;
	}
}
