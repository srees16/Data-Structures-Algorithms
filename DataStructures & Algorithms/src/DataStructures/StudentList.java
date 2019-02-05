package DataStructures;

import DataStructures.StudentList.Node;

public class StudentList {

	private Node h;
	
	class Node {
		private Student data;
		private Node next;
	}

	public StudentList() {
		h=new Node();
		h.next=null;
		h.data=null;
	}
	
	public boolean insertStu(Student stu) {
		Node n=new Node();
		n.data=stu;
		n.next=h.next;
		n.next=n;
		return true;
	}
	
	public boolean ifPresent(String rollNo) {
		Node a=h.next;
		//boolean present=false;
		while(a!=null) {
			if(rollNo.equals(a.data.getRollNo())) {
				//present=true;
				return true;
			}
			a=a.next;
		}
		//return present;
		return true;
	}
	
	public Student getStu(String rollNo) {
		Student data=null;
		Node p=h.next;
		while(p!=null) {
			if(p.data.getRollNo().equals(rollNo)) {
				data=p.data;
				break;
			}
			p=p.next;
		}
		return data;
	}
	
	public void deleteStu(String rollNo) {
		Node p=h;
		Node q=h.next;
		while(q!=null && !(q.data.getRollNo().equals(rollNo))) {
			p=q;
			q=q.next;
		}
		if(q!=null) {
			p.next=q.next;
		} else {
			System.out.println("Not found");
		}
	}
	
	public void showAll() {
		Node x=h.next;
		while(x!=null) {
			System.out.println(x.data);
			x=x.next;
		}
	}
}
