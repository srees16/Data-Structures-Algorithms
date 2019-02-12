package DataStructures;

/*In Order Traversal:print with left child,then root,then right child
Pre Order Traversal:print root,then left child, and then right child
Post Order Traversal:print left, then right and then root
*/
	/*
	 * method to insert an object
	 * method to delete an object
	 * method to find childs of a parent
	 * method to find parent of a child
	 * method to traverse 'in order'
	 * 
	 */

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

	public Node findNode1(String key) {
		Node node = root;
		while(node != null) {
			if(key.compareToIgnoreCase(node.student.getName()) == 0) {
				break;
			} else {
				if(key.compareToIgnoreCase(node.student.getName()) < 0) {
					node = node.lc;
				} else {
					node = node.rc;
				}
			}
		}
		System.out.println(node.student.toString());
		return node;
	}
	
	//Using Do While loop
	public void findNode2(String key) {
		Node x=root;
		Node y=root;
		do{
			if(key.compareToIgnoreCase(y.student.getName())==0) {
				break;
			}
			x=y;
			if(key.compareToIgnoreCase(y.student.getName())<0) {
				y=y.lc;
			} else {
				y=y.rc;
			}			
		} while(y!=null);
		System.out.println(x.student.getName());
	}
		
	public Node findParentNode1(String key) {
		Node x = root;
		Node y = root;
		while(y != null) {
			if(key.compareToIgnoreCase(y.student.getName()) == 0) {
				break;
			}
			x = y;
			if(key.compareToIgnoreCase(y.student.getName()) < 0) {
				y = y.lc;
			} else {
				y = y.rc;
			}
		}
		System.out.println(x.student.getName());
		return x;
	}
	
	//Using Do While loop
	public Node findParentNode2(String key) {
		Node x=root;
		Node y=root;
		do {
			if(key.compareToIgnoreCase(y.student.getName())==0) {
				break;
			}
			x=y;
			if(key.compareToIgnoreCase(x.student.getName())<0) {
				y=y.lc;
			} else {
				y=y.rc;
			}
		}
		/*while(y!=null);
		System.out.println(x.data.getName());
		return x;*/
		while(y!=null);
		System.out.println(x.student.getName());
		if(y!=null) {
			return x;
		} else {
			return null;
		}
	}
	
	private void findChildNodes(String input) {
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
		findChildNodes(x.rc.student.getName()+" with roll number "+x.rc.student.rollNo+" is of "+x.rc.student.cgpa+" with CGPA");
	}
	
	public void findChildNodes(Node node) { //May be incorrect, need to validate
		Node x=root;
		while(x!=null) {
			System.out.println(x.student);
			findChildNodes(x.lc);
			findChildNodes(x.rc);
		}
	}
	
	public Student getNodeData(Node node) {
		return node.student;
	}	

	private void traverseInorder(Node node) {
		if(node != null) {
			traverseInorder(node.lc);
			System.out.println(" " + node.student);
			traverseInorder(node.rc);
		}
	}

	private void traversePreorder(Node node) {
		if(node != null) {
			System.out.println(" " + node.student);
			traverseInorder(node.lc);
			traverseInorder(node.rc);
		}
	}

	private void traversePostorder(Node node) {
		if(node != null) {
			traverseInorder(node.lc);
			traverseInorder(node.rc);
			System.out.println(" " + node.student);
		}
	}

	public static void main(String[] args) {
		
	}
}