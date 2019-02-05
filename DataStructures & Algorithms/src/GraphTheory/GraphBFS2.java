package GraphTheory;

import java.util.*;
	/*Steps:
	1. Use Stack.
	2. First add the Starting Node to the Stack.
	3. Pop out an element from Stack and add all of its connected nodes to stack.
	4. Repeat the above two steps until the Stack is empty.
	5. Below is a walk through of the graph above.
	Also ref: https://www.codeproject.com/Articles/32212/Introduction-to-Graph-with-Breadth-First-Search-BF*/

	class Node { //Unweighted directed graph. Ref: https://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-graph
		int dest;
		Node next;
		public Node(int d) {
			dest = d;
			next = null;
		}
	}

	class adjList {
		Node head;
	}

	class Graf {
		int V;
		adjList[] array;
		public Graf(int V) {
			this.V = V;
			array = new adjList[V]; // linked lists = number of Nodes in Graph
			for (int i = 0; i < V; i++) {
				array[i] = new adjList();
				array[i].head = null;
			}
		}

		public void addEdge(int src, int dest) {
			Node n = new Node(dest);
			n.next = array[src].head;
			array[src].head = n;
		}

		public void BFS(int startVertex) {
			System.out.print("Bredth First Search: ");
			boolean[] visited = new boolean[V];
			Queue<Integer> s = new LinkedList<>();
			s.add(startVertex);
			while (!s.isEmpty()) {
				int n = s.poll();
				System.out.print(n+" ");
				visited[n] = true;
				Node head = array[n].head;
				while (head != null) {
					if (visited[head.dest] == false) {
						s.add(head.dest);
						visited[head.dest] = true;
					}
					head = head.next;
				}
			}
		}
		
		/*public void DFS(int startVertex) { //Review needed for DFS function to align with variables in this class
			System.out.print("Depth First Search: ");
			boolean visited[]=new boolean[V];
			Stack<Integer> stack=new Stack<>();
			stack.add(startVertex);
			for(int startIndex=startVertex;startIndex<V;startIndex++) {
				if(!visited[startIndex]) {
					stack.push(startIndex);
					visited[startIndex]=true;
					while(!stack.isEmpty()) {
						int nodeIndex=stack.pop();
						System.out.print(nodeIndex+" ");
						LinkedList<Integer> nodeList=list[nodeIndex];
						for(int i=0;i<nodeList.size();i++) {
							int dest=nodeList.get(i);
							if(!visited[dest]) {
								stack.push(dest);
								visited[dest]=true;
							}
						}
					}
				}
			}
		}*/
	}
	
	public class GraphBFS2 {
		
		public static void main(String args[]) {
			Graf g = new Graf(6);
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(1, 3);
			g.addEdge(3, 4);
			g.addEdge(2, 3);
			g.addEdge(4, 0);
			g.addEdge(4, 1);
			g.addEdge(4, 5);
			g.BFS(0);	
	}
}