package DataStructures;

public class LinkedListObject { //Write code for sorting

	private Node head;
	
	private class Node {
		Student student;
		Node next;
	}
	
	private LinkedListObject() {
		head = new Node();
		head.student = null;
		head.next = null;
	}
	
	public Student insertPre(Student student) {
		Node n = new Node();
		n.student = student;
		n.next = head;
		head = n;
		return student;
	}
	
	public Student insertPost(Student student) {
		Node n = new Node();
		Node xNode = head;
		while(xNode.next != null) {
			xNode = xNode.next;
		}
		n.student = student;
		n.next = null;
		xNode.next = n;
		return student;
	}
	
	public void delete(String name) {
		if(!isPresent(name)) {
			throw new IllegalStateException("You cant delete wat aint there!");
		} else {
			Node x = head.next;
			if(x.next.student.getName().equalsIgnoreCase(name)) {
				x = x.next;
			} else {
				Node y = head.next.next;
				while((y != null) && !(y.student.getName().equalsIgnoreCase(name))) {
					x = y;
					y = y.next;
				}
				if(y != null) {
					x.next = y.next;
				}
			}
		}
	}
	
	public boolean search(String name) {
		try {
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
		} catch(java.lang.NullPointerException e) {
			//System.out.println(e);
		}
		return false;
	}
	
	public void print() {
		try {
			Node x = head.next;
			while(x.next != null || x.next == null) {
				System.out.println(x.student.toString()+" ");
				x = x.next;
			}
		} catch(java.lang.NullPointerException e) {
			//System.out.println(e);
		}
	}
	
	/*public void sort() {
	int c=0;
	Node a=head.next;
	while(a.next!=null) {
		Node b=head.next;
		while(b.next!=null) {
			if(b.person.getName().compareTo(b.next.person.getName())) {
				c=b.value;
				b.value=b.next.value;
				b.next.value=c;
				}	
				b=b.next;
			}
			a=a.next;
		}
	}*/
	
	public static void main(String[] args) {
		
		Student student1 = new Student("Sita",0055,55);
		Student student2 = new Student("Rama",0256,15);
		Student student3 = new Student("Hanuma",0041,95);
		Student student4 = new Student("Laksh",0712,40);
		Student student5 = new Student("Vali",2188,78);
		Student student6 = new Student("Luv",6588,23);
		Student student7 = new Student("Kush",8467,80);
		
		LinkedListObject list = new LinkedListObject();
		
		list.insertPost(student1);
		list.insertPost(student2);
		list.insertPost(student3);
		list.insertPost(student4);
		list.insertPost(student5);
		list.insertPost(student6);
		list.insertPost(student7);
		list.print();
		System.out.println();
		System.out.println(list.search("Hanuma"));
		/*System.out.println();
		p.delete("Hanu");
		p.delete("Vali");
		p.print();*/
	}
}