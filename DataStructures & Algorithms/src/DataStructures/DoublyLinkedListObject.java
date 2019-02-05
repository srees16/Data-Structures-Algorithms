package DataStructures;

public class DoublyLinkedListObject {

	private Node head;
	
	private class Node {
		Node prev;
		Employee empData;
		Node next;
	}
	
	public DoublyLinkedListObject() {
		head=new Node();
		head.prev=null;
		head.next=null;
	}
	
	public Employee addPrev(Employee emp) {
		Node n=new Node();
		n.empData=emp;
		n.prev=null;
		n.next=head;
		head=n;
		return emp;
	}
	
	public Employee addPost(Employee emp) {
		Node n=new Node();
		Node x=head;
		while(x.next!=null) {
			x=x.next;
		}
		n.empData=emp;
		n.prev=x;
		x.next=n;
		n.next=null;
		return emp;
	}
	
	public boolean delete(String name) {
		Node x=head.next;
		if(x.empData.getEmpName().equalsIgnoreCase(name)) {
			x=x.next;
			return true;
		} else {
			Node y=head.next.next;
			while(y!=null && !(y.empData.getEmpName().equalsIgnoreCase(name))) {
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
				System.out.println(x.empData);
				x=x.next;
			}
		} catch(java.lang.NullPointerException e) {
			//System.out.println(e);
		}
	}
	
	/*public boolean isPresent() {
		
	}*/
	
	
	public static void main(String[] args) {
		Employee p1= new Employee("Sita",0055,55);
		Employee p2= new Employee("Rama",0256,15);
		Employee p3= new Employee("Hanu",0041,95);
		Employee p4= new Employee("Laksh",0712,40);
		Employee p5= new Employee("Vali",2188,78);
		Employee p6= new Employee("Luv",6588,23);
		Employee p7= new Employee("Kush",8467,80);
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