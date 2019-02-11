package DataStructures;

public class DoublyLinkedListObject { //Bug with insertPre method. Also need to write code for sorting

	private Node head;
	
	private class Node {
		Node prev;
		Student student;
		Node next;
	}
	
	public DoublyLinkedListObject() {
		head=new Node();
		head.prev=null;
		head.next=null;
	}
	
	public Student addPrev(Student student) {
		Node n=new Node();
		n.student = student;
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
		n.student=student;
		n.prev=x;
		x.next=n;
		n.next=null;
		return student;
	}
	
	public boolean delete(String name) {
		Node x=head.next;
		if(x.student.getName().equalsIgnoreCase(name)) {
			x=x.next;
			return true;
		} else {
			Node y=head.next.next;
			while(y!=null && !(y.student.getName().equalsIgnoreCase(name))) {
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
				System.out.println(x.student);
				x=x.next;
			}
		} catch(java.lang.NullPointerException e) {
			//System.out.println(e);
		}
	}
	
	public boolean search(String name) {
		Node x = head.next;
			if(name.equalsIgnoreCase(x.student.stuName)) {
				return true;
			} else {
				Node y = head.next;
				while((y != null) && !(name.equalsIgnoreCase(y.student.stuName))) {
					x = y;
					y = y.next;
				}
				if(y != null) {
					return true;
				}
			}
		return false;
	}
	
	
	public static void main(String[] args) {
		Student student1 = new Student("Sita",0055,55);
		Student student2 = new Student("Rama",0256,15);
		Student student3 = new Student("Hanu",0041,95);
		Student student4 = new Student("Laksh",0712,40);
		Student student5 = new Student("Vali",2188,78);
		Student student6 = new Student("Luv",6588,23);
		Student student7 = new Student("Kush",8467,80);
		Student student8 = new Student("Sugreva",4642,36);
		
		DoublyLinkedListObject doublyList=new DoublyLinkedListObject();
		
		doublyList.addPost(student1);
		doublyList.addPost(student2);
		doublyList.addPost(student3);
		doublyList.addPost(student4);
		doublyList.addPost(student5);
		doublyList.addPost(student6);
		doublyList.addPost(student7);
		//doublyList.addPrev(student8);
		doublyList.print();
		System.out.println("==========");
		System.out.println(doublyList.search("kush"));
	}
}