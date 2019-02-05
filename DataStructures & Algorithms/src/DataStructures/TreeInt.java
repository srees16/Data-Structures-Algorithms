package DataStructures;

public class TreeInt {
	
	private Node root;
	
	private class Node {
		int data;
		Node lc;
		Node rc;
	}
	
	private TreeInt() {
		root=null;
	}
	
	public void insert(int data) {
		Node n=new Node();
		n.data=data;
		n.lc=null;
		n.rc=null;
		if(root==null) {
			root=n;
		} else {
			Node x=root;
			Node y=root;
			while(y!=null) {
				x=y;
				if(y.data<=data) {
					y=y.lc;
				} else {
					y=y.rc;
				}
			}
			if(x.data<=data) {
				x.lc=n;
			} else {
				x.rc=n;
			}
		}
	}
	
	public void delete(Node n) {
		if(!isPresent(n.data)) {
			throw new IllegalStateException("Element is not present");
		} else {
			if(n.lc==null && n.rc==null) {
				n=null;
			} else if(n.lc==null) {
				Node temp=n;
				n=n.rc;
				temp=null;
			} else if(n.rc==null) {
				Node temp=n;
				n=n.lc;
				temp=null;
			} else {
				Node x=findMin(n.rc);
				n.data=x.data;
				n.rc=x;
			}
		}
	}
	
	private Node findMin(Node n) {
		while(n.lc!=null) {
			n=n.lc;
		}
		return n;
	}
	
	private Node findMax(Node n) {
		while(n.rc!=null) {
			n=n.rc;
		}
		return n;
	}

	private boolean isPresent(int input) {
		Node x=root;
		if(input==x.data) {
			return true;
		} else {
			Node y=root;
			while(y!=null) {
				x=y;
				if(y.data<input) {
					y=y.lc;
				} else {
					y=y.rc;
				}
			}
			if(x.data<input) {
				x.lc=x;
			} else {
				x.rc=x;
			}
		}
		
		return true;
	}
	
	public void print(Node n) {
		Node x=root;
		while(x.lc!=null) {
			System.out.println(x.data);
			print(x.lc);
			print(x.rc);
		}
	}

	public static void main(String[] args) {
	}
}