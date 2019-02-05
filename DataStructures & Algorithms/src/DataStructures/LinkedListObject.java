package DataStructures;

public class LinkedListObject { //isPresent & isPresents has bug. Gives false always. Write code for sorting

	private Node head;
	
	private class Node {
		Employee emp;
		Node next;
	}
	
	private LinkedListObject() {
		head=new Node();
		head.emp=null;
		head.next=null;
	}
	
	public Employee insertPre(Employee emp) {
		Node n=new Node();
		n.emp=emp;
		n.next=head;
		head=n;
		return emp;
	}
	
	public Employee insertPost(Employee emp) {
		Node n=new Node();
		Node xNode=head;
		while(xNode.next!=null) {
			xNode=xNode.next;
		}
		n.emp=emp;
		n.next=null;
		xNode.next=n;
		return emp;
	}
	
	public void delete(String name) {
		if(!isPresents(name)) {
			throw new IllegalStateException("You cant delete wat aint there!");
		} else {
			Node x=head.next;
			if(x.next.emp.getEmpName().equalsIgnoreCase(name)) {
				x=x.next;
			} else {
				Node y=head.next.next;
				while((y!=null) && !(y.emp.getEmpName().equalsIgnoreCase(name))) {
					x=y;
					y=y.next;
				}
				if(y!=null) {
					x.next=y.next;
				}
			}
		}
	}
	
	public boolean isPresent(String s) {
		try {
			Node x=head;
			if(s.compareToIgnoreCase(x.emp.getEmpName())==0) {
				return true;
			} else {
				Node y=head.next;
				while((y!=null) && !(s.compareToIgnoreCase(y.emp.getEmpName())==0)) {
					x=y;
					y=y.next;
				}
				if(y!=null) {
					return true;
				}
			}
		} catch(java.lang.NullPointerException e) {
			//System.out.println(e);
		}
		return false;
	}
	
	public boolean isPresents(String s) {
		try {
			Node x=head;
			if(s.equalsIgnoreCase(x.emp.getEmpName())) {
				return true;
			} else {
				Node y=head.next;
				while((y!=null) && !(s.equalsIgnoreCase(y.emp.getEmpName()))) {
					x=y;
					y=y.next;
				}
				if(y!=null) {
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
			Node x=head.next;
			while(x.next!=null || x.next==null) {
				System.out.println(x.emp.toString()+" ");
				x=x.next;
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
		Employee p1= new Employee("Sita",0055,55);
		Employee p2= new Employee("Rama",0256,15);
		Employee p3= new Employee("Hanu",0041,95);
		Employee p4= new Employee("Laksh",0712,40);
		Employee p5= new Employee("Vali",2188,78);
		Employee p6= new Employee("Luv",6588,23);
		Employee p7= new Employee("Kush",8467,80);
		LinkedListObject p=new LinkedListObject();
		p.insertPost(p1);
		p.insertPost(p2);
		p.insertPost(p3);
		p.insertPost(p4);
		p.insertPost(p5);
		p.insertPost(p6);
		p.insertPost(p7);
		p.print();
		System.out.println(p.isPresents("Vali"));
		/*System.out.println();
		p.delete("Hanu");
		p.delete("Vali");
		p.print();*/
	}
}