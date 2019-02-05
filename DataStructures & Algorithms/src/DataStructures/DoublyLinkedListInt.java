package DataStructures;

public class DoublyLinkedListInt {//Add sorting method

	private Node head;
	
	private class Node {
		Node prev;
		int data;
		Node next;
	}
	
	private DoublyLinkedListInt() {
		head=new Node();
		head.prev=null;
		head.data=0;
		head.next=null;
	}
	
	public boolean insertPre(int item) {
		Node n=new Node();
		n.data=item;
		n.prev=null;
		head.prev=n;
		n.next=head;
		head=n;
		return true;
	}
	
	public boolean insertPost(int item) {
		Node n=new Node();
		Node x=head;
		while(x.next!=null) {
			x=x.next;
		}
		n.data=item;
		n.prev=x;
		x.next=n;
		n.next=null;
		return true;
	}

	public void delete(int item) {
		if(isPresent(item)) {
			Node x=head;
			if(x.data==item) {
				x=x.next;
			} else {
				Node y=head.next;
				while(true) {
					if(y==null || y.data==item) {
						break;
					} else {
						x=y;
						y=y.next;
					}
				}
				if(y!=null) {
					x.next=y.next;
				}
			}
		} else {
			throw new IllegalStateException("Item "+item+" doesn't exist");
		}
	}
	
	public boolean isPresent(int item) {
		Node x=head;
		while(x.next!=null) {
			if(x.data==item)
				return true;
			x=x.next;
		}
		return false;
	}
	
	public void print() {
		try {
			Node x=head.next;
			while(x!=null || x==null) {
				System.out.println(x.data);
				x=x.next;
			}
		} catch(java.lang.NullPointerException e) {
			//System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedListInt ll = new DoublyLinkedListInt();
		ll.insertPost(56);
		ll.insertPost(22);
		ll.insertPost(68);
		ll.insertPost(35);
		ll.insertPost(73);
		ll.insertPost(15);
		ll.print();
		System.out.println("-----------");
		ll.delete(22);
		ll.print();
		System.out.println("-----------");
		System.out.println(ll.isPresent(56));
		System.out.println("-----------");
		ll.delete(65);
	}
}