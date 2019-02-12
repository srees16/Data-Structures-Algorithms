package DataStructures;

public class DoublyLinkedListInt { //Add sorting method

	private Node head;
	
	private class Node {
		Node prev;
		int data;
		Node next;
	}
	
	private DoublyLinkedListInt() {
		head = new Node();
		head.prev = null;
		head.data = 0;
		head.next = null;
	}
	
	public boolean insertPre(int item) {
		Node node = new Node();
		node.data = item;
		node.prev = null;
		head.prev = node;
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
		node.prev = x;
		x.next = node;
		node.next = null;
		return true;
	}

	public void delete(int item) {
		if(isPresent(item)) {
			Node x = head;
			if(x.data == item) {
				x = x.next;
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
			System.out.println("Your input " + item + " is deleted");
		} else {
			throw new IllegalStateException("Item " + item + " doesn't exist");
		}
	}
	
	public boolean isPresent(int item) {
		Node x = head;
		while(x.next != null) {
			if(x.data == item)
				return true;
			x = x.next;
		}
		return false;
	}
	
	public void print() {
		try {
			Node x = head.next;
			while(x != null || x == null) {
				System.out.println(x.data);
				x = x.next;
			}
		} catch(java.lang.NullPointerException e) {
			//System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		
		DoublyLinkedListInt doublyList = new DoublyLinkedListInt();
		doublyList.insertPost(56);
		doublyList.insertPost(22);
		doublyList.insertPost(68);
		doublyList.insertPost(35);
		doublyList.insertPost(73);
		doublyList.insertPost(15);
		doublyList.print();
		System.out.println("-----------");
		doublyList.delete(22);
		doublyList.print();
		System.out.println("-----------");
		System.out.println(doublyList.isPresent(56));
		System.out.println("-----------");
		doublyList.delete(65);
	}
	
}