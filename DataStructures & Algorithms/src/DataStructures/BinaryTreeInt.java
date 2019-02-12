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

public class BinaryTreeInt {
	
	private Node root;
	
	private class Node {
		int data;
		Node leftChild;
		Node rightChild;
	}
	
	private BinaryTreeInt() {
		root=null;
	}
	
	public void insert(int data) {
		Node node = new Node();
		node.data = data;
		node.leftChild = null;
		node.rightChild = null;
		if(root == null) {
			root = node;
		} else {
			Node x = root;
			Node y = root;
			while(y != null) {
				x = y;
				if(y.data <= data) {
					y = y.leftChild;
				} else {
					y = y.rightChild;
				}
			}
			if(x.data <= data) {
				x.leftChild = node;
			} else {
				x.rightChild = node;
			}
		}
	}
	
	public void delete(Node node) {
		if(!isPresent(node.data)) {
			throw new IllegalStateException("Element is not present");
		} else {
			if(node.leftChild == null && node.rightChild == null) {
				node = null;
			} else if(node.leftChild == null) {
				Node temp = node;
				node = node.rightChild;
				temp=null;
			} else if(node.rightChild == null) {
				Node temp = node;
				node = node.leftChild;
				temp = null;
			} else {
				Node x = findMin(node.rightChild);
				node.data=x.data;
				node.rightChild = x;
			}
		}
	}
	
	private Node findMin(Node node) {
		while(node.leftChild != null) {
			node = node.leftChild;
		}
		return node;
	}
	
	private Node findMax(Node node) {
		while(node.rightChild != null) {
			node = node.rightChild;
		}
		return node;
	}

	private boolean isPresent(int number) {
		Node x = root;
		if(number == x.data) {
			return true;
		} else {
			Node y = root;
			while(y != null) {
				x = y;
				if(y.data < number) {
					y = y.leftChild;
				} else {
					y = y.rightChild;
				}
			}
			if(x.data < number) {
				x.leftChild = x;
			} else {
				x.rightChild = x;
			}
		}
		return true;
	}
	
	public void print(Node node) {
		Node x = root;
		while(x.leftChild != null) {
			System.out.println(x.data);
			print(x.leftChild);
			print(x.rightChild);
		}
	}

	private void inorderTraversal(Node node) {
		if(node != null) {
			inorderTraversal(node.leftChild);
			System.out.println(node.data);
			inorderTraversal(node.rightChild);
		}
	}

	public static void main(String[] args) {
		BinaryTreeInt tree = new BinaryTreeInt();
		tree.insert(84);
		tree.insert(68);
		tree.insert(74);
		tree.insert(67);
		tree.insert(51);
		tree.insert(37);
		
		//tree.inOrder();
	}
}