package DataStructures;

public class BinaryTreeObject {
	
	private Node root;
	
	private class Node {
		Student student;
		Node lc;
		Node rc;
	}
	
	private BinaryTreeObject() {
		root=null;
	}
	
	public Node insert(Student student) {
		Node n=new Node();
		n.student=student;
		n.lc=null;
		n.rc=null;
		if(root==null) {
			root=n;
		} else {
			Node x=root;
			Node y=root;
			while(y!=null) {
				x=y;
				if(student.stuName.compareToIgnoreCase(y.student.getName())<0) {
					y=y.lc;
				} else {
					y=y.rc;
				}
			}
			if(student.stuName.compareToIgnoreCase(x.student.getName())<0) {
				x.lc=n;
			} else {
				x.rc=n;
			}
		}
		return n;
	}
	
	public Node delete(Node n) {
		if(!isPresent(n.student.getName())) {
			throw new IllegalStateException("Not found!");
		} else {
			if(n.lc==null && n.rc==null) { //Case 1: if child nodes doesn't exist
				n=null;
			} else if(n.lc==null) { //Case 2A: if left child node doesn't exist
				Node temp=n;
				n=n.rc;
				temp=null;
			} else if(n.rc==null) { //Case 2B: if right child node doesn't exist
				Node temp=n;
				n=n.lc;
				temp=null;
			} else { //Case 3: if both child nodes exist
				Node t=findMin(n.rc);
				n.student=t.student;
				n.rc=t;
			}
			return n;
		}
	}
	
	private boolean isPresent(String input) {
		Node x=root;
		if(input.compareToIgnoreCase(x.student.getName())==0) {
			return true;
		} else {
			Node y=root;
			while(y!=null) {
				x=y;
				if(input.compareToIgnoreCase(y.student.getName())<0) {
					y=y.lc;
				} else {
					y=y.rc;
				}
			}
			if(input.compareToIgnoreCase(x.student.getName())<0) {
				x.lc=x;
			} else {
				x.rc=x;
			}
		}
		return true;
	}
	
	private Node findMin(Node n) {
		if(n.lc!=null) {
			n=n.lc;
		}
		return n;
	}
	
	private boolean findMax(Node n) {
		if(n.rc!=null) {
			n=n.rc;
		}
		return true;
	}
	
	private void findChildNodes1(String input) {
		Node x=root;
		Node y=root;
		while(x.lc!=null) {
			if(input.compareToIgnoreCase(x.student.getName())==0) {
				break;
			} else {
				x=y;
				if(input.compareToIgnoreCase(y.student.getName())<0) {
					y=y.lc;
				} else {
					y=y.rc;
				}
			}
		}
		System.out.println(x.lc.student.getName()+" with roll number "+x.lc.student.rollNo+" is of "+x.lc.student.cgpa+" with CGPA");
		findChildNodes1(x.lc.student.getName()+" with roll number "+x.lc.student.rollNo+" is of "+x.lc.student.cgpa+" with CGPA");
	}
	
	public void findChildNodes2(String s) {
		if(root!=null) {
			System.out.println();
		}
	}
	
	public Node findNode(String key) {
		Node n=root;
		
		return n;
	}
	
	/*public void findChildren(Node n) {
		Node x=root;
		if(x!=null) {
			System.out.println(x.pers);
			findChildren(x.lc);
			findChildren(x.rc);
		}
	}*/
	
	/*public void findChildren(String key) {
		Node x=root;
		Node y=root;
		while(x.lc!=null) {
			if(key.compareToIgnoreCase(x.data.getName())==0) {
				break;
			} else {
				x=y;
				if(key.compareToIgnoreCase(y.data.getName())<0) {
					y=y.lc;
				} else {
					y=y.rc;
				}
			}
		}
		System.out.println(x.lc.data.getName()+" "+x.lc.data.getRollNo());
		findChildren(x.rc.data.getName()+" "+x.lc.data.getRollNo());
	}*/
	
	/*public Node findParent(String key) {
		Node x=root;
		Node y=root;
		do {
			if((key.compareTo(y.pers.getName())==0)) {
				break;
			}
			x=y;
			if(key.compareToIgnoreCase(y.pers.getName())<0) {
				y=y.lc;
			}
			else {
				y=y.rc;
			}
		} while(y!=null);
		System.out.println(x.pers.getName());
		if(y!=null) {
			return x;
		} else {
			return null;
		}
	}*/
	
	/*public Person getData(Node n) {
		return n.pers;
	}
	*/
	
	/*public Node showNodeName(String key) {
		Node r=root;
		while(r!=root) {
			if(key.compareToIgnoreCase(r.pers.getName())==0) {
				break;
			} if(key.compareToIgnoreCase(r.pers.getName())<0) {
				r=r.lc;
			} else {
				r=r.rc;
			}
		}
		return r;
	}*/
	
	/*public void findNode(String key) {
		Node x=root;
		while(x!=null) {
			if(key.compareToIgnoreCase(x.data.getName())==0) {
				break;
			} else {
				if(key.compareToIgnoreCase(x.data.getName())<0) {
					x=x.lc;
				} else {
					x=x.rc;
				}
			}
		}
		System.out.println(x.data.toString());
	}*/

	public void print(Node n) {
		Node x=root;
		while(x!=null) {
			System.out.println(x.student.toString());
			print(x.lc);
			print(x.rc);
		}
	}

	public static void main(String[] args) {
		
	}
}