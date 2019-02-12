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

/*
 * Ref: https://github.com/eugenp/tutorials/tree/master/data-structures
*/

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeInt1 {
	
	private class Node {
		int data;
		Node leftChild;
		Node rightChild;
		
		private Node(int data) {
			this.data = data;
			leftChild = null;
			rightChild = null;
		}
		
		private Node() {
			Node node = new Node();
			node.leftChild = null;
			node.rightChild = null;
		}
	}
	
	private Node root;
	
	public void insert(int data) {
		root = insertRecursive(root, data);
	}

	
	private Node insertRecursive(Node current, int data) {
		if(current == null) {
			return new Node(data);
		}
		if(data < current.data) {
			current.leftChild = insertRecursive(current.leftChild, data);
		} else if(data > current.data) {
			current.rightChild = insertRecursive(current.rightChild, data);
		}
		return current;
	}
	
	public void delete(int data) {
		root = deleteRecursive(root, data);
	}


	private Node deleteRecursive(Node current, int data) {
		if(current == null) {
			return null;
		}
		if(data == current.data) {
			if(current.leftChild == null && current.rightChild == null) { // case 1: if there are no child nodes
				return null;
			}
			if(current.rightChild == null) { //case 2: if there is only 1 child node
				return current.leftChild;
			}
			/*if(current.leftChild == null) { //May be invalid case since if there is no left child node, there wont be a right child node
				return current.rightChild;
			}*/
			int smallestValue = findSmallestValue(current.rightChild); // case 3: if there are both child nodes
			current.data = smallestValue;
			current.rightChild = deleteRecursive(current.rightChild, smallestValue);
			return current;
		}
		if(data < current.data) {
			current.leftChild = deleteRecursive(current.leftChild, data);
			return current;
		}
		current.rightChild = deleteRecursive(current.rightChild, data);
		return current;
	}


	private int findSmallestValue(Node root) {
		return root.leftChild == null ? root.data : findSmallestValue(root.leftChild);
	}
	
	private boolean isEmpty() {
		return (root == null);
	}
	
	private int getSize() {
		return getSizeRecursive(root);
	}


	private int getSizeRecursive(Node current) {
		return current == null ? 0 : getSizeRecursive(current.leftChild) + 1 + getSizeRecursive(current.rightChild);
	}
	
	private boolean containsNode(int data) {
		return containsNodeRecursive(root, data);
	}


	private boolean containsNodeRecursive(Node current, int data) {
		if(current == null) {
			return false;
		}
		if(data == current.data) {
			return true;
		}
		return data < current.data ? containsNodeRecursive(current.leftChild, data) : containsNodeRecursive(current.rightChild, data);
	}
	
	private void traverseInorder(Node node) {
		if(node != null) {
			traverseInorder(node.leftChild);
			System.out.println(" " + node.data);
			traverseInorder(node.rightChild);
		}
	}

	private void traversePreorder(Node node) {
		if(node != null) {
			System.out.println(" " + node.data);
			traverseInorder(node.leftChild);
			traverseInorder(node.rightChild);
		}
	}

	private void traversePostorder(Node node) {
		if(node != null) {
			traverseInorder(node.leftChild);
			traverseInorder(node.rightChild);
			System.out.println(" " + node.data);
		}
	}
	
	private void traverseLevelOrder() {
		if(root == null) {
			return;
		}
		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		while(!nodeQueue.isEmpty()) {
			Node node = nodeQueue.remove();
			System.out.println(" " + node.data);
			if(node.leftChild != null) {
				nodeQueue.add(node.leftChild);
			}
			if(node.leftChild != null) {
				nodeQueue.add(node.rightChild);
			}
		}
	}


	public static void main(String[] args) {
		
		BinaryTreeInt1 tree = new BinaryTreeInt1();
		
		tree.insert(84);
		tree.insert(68);
		tree.insert(74);
		tree.insert(67);
		tree.insert(51);
		tree.insert(37);
		//tree.traverseInorder();

	}

}