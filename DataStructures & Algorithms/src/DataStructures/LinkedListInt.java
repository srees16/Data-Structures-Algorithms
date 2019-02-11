package DataStructures;

public class LinkedListInt {

	private Node head;
	
	private class Node {
		private int data;
		private Node next;
	}
	
	public LinkedListInt() {
		head = new Node();
		head.data = 0;
		head.next = null;
	}
	
	public boolean insertPre(int item) {
		Node node = new Node();
		node.data = item;
		node.next = head;		
		head = node;
		return true;
	}
	
	public boolean insertPost(int item) {
		Node node = new Node();
		Node x = head;
		while(x.next != null) {
			x = x.next;
		}
		node.data = item;
		node.next = null;
		x.next = node;
		return true;
	}
	
	public void delete(int item) {
		if(isPresent(item)) {
			Node x = head;
			if(x.data == item) {
				head = head.next;
			} else {
				Node y = head.next;
				while(true) {
					if(y == null || y.data == item) {
						break;
					} else {
						x = y;
						y = y.next;
					}
				}
				if(y.data == item) {
					x.next = y.next;
				}
			}
		} else {
			throw new IllegalStateException("Item not found");
		}
	}
	
	private boolean isPresent(int item) {
		Node x = head.next;
		while(x != null) {
			if(x.data == item) {
				return true;
			}
			x = x.next;
		}
		return false;
	}
	
	public void print() {
		Node x = head.next;
		while(x != null) {
			System.out.println(x.data + " ");
			x = x.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListInt linkedList = new LinkedListInt();
		/*linkedList.insertPre(56);
		linkedList.insertPre(22);
		linkedList.insertPre(68);
		linkedList.insertPre(35);
		linkedList.insertPre(73);
		linkedList.insertPre(15);
		linkedList.print();*/
		
		linkedList.insertPost(56);
		linkedList.insertPost(22);
		linkedList.insertPost(68);
		linkedList.insertPost(35);
		linkedList.insertPost(73);
		linkedList.insertPost(15);
		linkedList.print();
		System.out.println();
		linkedList.delete(22);
		linkedList.print();
		System.out.println();
		System.out.println(linkedList.isPresent(56));
		linkedList.delete(65);
	}
}