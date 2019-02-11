package DataStructures;

public class DoublyLinkedListObject {

	private Node head;
	
	private class Node {
		Node prev;
		Student stuData;
		Node next;
	}
	
	public DoublyLinkedListObject() {
		head=new Node();
		head.prev=null;
		head.next=null;
	}
	
	public Student addPrev(Student student) {
		Node n=new Node();
		n.stuData = student;
		n.prev=null;
		n.next=head;
		head=n;
		return student;
	}
	
	public Student addPost(Student student) {
		Node n=new Node();
		Node x=head;
		while(x.next!=null) {
			x=x.next;
		}
		n.stuData=student;
		n.prev=x;
		x.next=n;
		n.next=null;
		return student;
	}
	
	public boolean delete(String name) {
		Node x=head.next;
		if(x.stuData.getName().equalsIgnoreCase(name)) {
			x=x.next;
			return true;
		} else {
			Node y=head.next.next;
			while(y!=null && !(y.stuData.getName().equalsIgnoreCase(name))) {
				break;
			}
			if(y!=null)
				x.next=y.next;
			return true;
		}
	}
	
	public void print() {
		try {
			Node x=head.next;
			while(x.next!=null || x.next==null) {
				System.out.println(x.stuData);
				x=x.next;
			}
		} catch(java.lang.NullPointerException e) {
			//System.out.println(e);
		}
	}
	
	/*public boolean isPresent() {
		
	}*/
	
	
	public static void main(String[] args) {
		Student p1= new Student("Sita",0055,55);
		Student p2= new Student("Rama",0256,15);
		Student p3= new Student("Hanu",0041,95);
		Student p4= new Student("Laksh",0712,40);
		Student p5= new Student("Vali",2188,78);
		Student p6= new Student("Luv",6588,23);
		Student p7= new Student("Kush",8467,80);
		DoublyLinkedListObject p=new DoublyLinkedListObject();
		p.addPost(p1);
		p.addPost(p2);
		p.addPost(p3);
		p.addPost(p4);
		p.addPost(p5);
		p.addPost(p6);
		p.addPost(p7);
		p.print();
	}
}