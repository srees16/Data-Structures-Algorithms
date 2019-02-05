package DataStructures;

public class LinkedListInt {

	private Node head;
	
	private class Node {
		private int data;
		private Node next;
	}
	
	public LinkedListInt() {
		head=new Node();
		head.data=0;
		head.next=null;
	}
	
	public boolean insertPre(int item) {
		Node n=new Node();
		n.data=item;
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
		n.next=null;
		x.next=n;
		return true;
	}
	
	public void delete(int item) {
		if(isPresent(item)) {
			Node x=head;
			if(x.data==item) {
				head=head.next;
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
				if(y.data==item) {
					x.next=y.next;
				}
			}
		} else {
			throw new IllegalStateException("Item not found");
		}
	}
	
	private boolean isPresent(int item) {
		Node x=head.next;
		while(x!=null) {
			if(x.data==item) {
				return true;
			}
			x=x.next;
		}
		return false;
	}
	
	public void print() {
		Node x=head.next;
		while(x!=null) {
			System.out.println(x.data+" ");
			x=x.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListInt ll = new LinkedListInt();
		/*ll.insertPre(56);
		ll.insertPre(22);
		ll.insertPre(68);
		ll.insertPre(35);
		ll.insertPre(73);
		ll.insertPre(15);
		ll.print();*/
		
		ll.insertPost(56);
		ll.insertPost(22);
		ll.insertPost(68);
		ll.insertPost(35);
		ll.insertPost(73);
		ll.insertPost(15);
		ll.print();
		System.out.println();
		ll.delete(22);
		ll.print();
		System.out.println();
		System.out.println(ll.isPresent(56));
		ll.delete(65);
	}
}